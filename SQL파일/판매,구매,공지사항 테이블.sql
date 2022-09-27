-- 공지사항 테이블
CREATE TABLE `notice_board` (
  `noticeBno` int NOT NULL AUTO_INCREMENT,
  `noticeTitle` varchar(150) NOT NULL,
  `noticeContent` varchar(2000) NOT NULL,
  `noticeWriter` varchar(50) NOT NULL,
  `noticeRegdate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `noticeUpdatedate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`noticeBno`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

-- 판매 게시판 첨부 파일 테이블 
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

-- 구매 게시판 첨부 파일 테이블
CREATE TABLE `trade_attach2` (
  `uuid2` varchar(100) NOT NULL,
  `uploadPath2` varchar(200) NOT NULL,
  `fileName2` varchar(100) NOT NULL,
  `filetype2` char(1) DEFAULT 'I',
  `bno2` int DEFAULT NULL,
  PRIMARY KEY (`uuid2`),
  KEY `fk_board_attach_idx2` (`bno2`),
  CONSTRAINT `fk_board_attach2` FOREIGN KEY (`bno2`) REFERENCES `trade_board2` (`tradeBno2`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

-- 판매 게시판 테이블
CREATE TABLE `trade_board` (
  `tradeBno` int NOT NULL AUTO_INCREMENT,
  `tradeTitle` varchar(150) NOT NULL,
  `tradeContent` varchar(2000) NOT NULL,
  `tradeWriter` varchar(50) NOT NULL,
  `tradeRegdate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `tradeUpdatedate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `tradeReplyCnt` int DEFAULT '0',
  PRIMARY KEY (`tradeBno`)
) ENGINE=InnoDB AUTO_INCREMENT=292 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

-- 구매 게시판 테이블
CREATE TABLE `trade_board2` (
  `tradeBno2` int NOT NULL AUTO_INCREMENT,
  `tradeTitle2` varchar(150) NOT NULL,
  `tradeContent2` varchar(2000) NOT NULL,
  `tradeWriter2` varchar(50) NOT NULL,
  `tradeRegdate2` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `tradeUpdatedate2` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `tradeReplyCnt2` int DEFAULT '0',
  PRIMARY KEY (`tradeBno2`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

-- 판매 게시판 댓글 테이블
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
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

-- 구매 게시판 댓글 테이블
CREATE TABLE `trade_reply2` (
  `rno2` int NOT NULL AUTO_INCREMENT,
  `bno2` int NOT NULL,
  `reply2` varchar(1000) NOT NULL,
  `replyer2` varchar(50) NOT NULL,
  `replyDate2` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updateDate2` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`rno2`),
  KEY `fk_reply_board_idx2` (`bno2`),
  CONSTRAINT `fk_reply_board2` FOREIGN KEY (`bno2`) REFERENCES `trade_board2` (`tradeBno2`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci     