-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mer. 03 jan. 2024 à 14:36
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
-- Structure de la table `clientperso`
--

CREATE TABLE `clientperso` (
  `id` int(11) NOT NULL COMMENT 'id',
  `Telephone` int(20) NOT NULL COMMENT 'Telephone Client perso',
  `Nom` varchar(255) NOT NULL COMMENT 'Nom client perso',
  `Prenom` varchar(255) NOT NULL COMMENT 'Prenom client perso'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `clientpro`
--

CREATE TABLE `clientpro` (
  `id` int(11) NOT NULL COMMENT 'Id Client pro',
  `Telephone` int(20) NOT NULL COMMENT 'Telephone client pro',
  `nomSociete` varchar(255) NOT NULL COMMENT 'Nom de societe'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `reservation`
--

CREATE TABLE `reservation` (
  `id` int(11) NOT NULL COMMENT 'id Réservation',
  `numero` int(11) NOT NULL COMMENT 'Numéro Réservation',
  `nbPersonne` int(11) NOT NULL COMMENT 'Nombre de personne',
  `date` date NOT NULL COMMENT 'Date de reservation',
  `heureDebut` time NOT NULL COMMENT 'heure du début de la reservation',
  `heureFin` time NOT NULL COMMENT 'heure de fin de la reservation'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `siteweb`
--

CREATE TABLE `siteweb` (
  `id` int(11) NOT NULL COMMENT 'id reservation Web',
  `Nom` varchar(11) NOT NULL COMMENT 'Nom reservation Web',
  `Prenom` varchar(11) NOT NULL COMMENT 'Prenom reservation Web',
  `nomSociete` varchar(255) NOT NULL COMMENT 'nom de la société',
  `Telephone` int(20) NOT NULL COMMENT 'Num telephone reservation Web',
  `numReservation` int(11) NOT NULL COMMENT 'Numéro reservation Web',
  `nbPersonne` int(11) NOT NULL COMMENT 'Nombre Personne reservation Web',
  `Date` date NOT NULL COMMENT 'Date reservation Web',
  `heureDebut` time NOT NULL COMMENT 'Heure Debut reservation Web',
  `heureFin` time NOT NULL COMMENT 'Heure Fin reservation Web'
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
-- Index pour les tables déchargées
--

--
-- Index pour la table `clientperso`
--
ALTER TABLE `clientperso`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `clientpro`
--
ALTER TABLE `clientpro`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `reservation`
--
ALTER TABLE `reservation`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `siteweb`
--
ALTER TABLE `siteweb`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `clientperso`
--
ALTER TABLE `clientperso`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id';

--
-- AUTO_INCREMENT pour la table `clientpro`
--
ALTER TABLE `clientpro`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Id Client pro';

--
-- AUTO_INCREMENT pour la table `reservation`
--
ALTER TABLE `reservation`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id Réservation';

--
-- AUTO_INCREMENT pour la table `siteweb`
--
ALTER TABLE `siteweb`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id reservation Web';
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
