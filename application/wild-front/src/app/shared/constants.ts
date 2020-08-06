// API Services

export const apiPrefix = "http://localhost:9001";

export const apiPrefixSession = "http://localhost:9002";

export const apiPrefixPayment = "http://localhost:9006";

export const apiPrefixOrder = "http://localhost:9005";

/**** API Commande ****/
export const apiOrders = apiPrefixOrder + "/api/orders";
export const apiCommandeById = apiPrefix + "/";
export const apiUpdateCommande = apiPrefix + "/";
export const apiSaveCommande = apiPrefix + "/";

/**** API User and Login ****/
export const apiLogin = apiPrefix + "/";
export const apiUserByusername = apiPrefix + "/";
export const apiUserByuserid = apiPrefix + "/";
export const apiInscription = apiPrefix + "/utilisateur/utilisateur/save";

/**** API Aventure ****/
export const apidAdventureBySession = apiPrefix + "/";
export const apidAdventureByCategory = apiPrefix + "/api/categories";
export const apidAdventure = apiPrefix + "/api/adventures";
export const apidAdventureById = apiPrefix + "/api/adventures";

/**** API Category ****/
export const apiCategory = apiPrefix + "/api/categories";
export const apiCategoryById = apiPrefix + "/api/categories";

/**** API Session ****/
export const apiSession = apiPrefixSession + "/api/sessions";

/**** API Paiement ****/
export const apiPayment = apiPrefixPayment + "/";

/**** API Commentaire ****/
export const apiCommentaire = apiPrefix + "/";
export const apiAddCommentaire = apiPrefix + "/";
