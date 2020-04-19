CREATE DATABASE java20_blog charset utf8mb4;
USE java20_blog;

CREATE TABLE users (
  id INT PRIMARY KEY AUTO_INCREMENT,
  username VARCHAR(100) NOT NULL UNIQUE,
  password CHAR(64) NOT NULL,
  nickname CHAR(64) NOT NULL,
  brief VARCHAR(200) NOT NULL,
  registered_at DATETIME NOT NULL
);
CREATE TABLE `articles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cover_image` varchar(200) NOT NULL,
  `author_id` int(11) NOT NULL,
  `title` varchar(200) NOT NULL,
  `body` varchar(600) NOT NULL,
  `published_at` datetime NOT NULL,
  PRIMARY KEY (`id`)
);