-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 13, 2017 at 08:53 AM
-- Server version: 10.1.28-MariaDB
-- PHP Version: 7.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `foodtrucks`
--

-- --------------------------------------------------------

--
-- Table structure for table `truck_info`
--

CREATE TABLE `truck_info` (
  `id` int(11) NOT NULL,
  `name` varchar(300) NOT NULL,
  `type` varchar(100) DEFAULT NULL,
  `zip_code` varchar(5) DEFAULT NULL,
  `phone_number` varchar(7) DEFAULT NULL,
  `area_code` varchar(3) DEFAULT NULL,
  `city` varchar(100) DEFAULT NULL,
  `address` varchar(300) DEFAULT NULL,
  `lat` double NOT NULL DEFAULT '0',
  `lon` double NOT NULL DEFAULT '0',
  `image_url` varchar(255) DEFAULT NULL,
  `time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `truck_info`
--

INSERT INTO `truck_info` (`id`, `name`, `type`, `zip_code`, `phone_number`, `area_code`, `city`, `address`, `lat`, `lon`, `image_url`, `time`) VALUES
(2, 'New Asian3', 'Thai', '91020', '2678988', '626', 'Alhambra', 'new address', 30, 30, 'Url', '2017-11-12 23:52:32'),
(3, 't', 'Mexican', NULL, '8590903', '818', 'Beverly Hills', '1442 S Euclid Ave', 34.198064099999996, -118.23511920000001, 'URL', '2017-11-12 23:52:32'),
(4, 'trrtg', 'Mexican', NULL, '8590903', '818', 'Beverly Hills', '1442 S Euclid Ave', 34.198064099999996, -118.23511920000001, 'URL', '2017-11-12 23:52:32'),
(5, 'trrtg', 'Mexican', NULL, '8590903', '818', 'Beverly Hills', '1442 S Euclid Ave', 34.198064099999996, -118.23511920000001, 'URL', '2017-11-12 23:52:32');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `truck_info`
--
ALTER TABLE `truck_info`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `truck_info`
--
ALTER TABLE `truck_info`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
