CREATE DATABASE  IF NOT EXISTS `industry` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `industry`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win64 (x86_64)
--
-- Host: localhost    Database: industry
-- ------------------------------------------------------
-- Server version	5.5.0-m2-community

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
-- Table structure for table `cost`
--

DROP TABLE IF EXISTS `cost`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cost` (
  `Serialno` int(11) NOT NULL,
  `product` varchar(45) NOT NULL,
  `modelno` varchar(45) NOT NULL,
  `costperunit` int(11) NOT NULL,
  PRIMARY KEY (`Serialno`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cost`
--

LOCK TABLES `cost` WRITE;
/*!40000 ALTER TABLE `cost` DISABLE KEYS */;
INSERT INTO `cost` VALUES (1,'Product 1','Model 1',1000),(2,'Product 1','Model 2',2000),(3,'Product 1','Model 3',3000),(4,'Product 2','Model 1',4000),(5,'Product 2','Model 2',5000),(6,'Product 2','Model 3',6000),(7,'Product 3','Model 1',7000),(8,'Product 3','Model 2',8000),(9,'Product 3','Model 3',9000);
/*!40000 ALTER TABLE `cost` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dep_1`
--

DROP TABLE IF EXISTS `dep_1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dep_1` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `curr_step` int(11) NOT NULL DEFAULT '0',
  `expect_step` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dep_1`
--

LOCK TABLES `dep_1` WRITE;
/*!40000 ALTER TABLE `dep_1` DISABLE KEYS */;
INSERT INTO `dep_1` VALUES (1,2,3),(2,1,2),(3,2,2),(4,1,1),(5,3,3),(6,3,2),(7,0,0),(8,0,0),(9,1,0),(10,3,3),(11,2,2),(12,1,3),(13,2,2),(14,1,3),(15,3,3),(16,1,1),(17,2,2);
/*!40000 ALTER TABLE `dep_1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dep_2`
--

DROP TABLE IF EXISTS `dep_2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dep_2` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `curr_step` int(11) NOT NULL DEFAULT '0',
  `expect_step` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dep_2`
--

LOCK TABLES `dep_2` WRITE;
/*!40000 ALTER TABLE `dep_2` DISABLE KEYS */;
INSERT INTO `dep_2` VALUES (1,1,1),(2,1,2),(3,2,2),(4,1,1),(5,0,0),(6,0,1),(7,2,3),(8,1,1),(9,2,2),(10,1,1),(11,2,2),(12,1,2),(13,2,1),(14,2,2),(15,1,1),(16,3,3),(17,2,3);
/*!40000 ALTER TABLE `dep_2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dep_3`
--

DROP TABLE IF EXISTS `dep_3`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dep_3` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `curr_step` int(11) NOT NULL DEFAULT '0',
  `expect_step` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dep_3`
--

LOCK TABLES `dep_3` WRITE;
/*!40000 ALTER TABLE `dep_3` DISABLE KEYS */;
INSERT INTO `dep_3` VALUES (1,1,1),(2,1,2),(3,2,2),(4,1,1),(5,0,0),(6,0,1),(7,2,3),(8,1,1),(9,2,2),(10,1,1),(11,3,3),(12,1,2),(13,2,2),(14,1,2),(15,1,3),(16,1,1),(17,1,1);
/*!40000 ALTER TABLE `dep_3` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `login` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `password` varchar(45) NOT NULL,
  `category` varchar(45) NOT NULL,
  `name` varchar(50) NOT NULL,
  `phoneno` int(15) NOT NULL,
  `email` varchar(50) NOT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES (1,'123','Customer','Mukesh',567890,'qwert'),(2,'123','Customer','Ramesh',56789,'xcvb'),(3,'sas123','Customer','Saswat',9876,'sas@gmail.com'),(4,'zxc','Customer','Sanidhya',12345,'asdf'),(5,'asd','Customer','Anupam',5678,'qwert'),(6,'123','Customer','Ankit',4563,'acgtf'),(7,'123','Customer','Rakesh',23456,'chacha'),(8,'888','Supplier','Rohan Enterprises',544612,'Rohan@RohanEnterprises'),(9,'999','dep1','Amitesh',5412354,'Amitesh@industry'),(10,'1010','Admin','Rakesh',999999,'Rakesh@industry'),(11,'3456','Customer','Mohan',45576878,'mohan@mh'),(12,'144','dep2','Sourav',5412356,'Sourav@industry'),(13,'169','dep3','Mayank',5412357,'Mayank@industry');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_details`
--

DROP TABLE IF EXISTS `order_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_details` (
  `orderid` int(11) NOT NULL AUTO_INCREMENT,
  `product` varchar(45) NOT NULL,
  `modelno` varchar(45) NOT NULL,
  `quantity` int(11) NOT NULL,
  `custid` int(11) NOT NULL,
  `date` varchar(45) NOT NULL,
  `total_cost` int(11) NOT NULL,
  PRIMARY KEY (`orderid`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_details`
--

LOCK TABLES `order_details` WRITE;
/*!40000 ALTER TABLE `order_details` DISABLE KEYS */;
INSERT INTO `order_details` VALUES (1,'Product 2','Model 2',100,1,'2019-07-04',500000),(2,'Product 1','Model 2',90,6,'2019-07-04',180000),(3,'Product 3','Model 3',890,2,'2019-07-04',8010000),(4,'Product 2','Model 2',5,2,'2019-07-05',25000),(5,'Product 2','Model 2',5,1,'2019-07-05',25000),(6,'Product 2','Model 2',5,7,'2019-07-05',25000),(7,'Product 2','Model 2',5,3,'2019-07-05',25000),(8,'Product 2','Model 2',5,6,'2019-07-05',25000),(9,'Product 2','Model 2',5,3,'2019-07-05',25000),(10,'Product 2','Model 2',5,7,'2019-07-05',25000),(11,'Product 2','Model 2',5,5,'2019-07-05',25000),(12,'Product 2','Model 2',4,4,'2019-07-05',20000),(13,'Product 1','Model 1',3,2,'2019-07-05',3000),(14,'Product 2','Model 3',5,3,'2019-07-05',30000),(15,'Product 2','Model 3',5,5,'2019-07-05',30000),(16,'Product 2','Model 2',5,2,'2019-07-05',5000),(17,'Product 2','Model 2',5,6,'2019-07-06',25000),(18,'Product 2','Model 3',50,1,'2019-07-08',300000),(19,'Product 1','Model 1',23,1,'2019-07-10',23000);
/*!40000 ALTER TABLE `order_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `req_time`
--

DROP TABLE IF EXISTS `req_time`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `req_time` (
  `dep_no` int(11) NOT NULL AUTO_INCREMENT,
  `step1` int(11) NOT NULL DEFAULT '0',
  `step2` int(11) NOT NULL DEFAULT '0',
  `step3` int(11) NOT NULL DEFAULT '0',
  `step4` int(11) NOT NULL DEFAULT '0',
  `step5` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`dep_no`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `req_time`
--

LOCK TABLES `req_time` WRITE;
/*!40000 ALTER TABLE `req_time` DISABLE KEYS */;
INSERT INTO `req_time` VALUES (1,15,20,15,24,0),(2,30,25,18,0,0),(3,20,1,25,12,0);
/*!40000 ALTER TABLE `req_time` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stock`
--

DROP TABLE IF EXISTS `stock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stock` (
  `type` int(11) NOT NULL AUTO_INCREMENT,
  `qty_present` int(11) NOT NULL,
  `qty_needed` int(11) NOT NULL,
  PRIMARY KEY (`type`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stock`
--

LOCK TABLES `stock` WRITE;
/*!40000 ALTER TABLE `stock` DISABLE KEYS */;
INSERT INTO `stock` VALUES (1,45,55),(2,67,96),(3,46,90),(4,36,65);
/*!40000 ALTER TABLE `stock` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-07-10  9:37:03
