CREATE TABLE `trade_attach` (
  `uuid` varchar(100) NOT NULL,
  `uploadPath` varchar(200) NOT NULL,
  `fileName` varchar(100) NOT NULL,
  `filetype` char(1) DEFAULT 'I',
  `bno` int DEFAULT NULL,
  PRIMARY KEY (`uuid`),
  KEY `fk_board_attach_idx` (`bno`),
  CONSTRAINT `fk_board_attach` FOREIGN KEY (`bno`) REFERENCES `trade_board` (`tradeBno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `trade_board` (
  `tradeBno` int NOT NULL AUTO_INCREMENT,
  `tradeTitle` varchar(150) NOT NULL,
  `tradeContent` varchar(2000) NOT NULL,
  `tradeWriter` varchar(50) NOT NULL,
  `tradeRegdate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `tradeUpdatedate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `tradeReplyCnt` int DEFAULT '0',
  PRIMARY KEY (`tradeBno`)
) ENGINE=InnoDB AUTO_INCREMENT=291 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `trade_reply` (
  `rno` int NOT NULL AUTO_INCREMENT,
  `bno` int NOT NULL,
  `reply` varchar(1000) NOT NULL,
  `replyer` varchar(50) NOT NULL,
  `replyDate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updateDate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`rno`),
  KEY `fk_reply_board_idx` (`bno`),
  CONSTRAINT `fk_reply_board` FOREIGN KEY (`bno`) REFERENCES `trade_board` (`tradeBno`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci