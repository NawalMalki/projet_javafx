# Projet : Application desktop de gestion des étudiants
Bienvenue dans le référentiel de mon projet "Application desktop de gestion des étudiants". Ce projet a été réalisé dans le cadre du cours d'algorithmique avancée, encadré par le Professeur Sara Roubi. Il consiste en la conception et la réalisation d'une application desktop permettant d'ajouter des étudiants à une base de données. L'application offre également la possibilité de visualiser une liste d'étudiants, avec des fonctionnalités telles que la modification, la suppression, et l'affichage du profil, imprimable en format PDF.

## Encadrement

- **Encadré par** : Professeur Sara Roubi
- **Réalisé par** : Malki Nawal

## Jars Utilisés

- `mysql-connector-java-8.0.17`

## Configuration de la Base de Données

**Base de données** : `projet`

**Structure de la table `etudiant`** :

```sql
CREATE TABLE etudiant (
  nom varchar(50) DEFAULT NULL,
  prenom varchar(50) DEFAULT NULL,
  anneeNaissance varchar(10) DEFAULT NULL,
  adresse varchar(100) DEFAULT NULL,
  telephone int(11) DEFAULT NULL,
  email varchar(100) DEFAULT NULL,
  nationalite varchar(50) DEFAULT NULL,
  cne varchar(20) NOT NULL,
  cin varchar(11) DEFAULT NULL,
  anneeBac varchar(11) DEFAULT NULL,
  mentionBac varchar(50) DEFAULT NULL,
  filiere varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
```

## Remarque
Assurez-vous d'adapter les noms de fichiers, les chemins, et autres détails selon la structure réelle de votre projet.
