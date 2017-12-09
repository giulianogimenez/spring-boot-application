-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: aloprefeitura_aud
-- ------------------------------------------------------
-- Server version	5.7.19-log

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
-- Table structure for table `mda_midia_aud`
--

DROP TABLE IF EXISTS `mda_midia_aud`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mda_midia_aud` (
  `MDA_ID` int(11) NOT NULL,
  `REV` int(11) NOT NULL,
  `OCR_ID` int(11) DEFAULT NULL,
  `MDA_TIPO` varchar(6) DEFAULT NULL,
  `REVTYPE` int(11) DEFAULT NULL,
  `MDA_BYTES` longblob,
  PRIMARY KEY (`MDA_ID`,`REV`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mda_midia_aud`
--

LOCK TABLES `mda_midia_aud` WRITE;
/*!40000 ALTER TABLE `mda_midia_aud` DISABLE KEYS */;
/*!40000 ALTER TABLE `mda_midia_aud` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ocr_ocorrencia_aud`
--

DROP TABLE IF EXISTS `ocr_ocorrencia_aud`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ocr_ocorrencia_aud` (
  `OCR_ID` int(11) NOT NULL,
  `REV` int(11) NOT NULL,
  `USR_ID` int(11) DEFAULT NULL,
  `USR_PREFEITURA_ID` int(11) DEFAULT NULL,
  `OCR_DATAHORA` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `OCR_PROTOCOLO` varchar(14) DEFAULT NULL,
  `OCR_DESCRICAO` text,
  `OCR_ENDERECO` text,
  `OCR_STATUS` varchar(50) DEFAULT NULL,
  `OCR_FEEDBACK` text,
  `REVTYPE` int(11) DEFAULT NULL,
  `SET_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`OCR_ID`,`REV`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ocr_ocorrencia_aud`
--

LOCK TABLES `ocr_ocorrencia_aud` WRITE;
/*!40000 ALTER TABLE `ocr_ocorrencia_aud` DISABLE KEYS */;
INSERT INTO `ocr_ocorrencia_aud` VALUES (4,8,NULL,NULL,'2017-12-09 20:20:31',NULL,'Problema com uma lombada','Rua Goiania, 194','0','',0,1),(5,9,1,NULL,'2017-12-09 20:30:29','20171209183029','Problema com uma lombada','Rua Goiania, 194','0','',0,1);
/*!40000 ALTER TABLE `ocr_ocorrencia_aud` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rep_reputacao_aud`
--

DROP TABLE IF EXISTS `rep_reputacao_aud`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rep_reputacao_aud` (
  `REP_ID` int(11) NOT NULL,
  `REV` int(11) NOT NULL,
  `USR_ID` int(11) DEFAULT NULL,
  `REP_NOTA` int(11) DEFAULT NULL,
  `REVTYPE` int(11) DEFAULT NULL,
  PRIMARY KEY (`REP_ID`,`REV`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rep_reputacao_aud`
--

LOCK TABLES `rep_reputacao_aud` WRITE;
/*!40000 ALTER TABLE `rep_reputacao_aud` DISABLE KEYS */;
/*!40000 ALTER TABLE `rep_reputacao_aud` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `revinfo`
--

DROP TABLE IF EXISTS `revinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `revinfo` (
  `REV` int(11) NOT NULL AUTO_INCREMENT,
  `REVTSTMP` bigint(20) DEFAULT NULL,
  `USERNAME` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`REV`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `revinfo`
--

LOCK TABLES `revinfo` WRITE;
/*!40000 ALTER TABLE `revinfo` DISABLE KEYS */;
INSERT INTO `revinfo` VALUES (2,1512849233569,'anonymousUser'),(3,1512849774260,'José'),(4,1512849945615,'José'),(8,1512850831992,'José'),(9,1512851429243,'José');
/*!40000 ALTER TABLE `revinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `set_setor_aud`
--

DROP TABLE IF EXISTS `set_setor_aud`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `set_setor_aud` (
  `SET_ID` int(11) NOT NULL,
  `REV` int(11) NOT NULL,
  `SET_NOME` varchar(55) DEFAULT NULL,
  `REVTYPE` int(11) DEFAULT NULL,
  PRIMARY KEY (`SET_ID`,`REV`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `set_setor_aud`
--

LOCK TABLES `set_setor_aud` WRITE;
/*!40000 ALTER TABLE `set_setor_aud` DISABLE KEYS */;
/*!40000 ALTER TABLE `set_setor_aud` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usr_usuario_aud`
--

DROP TABLE IF EXISTS `usr_usuario_aud`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usr_usuario_aud` (
  `USR_ID` int(11) NOT NULL,
  `REV` int(11) NOT NULL,
  `SET_ID` int(11) DEFAULT NULL,
  `USR_NOME` varchar(100) NOT NULL,
  `USR_EMAIL` varchar(55) NOT NULL,
  `USR_PASS` varchar(130) NOT NULL,
  `USR_CPF` varchar(11) DEFAULT NULL,
  `USR_TIPO` varchar(50) DEFAULT NULL,
  `REVTYPE` int(11) DEFAULT NULL,
  PRIMARY KEY (`USR_ID`,`REV`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usr_usuario_aud`
--

LOCK TABLES `usr_usuario_aud` WRITE;
/*!40000 ALTER TABLE `usr_usuario_aud` DISABLE KEYS */;
INSERT INTO `usr_usuario_aud` VALUES (5,2,1,'José','teste@teste.com.br','7110eda4d09e062aa5e4a390b0a572ac0d2c0220','12345678909','0',0),(6,3,1,'Giuliano','teste@teste.com.br','348162101fc6f7e624681b7400b085eeac6df7bd','9999999-99','0',0),(7,4,1,'lucas.nadalete','teste@teste.com.br','7b21848ac9af35be0ddb2d6b9fc3851934db8420','9999999-99','1',0);
/*!40000 ALTER TABLE `usr_usuario_aud` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-09 18:34:11
