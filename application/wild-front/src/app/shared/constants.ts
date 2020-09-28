// API Services
export const homeURI = 'http://localhost:4200/';

export const apiPrefix = 'http://localhost:9001';
export const apiUser = 'http://localhost:9003';

export const apiPrefixCommentaire = 'http://localhost:9004';

export const apiPrefixSession = 'http://localhost:9002';

export const apiPrefixPayment = 'http://localhost:9006';

export const apiPrefixOrder = 'http://localhost:9005';

export const keycloakURL = 'http://localhost:8080/auth/realms/WildAdventures';

// tslint:disable-next-line: max-line-length
export const logoutURI = 'http://localhost:8080/auth/realms/WildAdventures/protocol/openid-connect/logout?redirect_uri=http://localhost:4200/';
// tslint:disable-next-line: max-line-length
export const registerURI ='http://localhost:8080/auth/realms/WildAdventures/login-actions/registration?client_id=wildAdventures-frontend&tab_id=ZbJ2FUiHEak';

/**** API Commande ****/
export const apiOrders = apiPrefixOrder + '/api/orders';
export const apiCommandeById = apiPrefix + '/';
export const apiUpdateCommande = apiPrefix + '/';
export const apiSaveCommande = apiPrefix + '/';

/**** API User and Login ****/
export const apiLogin = apiPrefix + '/';
export const apiUserByusername = apiPrefix + '/';
export const apiUserByuserid = apiPrefix + '/';
export const apiInscription = apiPrefix + '/utilisateur/utilisateur/save';

/**** API Aventure ****/
export const apidAdventureBySession = apiPrefix + '/';
export const apidAdventureByCategory = apiPrefix + '/api/categories';
export const apidAdventure = apiPrefix + '/api/adventures';
export const apidAdventureById = apiPrefix + '/api/adventures';

/**** API Category ****/
export const apiCategory = apiPrefix + '/api/categories';
export const apiCategoryById = apiPrefix + '/api/categories';

/**** API Session ****/
export const apiSession = apiPrefixSession + '/api/sessions';

/**** API Paiement ****/
export const apiPayment = apiPrefixPayment + '/';

/**** API Commentaire ****/
export const apiCommentaire = apiPrefixCommentaire + '/api/commentaire';
export const apiAddCommentaire = apiCommentaire + '/api/commentaire/add';
export const apiCommentaireByuser = apiCommentaire + '/api/commentaire/user';
export const apiDeleteCommentaire = apiCommentaire + '/api/commentaire/delete';

/**** API User ****/
export const apiUserSession = apiUser + '/api/userInfos';
