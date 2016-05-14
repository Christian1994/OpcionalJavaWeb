-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.1.13-MariaDB - mariadb.org binary distribution
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

-- La exportación de datos fue deseleccionada.


-- Volcando estructura para tabla bdopcional.cargo
CREATE TABLE IF NOT EXISTS `cargo` (
  `idcargo` varchar(3) NOT NULL,
  `descripcion` varchar(50) NOT NULL,
  `salario` int(15) NOT NULL,
  PRIMARY KEY (`idcargo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- La exportación de datos fue deseleccionada.


-- Volcando estructura para tabla bdopcional.ciudad
CREATE TABLE IF NOT EXISTS `ciudad` (
  `idciudad` varchar(3) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `departamento` varchar(50) NOT NULL,
  PRIMARY KEY (`idciudad`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- La exportación de datos fue deseleccionada.


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

-- La exportación de datos fue deseleccionada.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
