import { KeycloakConfig, KeycloakInitOptions, KeycloakOptions } from 'keycloak-angular';



const keycloakConfig: KeycloakConfig = {
  url: 'http://localhost:8080/auth',
  realm: 'WildAdventures',
  clientId: 'wildAdventures-frontend'

};

const keycloakInitOptions: KeycloakInitOptions = {
  onLoad: 'login-required',
  checkLoginIframe: false
};

const keycloakOptions: KeycloakOptions = {
  config: keycloakConfig,
  initOptions: keycloakInitOptions,
  enableBearerInterceptor: true
};

export const environment = {
  production: false,
  keycloakOptions
};










/*
 * For easier debugging in development mode, you can import the following file
 * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
 *
 * This import should be commented out in production mode because it will have a negative impact
 * on performance if an error is thrown.
 */
// import 'zone.js/dist/zone-error';  // Included with Angular CLI.
