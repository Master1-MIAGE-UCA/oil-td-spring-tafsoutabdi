Projet Spring Boot - Gestion de lancés de dés

Description

L'application "Dice" permet de simuler des lancés de dés et de conserver un historique des résultats dans une base de données. Le projet met en œuvre les concepts fondamentaux de Spring Boot, notamment l'injection de dépendances, les services RESTful, les entités JPA et les repositories.

Fonctionnalités principales

Lancer un dé unique : Retourne un nombre entre 1 et 6.

Lancer plusieurs dés : Permet de lancer un nombre spécifié de dés.

Historique des lancés : Enregistre chaque lancé dans une base de données H2.

Consultation des lancés : Récupère l'historique complet des lancés.

Endpoints REST

Lancer des dés

GET /api/rollDice : Lance un seul dé.

GET /api/rollDices/{X} : Lance X dés.

Consulter l'historique des lancés

GET /api/diceLogs : Retourne tous les enregistrements sous format JSON.

Installation et exécution

Cloner le dépôt GitHub :

git clone https://github.com/Master1-MIAGE-UCA/oil-td-spring-tafsoutabdi.git

Accéder au projet :

cd oil-td-spring-tafsoutabdi

Construire le projet et exécuter l'application :

./mvnw spring-boot:run

Accéder aux endpoints dans le navigateur ou Postman :

http://localhost:8081/api/rollDice

http://localhost:8081/api/rollDices/5

http://localhost:8081/api/diceLogs

Technologies utilisées

Framework principal : Spring Boot

Base de données : H2

Langage : Java

Gestion de projet : Maven

Fonctionnalités avancées (Bonus)

Documentation API : Swagger (URL : http://localhost:8081/swagger-ui.html)

Simplification du code : Lombok (génération automatique de getters, setters et constructeurs)

