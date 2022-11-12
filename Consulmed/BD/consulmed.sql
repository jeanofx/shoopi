-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 15, 2022 at 12:45 AM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `consulmed`
--

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` bigint(20) NOT NULL,
  `name` varchar(50) CHARACTER SET utf8 NOT NULL,
  `last_name` varchar(50) CHARACTER SET utf8 NOT NULL,
  `email` varchar(255) CHARACTER SET utf8 NOT NULL,
  `pass` varchar(250) CHARACTER SET utf8 NOT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `usertype` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `name`, `last_name`, `email`, `pass`, `phone`, `usertype`) VALUES
(1, 'Jean', 'Forero', 'tausertholland@gmail.com', '123456', '3132555555', 'Doctor'),
(2, 'Andrea', 'Merchan', 'am@gmail.com', '654321', '3122555555', 'Manager'),
(4, 'Mati', 'Forero', 'mf@gmail.com', '$argon2id$v=19$m=1024,t=1,p=1$p/JkxW9Iu+sofLpcXIyTyw$9wd/OZcxTxatQX6g8fgV6pdKINRbS+Ed3sO2HxEOQsk', '3142555555', 'paciente'),
(6, 'Martin', 'Forero', 'mfa', '$argon2id$v=19$m=1024,t=1,p=1$rHderp5uPeqy8YbA98jq2A$vZCt+KvrLLpRkCu6HKLreGwcf/U4ZrLXs3V7nBA7l0o', '3112555555', 'paciente'),
(8, 'Jean Breiner', 'Forero', 'tasuertholland@gmail.com', '$argon2id$v=19$m=1024,t=1,p=1$Bq6YWHMjVCeCQvsE9cd5bA$5pQusKkGf56VhqhfAayaHfC+sBi//GaNvB0VseXMUn8', '312345678', 'Doctor'),
(9, 'Jean Breiner', 'Forero', 'tasuertholland@gmail.com', '$argon2id$v=19$m=1024,t=1,p=1$tP7gFIAK/Jca4oAN55YkMA$rzgf3NCHIPtRCKFSvrjGtPaJRo2eMdx5MVdo0phmiUE', '312345678', 'Doctor');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
