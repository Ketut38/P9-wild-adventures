Demarrage de Keycloak 10.0.2 sur le port 8080

- Pré-requis

  docker-compose installé (installez docker desktop)
 
 - Lancement

  Placez-vous dans le dossier keycloak
  
  $ cd docker
 
  $ docker-compose up -d
  
  keycloak est lancé sur localhost:8080
 
- Connexion

  cliquez sur administration console
  Username or email: admin  
  Password:admin

- Utiliser le theme wild_adventure pour Login et UserProfile

  Dans Realm Settings allez dans l'onglet themes,
  Selectrionnez wild-theme dans le menu déroulant de Login Theme
  faire de même pour Account Theme

- Ajouter des users

  Dans le menu de gauche slectionnez User/Add user
  Renseignez les champs que vous jugez utiles cliquez sur save
  Retrounez dans User/View all users;
  edit le user qui viens d'être crée;
  Onglet credentials : saissisez un mot de passe et désélectionnez la case "Temporary" puis save
  Vous pouvez maintenant acceder aux url securisées comme "profi" et d'autre qui nécéssitent une authentification.
