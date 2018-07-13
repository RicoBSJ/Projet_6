# Projet 6 OpenClassroom 

Site internet de réferencement de topo

Le site permet de : 
- visualiser une liste de topo créée par la communauté
- visualiser les details d'un topo, incluant ses sites, secteurs et voies
- rechercher des topos en fonction de leurs paramètres et disponibilité
- creer un topo 
- creer des sites, secteurs et voies pour chaque topo
- creer un compte utilisateur et s'authentifier 
- poster des commentaires sur chaque topos

Le site est contruit a l'aide de struts 2, spring jdbc, spring TX, une base de donnée Postgresql, maven et un serveur tomcat

Les scripts de création de la base de donnée sont disponibles dans le dossier script_sql qui se trouve dans le dossier parent du projet


Lancer le projet : 

Pour initialiser le projet, il faut tout d'abord creer la db et y inclure l'ensemble des scripts disponibles, ils sont numérotés afin d'éviter tout type d'erreur.
Dans un second temps il faut ouvrir un console et se poser a la racine du projet et creer un .war avec maven : 
    
    mvn package 
    
On note que cette commande a generer un .war dans le dossier target du dossier webapp.
Il faut copier se fichier .war dans le dossier webapps du serveur tomcat 

Enfin, il faut placer une console dans le dossier /bin du dossier du serveur tomcat afin de le lancer : 
    
Pour lancer le serveur sous windows : 

    ./catalina.bat start 
    
    
pour lancer le serveur sous macOS : 

    ./catalina.sh start
    
    
Il suffira de remplacer start par stop pour eteindre le serveur

Par la suite il suffira d'ouvrir un navigateur et de taper :

    localhost://8080/{Le nom du .war} 
    
et l'application devrait se lancer correctement.