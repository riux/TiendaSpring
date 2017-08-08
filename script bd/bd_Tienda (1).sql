-- phpMyAdmin SQL Dump
-- version 4.5.0.2
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 08-08-2017 a las 14:54:25
-- Versión del servidor: 10.0.17-MariaDB
-- Versión de PHP: 5.5.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bd_Tienda`
--

--
-- Volcado de datos para la tabla `categoria_producto`
--

INSERT INTO `categoria_producto` (`id`, `estado`, `nombre`) VALUES
(1, b'1', 'Bebidas'),
(2, b'1', 'Articulos de Tocador'),
(3, b'1', 'Deshidratados'),
(4, b'1', 'Postres');

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`id`, `descripcion`, `imagen_url`, `proest`, `pronom`, `propre`, `stock`, `categoria_producto_id`) VALUES
(1, 'Delicioso bebida alcoholica a base de leche y aguaymanto', '/products/18313crema2-aguaymanto.jpg', b'1', 'Coctel de Aguaymanto', 45, 15, 1),
(2, 'Bebida alcoholica de alta graduacion que se obtiene por destilacion, en especial de aguaymanto cuidadosamente seleccionado', '/products/181225licor de aguaymanto 1.jpg', b'1', 'Licor de Aguaymanto', 60, 30, 1),
(3, 'Bebida resfrescante que se obtiene al añadir agua, azucares y otras sustancias a la pulpa de la fruta', '/products/181225nectar aguaymanto.jpg', b'1', 'Nectar de Aguaymanto', 15, 100, 1),
(4, 'Producto cosmetico concebido a base de aguaymanto para combatir la sequedad de la piel y protegernos de las inclemencias', '/products/181225crema aguaymanto.gif', b'1', 'Crema de Aguaymanto', 150, 50, 2),
(5, 'Barra antiseptica y de aseo para todo el cuerpo, con aroma fresca', '/products/181225jabon de aguaymanto.png', b'1', 'Jabon de Aguaymanto', 15, 100, 2),
(6, 'Shampoo para todo tipo de cabello y anticaspa con aroma a aguaymanto', '/products/181225SHAMPOO-AGUAYMANTO.jpg', b'1', 'Shampoo de Aguaymanto', 40, 50, 2),
(8, 'Aguaymanto deshidratado en bolsa en presentacion de 1Kg.', '/products/181225deshidratado bolsa.jpg', b'1', 'Pasas de Aguaymanto', 40, 50, 3),
(9, 'Deshidratados de Aguaymanto con Maní en presentacion en bolsa de un 1 Kg.', '/products/181225deshidratado con mani.jpg', b'1', 'Deshidratados de Aguaymanto', 60, 100, 3),
(10, 'Deshidratado de Aguaymanto en presentacion en taper de 1.5Kg.', '/products/181225deshidratado taper.jpg', b'1', 'Deshidratado en Taper', 70, 100, 3),
(11, 'Chocolate acompañado con aguaymanto y miel, dulce y delicioso para chuparse el dedo ', '/products/181225Chocoteja aguaymanto.jpg', b'1', 'Chocoteja de Aguaymanto', 20, 100, 4),
(12, 'Tarta delicioso con aspecto crocante a base de fruto de aguaymanto seleccionado', '/products/181225Crostata de aguaymanto.jpg', b'1', 'Crostata de Aguaymanto', 29.9, 20, 4),
(13, 'Galletas elaboradas de harina de maiz rebosado con aguaymanto deshidratado en presentacion en bolsa de 250Gr.', '/products/181225Galletas Suizas aguaymanto.jpg', b'1', 'Galletas Suizas de Aguaymanto', 10, 20, 4),
(14, 'Gelatina con frutas picadas de aguaymanto que resultan atractivospor su consistencia suave y textura blanda y su llamativo color natural', '/products/181225Gelatina aguaymanto.jpg', b'1', 'Gelatina de Aguaymanto', 15, 100, 4),
(15, 'Conserva de aguaymanto cocida en azucar de color natural', '/products/181225mermelada aguaymanto.jpg', b'1', 'Mermelada de Aguaymanto', 45, 70, 4),
(16, 'Elaborado de base de harina, manteca,  frutas frescas y deshidratados de aguaymanto ', '/products/181225pastel aguaymanto.jpg', b'1', 'Pastel de Aguaymanto', 35, 50, 4),
(17, 'Elaborado a base de harina y azucar con crema elaborado de aguaymanto fresco.', '/products/181225Pye de aguaymanto.jpg', b'1', 'Pye Aguaymanto', 40, 50, 4),
(18, 'Postre tipico a base de leche condensada y aguamanto fresca, acaramelado por aguaymanto deshidratado', '/products/181225Quesillo en Miel aguaymanto.jpg', b'1', 'Quesillo en miel de Aguaymanto', 30, 50, 4),
(19, 'Postre hecha de helado de aguaymanto con capa fina de biscochuelo para formar un rollo', '/products/181225Rollo+de+aguaymanto-3111.jpeg', b'1', 'Rollo de Aguaymanto', 20, 30, 4),
(20, 'Dulce de pasta hecha a base de harina de trigo, aceite, aguaymanto y otras ingredientes', '/products/181225Torta aguaymanto.jpg', b'1', 'Torta de Aguaymato', 40, 30, 4),
(23, 'descripcion', '/products/458616610.png', b'1', 'producto22', 12, 12, 3);

--
-- Volcado de datos para la tabla `rol`
--

INSERT INTO `rol` (`id`, `estado`, `nombre`, `usuario_id`) VALUES
(1, b'1', 'ROLE_ADMIN', 3),
(2, b'1', 'ROLE_USER', 4);

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id`, `apellidos`, `contrasenia`, `cuecorele`, `estado`, `nombre_usuario`, `nombre`, `puntos`) VALUES
(3, 'mend', '$2a$10$/M8J4EiCepYoP.TS7BsJVuxIT0MceN1wNGtyFRVES.uST9Zg90l3O', 'rich@mail.com', b'1', 'admin', 'richard', 100),
(4, 'home', '$2a$10$Kxj.8Tetts2e5IUrHJdUmu1RP2mAUX0/zIX0JbdUPEF40f0bALMCS', 'homero@mail.com', b'1', 'user', 'homero', 100);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
