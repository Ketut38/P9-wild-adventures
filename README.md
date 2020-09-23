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

