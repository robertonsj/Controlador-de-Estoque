-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: bd_vendas
-- ------------------------------------------------------
-- Server version	8.0.23

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
-- Table structure for table `tb_clientes`
--

DROP TABLE IF EXISTS `tb_clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_clientes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) DEFAULT NULL,
  `cpf` varchar(20) DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL,
  `contato` varchar(30) DEFAULT NULL,
  `endereco` varchar(255) DEFAULT NULL,
  `complemento` varchar(200) DEFAULT NULL,
  `bairro` varchar(100) DEFAULT NULL,
  `cidade` varchar(100) DEFAULT NULL,
  `uf` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_clientes`
--

LOCK TABLES `tb_clientes` WRITE;
/*!40000 ALTER TABLE `tb_clientes` DISABLE KEYS */;
INSERT INTO `tb_clientes` VALUES (6,'João Silva','999.999.999 - 88','joao@gmail','(86) 9 9988 - 9988','Av. Principal','Bloco A','Tavares','Teresina','PI'),(7,'Fernanda Soares','999.999.999 - 55','fernanda@gmail','(86) 9 9988 - 7766','Rua 100','Condomínio','São Roque','Parnaíba','PI'),(8,'Gabriel Reis','999.999.999 - 44','gabriel@gmail','(86) 9 8155 - 5566','Sítio Flor de Lis','Escola','Bom Princípio','São Luís','MA'),(13,'Gabriel Silveira','999.999.999 - 66','gabriel@gmail','(86) 9 8155 - 5566','Sítio Flor de Lis','Escola','Bom Princípio','São Luís','PB');
/*!40000 ALTER TABLE `tb_clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_fornecedores`
--

DROP TABLE IF EXISTS `tb_fornecedores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_fornecedores` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) DEFAULT NULL,
  `cnpj` varchar(100) DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL,
  `contato` varchar(30) DEFAULT NULL,
  `endereco` varchar(255) DEFAULT NULL,
  `complemento` varchar(200) DEFAULT NULL,
  `bairro` varchar(100) DEFAULT NULL,
  `cidade` varchar(100) DEFAULT NULL,
  `uf` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_fornecedores`
--

LOCK TABLES `tb_fornecedores` WRITE;
/*!40000 ALTER TABLE `tb_fornecedores` DISABLE KEYS */;
INSERT INTO `tb_fornecedores` VALUES (4,'Gazin','333.333.333/3333-33','gazin@eletronicos','(22) 2 2222 - 2222','quadra123','perto de local A','jardim','pao','MS'),(6,'Oderço Distribuidora','444.444.444/4444-44','oderço@distribuidor','(11) 1 1111 - 1111','Av. Principal 3223','','abc','parnaiba','SP'),(7,'Utimix','555.555.555/5555-55','utimix@distribuidor','(11) 1 1111 - 1111','Conjunto Caribe 123','Rua principal','Promorar','São Luiz','MA'),(8,'SOS Eletrônicos','666.666.666/6666-66','soseletronicos@distribuidor','(33) 3 3333 - 3333','Av. Guadalupes 345','Ponte','São Bento','Ribeirão Preto','SP'),(9,'Distribuidora Gazin','077.941.490/0077-53','contato@gazinatacado.com.br','(44) 9 8848 - 8282','Rod Antonio Pedroso, KM 01','Bloco 1','','Douradina','PR');
/*!40000 ALTER TABLE `tb_fornecedores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_funcionarios`
--

DROP TABLE IF EXISTS `tb_funcionarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_funcionarios` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) DEFAULT NULL,
  `cpf` varchar(20) DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL,
  `senha` varchar(10) DEFAULT NULL,
  `cargo` varchar(100) DEFAULT NULL,
  `nivel_acesso` varchar(50) DEFAULT NULL,
  `contato` varchar(30) DEFAULT NULL,
  `endereco` varchar(255) DEFAULT NULL,
  `complemento` varchar(200) DEFAULT NULL,
  `bairro` varchar(100) DEFAULT NULL,
  `cidade` varchar(100) DEFAULT NULL,
  `uf` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_funcionarios`
--

LOCK TABLES `tb_funcionarios` WRITE;
/*!40000 ALTER TABLE `tb_funcionarios` DISABLE KEYS */;
INSERT INTO `tb_funcionarios` VALUES (1,'Maria','111.111.111 - 11','maria@gmail','abc','Faturista','Usuário','(11) 1 1111 - 1111','Av Marechal','Nenhum','Monte Castelo','Teresina','PI'),(3,'Everton','111.111.111 - 11','everton@gmail','abc','Gerente','Administrador','(11) 1 1111 - 1111','Central Park','Nenhum','Chelsea','Londres','AL'),(4,'Roberto','444.444.444 - 44','roberto@gmail.com','123','Coordenador','Administrador','(22) 2 2222 - 2222','Avenue St Martin','Nenhum','Birmighan','Manchester','AC');
/*!40000 ALTER TABLE `tb_funcionarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_itensvendas`
--

DROP TABLE IF EXISTS `tb_itensvendas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_itensvendas` (
  `id` int NOT NULL AUTO_INCREMENT,
  `venda_id` int DEFAULT NULL,
  `produto_id` int DEFAULT NULL,
  `qtd` int DEFAULT NULL,
  `subtotal` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `venda_id` (`venda_id`),
  KEY `produto_id` (`produto_id`),
  CONSTRAINT `tb_itensvendas_ibfk_1` FOREIGN KEY (`venda_id`) REFERENCES `tb_vendas` (`id`),
  CONSTRAINT `tb_itensvendas_ibfk_2` FOREIGN KEY (`produto_id`) REFERENCES `tb_produtos` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_itensvendas`
--

LOCK TABLES `tb_itensvendas` WRITE;
/*!40000 ALTER TABLE `tb_itensvendas` DISABLE KEYS */;
INSERT INTO `tb_itensvendas` VALUES (1,5,7,1,2700.00),(2,5,6,2,112.00),(3,10,3,1,199.90),(4,10,2,2,118.00),(5,11,10,1,3800.00),(6,12,2,2,118.00),(7,12,3,1,199.90),(8,13,1,3,234.00),(9,13,3,1,199.90),(10,14,3,1,199.90),(11,14,10,2,7600.00),(12,15,11,2,9600.00);
/*!40000 ALTER TABLE `tb_itensvendas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_produtos`
--

DROP TABLE IF EXISTS `tb_produtos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_produtos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `descricao` varchar(100) DEFAULT NULL,
  `preco` decimal(10,2) DEFAULT NULL,
  `qtd_estoque` int DEFAULT NULL,
  `for_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `for_id` (`for_id`),
  CONSTRAINT `tb_produtos_ibfk_1` FOREIGN KEY (`for_id`) REFERENCES `tb_fornecedores` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_produtos`
--

LOCK TABLES `tb_produtos` WRITE;
/*!40000 ALTER TABLE `tb_produtos` DISABLE KEYS */;
INSERT INTO `tb_produtos` VALUES (1,'Mini Game Portátil',78.00,147,6),(2,'Smartband M5',59.00,198,7),(3,'TV Box MXQ PRO',199.90,67,4),(4,'Smartband M4',199.00,150,6),(6,'Caixa de Som Bluetooth',56.00,120,8),(7,'Notebook Acer 15.6',2700.00,25,8),(8,'Mouse C3 Tech',120.00,150,8),(10,'Notebook Samsung 15.6',3800.00,20,6),(11,'Notebook Lenovo',4800.00,20,4);
/*!40000 ALTER TABLE `tb_produtos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_vendas`
--

DROP TABLE IF EXISTS `tb_vendas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_vendas` (
  `id` int NOT NULL AUTO_INCREMENT,
  `cliente_id` int DEFAULT NULL,
  `data_venda` datetime DEFAULT NULL,
  `total_venda` decimal(10,2) DEFAULT NULL,
  `observacoes` text,
  PRIMARY KEY (`id`),
  KEY `cliente_id` (`cliente_id`),
  CONSTRAINT `tb_vendas_ibfk_1` FOREIGN KEY (`cliente_id`) REFERENCES `tb_clientes` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_vendas`
--

LOCK TABLES `tb_vendas` WRITE;
/*!40000 ALTER TABLE `tb_vendas` DISABLE KEYS */;
INSERT INTO `tb_vendas` VALUES (1,6,'2021-05-22 00:00:00',234.00,''),(2,7,'2021-05-22 00:00:00',118.00,'Para presente.'),(3,7,'2021-05-23 00:00:00',599.70,'Entregar na minha casa.'),(4,13,'2021-05-23 00:00:00',599.70,'Caixa comum.'),(5,8,'2021-05-23 00:00:00',2812.00,''),(6,13,'2021-05-01 00:00:00',425.50,'Sem obs.'),(7,6,'2021-05-02 00:00:00',325.50,'Para viagem.'),(8,6,'2021-05-03 00:00:00',176.25,'Para minha irmã.'),(9,6,'2021-05-04 00:00:00',56.25,'Para viagem.'),(10,7,'2021-05-23 00:00:00',317.90,''),(11,7,'2021-05-25 00:00:00',3800.00,'Para presente.'),(12,7,'2021-05-25 00:00:00',317.90,'Para presente.'),(13,8,'2021-05-25 00:00:00',433.90,'Para presente.'),(14,7,'2021-05-26 00:00:00',7799.90,'Para presente.'),(15,8,'2021-05-26 00:00:00',9600.00,'para presente');
/*!40000 ALTER TABLE `tb_vendas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-06-06 13:35:34
