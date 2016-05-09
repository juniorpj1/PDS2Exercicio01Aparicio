CREATE DATABASE  IF NOT EXISTS `trabalho_pds2` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `trabalho_pds2`;
-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: 127.0.0.1    
-- ------------------------------------------------------
-- Server version	5.6.25

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
-- Table structure for table `tb_itenspedido`
--

DROP TABLE IF EXISTS `tb_itenspedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_itenspedido` (
  `codItemPedido` int(11) NOT NULL AUTO_INCREMENT,
  `quantidade` int(11) DEFAULT NULL,
  `pedido` int(11) DEFAULT NULL,
  `produto` int(11) DEFAULT NULL,
  PRIMARY KEY (`codItemPedido`),
  KEY `FK9emf5in4hpexoqp9ln492vvdd` (`pedido`),
  KEY `FK750juiq4ml9dv8tfceoxc492v` (`produto`),
  CONSTRAINT `FK750juiq4ml9dv8tfceoxc492v` FOREIGN KEY (`produto`) REFERENCES `tb_produtos` (`codProduto`),
  CONSTRAINT `FK9emf5in4hpexoqp9ln492vvdd` FOREIGN KEY (`pedido`) REFERENCES `tb_pedidos` (`codPedido`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_itenspedido`
--
-- ORDER BY:  `codItemPedido`

LOCK TABLES `tb_itenspedido` WRITE;
/*!40000 ALTER TABLE `tb_itenspedido` DISABLE KEYS */;
INSERT INTO `tb_itenspedido` (`codItemPedido`, `quantidade`, `pedido`, `produto`) VALUES (1,2,1,3),(2,3,1,4),(3,2,2,2),(4,2,2,5),(5,4,3,1),(6,2,3,2),(7,3,4,5),(8,2,4,3),(9,2,5,4),(10,2,5,1);
/*!40000 ALTER TABLE `tb_itenspedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_pedidos`
--

DROP TABLE IF EXISTS `tb_pedidos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_pedidos` (
  `codPedido` int(11) NOT NULL AUTO_INCREMENT,
  `data` datetime DEFAULT NULL,
  PRIMARY KEY (`codPedido`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_pedidos`
--
-- ORDER BY:  `codPedido`

LOCK TABLES `tb_pedidos` WRITE;
/*!40000 ALTER TABLE `tb_pedidos` DISABLE KEYS */;
INSERT INTO `tb_pedidos` (`codPedido`, `data`) VALUES (1,'2015-11-10 00:00:00'),(2,'2015-11-15 00:00:00'),(3,'2015-11-20 00:00:00'),(4,'2015-11-25 00:00:00'),(5,'2015-12-05 00:00:00');
/*!40000 ALTER TABLE `tb_pedidos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_produtos`
--

DROP TABLE IF EXISTS `tb_produtos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_produtos` (
  `codProduto` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  `preco` decimal(19,2) DEFAULT NULL,
  PRIMARY KEY (`codProduto`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_produtos`
--
-- ORDER BY:  `codProduto`

LOCK TABLES `tb_produtos` WRITE;
/*!40000 ALTER TABLE `tb_produtos` DISABLE KEYS */;
INSERT INTO `tb_produtos` (`codProduto`, `nome`, `preco`) VALUES (1,'Estojo',30.00),(2,'Caderno',20.00),(3,'Lapis de cor',40.00),(4,'Regua',10.00),(5,'Pasta',15.00);
/*!40000 ALTER TABLE `tb_produtos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'trabalho_pds2'
--

--
-- Dumping routines for database 'trabalho_pds2'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-04-11 13:06:53
