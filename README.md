# Documentation du Projet Pagode

## Introduction

Bienvenue dans la documentation du projet Pagode. Pagode est une plateforme de gestion des archives conçue pour simplifier et améliorer le processus de gestion des documents au sein de votre organisation.

## Présentation du Projet

Pagode s'appuie sur les dernières technologies pour offrir une solution complète de gestion des archives. Le backend est développé en utilisant Spring Boot, tandis que le frontend est construit avec Thymeleaf pour la gestion des vues. Le projet intègre également des fonctionnalités de sécurité et d'accès aux bases de données MySQL.

## Fonctionnalités Principales

1. **Gestion des Archives :**
   - Création, modification et suppression d'archives.
   - Suivi des versions des archives pour une gestion efficace des modifications.

2. **Interface Utilisateur Conviviale :**
   - Interface utilisateur moderne basée sur Thymeleaf pour une expérience utilisateur optimale.
   - Navigation intuitive et conviviale.

3. **Technologies Utilisées :**
   - Backend développé en Spring Boot.
   - Frontend construit avec Thymeleaf.
   - Base de données MySQL pour le stockage des archives.

## Dépendances Principales

### Backend

- Spring Boot (version 2.5.5)
- Spring Data JPA
- Thymeleaf pour la gestion des vues
- Lombok pour la simplification du code Java
- Spring Security pour la sécurité de l'application

### Base de Données

- MySQL Connector Java (version 8.0.26)

### Autres Dépendances

- Thymeleaf Layout Dialect
- Minio (version 8.5.7) pour le stockage d'objets
- OkHttp (version 4.11.0) pour les interactions HTTP
- Commons FileUpload (version 1.5) pour la gestion des fichiers

## Configuration

### Base de Données

- Type : MySQL
- Nom de la base de données : pagodedb3
- URL : jdbc:mysql://localhost:3306/pagodedb3?serverTimezone=UTC
- Utilisateur : root
- Mot de passe : admsql

### Propriétés d'Application

- Mode Hibernate DDL : update
- Affichage des requêtes SQL : activé
- Port du serveur : 8080

## Installation et Exécution

Pour installer et exécuter le projet Pagode localement, suivez les étapes décrites dans le fichier README.md du dépôt.

## Configuration Requise

- Java JDK 8 ou supérieur
- MySQL Server

 

## Licence

Ce projet est sous licence MIT. Veuillez consulter le fichier LICENSE.md pour plus d'informations.
