# P9-wild-adventures

OpenClassrooms - Parcours Expert en JAVA EE - Projet 9

L'agence  "Wild Adventures" est spécialisée dans l'organisation des voyages d'aventures de fortes sensations.

Ces dernières années, le catalogue de "Wild Adventures" ne cesse d'évoluer. C'est pour cette raison que l'agence a décidé

de passer à la transformation digitale de ses offre via une application web.

L'application web permet globalement de:

- S'inscrire/ s'authentifier afin d'accéder au contenu de l'application.
- Consulter les aventures par catégorie.
- Consulter la liste des catégories.
- Réserver une aventure et procéder à son paiement.
- Consulter la liste des commandes effectuées.
- Publier un commentaire sur une aventure.
- Visualiser les avis des aventuriers.

## Micro-services

### Micro-services métiers

- `ms-user` : gestion des utilisateurs
- `ms-adventure` : gestion des aventures et des categories
- `ms-session` : gestion des sessions des aventures
- `ms-order` : gestion des commandes
- `ms-payment` : gestion des paiements
- `ms-comment` : gestion des sessions des aventures

### Micro-services edge

- `ms-config-server` : mutualisation de la configuration des microservices
- `ms-eureka` : serveur de registre des instances
- `ms-zuul-server` : point d'entrée de l'application, router et implémentation du load balancing
- `ms-zipkin` : service de traçage des requêtes
- `ms-admin-server` : administration de l'infrastructure

### Architecture générale

![](fonctionnel/images/archi-globale.png?raw=true)

### Déploiement

Le tableau suivant résume les microservices avec leur différents ports
![](fonctionnel/images/appli-ports.png?raw=true)

#### Lancement de l'application
`cd application/backend/ms-business` et tapez la commande: `docker-compose up`. Une fois que l'appli est lancée vous pouvez accéder à l'interface grace à l'url suivante : [http://localhost:4200](http://localhost:4200)

Pour faire des tests, il faut ajouter les jeux de données dans la base de données. pour ce faire : 
- `cd database` et tapez la commande: `docker-compose up`.


### Lancement mannuel 
Avant de lancer les microservices : 
- Créer une base de données postgres : wild-adv (username : postgres, password : postgres).

Nous avons aussi créé des schéma en fonction des microservices. Il vous sera donc nécessaire de créer ces schémas en local : 
- waadventure
- wasession
- waorder

Avant de lancer les microservices : 
`cd keycloak` puis `docker-compose up`

Ensuite : 
`se mettre sur le microservice correspondant puis cd target/` et lancer les microservices dans l'ordre suivante : 
- java -jar ms-config-server.jar
- java -jar ms-eureka.jar
- java -jar zipkin-server.jar
- java -jar ms-adventure.jar
- java -jar ms-session.jar
- java -jar ms-orders.jar
- java -jar ms-payment.jar
- java -jar ms-user.jar
- java -jar ms-comments.jar

Pour lancer le front : 
`cd application/backend/wild-front` puis `ng serve`

[http://localhost:4200](http://localhost:4200)

Pour tester : 
veuillez exécuter les jeux de données du dossier scripts dans votre base de données.


