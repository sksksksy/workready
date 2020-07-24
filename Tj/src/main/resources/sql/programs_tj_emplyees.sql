-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: programs_tj
-- ------------------------------------------------------
-- Server version	8.0.21

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
-- Table structure for table `emplyees`
--

DROP TABLE IF EXISTS `emplyees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `emplyees` (
  `CREATED_BY` varchar(32) DEFAULT NULL COMMENT '创建人(创建人)',
  `CREATED_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATEDBY_` varchar(32) DEFAULT NULL COMMENT '最近一次更新人',
  `UPDATED_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  `EMPL_NO` varchar(32) NOT NULL COMMENT '职工编号',
  `EMPL_NAME` varchar(32) DEFAULT NULL COMMENT '名字',
  `EMPL_NUMBER` varchar(32) DEFAULT NULL COMMENT '电话',
  `EMPL_AGE` int DEFAULT NULL COMMENT '年龄',
  `EMPL_ADDR` varchar(32) DEFAULT NULL COMMENT '籍贯',
  PRIMARY KEY (`EMPL_NO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='职工表 ';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emplyees`
--

LOCK TABLES `emplyees` WRITE;
/*!40000 ALTER TABLE `emplyees` DISABLE KEYS */;
INSERT INTO `emplyees` VALUES ('zhp','2020-01-21 00:07:00','nobody','2020-01-21 00:07:00','00010023','kuangchengq','1237892345',24,'chongqing'),('zhp','2020-07-24 15:13:00',NULL,NULL,'zz0001','我二姨','1234534546',31,'chongqing'),('zhp','2020-07-24 15:13:00',NULL,NULL,'zz0002','爱的色','1231234512',26,'chongqing');
/*!40000 ALTER TABLE `emplyees` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-07-24 16:35:10
