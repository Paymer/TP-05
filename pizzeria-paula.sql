-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Client :  127.0.0.1
-- Généré le :  Lun 24 Juillet 2017 à 13:11
-- Version du serveur :  5.7.14
-- Version de PHP :  5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `pizzeria-paula`
--

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `ID` int(11) NOT NULL,
  `NOM` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `PRENOM` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `ADRESSE` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `CP` int(11) NOT NULL,
  `VILLE` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `TEL` int(11) NOT NULL,
  `Date_Naissance` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Contenu de la table `client`
--

INSERT INTO `client` (`ID`, `NOM`, `PRENOM`, `ADRESSE`, `CP`, `VILLE`, `TEL`, `Date_Naissance`) VALUES
(1, 'ARMANI', 'Sophia', '11 Avenue Liberation', 44200, 'Nantes', 442255441, '1989-04-11'),
(2, 'BERURIER', 'Laurent', 'avenue Paris 11', 44562, 'Saint Herblain', 66224455, '1989-05-06'),
(3, 'DENNIS', 'Sylvain', '12 avenue perdition', 25896, 'Lorient', 656565, '1988-12-31'),
(4, 'FERNIOT', 'Michelle', ' 20 Avenue xxx', 545426, 'VANNES', 564354, '1889-02-25'),
(5, 'LOPERT', 'Nikos', 'Rue Carillon 43', 252563, 'PARIS', 5646542, '1952-06-05');

-- --------------------------------------------------------

--
-- Structure de la table `commande`
--

CREATE TABLE `commande` (
  `ID` int(11) NOT NULL,
  `NUM_COMMANDE` int(11) NOT NULL,
  `DATE_COMANDE` date NOT NULL,
  `CLIENT_ID` int(11) NOT NULL,
  `LIVREUR_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Contenu de la table `commande`
--

INSERT INTO `commande` (`ID`, `NUM_COMMANDE`, `DATE_COMANDE`, `CLIENT_ID`, `LIVREUR_ID`) VALUES
(1, 1, '2017-07-19', 1, 1),
(2, 2, '2017-07-19', 2, 2),
(3, 3, '2017-07-19', 3, 3),
(4, 4, '2017-07-19', 4, 4),
(5, 5, '2017-07-19', 5, 5),
(6, 6, '2017-07-19', 1, 5),
(7, 7, '2017-07-18', 2, 4),
(8, 8, '2017-07-19', 3, 5),
(9, 9, '2017-07-19', 3, 2),
(10, 10, '2017-07-20', 3, 1);

-- --------------------------------------------------------

--
-- Structure de la table `commande_pizza`
--

CREATE TABLE `commande_pizza` (
  `COMMAND_ID` int(11) NOT NULL,
  `PIZZA_ID` int(11) NOT NULL,
  `QUANTITE` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Contenu de la table `commande_pizza`
--

INSERT INTO `commande_pizza` (`COMMAND_ID`, `PIZZA_ID`, `QUANTITE`) VALUES
(1, 1, 2),
(1, 2, 1),
(2, 4, 1),
(3, 5, 3),
(5, 5, 2),
(6, 1, 3),
(6, 8, 1),
(6, 9, 2),
(6, 10, 1),
(7, 4, 2),
(8, 8, 2),
(9, 3, 1),
(10, 2, 1),
(10, 5, 1),
(10, 4, 1);

-- --------------------------------------------------------

--
-- Structure de la table `livreur`
--

CREATE TABLE `livreur` (
  `ID` int(11) NOT NULL,
  `NOM` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `PRENOM` text COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Contenu de la table `livreur`
--

INSERT INTO `livreur` (`ID`, `NOM`, `PRENOM`) VALUES
(1, 'MILLOT', 'Perrine'),
(2, 'RESTRI', 'Mélanie'),
(3, 'sdkfjhkj', 'Paula'),
(4, 'MADEIRA', 'Joana'),
(5, 'VERNE', 'Jules');

-- --------------------------------------------------------

--
-- Structure de la table `pizza`
--

CREATE TABLE `pizza` (
  `ID` int(11) NOT NULL,
  `NAME` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `CODE` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `PRICE` float NOT NULL,
  `TYPE` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `ACTIVE` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Contenu de la table `pizza`
--

INSERT INTO `pizza` (`ID`, `NAME`, `CODE`, `PRICE`, `TYPE`, `ACTIVE`) VALUES
(1, 'Peperoni', 'PEP', 12, 'VIANDE', 1),
(2, 'Margherita', 'MAR', 14, 'VIANDE', 1),
(3, 'La Reine', 'REI', 11.5, 'VIANDE', 1),
(4, 'La 4 Fromages', 'FRO', 12, 'VIANDE', 1),
(5, 'La Cannibale', 'CAN', 12.5, 'VIANDE', 0),
(6, 'La Savoyarde', 'SAV', 13, 'VIANDE', 1),
(7, 'L\'Orientale', 'ORI', 13.5, 'VIANDE', 1),
(8, 'L\'Indienne', 'IND', 14, 'VIANDE', 1),
(9, 'L\'Espagnole', 'ESP', 20, 'VIANDE', 1),
(10, 'L\'Allemande', 'ALL', 20, 'VIANDE', 1),
(13, 'Espanola', 'ESP', 20, 'VIANDE', 1);

--
-- Index pour les tables exportées
--

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`ID`);

--
-- Index pour la table `commande`
--
ALTER TABLE `commande`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `LIVREUR_ID` (`LIVREUR_ID`),
  ADD KEY `CLIENT_ID` (`CLIENT_ID`);

--
-- Index pour la table `commande_pizza`
--
ALTER TABLE `commande_pizza`
  ADD KEY `COMMAND_ID` (`COMMAND_ID`),
  ADD KEY `PIZZA_ID` (`PIZZA_ID`);

--
-- Index pour la table `livreur`
--
ALTER TABLE `livreur`
  ADD PRIMARY KEY (`ID`);

--
-- Index pour la table `pizza`
--
ALTER TABLE `pizza`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `client`
--
ALTER TABLE `client`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT pour la table `commande`
--
ALTER TABLE `commande`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT pour la table `livreur`
--
ALTER TABLE `livreur`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT pour la table `pizza`
--
ALTER TABLE `pizza`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `commande`
--
ALTER TABLE `commande`
  ADD CONSTRAINT `commande_ibfk_1` FOREIGN KEY (`CLIENT_ID`) REFERENCES `client` (`ID`),
  ADD CONSTRAINT `commande_ibfk_2` FOREIGN KEY (`LIVREUR_ID`) REFERENCES `livreur` (`ID`);

--
-- Contraintes pour la table `commande_pizza`
--
ALTER TABLE `commande_pizza`
  ADD CONSTRAINT `commande_pizza_ibfk_1` FOREIGN KEY (`COMMAND_ID`) REFERENCES `commande` (`ID`),
  ADD CONSTRAINT `commande_pizza_ibfk_2` FOREIGN KEY (`PIZZA_ID`) REFERENCES `pizza` (`ID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
