-- MySQL dump 10.13  Distrib 8.0.15, for macos10.14 (x86_64)
--
-- Host: mysql4.cs.stonybrook.edu    Database: zhaowhuang
-- ------------------------------------------------------
-- Server version	5.7.20-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8mb4 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Accounts`
--

DROP TABLE IF EXISTS `Accounts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Accounts` (
  `ClientId` int(11) NOT NULL,
  `AccountNumber` int(11) NOT NULL,
  `Stock` char(20) NOT NULL,
  `DateOpened` date DEFAULT NULL,
  `NumberShares` int(11) DEFAULT NULL,
  `AccountID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ClientId`,`AccountNumber`,`Stock`),
  KEY `Stock` (`Stock`),
  CONSTRAINT `accounts_ibfk_1` FOREIGN KEY (`ClientId`) REFERENCES `Clients` (`Id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `accounts_ibfk_2` FOREIGN KEY (`Stock`) REFERENCES `Stock` (`StockSymbol`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Accounts`
--

LOCK TABLES `Accounts` WRITE;
/*!40000 ALTER TABLE `Accounts` DISABLE KEYS */;
/*!40000 ALTER TABLE `Accounts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Clients`
--

DROP TABLE IF EXISTS `Clients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Clients` (
  `Email` char(32) DEFAULT NULL,
  `CreditCardNumber` char(20) DEFAULT NULL,
  `Id` int(11) NOT NULL,
  `Rating` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  CONSTRAINT `clients_ibfk_1` FOREIGN KEY (`Id`) REFERENCES `Person` (`SSN`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Clients`
--

LOCK TABLES `Clients` WRITE;
/*!40000 ALTER TABLE `Clients` DISABLE KEYS */;
INSERT INTO `Clients` (`Email`, `CreditCardNumber`, `Id`, `Rating`) VALUES ('customer1@stonybrook.edu','6223666677663322',1002,1);
/*!40000 ALTER TABLE `Clients` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Employee`
--

DROP TABLE IF EXISTS `Employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Employee` (
  `SSN` int(11) NOT NULL,
  `StartDate` date DEFAULT NULL,
  `HourlyRate` int(11) DEFAULT NULL,
  `Email` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`SSN`),
  CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`SSN`) REFERENCES `Person` (`SSN`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Employee`
--

LOCK TABLES `Employee` WRITE;
/*!40000 ALTER TABLE `Employee` DISABLE KEYS */;
INSERT INTO `Employee` (`SSN`, `StartDate`, `HourlyRate`, `Email`) VALUES (1000,'2019-05-04',35,'manager@stonybrook.edu'),(1001,'2016-05-04',50,'cr@stonybrook.edu');
/*!40000 ALTER TABLE `Employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `HiddenStopOrder`
--

DROP TABLE IF EXISTS `HiddenStopOrder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `HiddenStopOrder` (
  `OrderId` int(11) NOT NULL AUTO_INCREMENT,
  `Date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `PricePerShare` double DEFAULT NULL,
  `Price` int(11) DEFAULT NULL,
  `TradeId` int(11) DEFAULT NULL,
  PRIMARY KEY (`OrderId`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `HiddenStopOrder`
--

LOCK TABLES `HiddenStopOrder` WRITE;
/*!40000 ALTER TABLE `HiddenStopOrder` DISABLE KEYS */;
INSERT INTO `HiddenStopOrder` (`OrderId`, `Date`, `PricePerShare`, `Price`, `TradeId`) VALUES (1,'2012-04-22 03:48:57',46,222,31),(2,'2018-08-06 04:41:54',9,116,27),(3,'2015-01-09 13:57:49',37,194,31),(4,'2010-04-26 15:31:26',26,113,31),(5,'2010-04-06 11:20:00',40,107,27),(6,'2017-02-21 15:33:11',38,229,27),(7,'2019-10-26 18:57:07',8,190,31),(8,'2010-11-23 00:12:26',47,69,27),(9,'2018-12-10 06:10:33',21,87,27),(10,'2019-04-30 16:36:20',17,60,31),(11,'2013-05-05 03:31:46',28,52,31),(12,'2010-06-06 22:21:57',6,14,31),(13,'2012-12-01 06:47:01',27,28,27),(14,'2010-04-16 22:08:01',38,86,27),(15,'2018-01-09 19:49:52',30,119,31),(16,'2012-12-18 12:02:34',27,256,31),(17,'2012-05-29 16:59:02',5,241,27),(18,'2010-05-25 21:08:53',18,129,31),(19,'2012-10-20 02:03:13',47,237,27),(20,'2013-04-04 16:45:03',39,92,27),(21,'2018-09-18 08:14:47',34,31,31),(22,'2014-06-13 18:51:39',9,200,31),(23,'2011-09-02 02:06:06',11,119,31),(24,'2010-05-20 23:06:57',37,20,27),(25,'2018-04-23 15:53:47',42,128,31),(26,'2015-12-12 05:41:20',16,213,27),(27,'2012-05-18 18:47:45',8,256,27),(28,'2013-11-06 05:40:12',4,166,31),(29,'2015-06-15 13:10:49',17,51,27),(30,'2011-01-06 22:58:56',49,95,31),(31,'2019-06-07 12:36:46',33,240,27),(32,'2012-12-17 01:34:03',19,142,27),(33,'2010-02-18 19:55:04',10,253,31),(34,'2016-05-19 02:30:50',34,28,27),(35,'2011-03-15 19:32:18',12,171,31),(36,'2019-01-27 21:59:22',39,27,27),(37,'2016-06-12 01:51:46',21,162,31),(38,'2012-07-04 03:31:19',19,52,27),(39,'2017-12-10 17:23:08',44,56,27),(40,'2019-03-28 21:14:41',24,131,27),(41,'2016-12-19 20:41:05',43,181,31),(42,'2010-08-23 13:47:21',24,154,27),(43,'2012-08-12 18:02:36',31,92,31),(44,'2016-12-02 19:39:25',18,95,27),(45,'2019-04-20 03:14:35',43,70,31),(46,'2017-08-11 14:19:25',35,32,31),(47,'2011-02-04 00:07:51',41,212,31),(48,'2013-07-05 06:59:00',4,212,27),(49,'2015-11-15 00:32:56',33,194,31),(50,'2019-12-27 15:13:47',29,55,31),(51,'2019-09-23 07:15:20',26,63,27),(52,'2018-08-27 01:36:52',31,139,31),(53,'2019-10-07 05:43:03',15,203,31),(54,'2011-11-23 05:01:27',45,133,27),(55,'2010-02-19 00:25:24',17,7,27),(56,'2017-10-30 02:17:49',17,249,27),(57,'2018-05-05 08:48:09',46,243,31),(58,'2017-06-18 19:27:34',35,140,27),(59,'2019-01-17 04:16:17',11,17,31),(60,'2010-08-27 18:29:19',4,71,31),(61,'2019-07-28 02:39:37',16,8,27),(62,'2017-09-25 13:46:02',3,7,31),(63,'2019-05-23 14:52:05',29,20,27),(64,'2015-06-17 12:09:04',34,169,27),(65,'2019-04-05 19:06:26',25,158,31),(66,'2012-04-28 09:37:22',33,213,27),(67,'2013-01-05 14:29:31',17,143,27),(68,'2012-05-16 02:52:57',6,176,27),(69,'2019-01-15 06:02:24',29,53,31),(70,'2016-10-27 20:20:27',17,132,27),(71,'2016-05-24 15:22:03',43,109,31),(72,'2018-04-09 15:36:12',45,101,27),(73,'2015-12-16 02:16:37',35,247,27),(74,'2016-10-31 13:15:26',24,121,31),(75,'2011-01-16 09:15:37',25,225,31),(76,'2018-04-15 08:43:28',20,231,31),(77,'2014-08-07 14:14:06',17,146,27),(78,'2014-02-09 14:30:18',21,250,27),(79,'2017-09-13 17:07:53',32,170,31),(80,'2015-12-15 13:32:19',18,252,27),(81,'2018-03-07 04:27:01',18,140,31),(82,'2012-12-10 05:24:56',10,233,27),(83,'2012-08-17 04:33:48',12,237,27),(84,'2014-09-11 11:24:12',44,62,31),(85,'2017-03-04 05:25:53',33,11,31),(86,'2015-07-11 00:20:22',11,250,27),(87,'2013-07-06 16:07:40',31,105,27),(88,'2016-12-05 17:46:18',24,192,31),(89,'2016-07-02 00:08:27',11,163,27),(90,'2017-09-26 23:55:10',34,66,27),(91,'2013-10-05 03:40:23',46,210,27),(92,'2014-09-28 16:49:02',44,22,27),(93,'2012-02-23 21:07:15',20,14,27),(94,'2013-02-06 05:55:14',36,140,31),(95,'2018-08-25 12:38:47',31,137,31),(96,'2016-10-07 22:48:50',35,110,27),(97,'2018-06-12 16:02:25',14,234,27),(98,'2012-09-16 00:22:20',30,40,27),(99,'2012-11-14 01:48:55',24,207,27),(100,'2017-09-15 14:40:52',26,137,31);
/*!40000 ALTER TABLE `HiddenStopOrder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Location`
--

DROP TABLE IF EXISTS `Location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Location` (
  `ZipCode` int(11) NOT NULL,
  `City` char(20) NOT NULL,
  `State` char(20) NOT NULL,
  `SSN` int(11) NOT NULL,
  PRIMARY KEY (`SSN`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Location`
--

LOCK TABLES `Location` WRITE;
/*!40000 ALTER TABLE `Location` DISABLE KEYS */;
INSERT INTO `Location` (`ZipCode`, `City`, `State`, `SSN`) VALUES (11790,'Stony Brook','NY',1000),(11790,'Stony Brook','NY',1001),(11790,'Stony Brook','NY',1002),(11766,'Coram','VN',233567843),(11688,'Coram','11727',456456332);
/*!40000 ALTER TABLE `Location` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Orders`
--

DROP TABLE IF EXISTS `Orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Orders` (
  `EmployeeId` int(11) DEFAULT NULL,
  `OrderId` int(11) NOT NULL AUTO_INCREMENT,
  `OrderType` varchar(35) DEFAULT NULL,
  `StockSymbol` varchar(20) DEFAULT NULL,
  `NumberOfShare` int(11) DEFAULT NULL,
  `buy_sell` varchar(10) DEFAULT NULL,
  `Percentage` int(11) DEFAULT NULL,
  `Time` date DEFAULT NULL,
  `ClientID` int(11) DEFAULT NULL,
  `Fee` double DEFAULT NULL,
  `PricePerShare` double DEFAULT NULL,
  PRIMARY KEY (`OrderId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Orders`
--

LOCK TABLES `Orders` WRITE;
/*!40000 ALTER TABLE `Orders` DISABLE KEYS */;
INSERT INTO `Orders` (`EmployeeId`, `OrderId`, `OrderType`, `StockSymbol`, `NumberOfShare`, `buy_sell`, `Percentage`, `Time`, `ClientID`, `Fee`, `PricePerShare`) VALUES (1001,7,'MarketOrder','asd',20,'Buy',NULL,'2019-05-06',1002,100,100),(NULL,8,'MarketOrder','asd',10,'Sell',NULL,'2019-05-06',1002,100,200);
/*!40000 ALTER TABLE `Orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Person`
--

DROP TABLE IF EXISTS `Person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Person` (
  `SSN` int(11) NOT NULL,
  `LastName` char(20) NOT NULL,
  `FirstName` char(20) NOT NULL,
  `Address` char(100) DEFAULT NULL,
  `ZipCode` int(11) DEFAULT NULL,
  `Telephone` char(15) DEFAULT NULL,
  PRIMARY KEY (`SSN`),
  KEY `ZipCode` (`ZipCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Person`
--

LOCK TABLES `Person` WRITE;
/*!40000 ALTER TABLE `Person` DISABLE KEYS */;
INSERT INTO `Person` (`SSN`, `LastName`, `FirstName`, `Address`, `ZipCode`, `Telephone`) VALUES (1000,'Manager','Manager','100 Nicolls Road',11790,'6316323333'),(1001,'Representative','Customer','100 Circle Road',11790,'6312223333'),(1002,'Customer1','Customer1','200 Circle Road',11790,'6317774455');
/*!40000 ALTER TABLE `Person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Stock`
--

DROP TABLE IF EXISTS `Stock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Stock` (
  `StockSymbol` char(20) NOT NULL,
  `CompanyName` char(20) NOT NULL,
  `StockType` char(20) NOT NULL,
  `NumShares` int(11) NOT NULL,
  `PricePerShare` double DEFAULT NULL,
  PRIMARY KEY (`StockSymbol`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Stock`
--

LOCK TABLES `Stock` WRITE;
/*!40000 ALTER TABLE `Stock` DISABLE KEYS */;
INSERT INTO `Stock` (`StockSymbol`, `CompanyName`, `StockType`, `NumShares`, `PricePerShare`) VALUES ('asd','sdsds','1asd',1212,200),('F','Ford','automotive',9,150),('GM','General Motors','automotive',34,200),('IBM','IBM','computer',91,250);
/*!40000 ALTER TABLE `Stock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `StockChange`
--

DROP TABLE IF EXISTS `StockChange`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `StockChange` (
  `StockSymbol` char(20) DEFAULT NULL,
  `PricePerShare` double DEFAULT NULL,
  `changeTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `StockChange`
--

LOCK TABLES `StockChange` WRITE;
/*!40000 ALTER TABLE `StockChange` DISABLE KEYS */;
INSERT INTO `StockChange` (`StockSymbol`, `PricePerShare`, `changeTime`) VALUES ('asd',12,'2019-05-03 20:44:15'),('F',12,'2019-05-03 20:48:21'),('F',15,'2019-05-03 21:50:24'),('F',3444,'2019-05-03 21:56:54'),('asd',1400,'2019-05-05 22:22:12'),('asd',1410,'2019-05-05 22:25:20'),('asd',1420,'2019-05-05 22:29:06'),('asd',100,'2019-05-06 18:45:56'),('F',150,'2019-05-06 18:46:02'),('GM',200,'2019-05-06 18:46:08'),('IBM',250,'2019-05-06 18:46:13'),('asd',200,'2019-05-06 18:49:03');
/*!40000 ALTER TABLE `StockChange` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `StockHold`
--

DROP TABLE IF EXISTS `StockHold`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `StockHold` (
  `NumShare` int(11) DEFAULT NULL,
  `StockSymbol` char(20) NOT NULL,
  `ClientID` int(11) NOT NULL,
  PRIMARY KEY (`StockSymbol`,`ClientID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `StockHold`
--

LOCK TABLES `StockHold` WRITE;
/*!40000 ALTER TABLE `StockHold` DISABLE KEYS */;
INSERT INTO `StockHold` (`NumShare`, `StockSymbol`, `ClientID`) VALUES (91,'asd',119),(12,'asd',122),(20,'asd',130),(10,'asd',1002),(21475,'asd',1232323),(45,'asd',233567843),(70089,'F',1232323),(65,'GM',119),(2,'GM',1232323),(55,'IBM',1232323);
/*!40000 ALTER TABLE `StockHold` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Trade`
--

DROP TABLE IF EXISTS `Trade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Trade` (
  `AccountId` int(11) NOT NULL,
  `BrokerId` varchar(30) NOT NULL,
  `TransactionId` int(11) NOT NULL,
  `OrderId` int(11) NOT NULL,
  `StockId` char(20) NOT NULL,
  PRIMARY KEY (`AccountId`,`BrokerId`,`TransactionId`,`OrderId`,`StockId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Trade`
--

LOCK TABLES `Trade` WRITE;
/*!40000 ALTER TABLE `Trade` DISABLE KEYS */;
/*!40000 ALTER TABLE `Trade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TrailingStopOrder`
--

DROP TABLE IF EXISTS `TrailingStopOrder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `TrailingStopOrder` (
  `OrderId` int(11) NOT NULL AUTO_INCREMENT,
  `Date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `PricePerShare` double DEFAULT NULL,
  `Price` int(11) DEFAULT NULL,
  `TradeId` int(11) DEFAULT NULL,
  PRIMARY KEY (`OrderId`)
) ENGINE=InnoDB AUTO_INCREMENT=214 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TrailingStopOrder`
--

LOCK TABLES `TrailingStopOrder` WRITE;
/*!40000 ALTER TABLE `TrailingStopOrder` DISABLE KEYS */;
INSERT INTO `TrailingStopOrder` (`OrderId`, `Date`, `PricePerShare`, `Price`, `TradeId`) VALUES (1,'2019-05-05 03:33:09',23,890,29),(2,'2019-05-05 03:48:35',14,174,29),(3,'2019-05-05 03:48:35',11,120,29),(4,'2019-05-05 03:48:35',6,15,29),(5,'2019-05-05 03:48:35',40,194,29),(6,'2019-05-05 03:48:35',18,212,29),(7,'2019-05-05 03:48:35',23,69,29),(8,'2019-05-05 03:48:35',10,123,29),(9,'2019-05-05 03:48:36',13,224,29),(10,'2019-05-05 03:48:36',24,209,29),(11,'2019-05-05 03:48:36',40,20,29),(12,'2019-05-05 03:48:36',35,93,29),(13,'2019-05-05 03:48:36',6,148,29),(14,'2019-05-05 03:48:36',8,68,29),(15,'2018-06-19 13:05:37',32,28,29),(16,'2011-10-26 06:03:32',21,223,30),(17,'2017-01-12 09:29:39',46,117,30),(18,'2010-05-05 08:51:27',8,209,32),(19,'2015-06-16 18:25:35',37,157,28),(20,'2014-01-04 01:52:55',25,80,28),(21,'2017-07-29 07:28:51',36,180,32),(22,'2019-04-30 09:43:22',42,26,28),(23,'2012-01-22 20:36:03',42,104,29),(24,'2013-04-25 13:22:41',11,146,29),(25,'2011-03-22 15:41:17',1,243,30),(26,'2015-10-21 10:08:34',26,60,28),(27,'2016-12-15 15:11:34',30,238,32),(28,'2015-04-01 03:40:57',24,36,30),(29,'2011-04-23 15:42:01',30,84,30),(30,'2016-02-15 14:34:14',43,55,30),(31,'2019-09-23 06:58:17',11,66,29),(32,'2014-08-07 21:18:20',24,163,32),(33,'2019-12-12 12:01:07',25,156,29),(34,'2017-12-01 08:22:56',35,63,30),(35,'2010-02-27 14:58:23',27,135,32),(36,'2011-10-26 03:57:05',9,92,30),(37,'2012-12-10 08:34:57',30,104,30),(38,'2015-12-07 06:55:10',31,123,28),(39,'2017-01-24 19:17:27',39,219,30),(40,'2016-05-29 03:57:34',19,30,30),(41,'2010-10-10 13:33:43',13,65,30),(42,'2017-06-10 04:08:15',33,37,32),(43,'2012-08-31 05:24:39',21,235,32),(44,'2018-11-22 09:12:29',31,17,29),(45,'2013-08-11 16:05:15',7,102,28),(46,'2016-08-27 06:54:01',31,182,32),(47,'2015-09-12 02:55:20',36,149,28),(48,'2011-11-05 04:37:06',37,149,30),(49,'2013-09-17 17:49:05',3,97,30),(50,'2011-05-07 08:36:20',16,156,29),(51,'2010-02-18 17:27:50',28,28,28),(52,'2010-12-10 08:55:38',27,32,28),(53,'2011-02-13 17:07:48',36,65,29),(54,'2010-11-16 04:12:09',30,153,32),(55,'2011-01-14 16:52:05',28,131,28),(56,'2013-08-04 05:14:46',25,162,30),(57,'2018-09-16 09:40:15',10,60,30),(58,'2013-12-13 02:01:24',3,235,30),(59,'2013-04-15 07:44:11',33,48,32),(60,'2014-12-12 16:59:35',17,44,32),(61,'2018-11-15 15:53:23',34,44,28),(62,'2013-02-12 00:40:43',38,207,32),(63,'2019-05-03 01:38:26',37,49,30),(64,'2013-01-11 03:22:43',20,49,29),(65,'2013-12-18 12:26:09',36,26,32),(66,'2017-05-16 22:47:38',7,139,28),(67,'2016-03-14 21:56:15',15,256,28),(68,'2014-07-18 21:44:32',11,194,30),(69,'2016-08-01 12:10:58',13,174,30),(70,'2011-05-02 06:31:33',12,41,29),(71,'2011-07-07 04:16:19',25,85,32),(72,'2011-12-07 02:08:05',2,34,28),(73,'2010-04-14 01:01:55',40,34,32),(74,'2012-03-03 03:18:57',20,114,30),(75,'2018-04-04 01:50:46',46,64,28),(76,'2011-10-14 13:35:35',22,73,29),(77,'2011-02-20 21:59:12',20,95,29),(78,'2014-04-07 05:59:36',41,10,30),(79,'2010-04-13 05:24:28',9,113,28),(80,'2014-11-04 09:09:31',26,161,29),(81,'2016-01-17 15:59:01',45,102,28),(82,'2017-01-04 04:23:56',34,248,28),(83,'2012-08-01 18:09:52',10,153,30),(84,'2017-12-13 04:58:47',25,172,29),(85,'2011-11-16 13:29:24',41,106,32),(86,'2016-11-01 06:25:03',25,75,30),(87,'2017-07-23 17:47:38',20,180,32),(88,'2015-07-21 20:26:23',38,243,29),(89,'2017-02-18 06:02:20',36,17,32),(90,'2011-04-03 10:20:07',41,169,32),(91,'2011-10-25 20:56:25',32,243,29),(92,'2011-07-07 06:49:58',9,43,28),(93,'2019-06-13 06:02:48',17,235,32),(94,'2014-12-23 02:58:44',19,75,32),(95,'2019-07-22 03:09:37',21,113,32),(96,'2012-10-20 22:10:15',33,6,32),(97,'2016-09-24 13:33:38',14,146,32),(98,'2013-06-14 15:08:30',4,107,30),(99,'2019-07-13 14:21:58',34,157,30),(100,'2010-12-19 20:34:57',24,64,28),(101,'2015-06-24 08:07:42',12,134,28),(102,'2015-08-09 13:25:31',10,46,28),(103,'2017-07-30 01:45:41',36,82,28),(104,'2019-06-20 12:38:45',16,235,29),(105,'2012-06-17 04:17:41',43,33,28),(106,'2015-11-28 14:02:52',37,201,28),(107,'2017-03-21 23:17:51',9,83,30),(108,'2014-08-24 16:38:12',27,38,28),(109,'2017-10-25 22:59:26',17,189,28),(110,'2015-02-05 12:39:40',1,10,28),(111,'2019-05-17 09:07:17',2,101,28),(112,'2011-02-27 03:43:07',9,61,29),(113,'2019-06-17 00:14:35',16,189,29),(114,'2012-11-18 07:29:07',34,6,29),(115,'2011-10-26 06:03:32',21,223,30),(116,'2017-01-12 09:29:39',46,117,30),(117,'2010-05-05 08:51:27',8,209,32),(118,'2015-06-16 18:25:35',37,157,28),(119,'2014-01-04 01:52:55',25,80,28),(120,'2017-07-29 07:28:51',36,180,32),(121,'2019-04-30 09:43:22',42,26,28),(122,'2012-01-22 20:36:03',42,104,29),(123,'2013-04-25 13:22:41',11,146,29),(124,'2011-03-22 15:41:17',1,243,30),(125,'2015-10-21 10:08:34',26,60,28),(126,'2016-12-15 15:11:34',30,238,32),(127,'2015-04-01 03:40:57',24,36,30),(128,'2011-04-23 15:42:01',30,84,30),(129,'2016-02-15 14:34:14',43,55,30),(130,'2019-09-23 06:58:17',11,66,29),(131,'2014-08-07 21:18:20',24,163,32),(132,'2019-12-12 12:01:07',25,156,29),(133,'2017-12-01 08:22:56',35,63,30),(134,'2010-02-27 14:58:23',27,135,32),(135,'2011-10-26 03:57:05',9,92,30),(136,'2012-12-10 08:34:57',30,104,30),(137,'2015-12-07 06:55:10',31,123,28),(138,'2017-01-24 19:17:27',39,219,30),(139,'2016-05-29 03:57:34',19,30,30),(140,'2010-10-10 13:33:43',13,65,30),(141,'2017-06-10 04:08:15',33,37,32),(142,'2012-08-31 05:24:39',21,235,32),(143,'2018-11-22 09:12:29',31,17,29),(144,'2013-08-11 16:05:15',7,102,28),(145,'2016-08-27 06:54:01',31,182,32),(146,'2015-09-12 02:55:20',36,149,28),(147,'2011-11-05 04:37:06',37,149,30),(148,'2013-09-17 17:49:05',3,97,30),(149,'2011-05-07 08:36:20',16,156,29),(150,'2010-02-18 17:27:50',28,28,28),(151,'2010-12-10 08:55:38',27,32,28),(152,'2011-02-13 17:07:48',36,65,29),(153,'2010-11-16 04:12:09',30,153,32),(154,'2011-01-14 16:52:05',28,131,28),(155,'2013-08-04 05:14:46',25,162,30),(156,'2018-09-16 09:40:15',10,60,30),(157,'2013-12-13 02:01:24',3,235,30),(158,'2013-04-15 07:44:11',33,48,32),(159,'2014-12-12 16:59:35',17,44,32),(160,'2018-11-15 15:53:23',34,44,28),(161,'2013-02-12 00:40:43',38,207,32),(162,'2019-05-03 01:38:26',37,49,30),(163,'2013-01-11 03:22:43',20,49,29),(164,'2013-12-18 12:26:09',36,26,32),(165,'2017-05-16 22:47:38',7,139,28),(166,'2016-03-14 21:56:15',15,256,28),(167,'2014-07-18 21:44:32',11,194,30),(168,'2016-08-01 12:10:58',13,174,30),(169,'2011-05-02 06:31:33',12,41,29),(170,'2011-07-07 04:16:19',25,85,32),(171,'2011-12-07 02:08:05',2,34,28),(172,'2010-04-14 01:01:55',40,34,32),(173,'2012-03-03 03:18:57',20,114,30),(174,'2018-04-04 01:50:46',46,64,28),(175,'2011-10-14 13:35:35',22,73,29),(176,'2011-02-20 21:59:12',20,95,29),(177,'2014-04-07 05:59:36',41,10,30),(178,'2010-04-13 05:24:28',9,113,28),(179,'2014-11-04 09:09:31',26,161,29),(180,'2016-01-17 15:59:01',45,102,28),(181,'2017-01-04 04:23:56',34,248,28),(182,'2012-08-01 18:09:52',10,153,30),(183,'2017-12-13 04:58:47',25,172,29),(184,'2011-11-16 13:29:24',41,106,32),(185,'2016-11-01 06:25:03',25,75,30),(186,'2017-07-23 17:47:38',20,180,32),(187,'2015-07-21 20:26:23',38,243,29),(188,'2017-02-18 06:02:20',36,17,32),(189,'2011-04-03 10:20:07',41,169,32),(190,'2011-10-25 20:56:25',32,243,29),(191,'2011-07-07 06:49:58',9,43,28),(192,'2019-06-13 06:02:48',17,235,32),(193,'2014-12-23 02:58:44',19,75,32),(194,'2019-07-22 03:09:37',21,113,32),(195,'2012-10-20 22:10:15',33,6,32),(196,'2016-09-24 13:33:38',14,146,32),(197,'2013-06-14 15:08:30',4,107,30),(198,'2019-07-13 14:21:58',34,157,30),(199,'2010-12-19 20:34:57',24,64,28),(200,'2015-06-24 08:07:42',12,134,28),(201,'2015-08-09 13:25:31',10,46,28),(202,'2017-07-30 01:45:41',36,82,28),(203,'2019-06-20 12:38:45',16,235,29),(204,'2012-06-17 04:17:41',43,33,28),(205,'2015-11-28 14:02:52',37,201,28),(206,'2017-03-21 23:17:51',9,83,30),(207,'2014-08-24 16:38:12',27,38,28),(208,'2017-10-25 22:59:26',17,189,28),(209,'2015-02-05 12:39:40',1,10,28),(210,'2019-05-17 09:07:17',2,101,28),(211,'2011-02-27 03:43:07',9,61,29),(212,'2019-06-17 00:14:35',16,189,29),(213,'2012-11-18 07:29:07',34,6,29);
/*!40000 ALTER TABLE `TrailingStopOrder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Transactions`
--

DROP TABLE IF EXISTS `Transactions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Transactions` (
  `TransactionsId` int(11) NOT NULL,
  `Fee` double DEFAULT NULL,
  `TransactionTime` datetime DEFAULT NULL,
  `PricePerShare` double DEFAULT NULL,
  PRIMARY KEY (`TransactionsId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Transactions`
--

LOCK TABLES `Transactions` WRITE;
/*!40000 ALTER TABLE `Transactions` DISABLE KEYS */;
/*!40000 ALTER TABLE `Transactions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `User`
--

DROP TABLE IF EXISTS `User`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `User` (
  `Email` char(32) NOT NULL,
  `Role` char(30) DEFAULT NULL,
  `Password` char(20) DEFAULT NULL,
  `SSN` int(11) NOT NULL,
  PRIMARY KEY (`SSN`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `User`
--

LOCK TABLES `User` WRITE;
/*!40000 ALTER TABLE `User` DISABLE KEYS */;
INSERT INTO `User` (`Email`, `Role`, `Password`, `SSN`) VALUES ('manager@stonybrook.edu','manager','123456',1000),('cr@stonybrook.edu','Customer Representative','123456',1001),('customer1@stonybrook.edu','Customer','123456',1002),('yichun@cs.stonybrook.edu','Customer','111',1232323);
/*!40000 ALTER TABLE `User` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `activelystock`
--

DROP TABLE IF EXISTS `activelystock`;
/*!50001 DROP VIEW IF EXISTS `activelystock`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8mb4;
/*!50001 CREATE VIEW `activelystock` AS SELECT 
 1 AS `StockSymbol`,
 1 AS `Time`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `revbuy`
--

DROP TABLE IF EXISTS `revbuy`;
/*!50001 DROP VIEW IF EXISTS `revbuy`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8mb4;
/*!50001 CREATE VIEW `revbuy` AS SELECT 
 1 AS `Customer`,
 1 AS `Money`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `revbuy2`
--

DROP TABLE IF EXISTS `revbuy2`;
/*!50001 DROP VIEW IF EXISTS `revbuy2`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8mb4;
/*!50001 CREATE VIEW `revbuy2` AS SELECT 
 1 AS `Customer`,
 1 AS `Money`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `revsell`
--

DROP TABLE IF EXISTS `revsell`;
/*!50001 DROP VIEW IF EXISTS `revsell`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8mb4;
/*!50001 CREATE VIEW `revsell` AS SELECT 
 1 AS `Customer`,
 1 AS `Money`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `stockhistory`
--

DROP TABLE IF EXISTS `stockhistory`;
/*!50001 DROP VIEW IF EXISTS `stockhistory`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8mb4;
/*!50001 CREATE VIEW `stockhistory` AS SELECT 
 1 AS `Symbol`,
 1 AS `Name`,
 1 AS `Type`,
 1 AS `Time`,
 1 AS `Price`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `stocksellrecord`
--

DROP TABLE IF EXISTS `stocksellrecord`;
/*!50001 DROP VIEW IF EXISTS `stocksellrecord`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8mb4;
/*!50001 CREATE VIEW `stocksellrecord` AS SELECT 
 1 AS `Symbol`,
 1 AS `TotalSell`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `activelystock`
--

/*!50001 DROP VIEW IF EXISTS `activelystock`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`zhaowhuang`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `activelystock` AS select `orders`.`StockSymbol` AS `StockSymbol`,count(`orders`.`StockSymbol`) AS `Time` from `orders` group by `orders`.`StockSymbol` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `revbuy`
--

/*!50001 DROP VIEW IF EXISTS `revbuy`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`zhaowhuang`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `revbuy` AS select `orders`.`ClientID` AS `Customer`,(`orders`.`NumberOfShare` * `orders`.`PricePerShare`) AS `Money` from `orders` where (`orders`.`buy_sell` = 'Buy') order by `orders`.`ClientID` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `revbuy2`
--

/*!50001 DROP VIEW IF EXISTS `revbuy2`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`zhaowhuang`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `revbuy2` AS select `orders`.`ClientID` AS `Customer`,sum((`orders`.`NumberOfShare` * `orders`.`PricePerShare`)) AS `Money` from `orders` where (`orders`.`buy_sell` = 'Buy') group by `orders`.`ClientID` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `revsell`
--

/*!50001 DROP VIEW IF EXISTS `revsell`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`zhaowhuang`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `revsell` AS select `orders`.`ClientID` AS `Customer`,(`orders`.`NumberOfShare` * `orders`.`PricePerShare`) AS `Money` from `orders` where (`orders`.`buy_sell` = 'SELL') order by `orders`.`ClientID` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `stockhistory`
--

/*!50001 DROP VIEW IF EXISTS `stockhistory`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`zhaowhuang`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `stockhistory` AS select `stockchange`.`StockSymbol` AS `Symbol`,`stock`.`CompanyName` AS `Name`,`stock`.`StockType` AS `Type`,`stockchange`.`changeTime` AS `Time`,`stockchange`.`PricePerShare` AS `Price` from (`stockchange` join `stock`) where (`stockchange`.`StockSymbol` = `stock`.`StockSymbol`) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `stocksellrecord`
--

/*!50001 DROP VIEW IF EXISTS `stocksellrecord`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`zhaowhuang`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `stocksellrecord` AS select `orders`.`StockSymbol` AS `Symbol`,count(`orders`.`StockSymbol`) AS `TotalSell` from `orders` where (`orders`.`buy_sell` = 'Buy') group by `orders`.`StockSymbol` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-05-07 12:58:23
