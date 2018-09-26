-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 26-Set-2018 às 22:11
-- Versão do servidor: 10.1.16-MariaDB
-- PHP Version: 5.6.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_activities`
--
CREATE DATABASE IF NOT EXISTS `db_activities` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `db_activities`;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_activities`
--

CREATE TABLE `tb_activities` (
  `id` varchar(100) NOT NULL,
  `amount` int(11) NOT NULL,
  `subtotal` int(11) NOT NULL,
  `fee` int(11) NOT NULL,
  `ba_id` varchar(100) NOT NULL,
  `ba_number` varchar(100) NOT NULL,
  `ba_type` varchar(100) NOT NULL,
  `ba_holder` varchar(100) NOT NULL,
  `bank_id` varchar(100) NOT NULL,
  `bank_name` varchar(100) NOT NULL,
  `bank_description` text NOT NULL,
  `status` varchar(100) NOT NULL,
  `commited` varchar(100) NOT NULL,
  `paid` varchar(100) NOT NULL,
  `transation_type` varchar(100) NOT NULL,
  `created_at` varchar(30) NOT NULL,
  `updated_at` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
