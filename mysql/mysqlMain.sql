use gottclass6;

CREATE table rent(
NUM INT NOT NULL AUTO_INCREMENT,
RENT_REC DATETIME NOT NULL ,
USER_NUM CHAR(6) NOT NULL,
VIDEO_CODE CHAR(10) NOT NULL,
GENRE_CODE VARCHAR(13) NOT NULL,
RENTDATE DATE NOT NULL,
ISRETURN CHAR(1) NOT NULL default 'N',
ADD_LATE_FEE MEDIUMINT,
CHECK_LATE CHAR(1) default 'N',
RETURN_DATE DATE,

constraint rent_RENT_REC_NUM_PK primary key (NUM, RENT_REC),
constraint rent_USER_NUM_FK foreign key (USER_NUM) references member(USER_NUM),
constraint rent_VIDEO_CODE_FK foreign key (VIDEO_CODE) references video(VIDEO_CODE),
constraint rent_GENRE_CODE_FK foreign key (GENRE_CODE) references genre(GENRE_CODE)

)COMMENT = '대여기록 테이블';




