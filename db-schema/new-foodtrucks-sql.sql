-- MySQL dump 10.13  Distrib 5.7.20, for macos10.12 (x86_64)
--
-- Host: localhost    Database: foodtrucks
-- ------------------------------------------------------
-- Server version	5.7.20

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `truck_info`
--

DROP TABLE IF EXISTS `truck_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `truck_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(300) NOT NULL,
  `startHour0` varchar(5) DEFAULT NULL,
  `startHour1` varchar(5) DEFAULT NULL,
  `startHour2` varchar(5) DEFAULT NULL,
  `startHour3` varchar(5) DEFAULT NULL,
  `startHour4` varchar(5) DEFAULT NULL,
  `startHour5` varchar(5) DEFAULT NULL,
  `startHour6` varchar(5) DEFAULT NULL,
  `endHour0` varchar(5) DEFAULT NULL,
  `endHour1` varchar(5) DEFAULT NULL,
  `endHour2` varchar(5) DEFAULT NULL,
  `endHour3` varchar(5) DEFAULT NULL,
  `endHour4` varchar(5) DEFAULT NULL,
  `endHour5` varchar(5) DEFAULT NULL,
  `endHour6` varchar(5) DEFAULT NULL,
  `ampmS0` tinyint(1) NOT NULL DEFAULT '0',
  `ampmS1` tinyint(1) NOT NULL DEFAULT '0',
  `ampmS2` tinyint(1) NOT NULL DEFAULT '0',
  `ampmS3` tinyint(1) NOT NULL DEFAULT '0',
  `ampmS4` tinyint(1) NOT NULL DEFAULT '0',
  `ampmS5` tinyint(1) NOT NULL DEFAULT '0',
  `ampmS6` tinyint(1) NOT NULL DEFAULT '0',
  `ampmE0` tinyint(1) NOT NULL DEFAULT '0',
  `ampmE1` tinyint(1) NOT NULL DEFAULT '0',
  `ampmE2` tinyint(1) NOT NULL DEFAULT '0',
  `ampmE3` tinyint(1) NOT NULL DEFAULT '0',
  `ampmE4` tinyint(1) NOT NULL DEFAULT '0',
  `ampmE5` tinyint(1) NOT NULL DEFAULT '0',
  `ampmE6` tinyint(1) NOT NULL DEFAULT '0',
  `type` varchar(100) DEFAULT NULL,
  `zipCode` varchar(5) DEFAULT NULL,
  `phoneNumber` varchar(7) DEFAULT NULL,
  `areaCode` varchar(3) DEFAULT NULL,
  `city` varchar(100) DEFAULT NULL,
  `address` varchar(300) DEFAULT NULL,
  `lat` double NOT NULL DEFAULT '0',
  `lon` double NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `truck_info`
--

LOCK TABLES `truck_info` WRITE;
/*!40000 ALTER TABLE `truck_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `truck_info` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-10-24  3:23:42
