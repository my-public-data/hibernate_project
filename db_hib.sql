-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: db_hib
-- ------------------------------------------------------
-- Server version	8.0.38

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
-- Table structure for table `mygroup2`
--

DROP TABLE IF EXISTS `mygroup2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mygroup2` (
  `id` int NOT NULL AUTO_INCREMENT,
  `groupName` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mygroup2`
--

LOCK TABLES `mygroup2` WRITE;
/*!40000 ALTER TABLE `mygroup2` DISABLE KEYS */;
INSERT INTO `mygroup2` VALUES (1,'Карандаши'),(2,'Ручки'),(3,'Линейки'),(4,'Ножницы'),(5,'Точилки');
/*!40000 ALTER TABLE `mygroup2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mygroup2_tovar_directional`
--

DROP TABLE IF EXISTS `mygroup2_tovar_directional`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mygroup2_tovar_directional` (
  `tovar_id` int NOT NULL,
  `user_id` int NOT NULL,
  PRIMARY KEY (`tovar_id`,`user_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `mygroup2_tovar_directional_ibfk_1` FOREIGN KEY (`tovar_id`) REFERENCES `tovar_directional` (`id`),
  CONSTRAINT `mygroup2_tovar_directional_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `users_table_3` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mygroup2_tovar_directional`
--

LOCK TABLES `mygroup2_tovar_directional` WRITE;
/*!40000 ALTER TABLE `mygroup2_tovar_directional` DISABLE KEYS */;
INSERT INTO `mygroup2_tovar_directional` VALUES (1,2),(2,2),(3,2),(1,3);
/*!40000 ALTER TABLE `mygroup2_tovar_directional` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `id` int NOT NULL,
  `number` varchar(55) DEFAULT NULL,
  `dAndT` varchar(25) DEFAULT NULL,
  `status` varchar(25) DEFAULT NULL,
  `person_id` int DEFAULT NULL,
  `tovar_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `person_id` (`person_id`),
  KEY `tovar_id` (`tovar_id`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`person_id`) REFERENCES `users_table_3` (`id`),
  CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`tovar_id`) REFERENCES `tovar_directional` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tovar_directional`
--

DROP TABLE IF EXISTS `tovar_directional`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tovar_directional` (
  `id` int NOT NULL AUTO_INCREMENT,
  `tovarName` varchar(25) DEFAULT NULL,
  `tovarPrice` double DEFAULT NULL,
  `tovarCode` varchar(25) DEFAULT NULL,
  `mygroup_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `mygroup_id` (`mygroup_id`),
  CONSTRAINT `tovar_directional_ibfk_1` FOREIGN KEY (`mygroup_id`) REFERENCES `mygroup2` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tovar_directional`
--

LOCK TABLES `tovar_directional` WRITE;
/*!40000 ALTER TABLE `tovar_directional` DISABLE KEYS */;
INSERT INTO `tovar_directional` VALUES (1,'Карандаш1',10,'PP0001',1),(2,'Карандаш2',10,'PP0002',1),(3,'Карандаш3',20,'PP0003',1),(5,'Линейка1',1,'LI0001',3),(8,'Ножницы1',20,'NO0001',4),(9,'Ручка1',10,'RR0001',2),(10,'Ручка2',20,'RR0002',2),(11,'Линейка2',10,'LI0002',3),(12,'Линейка3',20,'LI0003',3),(13,'Ножницы2',30,'NO0002',4),(14,'Ножницы3',40,'NO0003',4),(15,'Ручка3',20,'RR0003',2),(16,'Точилка1',10,'TT0001',5),(17,'Точилка2',11,'TT0002',5);
/*!40000 ALTER TABLE `tovar_directional` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_table_3`
--

DROP TABLE IF EXISTS `users_table_3`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users_table_3` (
  `id` int NOT NULL AUTO_INCREMENT,
  `surname` varchar(25) DEFAULT NULL,
  `name` varchar(25) DEFAULT NULL,
  `patronymic` varchar(25) DEFAULT NULL,
  `email` varchar(25) DEFAULT NULL,
  `telephone_number` varchar(25) DEFAULT NULL,
  `role` varchar(25) DEFAULT NULL,
  `login` varchar(25) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_table_3`
--

LOCK TABLES `users_table_3` WRITE;
/*!40000 ALTER TABLE `users_table_3` DISABLE KEYS */;
INSERT INTO `users_table_3` VALUES (1,'Первов','Перв','Первович','1@ya.ru','+7-000-000-00-01','администратор','1','$2a$10$T4gT.b3zcdKQxS8eT0jMge5HQF8FJlz3XgBHj4mlKUes.kb7yiwqC'),(2,'Второв','Втор','Вторович','2@ya.ru','+7-000-000-00-02','пользователь','2','$2a$10$QkQ4DXEXlsDqQrBlUwIzIePOin0176ty7Rt1yjawTpzDtRMROSUXC'),(3,'Третьев','Трет','Третьевич','3@ya.ru','+7-000-000-00-03','пользователь','3','$2a$10$jMxtSxeKTxCkYDw.fdePxuAu5yNHzlR0YuKcUXpTuHZOyJpm4h0a2'),(4,'Четвертов','Четверт','Четвертович','4@ya.ru','+7-000-000-00-04','пользователь','4','$2a$10$A1MTf/oaGgceOVkSfAf1S.lKAU.PDn.EHoTXoZH7JsWfkEcZIgWj.'),(5,'Пятов','Пят','Пятович','5@ya.ru','+7-000-000-00-05','пользователь','5','$2a$10$Bwwk0ZTQWTABzJUN3tYJG.DpEJZdAr0J2VEpvpI5VNCGl/d/HBkxi'),(6,'Шестов','Шест','Шестович','6@ya.ru','+7-000-000-00-06','пользователь','6','$2a$10$HG5KRh0hu39vnOJeNas8qexkLjYR3nZiNjJOUCzURioN6HLkaVUXW'),(7,'Седьмов','Седьм','Седьмович','7@ya.ru','+7-000-000-00-07','пользователь','7','$2a$10$Ty9jnuS8vhR6Xehl2coN0eG2s57i4fiZmMFNsEjsIZQH9X2VCBe02'),(8,'Восьмов','Восьм','Восьмович','8@ya.ru','+7-000-000-00-08','пользователь','8','$2a$10$rXc.umYEXHLXDZqwsCzbtezzE.z3ldSCh9GdD2F3Z2dWVUeeGiNZK'),(9,'Девятов','Девят','Девятович','9@ya.ru','+7-000-000-00-09','пользователь','9','$2a$10$egrmJA23M882LxH/.vQJYei/qBjWbSUyLs6ZBl3rPgdzhQRMZBhQW'),(10,'Десятов','Десят','Десятович','10@ya.ru','+7-000-000-00-10','пользователь','10','$2a$10$MfW5LHmXkjm/MDSnUEKdnuSxI0a.vGFqurWk3F06cYSyIIfFaXIWG'),(11,'Одиннадцатов','Одиннадцат','Одиннадцатович','11@ya.ru','+7-000-000-00-11','пользователь','11','$2a$10$Bp4IPTPpcOXr.xuZldzwQOKMPSx7tU7XAoVEO5vGORJxOK9g9PhKe');
/*!40000 ALTER TABLE `users_table_3` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-04-26 12:43:50
