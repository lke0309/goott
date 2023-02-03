use gottclass6;

-- CREATE table rent(
-- NUM INT NOT NULL AUTO_INCREMENT,
-- RENT_REC DATETIME NOT NULL ,
-- USER_NUM INT(4) NOT NULL,
-- VIDEO_CODE CHAR(10) NOT NULL,
-- GENRE_CODE VARCHAR(13) NOT NULL,
-- RENTDATE DATE NOT NULL,
-- ISRETURN CHAR(1) NOT NULL default 'N',
-- ADD_LATE_FEE MEDIUMINT,
-- CHECK_LATE CHAR(1) default 'N',
-- RETURN_DATE DATE,

-- constraint rent_RENT_REC_NUM_PK primary key (NUM, RENT_REC),
-- constraint rent_USER_NUM_FK foreign key (USER_NUM) references member(USER_NUM),
-- constraint rent_VIDEO_CODE_FK foreign key (VIDEO_CODE) references video(VIDEO_CODE),
-- constraint rent_GENRE_CODE_FK foreign key (GENRE_CODE) references genre(GENRE_CODE)

-- )COMMENT = '대여기록 테이블';


CREATE TABLE `rent` (
  `NUM` int(11) NOT NULL AUTO_INCREMENT,
  `RENT_REC` datetime NOT NULL,
  `USER_NUM` int(4) NOT NULL,
  `VIDEO_CODE` char(10) NOT NULL,
  `GENRE_CODE` varchar(13) NOT NULL,
  `RENTDATE` date NOT NULL,
  `ISRETURN` char(1) NOT NULL DEFAULT 'N',
  `ADD_LATE_FEE` mediumint(9) DEFAULT NULL,
  `CHECK_LATE` char(1) DEFAULT 'N',
  `RETURN_DATE` date NOT NULL,
  PRIMARY KEY (`NUM`,`RENT_REC`),
  KEY `rent_USER_NUM_FK` (`USER_NUM`),
  KEY `rent_VIDEO_CODE_FK` (`VIDEO_CODE`),
  KEY `rent_GENRE_CODE_FK` (`GENRE_CODE`),
  CONSTRAINT `rent_GENRE_CODE_FK` FOREIGN KEY (`GENRE_CODE`) REFERENCES `genre` (`GENRE_CODE`),
  CONSTRAINT `rent_USER_NUM_FK` FOREIGN KEY (`USER_NUM`) REFERENCES `member` (`USER_NUM`),
  CONSTRAINT `rent_VIDEO_CODE_FK` FOREIGN KEY (`VIDEO_CODE`) REFERENCES `video` (`VIDEO_CODE`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='대여기록 테이블';





-- insert into rent; 

drop table rent;




