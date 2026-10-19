#TP5 : microservice-product

Petit projet réalisé avec Spring et Hibernate pour gérer des produits dans une base de données MySQL. Il suit une organisation en couches classique : entité, DAO, service, configuration. L'idée était surtout de bien comprendre comment Spring et Hibernate travaillent ensemble, sans passer par Spring Boot.

## Technologies utilisées

- Java 22
- Spring 5.3.20 (context, ORM, transactions)
- Hibernate 5.6.9.Final
- MySQL 8 (driver mysql-connector-j 8.0.33)
- Maven

## Structure du projet



Rapidement, le rôle de chaque partie :

- **Product** : l'entité, mappée sur la table `products` (id auto-généré, nom, prix).
- **IDao / ProductDaoImpl** : les opérations de base sur la base (ajouter, modifier, supprimer, chercher par id, tout lister) avec la `SessionFactory` de Hibernate.
- **ProductServiceImpl** : la logique métier. Il refuse par exemple un prix négatif, et les méthodes sont transactionnelles.
- **HibernateConfig** : crée la connexion (DataSource) et la `SessionFactory` à partir du fichier `application.properties`.
- **TransactionConfig** : active la gestion des transactions.
- **AppConfig** : lance le scan des composants du package `ma.spring.ma`.

## Configuration de la base de données

Les paramètres sont dans `src/main/resources/application.properties` :

```
jdbc.driver=com.mysql.cj.jdbc.Driver
jdbc.url=jdbc:mysql://localhost:3306/product_db?useSSL=false&serverTimezone=UTC
jdbc.username=root
jdbc.password=
```

Avant de lancer le projet :

1. Démarrer MySQL (avec XAMPP ou WAMP par exemple).
2. Créer la base de données :
   ```sql
   CREATE DATABASE product_db;
   ```
3. Adapter le nom d'utilisateur et le mot de passe si les vôtres sont différents.

Il n'est pas nécessaire de créer la table à la main : avec `hibernate.hbm2ddl.auto=update`, Hibernate crée la table `products` tout seul au premier lancement.

## Lancer le projet

1. Ouvrir le projet dans IntelliJ IDEA et laisser Maven télécharger les dépendances.
2. Lancer la classe `ma.spring.ma.test.MainApp`.

<img width="1016" height="348" alt="image" src="https://github.com/user-attachments/assets/1e66119d-1f64-4767-8ff9-710ce8918c05" />


Le programme crée un produit ("Microservice Gateway", 149.99), l'enregistre en base, puis affiche le nombre total de produits.

## Résultat de l'exécution

Voici la console après un lancement. On voit la requête `insert` puis le `select`, et le message de confirmation. Le total affiché est 2 parce que le programme avait déjà été lancé une fois auparavant.

<img width="684" height="71" alt="image" src="https://github.com/user-attachments/assets/36a241ab-6e83-477e-b016-283be0a0378d" />



