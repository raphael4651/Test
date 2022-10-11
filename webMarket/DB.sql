CREATE TABLE `book_member` (
  `memberId` varchar(50) NOT NULL,
  `memberPw` varchar(100) NOT NULL,
  `memberName` varchar(30) NOT NULL,
  `memberMail` varchar(100) NOT NULL,
  `memberAddr1` varchar(100) NOT NULL,
  `memberAddr2` varchar(100) NOT NULL,
  `memberAddr3` varchar(100) NOT NULL,
  `adminCk` int NOT NULL,
  `regDate` date NOT NULL,
  `money` int NOT NULL,
  `point` int NOT NULL,
  PRIMARY KEY (`memberId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE DATABASE `webmarket` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
