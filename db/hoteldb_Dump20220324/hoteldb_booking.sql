-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: hoteldb
-- ------------------------------------------------------
-- Server version	8.0.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `booking`
--

DROP TABLE IF EXISTS `booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `booking` (
  `booking_id` int NOT NULL AUTO_INCREMENT,
  `booking_dateTime` datetime DEFAULT NULL,
  `booking_amt` decimal(10,2) DEFAULT NULL,
  `check_in_DateTime` datetime DEFAULT NULL,
  `check_out_DateTime` datetime DEFAULT NULL,
  `no_of_adults` int DEFAULT NULL,
  `no_of_child` int DEFAULT NULL,
  `booking_status` varchar(20) DEFAULT NULL,
  `hotel_id` int DEFAULT NULL,
  `customer_id` int DEFAULT NULL,
  `bill_id` int DEFAULT NULL,
  `room_id` int DEFAULT NULL,
  `emp_id` int DEFAULT NULL,
  PRIMARY KEY (`booking_id`),
  KEY `hotel_id` (`hotel_id`),
  KEY `customer_id` (`customer_id`),
  KEY `bill_id` (`bill_id`),
  KEY `room_id` (`room_id`),
  KEY `emp_id` (`emp_id`),
  CONSTRAINT `booking_ibfk_1` FOREIGN KEY (`hotel_id`) REFERENCES `hotel` (`hotel_id`),
  CONSTRAINT `booking_ibfk_2` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`),
  CONSTRAINT `booking_ibfk_3` FOREIGN KEY (`bill_id`) REFERENCES `bill` (`bill_id`),
  CONSTRAINT `booking_ibfk_4` FOREIGN KEY (`room_id`) REFERENCES `room` (`room_id`),
  CONSTRAINT `booking_ibfk_5` FOREIGN KEY (`emp_id`) REFERENCES `employee` (`emp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=506 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking`
--

LOCK TABLES `booking` WRITE;
/*!40000 ALTER TABLE `booking` DISABLE KEYS */;
INSERT INTO `booking` VALUES (501,'2022-02-22 08:05:22',5000.00,'2022-02-25 12:05:22','2022-02-26 11:05:22',2,NULL,'Completed',101,301,701,201,401),(502,'2022-02-20 12:05:22',5500.00,NULL,NULL,1,1,'Postponed',101,302,702,202,402),(503,'2022-02-25 06:05:22',8000.00,NULL,NULL,2,1,'No show',101,303,703,203,403),(504,'2022-02-28 06:05:22',5000.00,'2022-03-11 12:05:22','2022-03-12 11:05:22',2,NULL,'Completed',102,304,704,201,403),(505,'2022-03-01 06:05:22',8100.00,'2022-03-12 12:05:22','2022-03-13 11:05:22',2,1,'Completed',103,303,705,203,401);
/*!40000 ALTER TABLE `booking` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-03-24 17:24:53
