CREATE DATABASE  IF NOT EXISTS `sql11413968` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `sql11413968`;
-- MySQL dump 10.13  Distrib 8.0.16, for macos10.14 (x86_64)
--
-- Host: sql11.freemysqlhosting.net    Database: sql11413968
-- ------------------------------------------------------
-- Server version	5.5.62-0ubuntu0.14.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Almacen`
--

DROP TABLE IF EXISTS `Almacen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Almacen` (
  `idAlmacen` int(11) NOT NULL AUTO_INCREMENT,
  `telefono` int(11) NOT NULL,
  `capacidad` int(11) NOT NULL,
  `direccion` varchar(30) NOT NULL,
  `activo` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`idAlmacen`)
) ENGINE=InnoDB AUTO_INCREMENT=102 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Almacen`
--

LOCK TABLES `Almacen` WRITE;
/*!40000 ALTER TABLE `Almacen` DISABLE KEYS */;
INSERT INTO `Almacen` VALUES (1,993234543,123,'C/ Serrano Nº32',1),(2,678334667,100,'TIENDA',1),(3,987445662,500,'C/ Gutenberg Nº7',1),(4,345654345,3,'Gran Vía',1);
/*!40000 ALTER TABLE `Almacen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Clientes`
--

DROP TABLE IF EXISTS `Clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Clientes` (
  `idCliente` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(35) NOT NULL,
  `socio` tinyint(1) NOT NULL,
  `DNI` varchar(9) DEFAULT NULL,
  `activo` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`idCliente`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Clientes`
--

LOCK TABLES `Clientes` WRITE;
/*!40000 ALTER TABLE `Clientes` DISABLE KEYS */;
INSERT INTO `Clientes` VALUES (1,'Guillermo',1,'38764732S',1),(2,'Ángel Hortelano',1,'89856534F',1),(3,'Mario Campos',1,'74533167O',1),(4,'Patricia Pastor',0,'89766782V',1),(5,'Jorge Morales',1,'82455671C',1),(25,'Laura Llorente',1,'74659834C',1);
/*!40000 ALTER TABLE `Clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Contiene`
--

DROP TABLE IF EXISTS `Contiene`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Contiene` (
  `unidades` int(11) DEFAULT NULL,
  `precio` decimal(8,2) DEFAULT NULL,
  `idProducto` int(11) DEFAULT NULL,
  `idFactura` int(11) DEFAULT NULL,
  KEY `FK1_Contiene` (`idProducto`),
  KEY `FK2_Contiene` (`idFactura`),
  CONSTRAINT `FK2_Contiene` FOREIGN KEY (`idFactura`) REFERENCES `Facturas` (`idFactura`) ON DELETE CASCADE,
  CONSTRAINT `FK1_Contiene` FOREIGN KEY (`idProducto`) REFERENCES `Productos` (`idProducto`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Contiene`
--

LOCK TABLES `Contiene` WRITE;
/*!40000 ALTER TABLE `Contiene` DISABLE KEYS */;
INSERT INTO `Contiene` VALUES (2,468.00,1,1),(4,15.60,6,2),(2,200.00,10,2),(1,169.99,2,2),(2,41.98,15,2),(1,2.95,3,4),(1,3.99,12,4),(1,3.90,6,4),(1,4.99,9,4),(1,20.99,15,4);
/*!40000 ALTER TABLE `Contiene` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Facturas`
--

DROP TABLE IF EXISTS `Facturas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Facturas` (
  `idFactura` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `precioTotal` decimal(8,2) DEFAULT NULL,
  `idTrabajador` int(11) DEFAULT NULL,
  `idCliente` int(11) DEFAULT NULL,
  `activo` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`idFactura`),
  KEY `FK_Facturas` (`idTrabajador`),
  KEY `FK1_Facturas` (`idCliente`),
  CONSTRAINT `FK1_Facturas` FOREIGN KEY (`idCliente`) REFERENCES `Clientes` (`idCliente`),
  CONSTRAINT `FK_Facturas` FOREIGN KEY (`idTrabajador`) REFERENCES `Trabajadores` (`idTrabajador`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Facturas`
--

LOCK TABLES `Facturas` WRITE;
/*!40000 ALTER TABLE `Facturas` DISABLE KEYS */;
INSERT INTO `Facturas` VALUES (1,'2021-05-21 16:47:59',468.00,1,1,1),(2,'2021-05-22 11:02:00',427.57,5,2,1),(4,'2021-05-23 10:24:40',36.00,2,25,1);
/*!40000 ALTER TABLE `Facturas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Marca`
--

DROP TABLE IF EXISTS `Marca`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Marca` (
  `idMarca` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(35) NOT NULL,
  `activo` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`idMarca`)
) ENGINE=InnoDB AUTO_INCREMENT=90 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Marca`
--

LOCK TABLES `Marca` WRITE;
/*!40000 ALTER TABLE `Marca` DISABLE KEYS */;
INSERT INTO `Marca` VALUES (1,'Nike',1),(2,'Adidas',1),(3,'Jordan',1),(4,'Puma',1),(5,'Balenciaga',1);
/*!40000 ALTER TABLE `Marca` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Productos`
--

DROP TABLE IF EXISTS `Productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Productos` (
  `idProducto` int(11) NOT NULL AUTO_INCREMENT,
  `color` varchar(9) DEFAULT NULL,
  `talla` int(11) DEFAULT NULL,
  `stock` int(11) DEFAULT NULL,
  `nombre` varchar(35) DEFAULT NULL,
  `precio` decimal(8,2) DEFAULT NULL,
  `tejido` varchar(20) DEFAULT NULL,
  `tipo` varchar(20) DEFAULT NULL,
  `tipoProducto` int(11) DEFAULT NULL,
  `idAlmacen` int(11) DEFAULT NULL,
  `idMarca` int(11) DEFAULT NULL,
  `activo` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`idProducto`),
  KEY `FK_Productos` (`idAlmacen`),
  KEY `FK1_Productos` (`idMarca`),
  CONSTRAINT `FK1_Productos` FOREIGN KEY (`idMarca`) REFERENCES `Marca` (`idMarca`) ON DELETE CASCADE,
  CONSTRAINT `FK_Productos` FOREIGN KEY (`idAlmacen`) REFERENCES `Almacen` (`idAlmacen`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Productos`
--

LOCK TABLES `Productos` WRITE;
/*!40000 ALTER TABLE `Productos` DISABLE KEYS */;
INSERT INTO `Productos` VALUES (1,'Azul',42,7,'Nike SB',64.95,NULL,'Casual',0,1,1,1),(2,'Azul',41,4,'Air Max 95 Essential',169.99,NULL,'Casual',0,2,1,1),(3,'Azul',42,17,'Nike modelo 1',2.95,'Lana',NULL,1,2,1,1),(4,'Verde',42,12,'Superstar',100.00,NULL,'Casual',0,2,2,1),(5,'Azul',44,10,'Adidas ZX 1K Boost',110.00,NULL,'Casual',0,2,2,1),(6,'Azul',40,15,'Adidas modelo 1',3.90,'Seda',NULL,1,2,2,1),(7,'Rojo',40,8,'Air Jordan 1 Low',109.99,NULL,'Casual',0,3,3,1),(8,'Azul',42,12,'Jordan Zion 1',119.99,NULL,'Casual',0,2,3,1),(9,'Azul',42,15,'Jordan modelo 1',4.99,'Seda',NULL,1,2,3,1),(10,'Azul',40,7,'Wild Rider Rollin\'',100.00,NULL,'Deportivas',0,2,4,1),(11,'Azul',40,10,'RS-Connect Mono',120.00,NULL,'Casual',0,2,4,1),(12,'Azul',40,17,'Puma modelo 1',3.99,'Seda',NULL,1,2,4,1),(13,'Azul',40,5,'Speed 2.0 Sneaker',825.00,NULL,'Casual',0,2,5,1),(14,'Verde',42,2,'Heeled Toe',1090.00,NULL,'Casual',0,2,5,1),(15,'Rojo',41,7,'Balenciaga modelo 1',20.99,'Algodon',NULL,1,2,5,1);
/*!40000 ALTER TABLE `Productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Proveedores`
--

DROP TABLE IF EXISTS `Proveedores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Proveedores` (
  `idProveedor` int(11) NOT NULL AUTO_INCREMENT,
  `telefono` int(11) NOT NULL,
  `direccion` varchar(30) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `activo` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`idProveedor`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Proveedores`
--

LOCK TABLES `Proveedores` WRITE;
/*!40000 ALTER TABLE `Proveedores` DISABLE KEYS */;
INSERT INTO `Proveedores` VALUES (1,974313998,'C/ Fuencarral Nº16','Aliexpress Spain',0),(2,996330876,'C/ Severo Ochoa Nº4','Foot dealer',1);
/*!40000 ALTER TABLE `Proveedores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Suministra`
--

DROP TABLE IF EXISTS `Suministra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Suministra` (
  `idProveedor` int(11) DEFAULT NULL,
  `idProducto` int(11) DEFAULT NULL,
  `precioSuministro` decimal(8,2) DEFAULT NULL,
  KEY `FK1_Suministra` (`idProveedor`),
  KEY `FK2_Suministra` (`idProducto`),
  CONSTRAINT `FK2_Suministra` FOREIGN KEY (`idProducto`) REFERENCES `Productos` (`idProducto`) ON DELETE CASCADE,
  CONSTRAINT `FK1_Suministra` FOREIGN KEY (`idProveedor`) REFERENCES `Proveedores` (`idProveedor`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Suministra`
--

LOCK TABLES `Suministra` WRITE;
/*!40000 ALTER TABLE `Suministra` DISABLE KEYS */;
INSERT INTO `Suministra` VALUES (1,1,45.00),(1,2,105.90),(1,3,1.50),(1,4,75.50),(1,5,80.00),(1,6,2.25),(1,7,87.95),(1,8,90.00),(1,9,2.75),(2,7,82.50),(2,8,92.50),(2,9,2.80),(2,10,75.05),(2,11,84.00),(2,12,1.85),(2,13,590.00),(2,14,755.00),(2,15,12.99);
/*!40000 ALTER TABLE `Suministra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Trabajadores`
--

DROP TABLE IF EXISTS `Trabajadores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Trabajadores` (
  `idTrabajador` int(11) NOT NULL AUTO_INCREMENT,
  `DNI` varchar(9) NOT NULL,
  `telefono` int(11) NOT NULL,
  `nombre` varchar(35) NOT NULL,
  `activo` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`idTrabajador`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Trabajadores`
--

LOCK TABLES `Trabajadores` WRITE;
/*!40000 ALTER TABLE `Trabajadores` DISABLE KEYS */;
INSERT INTO `Trabajadores` VALUES (1,'82372734S',876323234,'Juan Pedro',1),(2,'09076532D',667543902,'Antonio Navarro',1),(3,'98822317H',654338999,'Nacho Fluxa',1),(4,'77822100K',676992341,'Ana Martinez',1),(5,'73300987P',667233990,'Manuel Montenegro',1),(6,'67678876T',678789875,'Paco Martinez',0);
/*!40000 ALTER TABLE `Trabajadores` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-24 20:25:15
