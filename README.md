# Fun escalade site communautaire d'escalade

## Présentation du projet

Fun escalade est une application permettant à des grimpeurs de découvrir et/ou de partager
des informations concernant des sites de grimpes.
Soit par consultation/création de sites , soit par échange de Topo.

L'appli gère trois type d'acteur différent:
-L'utilisateur non connecté, peut consulter les sites,et se créer un compte.
-L'utilisateur connecté a quand à lui accès à toute les autres fonctionalités classqiue de l'ppli.
-Les modérateurs peuvent en plus gérer la modération des commentaires et proclamer que certain 
site sont officielement reconu.



## Pré requis pour le developpement:

-Java 1.8
Maven version 3.6 mini
-springboot v2.2.6 embed tomcat
-db postgres12

##Paramétrage
spring.datasource.url=jdbc:postgresql://localhost:5432/LastClimb
spring.datasource.username=postgres
spring.datasource.password=root


##DB

Scrypt de dump et comment éxécuter le dump avec pg admin.

## Compilation

compilation via maven : mvn compile depuis la racine.

## packaging
mvn clean package

##run program

mode dev -> mvn spring-boot:run
mode prod -> cd target java -jar nom du projet .

##Utilisation de l'application(ihm)
Lancer localhost:8080
user +pass (joze/123)
admin+pass (JC/123)

Username are case sensitive.


