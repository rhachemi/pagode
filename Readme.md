 # Documentation d'Installation - Environnement Docker avec Debian, Java 17, Tomcat 10 et MySQL sur Windows 10 (WSL)

## 1. Installation de Debian sur WSL

### 1.1 Installation de WSL
- Suivez les instructions de Microsoft pour installer WSL sur Windows 10 : [Install WSL](https://docs.microsoft.com/en-us/windows/wsl/install)

### 1.2 Installation de Debian
- Installez Debian à partir du Microsoft Store en suivant les instructions : [Debian on Microsoft Store](https://www.microsoft.com/store/apps/9MSVKQC78PK6)

## 2. Configuration de l'Environnement Debian

### 2.1 Mise à jour du Système
```bash
sudo apt update
sudo apt upgrade -y
``` 


### 2.2 Installation de Java 17
```bash
sudo apt install openjdk-17-jdk -y
```

### 2.3 Installation de Docker
```sudo apt install docker.io -y
sudo systemctl start docker
sudo systemctl enable docker
```
### 2.4 installation de Portainer
```sudo apt install docker.io -y
sudo systemctl start docker
sudo systemctl enable docker
```
Accédez à Portainer via http://localhost:9000

 

## 3. Installation d'Apache Tomcat et MySQL dans Docker

### 3.1 Installation de Tomcat 10
```
sudo docker run -d -p 8080:8080 --name=tomcat --restart=always tomcat:10
```
Accédez à Tomcat via http://localhost:8080

### 3.2 Installation de MySQL
```
sudo docker run -d -p 3306:3306 --name=mysql --restart=always -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=mydb -e MYSQL_USER=user -e MYSQL_PASSWORD=password mysql:latest

```
## 4. Déploiement de l'Application dans Tomcat

### 4.1 Obtention du fichier WAR
Construisez votre application Java avec Java 17 et obtenez le fichier WAR.

### 4.2 Déploiement dans Tomcat
```
sudo docker cp /chemin/vers/votre/application.war tomcat:/usr/local/tomcat/webapps
```
L'application sera automatiquement déployée par Tomcat.

## 5. Configuration de la Base de Données MySQL

### 5.1 Connexion à MySQL
```
sudo docker exec -it mysql bash
mysql -u root -p
```
### 5.2 Configuration de la Base de Données
```
CREATE DATABASE mydb;
USE mydb;
-- Ajoutez vos scripts SQL ici, le cas échéant.
```
## 6. Script de Création du Compte Administrateur dans la Table User
### 6.1 Script SQL

-- Création d'un rôle administrateur
```
INSERT INTO Role (description, details) VALUES ('ROLE_ADMIN', 'Rôle d\'administrateur');
```
-- Création de l'utilisateur administrateur
```
INSERT INTO "User" (firstname, lastname, username, password) VALUES ('Admin', 'Admin', 'admin', '$2a$10$68l8l2...'); -- Remplacez le hash du mot de passe avec celui généré pour votre mot de passe
```
-- Attribution du rôle administrateur à l'utilisateur
```
INSERT INTO user_role (user_id, role_id) VALUES ((SELECT id FROM "User" WHERE username = 'admin'), (SELECT id FROM Role WHERE description = 'ROLE_ADMIN'));
```

Veillez à remplacer $2a$10$68l8l2... par le hash de votre mot de passe administrateur. Vous pouvez générer un hash avec BCrypt ou un autre algorithme de hachage.

Assurez-vous d'ajuster les chemins, les adresses IP et autres configurations selon vos besoins spécifiques. Cette documentation fournit une base pour l'installation de Debian avec Docker, Tomcat 10, MySQL, et Portainer sur un environnement Windows 10 avec WSL.


 


