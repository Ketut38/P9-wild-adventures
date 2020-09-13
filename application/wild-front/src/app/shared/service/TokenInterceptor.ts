import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor,
  HttpHeaders
} from '@angular/common/http';
import { Observable, from } from 'rxjs';
import 'rxjs/add/operator/mergeMap';
import 'rxjs/add/observable/fromPromise';

import { KeycloakService, KeycloakAuthGuard, KeycloakAngularModule } from 'keycloak-angular';
import { ExcludedUrlRegex } from '../interfaces/keycloak-options';
import { mergeMap } from 'rxjs/operators';

/**
 * This interceptor includes the bearer by default in all HttpClient requests.
 *
 * If you need to exclude some URLs from adding the bearer, please, take a look
 * at the {@link KeycloakOptions} bearerExcludedUrls property.
 */

@Injectable()
export class KeycloakBearerInterceptor implements HttpInterceptor {
  constructor(private keycloakService: KeycloakService) {}

  /**
   * Checks if the url is excluded from having the Bearer Authorization
   * header added.
   *
   * @param req http request from @angular http module.
   * @param excludedUrlRegex contains the url pattern and the http methods,
   * excluded from adding the bearer at the Http Request.
   */
  private isUrlExcluded(
    { method, url }: HttpRequest<any>,
    { urlPattern, httpMethods }: ExcludedUrlRegex
  ): boolean {
    const httpTest =
      httpMethods.length === 0 ||
      httpMethods.join().indexOf(method.toUpperCase()) > -1;

    const urlTest = urlPattern.test(url);

    return httpTest && urlTest;
  }

  /**
   * Intercept implementation that checks if the request url matches the excludedUrls.
   * If not, adds the Authorization header to the request if the user is logged in.
   *
   *
   */

  public intercept(
    req: HttpRequest<any>,
    next: HttpHandler
  ): Observable<HttpEvent<any>> {
    const { enableBearerInterceptor, excludedUrls } = this.keycloakService;
    if (!enableBearerInterceptor) {
      return next.handle(req);
    }

    const shallPass = excludedUrls.findIndex(item => this.isUrlExcluded(req, item)) > -1;
    if (shallPass) {
      return next.handle(req);
    }

    return from(this.keycloakService.isLoggedIn()).pipe(
      mergeMap((loggedIn) => (loggedIn ? this.handleRequestWithTokenHeader(req, next) : next.handle(req)))
  );
  }

  /**
   * Adds the token of the current user to the Authorization header
   *
   * @param req
   * @param next
   */
  private handleRequestWithTokenHeader(
    req: HttpRequest<any>,
    next: HttpHandler
  ): Observable<any> {
    return this.keycloakService.addTokenToHeader(req.headers).pipe(
      mergeMap(headersWithBearer => {
        const kcReq = req.clone({ headers: headersWithBearer });
        return next.handle(kcReq);
      })
    );
  }
}
