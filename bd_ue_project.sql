/*
MySQL Backup
Source Server Version: 5.5.5
Source Database: bd_ue_project
Date: 15/06/2022 22:10:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
--  Table structure for `docentes`
-- ----------------------------
DROP TABLE IF EXISTS `docentes`;
CREATE TABLE `docentes` (
  `Cod_doc` varchar(10) NOT NULL,
  `Nombre` varchar(50) NOT NULL,
  `Apellidos` varchar(80) DEFAULT NULL,
  `Ci` varchar(15) NOT NULL,
  `Direccion` varchar(100) DEFAULT NULL,
  `Fecha_Nac` date NOT NULL,
  `Telefono` varchar(10) NOT NULL,
  `Cod_mat` varchar(10) DEFAULT NULL,
  `Cod_grado` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`Cod_doc`),
  UNIQUE KEY `Ci` (`Ci`),
  KEY `FK_Cod_mat` (`Cod_mat`),
  KEY `FK_Cod_grado` (`Cod_grado`),
  CONSTRAINT `FK_Cod_grado` FOREIGN KEY (`Cod_grado`) REFERENCES `grado` (`Cod_grado`),
  CONSTRAINT `FK_Cod_mat` FOREIGN KEY (`Cod_mat`) REFERENCES `materias` (`Cod_mat`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `estudiantes`
-- ----------------------------
DROP TABLE IF EXISTS `estudiantes`;
CREATE TABLE `estudiantes` (
  `Rude` varchar(20) NOT NULL,
  `Ci` int(11) NOT NULL,
  `Nombre` varchar(30) NOT NULL,
  `Apellidos` varchar(50) NOT NULL,
  `Fecha_nacimiento` date DEFAULT NULL,
  `Direccion` varchar(100) NOT NULL,
  `Estado` varchar(20) NOT NULL,
  `Cod_ppff` varchar(10) NOT NULL,
  PRIMARY KEY (`Rude`),
  KEY `FK_cod_ppff` (`Cod_ppff`),
  CONSTRAINT `FK_cod_ppff` FOREIGN KEY (`Cod_ppff`) REFERENCES `ppff` (`Cod_ppff`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `grado`
-- ----------------------------
DROP TABLE IF EXISTS `grado`;
CREATE TABLE `grado` (
  `Cod_grado` varchar(10) NOT NULL,
  `Descripcion` varchar(20) DEFAULT NULL,
  `Cod_paralelo` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`Cod_grado`),
  KEY `FK_cod_paralelo` (`Cod_paralelo`),
  CONSTRAINT `FK_cod_paralelo` FOREIGN KEY (`Cod_paralelo`) REFERENCES `paralelo` (`Cod_paralelo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `inscripcion`
-- ----------------------------
DROP TABLE IF EXISTS `inscripcion`;
CREATE TABLE `inscripcion` (
  `Cod_inscripcion` varchar(10) NOT NULL,
  `Rude1` varchar(20) NOT NULL,
  `Cod_grado1` varchar(10) NOT NULL,
  `Cod_turno` varchar(10) NOT NULL,
  `Fecha` date DEFAULT NULL,
  `Tipo_inscripcion` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`Cod_inscripcion`),
  KEY `FK_rude1` (`Rude1`),
  KEY `FK_cod_grado02` (`Cod_grado1`),
  KEY `FK_cod_turno` (`Cod_turno`),
  CONSTRAINT `FK_cod_grado02` FOREIGN KEY (`Cod_grado1`) REFERENCES `grado` (`Cod_grado`),
  CONSTRAINT `FK_cod_turno` FOREIGN KEY (`Cod_turno`) REFERENCES `turno` (`Cod_turno`),
  CONSTRAINT `FK_rude1` FOREIGN KEY (`Rude1`) REFERENCES `estudiantes` (`Rude`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `materias`
-- ----------------------------
DROP TABLE IF EXISTS `materias`;
CREATE TABLE `materias` (
  `Cod_mat` varchar(10) NOT NULL,
  `Descripcion` varchar(50) NOT NULL,
  `Sigla` varchar(5) NOT NULL,
  PRIMARY KEY (`Cod_mat`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `nota`
-- ----------------------------
DROP TABLE IF EXISTS `nota`;
CREATE TABLE `nota` (
  `Cod_nota` varchar(10) NOT NULL,
  `Rude` varchar(20) NOT NULL,
  `Primer_trimestre` int(11) NOT NULL,
  `Segundo_trimestre` int(11) NOT NULL,
  `Tercer_trimestre` int(11) NOT NULL,
  PRIMARY KEY (`Cod_nota`),
  KEY `FK_rude` (`Rude`),
  CONSTRAINT `FK_rude` FOREIGN KEY (`Rude`) REFERENCES `estudiantes` (`Rude`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `paralelo`
-- ----------------------------
DROP TABLE IF EXISTS `paralelo`;
CREATE TABLE `paralelo` (
  `Cod_paralelo` varchar(10) NOT NULL,
  `Descripcion` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`Cod_paralelo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `permiso_laboral`
-- ----------------------------
DROP TABLE IF EXISTS `permiso_laboral`;
CREATE TABLE `permiso_laboral` (
  `Cod_permiso` varchar(10) NOT NULL,
  `Descripcion` varchar(100) NOT NULL,
  `Fecha` date DEFAULT NULL,
  `Fecha_inicio` date DEFAULT NULL,
  `Fecha_final` date DEFAULT NULL,
  `Cod_doc` varchar(10) DEFAULT NULL,
  `Cod_admi` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`Cod_permiso`),
  KEY `FK_Cod_doc01` (`Cod_doc`),
  KEY `FK_Cod_admi` (`Cod_admi`),
  CONSTRAINT `FK_Cod_admi` FOREIGN KEY (`Cod_admi`) REFERENCES `personal_administrativo` (`Cod_admi`),
  CONSTRAINT `FK_Cod_doc01` FOREIGN KEY (`Cod_doc`) REFERENCES `docentes` (`Cod_doc`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `personal_administrativo`
-- ----------------------------
DROP TABLE IF EXISTS `personal_administrativo`;
CREATE TABLE `personal_administrativo` (
  `Cod_admi` varchar(10) NOT NULL,
  `Nombre` varchar(50) NOT NULL,
  `Apellidos` varchar(80) DEFAULT NULL,
  `Ci` varchar(15) NOT NULL,
  `Fecha_Nac` date NOT NULL,
  `Direccion` varchar(100) DEFAULT NULL,
  `Telefono` varchar(10) NOT NULL,
  PRIMARY KEY (`Cod_admi`),
  UNIQUE KEY `Ci` (`Ci`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `ppff`
-- ----------------------------
DROP TABLE IF EXISTS `ppff`;
CREATE TABLE `ppff` (
  `Cod_ppff` varchar(10) NOT NULL,
  `Ci` int(11) NOT NULL,
  `Nombre` varchar(30) NOT NULL,
  `Apellidos` varchar(50) NOT NULL,
  `Fecha_nacimiento` date DEFAULT NULL,
  `Direccion` varchar(100) NOT NULL,
  `Tipo_pariente` varchar(20) NOT NULL,
  `Telefono` int(11) DEFAULT NULL,
  PRIMARY KEY (`Cod_ppff`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `turno`
-- ----------------------------
DROP TABLE IF EXISTS `turno`;
CREATE TABLE `turno` (
  `Cod_turno` varchar(10) NOT NULL,
  `Turno` varchar(20) NOT NULL,
  `Incio` varchar(20) NOT NULL,
  `Fin` varchar(20) NOT NULL,
  PRIMARY KEY (`Cod_turno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `usuarios`
-- ----------------------------
DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE `usuarios` (
  `Cod_usr` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(50) NOT NULL,
  `Apellidos` varchar(80) DEFAULT NULL,
  `Usuario` varchar(20) NOT NULL,
  `Contraseña` varchar(20) NOT NULL,
  `Tipo_usuario` varchar(20) NOT NULL,
  PRIMARY KEY (`Cod_usr`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records 
-- ----------------------------
INSERT INTO `usuarios` VALUES ('1','Kevin','Canaza Sanga','KevinCS','9994841','ADMINISTRADOR'), ('2','Alison Cielo','Alaro Vino','AlisonAV','9173259','ADMINISTRADOR'), ('3','Cristhian',' Choquehuanca Apaza','CristhianCA','7099250','ADMINISTRADOR');
