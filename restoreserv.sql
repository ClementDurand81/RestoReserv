-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mar. 23 jan. 2024 à 17:01
-- Version du serveur : 10.4.28-MariaDB
-- Version de PHP : 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `restoreserv`
--

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `id_client` int(11) NOT NULL COMMENT 'id',
  `Telephone` varchar(20) NOT NULL COMMENT 'Telephone Client perso',
  `Nom` varchar(255) DEFAULT NULL COMMENT 'Nom client perso',
  `Prenom` varchar(255) DEFAULT NULL COMMENT 'Prenom client perso',
  `Societe` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `reservation`
--

CREATE TABLE `reservation` (
  `numéro` int(11) NOT NULL COMMENT 'numéro Reservation',
  `nbPersonne` int(11) NOT NULL COMMENT 'Nombre de personne',
  `date` date NOT NULL COMMENT 'Date de reservation',
  `heureDebut` time NOT NULL COMMENT 'heure du début de la reservation',
  `heureFin` time NOT NULL COMMENT 'heure de fin de la reservation',
  `id_client` int(11) DEFAULT NULL COMMENT 'id_client',
  `id_table` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `tablerestaurant`
--

CREATE TABLE `tablerestaurant` (
  `id` int(11) NOT NULL COMMENT 'Id Table',
  `nbPlace` int(11) NOT NULL COMMENT 'Nombre de place '
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Déchargement des données de la table `tablerestaurant`
--

INSERT INTO `tablerestaurant` (`id`, `nbPlace`) VALUES
(1, 4),
(2, 4),
(3, 6),
(4, 8);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`id_client`);

--
-- Index pour la table `reservation`
--
ALTER TABLE `reservation`
  ADD PRIMARY KEY (`numéro`),
  ADD KEY `id_clientperso` (`id_client`),
  ADD KEY `id_table` (`id_table`);

--
-- Index pour la table `tablerestaurant`
--
ALTER TABLE `tablerestaurant`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `client`
--
ALTER TABLE `client`
  MODIFY `id_client` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id', AUTO_INCREMENT=163;

--
-- AUTO_INCREMENT pour la table `reservation`
--
ALTER TABLE `reservation`
  MODIFY `numéro` int(11) NOT NULL AUTO_INCREMENT COMMENT 'numéro Reservation', AUTO_INCREMENT=116;

--
-- AUTO_INCREMENT pour la table `tablerestaurant`
--
ALTER TABLE `tablerestaurant`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Id Table', AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
