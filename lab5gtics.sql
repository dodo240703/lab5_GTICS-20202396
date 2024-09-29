-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: lab5gtics
-- ------------------------------------------------------
-- Server version	8.0.36

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
-- Table structure for table `areas`
--

DROP TABLE IF EXISTS `areas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `areas` (
  `idAreas` int NOT NULL,
  `nombreArea` varchar(45) NOT NULL,
  PRIMARY KEY (`idAreas`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `areas`
--

LOCK TABLES `areas` WRITE;
/*!40000 ALTER TABLE `areas` DISABLE KEYS */;
INSERT INTO `areas` VALUES (1,'Psiquiatría'),(2,'Neurología'),(3,'Psicología'),(4,'Terapia Ocupacional');
/*!40000 ALTER TABLE `areas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `canciones`
--

DROP TABLE IF EXISTS `canciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `canciones` (
  `idCanciones` int NOT NULL AUTO_INCREMENT,
  `nombreCancion` varchar(45) NOT NULL,
  `tipoCancion` varchar(45) DEFAULT NULL,
  `idRecurso` int NOT NULL,
  PRIMARY KEY (`idCanciones`,`idRecurso`),
  KEY `fk_Canciones_Recursos1_idx` (`idRecurso`),
  CONSTRAINT `fk_Canciones_Recursos1` FOREIGN KEY (`idRecurso`) REFERENCES `recursos` (`idRecursos`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `canciones`
--

LOCK TABLES `canciones` WRITE;
/*!40000 ALTER TABLE `canciones` DISABLE KEYS */;
INSERT INTO `canciones` VALUES (1,'Canta - Vi-Em','recomendada',1),(2,'Viva la vida - Coldplay','recomendada',1),(3,'Rise - Jonas Blue','recomendada',1),(4,'Glorious - Macklemore ft. Skylar Grey','recomendada',1),(5,'On Top of the World - Imagine Dragons','recomendada',1),(6,'Happy - Pharrell Williams','recomendada',1),(7,'Fight Song - Rachel Platten','recomendada',1),(8,'Stronger - Kanye West','recomendada',1),(9,'Don\'t Stop Believin\' - Journey','recomendada',1),(10,'Best Day of My Life - American Authors','recomendada',1),(11,'Bugambilia - Nasa Histories','no recomendada',2),(12,'Cactus - Nasa Histories','no recomendada',2),(13,'The Scientist - Coldplay','no recomendada',2),(14,'Someone Like You - Adele','no recomendada',2),(15,'Hurt - Johnny Cash','no recomendada',2),(16,'Tears Dry On Their Own - Amy Winehouse','no recomendada',2),(17,'Yesterday - The Beatles','no recomendada',2),(18,'Everybody Hurts - R.E.M.','no recomendada',2),(19,'Let Her Go - Passenger','no recomendada',2),(20,'Nothing Compares 2 U - Sinead O’Connor','no recomendada',2);
/*!40000 ALTER TABLE `canciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `citas`
--

