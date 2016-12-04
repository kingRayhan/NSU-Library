-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Dec 04, 2016 at 06:07 AM
-- Server version: 10.1.16-MariaDB
-- PHP Version: 5.6.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `nsu_library`
--

-- --------------------------------------------------------

--
-- Table structure for table `admins`
--

CREATE TABLE `admins` (
  `id` int(11) NOT NULL,
  `username` varchar(200) NOT NULL,
  `password` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admins`
--

INSERT INTO `admins` (`id`, `username`, `password`) VALUES
(1, 'admin', '123'),
(2, 'rayhan', 'rayhan'),
(3, 'rayhan', 'rayhan');

-- --------------------------------------------------------

--
-- Table structure for table `books`
--

CREATE TABLE `books` (
  `id` int(11) NOT NULL,
  `name` varchar(200) NOT NULL,
  `Author` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `books`
--

INSERT INTO `books` (`id`, `name`, `Author`) VALUES
(1, 'Descreate mathmatics', 'author1'),
(2, 'EEE', 'author2'),
(3, 'Bangle PHP', 'King Rayhan'),
(4, 'Bangle JAVA', 'Sazid Khandaker'),
(5, 'The Moon', 'Kingstone'),
(6, 'The Night Ghost', 'MAIKAL'),
(7, 'Bangle C', 'Rayhan Master'),
(8, 'Smart Spoken ', 'Odhora Ahmed'),
(9, 'English Lerner ', 'Saifur Rahman'),
(10, 'Biology ', 'Yeashir Rahman'),
(11, 'Pre-Calculus Mathematics ', 'Salman Khan'),
(12, 'The Lion King', ' William Shakespeare''s Hamlet.'),
(13, 'The Toy Story ', 'Max MIllan'),
(14, 'Physic ', 'Jon bane '),
(15, 'Environment Science  ', 'Kaven Hoq'),
(16, 'The Programming Language ', 'Hardson David'),
(17, 'The Chemistry  ', 'Chi FU Than'),
(18, 'Rupkotha', 'Hemal Khan'),
(19, 'The Ghost Rider ', 'Robbie Reyes'),
(20, 'The Tin tin ', 'samuel Sam'),
(21, 'Kotha Koli', 'Humayan Ahmed'),
(22, 'The World Knowledge ', 'Jenny Loof'),
(23, 'The Bangle Bornomala', 'Hnaif Khan'),
(24, 'The Alpha-bate', 'Kavin Hooper '),
(25, 'The Scientist Day ', 'Alvan Rock'),
(26, 'Story oF Marsh ', 'Max Cooper'),
(27, 'Accounting ', 'Mahiya mahi'),
(28, 'Economic System', 'Topon Khan'),
(29, 'Tipu Sultan ', 'Soniya kahn'),
(30, 'The Earth ', 'Max Jax DON'),
(31, 'The Ecosystem ', 'Royal Rum'),
(32, 'The Harry Potter ', 'jk Rowling'),
(33, 'newBook', 'rayhan'),
(34, 'Linear math matics', 'Sazid');

-- --------------------------------------------------------

--
-- Table structure for table `students`
--

CREATE TABLE `students` (
  `id` int(11) NOT NULL,
  `username` varchar(200) NOT NULL,
  `password` varchar(200) NOT NULL,
  `student_id` int(12) NOT NULL,
  `email` varchar(200) NOT NULL,
  `department` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `students`
--

INSERT INTO `students` (`id`, `username`, `password`, `student_id`, `email`, `department`) VALUES
(4, 'rayhan', 'pass4', 152045874, 'email@email1', 'cse1'),
(5, 'Riyad', '12354', 152052745, 'sdkfjl', 'fds;fsd;l'),
(6, 'Nusayra', 'nunu', 1520647857, 'nusayrafn@gmail.com', 'CSE'),
(10, 'Sazid Khandaker', '54321', 123456789, 'sazid@gmail.com', 'ece');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admins`
--
ALTER TABLE `admins`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `books`
--
ALTER TABLE `books`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `students`
--
ALTER TABLE `students`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admins`
--
ALTER TABLE `admins`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `books`
--
ALTER TABLE `books`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;
--
-- AUTO_INCREMENT for table `students`
--
ALTER TABLE `students`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
