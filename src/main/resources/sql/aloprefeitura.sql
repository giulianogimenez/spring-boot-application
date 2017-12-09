-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: aloprefeitura
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
-- Table structure for table `mda_midia`
--

DROP TABLE IF EXISTS `mda_midia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mda_midia` (
  `MDA_ID` int(11) NOT NULL AUTO_INCREMENT,
  `OCR_ID` int(11) DEFAULT NULL,
  `MDA_TIPO` varchar(6) DEFAULT NULL,
  `MDA_BYTES` longblob,
  PRIMARY KEY (`MDA_ID`),
  KEY `FK_MIDIA_DA_OCORRENCIA` (`OCR_ID`),
  CONSTRAINT `FK_MIDIA_DA_OCORRENCIA` FOREIGN KEY (`OCR_ID`) REFERENCES `ocr_ocorrencia` (`OCR_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mda_midia`
--

LOCK TABLES `mda_midia` WRITE;
/*!40000 ALTER TABLE `mda_midia` DISABLE KEYS */;
/*!40000 ALTER TABLE `mda_midia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ocr_ocorrencia`
--

DROP TABLE IF EXISTS `ocr_ocorrencia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ocr_ocorrencia` (
  `OCR_ID` int(11) NOT NULL AUTO_INCREMENT,
  `USR_ID` int(11) DEFAULT NULL,
  `USR_PREFEITURA_ID` int(11) DEFAULT NULL,
  `OCR_DATAHORA` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `OCR_PROTOCOLO` varchar(14) DEFAULT NULL,
  `OCR_DESCRICAO` text,
  `OCR_ENDERECO` text,
  `OCR_STATUS` varchar(50) DEFAULT NULL,
  `OCR_FEEDBACK` text,
  `SET_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`OCR_ID`),
  KEY `FK_OCORRENCIA_DO_USUARIO` (`USR_ID`),
  KEY `FK_OCORRENCIA_SETOR_idx` (`SET_ID`),
  CONSTRAINT `FK_OCORRENCIA_DO_USUARIO` FOREIGN KEY (`USR_ID`) REFERENCES `usr_usuario` (`USR_ID`),
  CONSTRAINT `FK_OCORRENCIA_SETOR` FOREIGN KEY (`SET_ID`) REFERENCES `set_setor` (`SET_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ocr_ocorrencia`
--

LOCK TABLES `ocr_ocorrencia` WRITE;
/*!40000 ALTER TABLE `ocr_ocorrencia` DISABLE KEYS */;
INSERT INTO `ocr_ocorrencia` VALUES (4,NULL,NULL,'2017-12-09 20:20:31',NULL,'Problema com uma lombada','Rua Goiania, 194','0','',1),(5,1,NULL,'2017-12-09 20:30:29','20171209183029','Problema com uma lombada','Rua Goiania, 194','0','',1);
/*!40000 ALTER TABLE `ocr_ocorrencia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rep_reputacao`
--

DROP TABLE IF EXISTS `rep_reputacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rep_reputacao` (
  `REP_ID` int(11) NOT NULL AUTO_INCREMENT,
  `USR_ID` int(11) DEFAULT NULL,
  `REP_NOTA` int(11) DEFAULT NULL,
  PRIMARY KEY (`REP_ID`),
  KEY `FK_REPUTACAO_DO_USUARIO` (`USR_ID`),
  CONSTRAINT `FK_REPUTACAO_DO_USUARIO` FOREIGN KEY (`USR_ID`) REFERENCES `usr_usuario` (`USR_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rep_reputacao`
--

LOCK TABLES `rep_reputacao` WRITE;
/*!40000 ALTER TABLE `rep_reputacao` DISABLE KEYS */;
/*!40000 ALTER TABLE `rep_reputacao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `set_setor`
--

DROP TABLE IF EXISTS `set_setor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `set_setor` (
  `SET_ID` int(11) NOT NULL AUTO_INCREMENT,
  `SET_NOME` varchar(55) DEFAULT NULL,
  PRIMARY KEY (`SET_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `set_setor`
--

LOCK TABLES `set_setor` WRITE;
/*!40000 ALTER TABLE `set_setor` DISABLE KEYS */;
INSERT INTO `set_setor` VALUES (1,'Trânsito'),(2,'Zoonose'),(3,'Segurança pública'),(4,'Saúde'),(5,'Iluminação');
/*!40000 ALTER TABLE `set_setor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usr_usuario`
--

DROP TABLE IF EXISTS `usr_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usr_usuario` (
  `USR_ID` int(11) NOT NULL AUTO_INCREMENT,
  `SET_ID` int(11) DEFAULT NULL,
  `USR_NOME` varchar(100) NOT NULL,
  `USR_EMAIL` varchar(55) NOT NULL,
  `USR_PASS` varchar(130) NOT NULL,
  `USR_CPF` varchar(11) DEFAULT NULL,
  `USR_TIPO` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`USR_ID`),
  KEY `FK_SETOR_DA_PREFEITURA` (`SET_ID`),
  CONSTRAINT `FK_SETOR_DA_PREFEITURA` FOREIGN KEY (`SET_ID`) REFERENCES `set_setor` (`SET_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usr_usuario`
--

LOCK TABLES `usr_usuario` WRITE;
/*!40000 ALTER TABLE `usr_usuario` DISABLE KEYS */;
INSERT INTO `usr_usuario` VALUES (1,1,'José','teste@teste.com.br','7110eda4d09e062aa5e4a390b0a572ac0d2c0220','12345678909','0'),(6,1,'Giuliano','teste@teste.com.br','348162101fc6f7e624681b7400b085eeac6df7bd','9999999-99','0'),(7,1,'lucas.nadalete','teste@teste.com.br','7b21848ac9af35be0ddb2d6b9fc3851934db8420','9999999-99','1');
/*!40000 ALTER TABLE `usr_usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-09 18:33:55
