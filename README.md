<h1> MINI PROJET JAVA FX </h1>
<b>Encadré par :</b> Professeur Sara Roubi<br>
<b>Réalisé par :</b> Malki Nawal 


<h3> Jars utilisés : </h3>
<ul>
  <li>mysql-connector-java-8.0.17</li>

</ul>
<h3>Configuration de la base de données </h3>
--
-- Base de données : `projet`
--

-- --------------------------------------------------------

--
-- Structure de la table `etudiant`
--

CREATE TABLE `etudiant` (
  `nom` varchar(50) DEFAULT NULL,
  `prenom` varchar(50) DEFAULT NULL,
  `anneeNaissance` varchar(10) DEFAULT NULL,
  `adresse` varchar(100) DEFAULT NULL,
  `telephone` int(11) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `nationalite` varchar(50) DEFAULT NULL,
  `cne` varchar(20) NOT NULL,
  `cin` varchar(11) DEFAULT NULL,
  `anneeBac` varchar(11) DEFAULT NULL,
  `mentionBac` varchar(50) DEFAULT NULL,
  `filiere` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
