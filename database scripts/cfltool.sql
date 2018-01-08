-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 08, 2018 at 06:58 AM
-- Server version: 5.7.14
-- PHP Version: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cfltool`
--
CREATE DATABASE IF NOT EXISTS `cfltool` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `cfltool`;

-- --------------------------------------------------------

--
-- Table structure for table `cft_setting`
--

CREATE TABLE `cft_setting` (
  `id` int(11) NOT NULL,
  `setting_key` varchar(50) NOT NULL,
  `setting_value` varchar(100) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `cloud_config`
--

CREATE TABLE `cloud_config` (
  `config_id` varchar(50) NOT NULL,
  `access_key` varchar(100) NOT NULL COMMENT 'aws access key',
  `secret_key` varchar(100) NOT NULL COMMENT 'secret key',
  `modifiedOn` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `role_id` int(11) NOT NULL,
  `role_name` varchar(40) NOT NULL COMMENT 'Role_Name',
  `isactive` int(11) NOT NULL COMMENT '1=active 0=inactive'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`role_id`, `role_name`, `isactive`) VALUES
(1, 'Admin', 1),
(2, 'Super-Admin', 1);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `usrid` int(11) NOT NULL,
  `emailid` varchar(50) NOT NULL,
  `firstName` varchar(50) NOT NULL,
  `lastName` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `createdOn` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Date of creation',
  `modifiedBy` varchar(50) NOT NULL,
  `modifiedOn` timestamp NULL DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`usrid`, `emailid`, `firstName`, `lastName`, `password`, `createdOn`, `modifiedBy`, `modifiedOn`) VALUES
(1, 'saurabhpawar1396@gmail.com', 'saurabh', 'pawar', 'admin', '2017-12-24 18:30:00', 'saurabh', '2017-12-24 18:30:00'),
(2, 'saurabhpawar11396@gmail.com', 'saurabh', 'pawar', 'admin', '2017-12-24 18:30:00', 'saurabh', '2017-12-24 18:30:00'),
(3, 'pavanpawar@gmail.com', 'saurabh', 'pawar', 'admin', '2017-12-24 18:30:00', 'saurabh', '2017-12-24 18:30:00'),
(4, 'pavanpawarqa@gmail.com', 'saurabh', 'pawar', 'admin', '2018-01-05 18:30:00', 'saurabh', '2018-01-05 18:30:00'),
(5, 'saurabhpawar1396@gmial.com', 'sdfs', 'fdfsd', 'admin@123', '2018-01-05 18:30:00', 'sourbh', '2018-01-05 18:30:00'),
(6, 'dfdf@gmail.com', 'vishal', 'asdka', 'admin@123', '2018-01-05 18:30:00', 'sourbh', '2018-01-05 18:30:00'),
(7, 'biahf@gmail.coms', 'pavanmds', 'dsldka', 'dsada', '2018-01-05 18:30:00', 'sourbh', '2018-01-05 18:30:00'),
(8, 'biahf@gfdmail.coms', 'pavanmdsdfds', 'dsldkafds', 'fdf', '2018-01-05 18:30:00', 'sourbh', '2018-01-05 18:30:00'),
(9, 'viad@fmai.com', 'vishall', 'vasoal', 'sd', '2018-01-05 18:30:00', 'sourbh', '2018-01-05 18:30:00');

-- --------------------------------------------------------

--
-- Table structure for table `user_roles`
--

CREATE TABLE `user_roles` (
  `usrid` int(11) NOT NULL,
  `role_id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cft_setting`
--
ALTER TABLE `cft_setting`
  ADD PRIMARY KEY (`id`,`setting_key`);

--
-- Indexes for table `cloud_config`
--
ALTER TABLE `cloud_config`
  ADD PRIMARY KEY (`config_id`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`role_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`usrid`),
  ADD UNIQUE KEY `emailid` (`emailid`);

--
-- Indexes for table `user_roles`
--
ALTER TABLE `user_roles`
  ADD PRIMARY KEY (`usrid`,`role_id`),
  ADD UNIQUE KEY `UQ_ReversePK` (`role_id`,`usrid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `role_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `usrid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
