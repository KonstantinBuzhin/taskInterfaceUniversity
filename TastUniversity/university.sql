-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Хост: 127.0.0.1
-- Время создания: Ноя 23 2020 г., 17:47
-- Версия сервера: 5.5.25
-- Версия PHP: 5.3.13

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- База данных: `university`
--

-- --------------------------------------------------------

--
-- Структура таблицы `departments`
--

CREATE TABLE IF NOT EXISTS `departments` (
  `id_Department` bigint(20) NOT NULL AUTO_INCREMENT,
  `head_Department_Name` varchar(30) NOT NULL,
  `head_Department_Surname` varchar(30) NOT NULL,
  `department_Name` varchar(100) NOT NULL,
  PRIMARY KEY (`id_Department`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=6 ;

--
-- Дамп данных таблицы `departments`
--

INSERT INTO `departments` (`id_Department`, `head_Department_Name`, `head_Department_Surname`, `department_Name`) VALUES
(1, 'Ivan', 'Vasylenko', 'FEP'),
(2, 'Vladyslav', 'Alenkov', 'FTIT'),
(3, 'Andriy', 'Petrych', 'FMLT'),
(4, 'Sergiy', 'Rakhmanin', 'ARF'),
(5, 'Oleksiy', 'Mashluk', 'FIR');

-- --------------------------------------------------------

--
-- Структура таблицы `lectors`
--

CREATE TABLE IF NOT EXISTS `lectors` (
  `id_Lector` bigint(20) NOT NULL AUTO_INCREMENT,
  `degree` varchar(100) NOT NULL,
  `salary` int(11) NOT NULL,
  `lector_Name` varchar(30) NOT NULL,
  `lector_Surname` varchar(30) NOT NULL,
  PRIMARY KEY (`id_Lector`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=21 ;

--
-- Дамп данных таблицы `lectors`
--

INSERT INTO `lectors` (`id_Lector`, `degree`, `salary`, `lector_Name`, `lector_Surname`) VALUES
(1, 'assistant', 10000, 'Denys', 'Biletskiy'),
(2, 'associate professor', 13000, 'Kostiantyn', 'Fomenko'),
(3, 'assistant', 9500, 'Maxym', 'Koval'),
(4, 'associate professor', 12500, 'Roman', 'Levchenko'),
(5, 'professor', 17000, 'Ivan', 'Kuleba'),
(6, 'assistant', 9000, 'Maxym', 'Kolomko'),
(7, 'professor', 16000, 'Andriy', 'Roba'),
(8, 'professor', 17000, 'Dmytro', 'Varos'),
(9, 'assistant', 10000, 'Ruslan', 'Gorovay'),
(10, 'associate professor', 12000, 'Vadim', 'Kovanich'),
(11, 'assistant', 10000, 'Denys', 'Farychenko'),
(12, 'associate professor', 13000, 'Ivan', 'Semenchuk'),
(13, 'assistant', 9500, 'Maxym', 'Muzychenko'),
(14, 'associate professor', 12500, 'Roman', 'Sergiychyk'),
(15, 'professor', 17000, 'Bohdan', 'Zaporozniy'),
(16, 'assistant', 9000, 'Vladyskav', 'Vadymenko'),
(17, 'professor', 16000, 'Valentyn', 'Yakovenko'),
(18, 'professor', 17000, 'Dmytro', 'Shevchenko'),
(19, 'assistant', 10000, 'Yaroslav', 'Andrievskiy'),
(20, 'associate professor', 12000, 'Semen', 'Lomaka');

-- --------------------------------------------------------

--
-- Структура таблицы `university`
--

CREATE TABLE IF NOT EXISTS `university` (
  `id_Note` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_Lector` bigint(20) NOT NULL,
  `id_Department` bigint(20) NOT NULL,
  PRIMARY KEY (`id_Note`),
  KEY `id_Lector` (`id_Lector`,`id_Department`),
  KEY `id_Department` (`id_Department`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=30 ;

--
-- Дамп данных таблицы `university`
--

INSERT INTO `university` (`id_Note`, `id_Lector`, `id_Department`) VALUES
(1, 1, 2),
(21, 1, 5),
(2, 2, 1),
(3, 3, 1),
(4, 4, 2),
(22, 4, 5),
(5, 5, 3),
(23, 5, 4),
(6, 6, 1),
(7, 7, 2),
(8, 8, 1),
(25, 8, 5),
(9, 9, 2),
(24, 9, 5),
(10, 10, 3),
(11, 11, 4),
(12, 12, 5),
(13, 13, 1),
(14, 14, 4),
(26, 15, 1),
(15, 15, 5),
(16, 16, 2),
(17, 17, 4),
(27, 18, 2),
(18, 18, 5),
(28, 19, 3),
(19, 19, 4),
(29, 20, 3),
(20, 20, 5);

--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `university`
--
ALTER TABLE `university`
  ADD CONSTRAINT `university_ibfk_2` FOREIGN KEY (`id_Department`) REFERENCES `departments` (`id_Department`),
  ADD CONSTRAINT `university_ibfk_1` FOREIGN KEY (`id_Lector`) REFERENCES `lectors` (`id_Lector`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
