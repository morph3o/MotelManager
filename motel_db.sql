-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Oct 14, 2013 at 07:53 AM
-- Server version: 5.5.9
-- PHP Version: 5.2.17

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `motel`
--

-- --------------------------------------------------------

--
-- Table structure for table `admins`
--

CREATE TABLE `admins` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_persona` varchar(50) NOT NULL DEFAULT '',
  `clave` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_persona` (`id_persona`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `detalle_factura`
--

CREATE TABLE `detalle_factura` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_factura` int(11) NOT NULL,
  `id_prod` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `precio_unitario` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_factura` (`id_factura`),
  KEY `id_prod` (`id_prod`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `entradas`
--

CREATE TABLE `entradas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_entrada` int(11) NOT NULL,
  `id_factura` int(11) NOT NULL,
  `id_prod` int(11) NOT NULL,
  `id_persona` varchar(50) NOT NULL,
  `fecha_ingreso` date NOT NULL,
  `cant_ingreso` int(11) NOT NULL,
  `cant_ext_ant` int(11) NOT NULL,
  `cant_ext_desp` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_factura` (`id_factura`),
  KEY `id_prod` (`id_prod`),
  KEY `id_persona` (`id_persona`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `factura`
--

CREATE TABLE `factura` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_factura` int(11) NOT NULL,
  `id_prov` varchar(50) NOT NULL,
  `precio_neto` int(11) NOT NULL,
  `precio_total` int(11) NOT NULL,
  `link_imagen` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_factura` (`id_factura`),
  KEY `id_prov` (`id_prov`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `persona`
--

CREATE TABLE `persona` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_persona` varchar(50) NOT NULL,
  `nombre` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `ape_paterno` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `ape_materno` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(50) NOT NULL,
  `telefono` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_persona` (`id_persona`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `persona`
--

INSERT INTO `persona` (`id`, `id_persona`, `nombre`, `ape_paterno`, `ape_materno`, `email`, `telefono`) VALUES
(1, '16.349.603-8', 'Piero', 'Divasto', 'Martinez', 'pdivasto@gmail.com', '56996191517'),
(2, '8.031.069-2', 'Maria', 'Martinez', 'Farias', 'morph3o@gmail.com', '234234');

-- --------------------------------------------------------

--
-- Table structure for table `producto`
--

CREATE TABLE `producto` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_prod` int(11) NOT NULL,
  `nm_prod` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `tipo_prod` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `marca` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'Marca del producto',
  `cant_prod` int(11) DEFAULT NULL COMMENT 'cantidad del producto en bodega',
  `imagen` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `detalle` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_prod` (`id_prod`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;

--
-- Dumping data for table `producto`
--

INSERT INTO `producto` (`id`, `id_prod`, `nm_prod`, `tipo_prod`, `marca`, `cant_prod`, `imagen`, `detalle`) VALUES
(1, 100, 'Coca-Cola', NULL, NULL, 0, NULL, NULL),
(2, 300, 'Fanta', NULL, 'Coca-Cola Company', 20, '', 'dasdasd'),
(3, 400, 'Sprite', NULL, 'Coca-Cola Company', 20, '', ''),
(4, 500, 'asdasd', NULL, 'asdasd', 333, '', ''),
(6, 1000, 'asdasd', NULL, 'kjnkjkj', 20, '', ''),
(10, 999, 'llmlk', NULL, 'nkjjkkj', 0, '', '');

-- --------------------------------------------------------

--
-- Table structure for table `proveedor`
--

CREATE TABLE `proveedor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_prov` varchar(50) NOT NULL COMMENT 'rut proveedor',
  `nm_prov` varchar(50) NOT NULL COMMENT 'Nombre del proveedor',
  `tel_prov` varchar(50) NOT NULL COMMENT 'Telefono de contacto del proveedor',
  `dir_prov` varchar(100) NOT NULL COMMENT 'Dirección del proveedor',
  `email_prov` varchar(20) NOT NULL COMMENT 'Correo del proveedor',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_prov` (`id_prov`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Tabla de los proveedores del motel' AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `salidas`
--

CREATE TABLE `salidas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_salida` int(11) NOT NULL,
  `id_prod` int(11) NOT NULL,
  `id_persona` varchar(50) NOT NULL,
  `fecha_egreso` date NOT NULL,
  `cant_egreso` int(11) NOT NULL,
  `cant_ext_ant` int(11) NOT NULL,
  `cant_ext_desp` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_prod` (`id_prod`),
  KEY `id_persona` (`id_persona`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `admins`
--
ALTER TABLE `admins`
  ADD CONSTRAINT `admins_ibfk_1` FOREIGN KEY (`id_persona`) REFERENCES `persona` (`id_persona`);

--
-- Constraints for table `detalle_factura`
--
ALTER TABLE `detalle_factura`
  ADD CONSTRAINT `detalle_factura_ibfk_1` FOREIGN KEY (`id_factura`) REFERENCES `factura` (`id_factura`),
  ADD CONSTRAINT `detalle_factura_ibfk_2` FOREIGN KEY (`id_prod`) REFERENCES `producto` (`id_prod`);

--
-- Constraints for table `entradas`
--
ALTER TABLE `entradas`
  ADD CONSTRAINT `entradas_ibfk_1` FOREIGN KEY (`id_factura`) REFERENCES `factura` (`id_factura`),
  ADD CONSTRAINT `entradas_ibfk_2` FOREIGN KEY (`id_prod`) REFERENCES `producto` (`id_prod`),
  ADD CONSTRAINT `entradas_ibfk_3` FOREIGN KEY (`id_persona`) REFERENCES `persona` (`id_persona`);

--
-- Constraints for table `factura`
--
ALTER TABLE `factura`
  ADD CONSTRAINT `factura_ibfk_1` FOREIGN KEY (`id_prov`) REFERENCES `proveedor` (`id_prov`);

--
-- Constraints for table `salidas`
--
ALTER TABLE `salidas`
  ADD CONSTRAINT `salidas_ibfk_1` FOREIGN KEY (`id_prod`) REFERENCES `producto` (`id_prod`),
  ADD CONSTRAINT `salidas_ibfk_2` FOREIGN KEY (`id_persona`) REFERENCES `persona` (`id_persona`);
