// API Services

export const apiPrefix = "http://localhost:NUMERO_PORT";

/**** API Commande ****/
export const apiCommande = apiPrefix + "/";
export const apiCommandeById = apiPrefix + "/";
export const apiUpdateCommande = apiPrefix + "/";
export const apiSaveCommande = apiPrefix + "/";

/**** API User and Login ****/
export const apiLogin = apiPrefix + "/";
export const apiUserByusername = apiPrefix + "/";
export const apiUserByuserid = apiPrefix + "/";
export const apiSessionById = apiPrefix + "/";
export const apiInscription = apiPrefix + "/utilisateur/utilisateur/save";

/**** API Aventure ****/
export const apiAventureBySession = apiPrefix + "/";
export const apiAventureByCategory = apiPrefix + "/";
export const apiAventure = apiPrefix + "/";
export const apiAventureById = apiPrefix + "/";

/**** API Category ****/
export const apiCategory = apiPrefix + "/";
export const apiCategoryById = apiPrefix + "/";

/**** API Paiement ****/
export const apiPayment = apiPrefix + "/";

/**** API Commentaire ****/
export const apiCommentaire = apiPrefix + "/";
export const apiAddCommentaire = apiPrefix + "/";
