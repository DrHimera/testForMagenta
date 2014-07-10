-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Хост: 127.0.0.1
-- Время создания: Окт 20 2013 г., 20:54
-- Версия сервера: 5.5.27
-- Версия PHP: 5.4.7

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- База данных: `cityroute`
--

-- --------------------------------------------------------

--
-- Структура таблицы `city`
--

CREATE TABLE IF NOT EXISTS `city` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(100) CHARACTER SET utf8 NOT NULL,
  `Latitude` double NOT NULL,
  `Longitude` double NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=14 ;

--
-- Дамп данных таблицы `city`
--

INSERT INTO `city` (`ID`, `Name`, `Latitude`, `Longitude`) VALUES
(1, 'Samara', 53.183333, 50.116667),
(2, 'Moskow', 55.751667, 37.617778);

-- --------------------------------------------------------

--
-- Структура таблицы `route`
--

CREATE TABLE IF NOT EXISTS `route` (
  `City1_ID` int(11) NOT NULL COMMENT 'ИД города1',
  `City2_ID` int(11) NOT NULL COMMENT 'ИД города2',
  `Distance` double NOT NULL COMMENT 'Расстояние между городами'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Дамп данных таблицы `route`
--

INSERT INTO `route` (`City1_ID`, `City2_ID`, `Distance`) VALUES
(1, 2, 1054);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
