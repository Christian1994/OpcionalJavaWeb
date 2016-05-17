-- --------------------------------------------------------
-- Host:                         localhost
-- Versión del servidor:         5.6.16 - MySQL Community Server (GPL)
-- SO del servidor:              Win32
-- HeidiSQL Versión:             8.3.0.4694
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Volcando estructura de base de datos para bdopcional
CREATE DATABASE IF NOT EXISTS `bdopcional` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci */;
USE `bdopcional`;


-- Volcando estructura para tabla bdopcional.admin
CREATE TABLE IF NOT EXISTS `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clave` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla bdopcional.admin: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` (`id`, `clave`) VALUES
	(1, 'b1f37ec94d5ce01b55b89cec07183cef'),
	(2, 'b1f37ec94d5ce01b55b89cec07183cef'),
	(3, 'b1f37ec94d5ce01b55b89cec07183cef'),
	(4, 'b1f37ec94d5ce01b55b89cec07183cef');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;


-- Volcando estructura para tabla bdopcional.cargo
CREATE TABLE IF NOT EXISTS `cargo` (
  `idcargo` int(11) NOT NULL,
  `descripcion` varchar(50) DEFAULT NULL,
  `salario` int(11) DEFAULT NULL,
  PRIMARY KEY (`idcargo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla bdopcional.cargo: ~10 rows (aproximadamente)
/*!40000 ALTER TABLE `cargo` DISABLE KEYS */;
INSERT INTO `cargo` (`idcargo`, `descripcion`, `salario`) VALUES
	(10, 'GERENTE GENERAL', 10000),
	(11, 'GERENTE COMERCIAL', 8000),
	(15, 'GERENTE FINANCIERO', 8000),
	(20, 'DIRECTOR PLANEACION', 5000),
	(25, 'DIRECTOR SUMINISTROS', 5000),
	(30, 'JEFE CONTABILIDAD', 3000),
	(50, 'AUXILIAR CONTABLE', 2000),
	(51, 'SECRETARIA', 1000),
	(52, 'TECNICO DE SISTEMAS', 1500),
	(56, 'INSTRUCTIR', 1000);
/*!40000 ALTER TABLE `cargo` ENABLE KEYS */;


-- Volcando estructura para tabla bdopcional.ciudad
CREATE TABLE IF NOT EXISTS `ciudad` (
  `idciudad` varchar(50) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `departamento` varchar(50) NOT NULL,
  PRIMARY KEY (`idciudad`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla bdopcional.ciudad: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `ciudad` DISABLE KEYS */;
INSERT INTO `ciudad` (`idciudad`, `nombre`, `departamento`) VALUES
	('BAQ', 'BARRANQUILLA', 'ATLANTICO'),
	('BOG', 'BOGOTA', 'CUNDINAMARCA'),
	('BUC', 'BUCARAMANGA', 'SANTANDER'),
	('CAL', 'CALI', 'VALLE DEL CAUCA'),
	('CTG', 'CARTAGENA', 'BOLIVAR'),
	('CUC', 'CUCUTA', 'NORTE DE SANTANDER'),
	('MED', 'MEDELLIN', 'ANTIOQUIA'),
	('POP', 'POPAYAN', 'CAUCA'),
	('RIO', 'RIOACHA', 'GUAJIRA'),
	('STA', 'SANTA MARTA', 'MAGDALENA');
/*!40000 ALTER TABLE `ciudad` ENABLE KEYS */;


-- Volcando estructura para tabla bdopcional.empleado
CREATE TABLE IF NOT EXISTS `empleado` (
  `idempleado` int(11) NOT NULL,
  `codigo` int(11) DEFAULT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `apellido` varchar(50) DEFAULT NULL,
  `idcargo` int(11) DEFAULT NULL,
  `direccion` varchar(50) DEFAULT NULL,
  `telefono` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `codciudad` varchar(50) DEFAULT NULL,
  `edad` int(11) DEFAULT NULL,
  PRIMARY KEY (`idempleado`),
  KEY `FK_empleado_cargo` (`idcargo`),
  KEY `FK_empleado_ciudad` (`codciudad`),
  CONSTRAINT `FK_empleado_cargo` FOREIGN KEY (`idcargo`) REFERENCES `cargo` (`idcargo`) ON UPDATE CASCADE,
  CONSTRAINT `FK_empleado_ciudad` FOREIGN KEY (`codciudad`) REFERENCES `ciudad` (`idciudad`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla bdopcional.empleado: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `empleado` DISABLE KEYS */;
INSERT INTO `empleado` (`idempleado`, `codigo`, `nombre`, `apellido`, `idcargo`, `direccion`, `telefono`, `email`, `codciudad`, `edad`) VALUES
	(8550000, 2505, 'ANDRES', 'PEREZ', 10, 'Carrera 36 12-58', '22569874', 'aperez@empresa.com', 'BAQ', 30),
	(32454589, 2506, 'JUAN', 'MARTINEZ', 11, 'CR 50 12-25', '35554578', 'jmartinez@empresa.com', 'CTG', 41),
	(72207855, 2507, 'MARTHA', 'MORALES', 50, 'CLLE 90 58-25', '35558596', 'mmorales@empresa.com', 'BOG', 26),
	(96556489, 2508, 'SANDRA', 'CARRILLO', 25, 'TRANSV 10 8-79', '35554782', 'scarrillo@empresa.com', 'CAL', 29);
/*!40000 ALTER TABLE `empleado` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
admin