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
-- Table structure for table `work_programs`
--

DROP TABLE IF EXISTS `work_programs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `work_programs` (
  `REVISION` int DEFAULT NULL COMMENT '乐观锁',
  `CREATED_BY` varchar(32) DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATED_BY` varchar(32) DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  `PROG_NO` varchar(64) DEFAULT NULL COMMENT '项目编号',
  `PROG_NAME` varchar(128) DEFAULT NULL COMMENT '项目名称',
  `PROG_ADDR` varchar(128) DEFAULT NULL COMMENT '项目地址',
  `PROG_MAN` varchar(32) DEFAULT NULL COMMENT '项目负责人',
  `PROG_DAYS` int DEFAULT NULL COMMENT '项目工期（单位：天）',
  `PROG_PAY` decimal(32,8) DEFAULT NULL COMMENT '合同金额',
  `PROG_HAS_PAY` decimal(32,8) DEFAULT NULL COMMENT '已付金额',
  `PROG_ADD_PAY` decimal(32,8) DEFAULT NULL COMMENT '追加金额',
  `PROG_NOPAY` decimal(32,8) DEFAULT NULL COMMENT '待支付金额',
  `PROG_STATUS` varchar(32) DEFAULT NULL COMMENT '项目状态',
  `CUCYCD` varchar(32) DEFAULT NULL COMMENT '金额币种',
  `PROG_IINFOS` varchar(3072) DEFAULT NULL COMMENT '项目说明',
  `PROG_ID` int unsigned NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`PROG_ID`),
  UNIQUE KEY `PROG_ID_UNIQUE` (`PROG_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COMMENT='项目表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `work_programs`
--

LOCK TABLES `work_programs` WRITE;
/*!40000 ALTER TABLE `work_programs` DISABLE KEYS */;
INSERT INTO `work_programs` VALUES (NULL,'qq','2020-07-22 17:20:02','zhjk','2020-07-22 17:20:02','quioadf','重庆振兴','长寿','吴涛',3,10000.00000000,0.00000000,0.00000000,10000.00000000,'1','CNY','没啥可说            ',2),(NULL,'王莹','2020-07-23 15:19:13','','2020-07-23 15:19:13','prog_20200723#1','重庆南山一棵树改造项目','重庆南岸区','狂三',300,100000000.00000000,0.00000000,0.00000000,100000000.00000000,'1','CNY','特殊项目        ',3),(NULL,'伍柒','2020-07-23 15:20:23','','2020-07-23 15:20:23','prog_20200723#1','重庆西山两棵树改造项目','重庆沙坪坝','刘武',300,100000000.00000000,0.00000000,0.00000000,100000000.00000000,'1','CNY','特殊项目        ',4),(NULL,'伍柒01','2020-07-23 15:29:17','','2020-07-23 15:29:17','prog_20200723#1','重庆西山两棵树','重庆沙坪坝01','刘武2',300,100000000.00000000,0.00000000,0.00000000,100000000.00000000,'1','CNY','特殊项目        ',5),(NULL,'伍柒02','2020-07-23 15:29:42','','2020-07-23 15:29:42','prog_20200723#2','重庆阿斯蒂芬','重庆答复','刘的2',300,100000000.00000000,0.00000000,0.00000000,100000000.00000000,'1','CNY','特殊项目111      ',6),(NULL,'zhp','2020-07-23 15:44:10','爱的色放','2020-07-23 15:44:10','prog_20200723#3','阿斯达','北京','去玩儿',90,10.00000000,0.00000000,0.00000000,10.00000000,'未开工','cny','                        ',7),(NULL,'asdf','2020-07-23 15:44:28','爱的色','2020-07-23 15:44:28','prog_20200723#4','阿斯q','北京','去玩儿',90,10.00000000,0.00000000,0.00000000,10.00000000,'未开工','cny','                        ',8),(NULL,'我二姨','2020-07-23 15:44:48','爱的色','2020-07-23 15:44:48','prog_20200723#5','阿斯q','北京','阿斯蒂芬土豆',90,10.00000000,0.00000000,0.00000000,10.00000000,'未开工','cny','                        ',9),(NULL,'我二姨','2020-07-23 15:45:07','','2020-07-23 15:45:07','prog_20200723#6','阿萨德','北京','土豆',90,10.00000000,0.00000000,0.00000000,10.00000000,'未开工','cny','                        ',10),(NULL,'他大姨','2020-07-23 15:45:37','','2020-07-23 15:45:37','prog_20200723#7','欧冠的','北京分想','人太少',90,10.00000000,0.00000000,0.00000000,10.00000000,'未开工','cny','                        ',11),(NULL,'他大姨是','2020-07-23 15:45:50','','2020-07-23 15:45:50','prog_20200723#8','欧冠的阿斯达','北京分想','人太少阿斯达',90,10.00000000,0.00000000,0.00000000,10.00000000,'未开工','cny','                        ',12),(NULL,'他大 ','2020-07-23 15:46:12','','2020-07-23 15:46:12','prog_20200723#9','欧 ','东京','人太少阿斯达',90,10.00000000,0.00000000,0.00000000,10.00000000,'未开工','cny','                        ',13),(NULL,'亲爱的舒服','2020-07-23 15:46:27','阿斯达','2020-07-23 15:46:27','prog_20200723#10','欧 ','东京','人太少',90,10.00000000,0.00000000,0.00000000,10.00000000,'未开工','cny','                        ',14);
/*!40000 ALTER TABLE `work_programs` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-07-24 16:35:14
