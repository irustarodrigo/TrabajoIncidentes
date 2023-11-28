-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 28-11-2023 a las 22:32:52
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `incidentes`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `idCliente` int(11) NOT NULL,
  `contacto` varchar(255) DEFAULT NULL,
  `cuit` varchar(255) DEFAULT NULL,
  `estado` bit(1) NOT NULL,
  `razonSocial` varchar(255) DEFAULT NULL,
  `servicio` varchar(255) DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`idCliente`, `contacto`, `cuit`, `estado`, `razonSocial`, `servicio`, `telefono`) VALUES
(3, 'SCOMP@ARNET.COM.AR', 'SOCIALCOMP', b'1', 'SOCIAL COMP', 'MANTENIMIENTO CONEX Y REDES', '011 8384234'),
(4, 'tecmader@arnet.com.ar', '11222233', b'1', 'TEC MADER', 'MANTENIMIENTO EQUIPOS', '54123456'),
(8, 'PEPEE', '5555', b'1', 'CATALINA FERNANDEZ', 'MANTENIMIENTO SO', '919191'),
(13, 'pagoda@gmail.com', '9999', b'1', 'PAGODA SA', 'MANTENIMIENTO SO', '123456'),
(15, 'guerrero@guerrero.com.ar', '7777', b'1', 'GUERRERO', 'MANTENIMIENTO SO', '426720');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(17),
(17),
(17),
(17),
(17),
(17),
(17),
(17),
(17),
(17),
(17),
(17),
(17),
(17),
(17),
(17),
(17),
(17),
(17),
(17),
(17),
(17),
(17),
(17),
(17),
(17),
(17),
(17),
(17),
(17),
(17),
(17),
(17),
(17),
(17),
(17),
(17),
(17),
(17),
(17),
(17),
(17),
(17),
(17),
(17),
(17),
(17),
(17),
(17),
(17),
(17),
(17),
(17),
(17),
(17),
(17),
(17),
(17),
(17),
(17),
(17),
(17),
(17),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `incidente`
--

CREATE TABLE `incidente` (
  `idIncidente` int(11) NOT NULL,
  `dificultad` varchar(255) DEFAULT NULL,
  `estado` bit(1) NOT NULL,
  `fechaEstimada` date DEFAULT NULL,
  `fechaRegistro` date DEFAULT NULL,
  `idCliente` int(11) DEFAULT NULL,
  `idTecnico` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `incidente`
--

INSERT INTO `incidente` (`idIncidente`, `dificultad`, `estado`, `fechaEstimada`, `fechaRegistro`, `idCliente`, `idTecnico`) VALUES
(10, 'MEDIA', b'1', '2023-11-30', '2023-11-27', 8, 5),
(11, 'BAJA', b'0', '2023-12-04', '2023-11-27', 8, 1),
(12, 'COMPLEJA', b'1', '2023-12-10', '2023-11-27', 4, 2),
(14, 'ALTA', b'1', '2023-12-03', '2023-11-27', 13, 1),
(16, 'COMPLEJA', b'1', '2024-01-03', '2023-11-27', 15, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tecnico`
--

CREATE TABLE `tecnico` (
  `idTecnico` int(11) NOT NULL,
  `contacto` varchar(255) DEFAULT NULL,
  `dni` varchar(255) DEFAULT NULL,
  `especialidad` varchar(255) DEFAULT NULL,
  `estado` bit(1) NOT NULL,
  `nomApe` varchar(255) DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `tecnico`
--

INSERT INTO `tecnico` (`idTecnico`, `contacto`, `dni`, `especialidad`, `estado`, `nomApe`, `telefono`) VALUES
(1, 'irustarodrigo@gmail.com', '28126572', 'SO', b'1', 'RODRIGO JUAN IRUSTA', '3476618816'),
(2, 'tomi@gmail.com', '47657315', 'HARDWARE', b'1', 'Tomas Irusta', '16534356'),
(5, 'ROER', '1234', 'SO', b'1', 'RAMON SISTO', '4994'),
(6, 'PEPE', '4321', 'SOFTWARE', b'1', 'JOSE PEREZ', '9999'),
(7, 'MARIAN', '9999', 'REDES', b'1', 'MARIANA ARIAS', '9292'),
(9, 'OE', '12345123', 'SO', b'0', 'ARTURO MANAOS', '98');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`idCliente`);

--
-- Indices de la tabla `incidente`
--
ALTER TABLE `incidente`
  ADD PRIMARY KEY (`idIncidente`),
  ADD KEY `FK14g7jp03kxjbheovxcrxerej7` (`idCliente`),
  ADD KEY `FK1hbm5nv1esm63t9lwrgei0u58` (`idTecnico`);

--
-- Indices de la tabla `tecnico`
--
ALTER TABLE `tecnico`
  ADD PRIMARY KEY (`idTecnico`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `incidente`
--
ALTER TABLE `incidente`
  ADD CONSTRAINT `FK14g7jp03kxjbheovxcrxerej7` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`),
  ADD CONSTRAINT `FK1hbm5nv1esm63t9lwrgei0u58` FOREIGN KEY (`idTecnico`) REFERENCES `tecnico` (`idTecnico`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
