SELECT * FROM gottclass6.rent;
SELECT * FROM gottclass6.genre;
SELECT * FROM gottclass6.member;
SELECT * FROM gottclass6.Persons;
SELECT * FROM gottclass6.video;



insert into member values('7','이경은', '010-8454-5454','2010-11-14', 'female', '0', 'N', '서울시 구로구 구로동');




insert into gottclass6.rent(RENT_REC, USER_NUM, VIDEO_CODE, GENRE_CODE, RENTDATE, RETURN_DATE) values (now(), '4', 'AC00004433' , 'Action' , now(), date_add(now(), interval + 3 day));



truncate table rent; -- 데이터 행 지우기
commit;


