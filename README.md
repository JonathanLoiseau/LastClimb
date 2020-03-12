# Fun escalade site communautaire d'escalade

## Présentation du projet

//todo présentation et rappel des acteurs.

## Pré requis pour le developpement:

-Java 1.8
Maven version
-springboot v*** embed tomcat
-db postgres12

##Paramétrage
//to do détail du app.properties.
spring.datasource.url=jdbc:postgresql://localhost:5432/LastClimb
spring.datasource.username=postgres
spring.datasource.password=root
paramétrage des logs(log??)

##DB

Scrypt de dump et comment éxécuter le dump avec pg admin.

## Compilation

compilation maven mvn compile depuis la racine.

## packaging
mvn clean package

##run program

mode dev -> mvn spring-boot:run
mode prod -> cd target java -jar nom du projet lancer le jar.

##Utilisation de l'application(ihm)
Lancer localhost:8080
(insert screenshot(doc:SCREENSHOT))+default user.
user +pass
admin+pass


