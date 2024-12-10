-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: specificpet
-- ------------------------------------------------------
-- Server version	8.0.36

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `additionaldetails`
--

DROP TABLE IF EXISTS `additionaldetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `additionaldetails` (
  `details_id` int NOT NULL AUTO_INCREMENT,
  `details_text` varchar(300) DEFAULT NULL,
  `pet_id` int DEFAULT NULL,
  PRIMARY KEY (`details_id`),
  KEY `fk_pet_id` (`pet_id`),
  CONSTRAINT `fk_pet_id` FOREIGN KEY (`pet_id`) REFERENCES `pet` (`pet_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `additionaldetails`
--

LOCK TABLES `additionaldetails` WRITE;
/*!40000 ALTER TABLE `additionaldetails` DISABLE KEYS */;
INSERT INTO `additionaldetails` VALUES (3,'I just hope the dog I get is energetic!',4),(4,'I just really, really like birds ya know!',9),(5,'I already know what I\'m going to name him/her!',1),(6,'I haven\'t had a cat in so long!',3),(7,'My lease doesn\'t allow cats or dogs so this shall do!',8),(8,'Open to hearing any advice on upkeep!',8),(9,'Would make a great Christmas gift!',10),(10,'There is veterinary clinic down the street from me as well as a dog park!',7),(11,'My last dog ran away!',4),(12,'I\'ll wait as long as it takes to get this kind of dog!!!',4);
/*!40000 ALTER TABLE `additionaldetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pet`
--

DROP TABLE IF EXISTS `pet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pet` (
  `pet_id` int NOT NULL AUTO_INCREMENT,
  `pet_age` int DEFAULT NULL,
  `pet_weight` int DEFAULT NULL,
  `pet_species` varchar(255) DEFAULT NULL,
  `pet_color` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pet_id`)
) ENGINE=InnoDB AUTO_INCREMENT=80 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pet`
--

LOCK TABLES `pet` WRITE;
/*!40000 ALTER TABLE `pet` DISABLE KEYS */;
INSERT INTO `pet` VALUES (1,9,24,'Dog','blue'),(3,7,8,'Cat','yellow'),(4,1,31,'Dog','black'),(5,2,12,'Cat','white'),(6,7,5,'Cat','orange'),(7,5,16,'Dog','purple'),(8,2,23,'Turtle','brown'),(9,12,7,'Bird','brown'),(10,6,14,'Dog','grey'),(78,88,1906,'Bird','Multi-color'),(79,88,1906,'Bird','Multi-color');
/*!40000 ALTER TABLE `pet` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-12-10  3:19:54
