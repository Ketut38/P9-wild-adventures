import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor,
  HttpHeaders
} from '@angular/common/http';
import { Observable } from 'rxjs';
import 'rxjs/add/operator/mergeMap';
import 'rxjs/add/observable/fromPromise';



import { KeycloakService, KeycloakAuthGuard, KeycloakAngularModule } from 'keycloak-angular';


@Injectable()
export class TokenInterceptor implements HttpInterceptor {

  constructor(protected keycloak: KeycloakService) {}

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    return Observable
      .fromPromise(this.keycloak.getToken())
      .mergeMap(
      token => {

        console.log('adding header to request');
        console.log(token);

        const headers: HttpHeaders = req.headers;
        const hedersWithAuthorization: HttpHeaders = headers.append('Authorization', 'bearer ' + token);
        const requestWithAuthorizationHeader = req.clone({ headers: hedersWithAuthorization });
        return next.handle(requestWithAuthorizationHeader);
      }
    );
  }
}