DROP TABLE IF EXISTS `citas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `citas` (
  `idCitas` int NOT NULL AUTO_INCREMENT,
  `motivoConsulta` varchar(45) NOT NULL,
  `idPaciente` int NOT NULL,
  `idArea` int NOT NULL,
  `idProfesional` int NOT NULL,
  `idSede` int NOT NULL,
  `idFechaConsulta` int NOT NULL,
  `idRiesgo` int NOT NULL,
  `precio` decimal(10,0) DEFAULT NULL,
  `Citascol` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idCitas`),
  KEY `fk_Citas_Fechas1_idx` (`idFechaConsulta`,`idProfesional`),
  KEY `fk_Citas_Areas1_idx` (`idArea`),
  KEY `fk_Citas_Sedes1_idx` (`idSede`),
  KEY `fk_Citas_Pacientes1_idx` (`idPaciente`),
  KEY `fk_Citas_Riesgos1_idx` (`idRiesgo`),
  CONSTRAINT `fk_Citas_Areas1` FOREIGN KEY (`idArea`) REFERENCES `areas` (`idAreas`),
  CONSTRAINT `fk_Citas_Fechas1` FOREIGN KEY (`idFechaConsulta`, `idProfesional`) REFERENCES `fechas` (`idFechas`, `idProfesional`),
  CONSTRAINT `fk_Citas_Pacientes1` FOREIGN KEY (`idPaciente`) REFERENCES `pacientes` (`idPacientes`),
  CONSTRAINT `fk_Citas_Riesgos1` FOREIGN KEY (`idRiesgo`) REFERENCES `riesgos` (`idRiesgos`),
  CONSTRAINT `fk_Citas_Sedes1` FOREIGN KEY (`idSede`) REFERENCES `sedes` (`idSedes`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `citas`
--

LOCK TABLES `citas` WRITE;
/*!40000 ALTER TABLE `citas` DISABLE KEYS */;
INSERT INTO `citas` VALUES (8,'Dolor de corazón',11,1,2,2,2,4,NULL,NULL),(13,'Ansiedad y estrés',11,1,1,1,1,1,50,NULL),(14,'Problemas de sueño',12,2,2,2,2,2,60,NULL),(15,'Depresión leve',13,3,3,3,3,3,55,NULL),(16,'Trastornos alimenticios',14,4,4,4,4,4,65,NULL),(17,'Trastornos alimenticios',15,4,4,4,4,4,65,NULL);
/*!40000 ALTER TABLE `citas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fechas`
--

DROP TABLE IF EXISTS `fechas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fechas` (
  `idFechas` int NOT NULL,
  `fechaDisponibilidad` date NOT NULL,
  `idProfesional` int NOT NULL,
  PRIMARY KEY (`idFechas`,`idProfesional`),
  KEY `fk_Fechas_Profesionales1_idx` (`idProfesional`),
  CONSTRAINT `fk_Fechas_Profesionales1` FOREIGN KEY (`idProfesional`) REFERENCES `profesionales` (`idProfesionales`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fechas`
--

LOCK TABLES `fechas` WRITE;
/*!40000 ALTER TABLE `fechas` DISABLE KEYS */;
INSERT INTO `fechas` VALUES (1,'2024-09-15',1),(2,'2024-09-18',2),(3,'2024-09-21',3),(4,'2024-09-10',4),(5,'2024-09-12',5),(6,'2024-09-20',6),(7,'2024-09-22',7),(8,'2024-09-25',8),(9,'2024-09-27',9),(10,'2024-09-29',10),(11,'2024-10-01',1),(11,'2024-09-30',11),(12,'2024-10-02',2),(13,'2024-10-03',3),(14,'2024-10-04',4),(15,'2024-10-05',5),(16,'2024-10-06',6),(17,'2024-10-07',7),(18,'2024-10-08',8),(19,'2024-10-09',9),(20,'2024-10-10',10),(21,'2024-10-11',1),(22,'2024-10-12',2),(23,'2024-10-13',3),(24,'2024-10-14',4),(25,'2024-10-15',5),(26,'2024-10-16',6),(27,'2024-10-17',7),(28,'2024-10-18',8),(29,'2024-10-19',9),(30,'2024-10-20',10);
/*!40000 ALTER TABLE `fechas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `foro`
--

DROP TABLE IF EXISTS `foro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `foro` (
  `idForo` int NOT NULL AUTO_INCREMENT,
  `comentario` varchar(45) NOT NULL,
  `nombrePersona` varchar(45) NOT NULL,
  `edadPersona` int DEFAULT NULL,
  PRIMARY KEY (`idForo`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `foro`
--

LOCK TABLES `foro` WRITE;
/*!40000 ALTER TABLE `foro` DISABLE KEYS */;
INSERT INTO `foro` VALUES (1,'hola papu cuidate mucho te quieroo muchooooo','Dodo',21),(2,'Despierta papuuuuuuuu','Dodo',21);
/*!40000 ALTER TABLE `foro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `frases`
--

DROP TABLE IF EXISTS `frases`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `frases` (
  `idFrases` int NOT NULL AUTO_INCREMENT,
  `frase` varchar(500) DEFAULT NULL,
  `idRecurso` int NOT NULL,
  PRIMARY KEY (`idFrases`,`idRecurso`),
  KEY `fk_Frases_Recursos1_idx` (`idRecurso`),
  CONSTRAINT `fk_Frases_Recursos1` FOREIGN KEY (`idRecurso`) REFERENCES `recursos` (`idRecursos`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `frases`
--

LOCK TABLES `frases` WRITE;
/*!40000 ALTER TABLE `frases` DISABLE KEYS */;
INSERT INTO `frases` VALUES (1,'Mientras haya vida, hay esperanza.',1),(2,'Tercera Ley de Newton: La única manera de que los humanos descubran cómo llegar a algún lado, es dejando algo atrás.',1),(3,'No importa lo lento que vayas, siempre y cuando no te detengas.',1),(4,'El éxito es la suma de pequeños esfuerzos repetidos día tras día.',1),(5,'No dejes que lo que no puedes hacer interfiera con lo que puedes hacer.',1),(6,'El futuro pertenece a quienes creen en la belleza de sus sueños.',1),(7,'Nunca es tarde para ser lo que podrías haber sido.',1),(8,'Cada día es una nueva oportunidad para cambiar tu vida.',1),(9,'Los grandes logros requieren tiempo y paciencia.',1),(10,'Levántate, sonríe y sigue adelante.',1);
/*!40000 ALTER TABLE `frases` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pacientes`
--

DROP TABLE IF EXISTS `pacientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pacientes` (
  `idPacientes` int NOT NULL AUTO_INCREMENT,
  `nombrePaciente` varchar(45) DEFAULT NULL,
  `DNI` varchar(45) DEFAULT NULL,
  `Edad` int DEFAULT NULL,
  `Pacientescol` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idPacientes`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pacientes`
--

LOCK TABLES `pacientes` WRITE;
/*!40000 ALTER TABLE `pacientes` DISABLE KEYS */;
INSERT INTO `pacientes` VALUES (11,'Dorian Felix','10093414',21,NULL),(12,'Carlos Vargas','12345678',34,NULL),(13,'Luis Pinedo','87654321',29,NULL),(14,'Liz Vela','98765432',45,NULL),(15,'Angela Salazar','76543210',32,NULL);
/*!40000 ALTER TABLE `pacientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profesionales`
--

DROP TABLE IF EXISTS `profesionales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `profesionales` (
  `idProfesionales` int NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `imagen` varchar(45) NOT NULL,
  `descripcionProfesional` varchar(90) NOT NULL,
  `idArea` int NOT NULL,
  `idSede` int NOT NULL,
  PRIMARY KEY (`idProfesionales`),
  KEY `fk_Profesionales_Areas_idx` (`idArea`),
  KEY `fk_Profesionales_Sedes1_idx` (`idSede`),
  CONSTRAINT `fk_Profesionales_Areas` FOREIGN KEY (`idArea`) REFERENCES `areas` (`idAreas`),
  CONSTRAINT `fk_Profesionales_Sedes1` FOREIGN KEY (`idSede`) REFERENCES `sedes` (`idSedes`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profesionales`
--

LOCK TABLES `profesionales` WRITE;
/*!40000 ALTER TABLE `profesionales` DISABLE KEYS */;
INSERT INTO `profesionales` VALUES (1,'Leonardo Campos','leonardo_campos.jpeg','Psiquiatra con más de 20 años de experiencia en salud mental.',1,1),(2,'Ronald Boyer','ronald_boyer.jpeg','Especialista en trastornos de ansiedad y depresión.',1,2),(3,'Karla Pezo','karla_pezo.jpeg','Especialista en psiquiatría infantil.',1,3),(4,'Mayra Gonzales','mayra_gonzales.jpeg','Experta en enfermedades neurodegenerativas.',2,1),(5,'Franco Lazo','franco_lazo.jpeg','Especialista en epilepsia y trastornos neurológicos.',2,5),(6,'Victor Guerra','victor_guerra.jpeg','Psicólogo clínico especializado en terapia cognitivo-conductual.',3,4),(7,'Paolo Valiente','paolo_valiente.jpeg','Psicólogo organizacional con enfoque en estrés laboral.',3,1),(8,'Alonso Llanos','alonso_llanos.jpeg','Psicólogo con enfoque en terapias familiares.',3,2),(9,'Diego Torres','diego_torres.jpeg','Terapeuta ocupacional experto en rehabilitación física.',4,3),(10,'Piero Mendoza','piero_mendoza.jpeg','Especialista en rehabilitación cognitiva.',4,1),(11,'Hellen Aranda','hellen_aranda.jpeg','Experta en terapia ocupacional infantil.',4,5);
/*!40000 ALTER TABLE `profesionales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recursos`
--

DROP TABLE IF EXISTS `recursos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recursos` (
  `idRecursos` int NOT NULL,
  PRIMARY KEY (`idRecursos`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recursos`
--

LOCK TABLES `recursos` WRITE;
/*!40000 ALTER TABLE `recursos` DISABLE KEYS */;
INSERT INTO `recursos` VALUES (1),(2);
/*!40000 ALTER TABLE `recursos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `riesgos`
--

DROP TABLE IF EXISTS `riesgos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `riesgos` (
  `idRiesgos` int NOT NULL,
  `tipoRiesgo` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idRiesgos`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `riesgos`
--

LOCK TABLES `riesgos` WRITE;
/*!40000 ALTER TABLE `riesgos` DISABLE KEYS */;
INSERT INTO `riesgos` VALUES (1,'Bajo'),(2,'Moderado'),(3,'Alto'),(4,'Muy Alto');
/*!40000 ALTER TABLE `riesgos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sedes`
--

DROP TABLE IF EXISTS `sedes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sedes` (
  `idSedes` int NOT NULL,
  `nombreSede` varchar(45) NOT NULL,
  PRIMARY KEY (`idSedes`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sedes`
--

LOCK TABLES `sedes` WRITE;
/*!40000 ALTER TABLE `sedes` DISABLE KEYS */;
INSERT INTO `sedes` VALUES (1,'Lima'),(2,'Trujillo'),(3,'Arequipa'),(4,'San Martín'),(5,'Ayacucho');
/*!40000 ALTER TABLE `sedes` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-09-29 16:47:30
