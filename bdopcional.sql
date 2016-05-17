-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.0.17-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win32
-- HeidiSQL Versión:             9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Volcando estructura de base de datos para bdopcional
CREATE DATABASE IF NOT EXISTS `bdopcional` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `bdopcional`;


-- Volcando estructura para tabla bdopcional.admin
CREATE TABLE IF NOT EXISTS `admin` (
  `id` int(10) NOT NULL,
  `clave` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla bdopcional.admin: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` (`id`, `clave`) VALUES
	(1234, 'b1f37ec94d5ce01b55b89cec07183cef'),
	(3333, 'b1f37ec94d5ce01b55b89cec07183cef'),
	(5678, 'b1f37ec94d5ce01b55b89cec07183cef');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;


-- Volcando estructura para tabla bdopcional.cargo
CREATE TABLE IF NOT EXISTS `cargo` (
  `idcargo` varchar(3) NOT NULL,
  `descripcion` varchar(50) NOT NULL,
  `salario` int(15) NOT NULL,
  PRIMARY KEY (`idcargo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla bdopcional.cargo: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `cargo` DISABLE KEYS */;
INSERT INTO `cargo` (`idcargo`, `descripcion`, `salario`) VALUES
	('GGR', 'Gerente General', 2000000),
	('ING', 'Ingeniero', 1500000),
	('TCN', 'Técnico', 1000000),
	('TEC', 'Tecnólogo', 1200000);
/*!40000 ALTER TABLE `cargo` ENABLE KEYS */;


-- Volcando estructura para tabla bdopcional.ciudad
CREATE TABLE IF NOT EXISTS `ciudad` (
  `idciudad` varchar(3) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `departamento` varchar(50) NOT NULL,
  PRIMARY KEY (`idciudad`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla bdopcional.ciudad: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `ciudad` DISABLE KEYS */;
INSERT INTO `ciudad` (`idciudad`, `nombre`, `departamento`) VALUES
	('BNV', 'Buenaventura', 'Valle del Cauca'),
	('BOG', 'Bogotá', 'Cundinamarca'),
	('CAL', 'Cali', 'Valle del Cauca'),
	('MAN', 'Manizales', 'Caldas'),
	('MED', 'Medellín', 'Antioquia'),
	('SRC', 'Santa Rosa de Cabal', 'Risaralda'),
	('TUL', 'Tuluá', 'Valle del Cauca');
/*!40000 ALTER TABLE `ciudad` ENABLE KEYS */;


-- Volcando estructura para tabla bdopcional.empleado
CREATE TABLE IF NOT EXISTS `empleado` (
  `codigo` int(10) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `direccion` varchar(50) NOT NULL,
  `telefono` int(11) NOT NULL,
  `email` varchar(50) NOT NULL,
  `edad` int(2) NOT NULL,
  `idciudad` varchar(3) NOT NULL,
  `idcargo` varchar(3) NOT NULL,
  PRIMARY KEY (`codigo`),
  KEY `fk_idciudad` (`idciudad`),
  KEY `fk_idcargo` (`idcargo`),
  CONSTRAINT `fk_idcargo` FOREIGN KEY (`idcargo`) REFERENCES `cargo` (`idcargo`),
  CONSTRAINT `fk_idciudad` FOREIGN KEY (`idciudad`) REFERENCES `ciudad` (`idciudad`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla bdopcional.empleado: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `empleado` DISABLE KEYS */;
INSERT INTO `empleado` (`codigo`, `nombre`, `apellido`, `direccion`, `telefono`, `email`, `edad`, `idciudad`, `idcargo`) VALUES
	(94367124, 'Luisa', 'Morales', 'Calle 72 No. 47A-02', 4512300, 'morlui86@hotmail.com', 30, 'MED', 'GGR'),
	(1112098234, 'María', 'Giraldo', 'Carrera 25 No. 58-12', 8871234, 'girmar95@hotmail.com', 29, 'MAN', 'TCN'),
	(1116265806, 'Christian', 'Noreña', 'Calle 39 No. 27A-29', 2262893, 'crisdanovagoodyear@hotmail.com', 21, 'TUL', 'ING'),
	(1116285102, 'Carlos', 'Gómez', 'Calle 26 No. 6-12', 3312431, 'carlos.gomez@hotmail.com', 24, 'SRC', 'TEC');
/*!40000 ALTER TABLE `empleado` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
