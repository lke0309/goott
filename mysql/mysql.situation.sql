SELECT * FROM gottclass6.rent; -- 대여
SELECT * FROM gottclass6.genre; -- 장르
SELECT * FROM gottclass6.member; -- 회원
SELECT * FROM gottclass6.video; -- 비디오

-- 회원 CRUD
insert into gottclass6.member(USER_NAME, PHONE_NUM, BIRTHDAY, GENDER,  ADDR)
values('이상진상', '010-0707-0707', '1994-07-07', 'male',  '서울시 구로구 구로동'); -- 생성

select user_num, USER_NAME, BIRTHDAY, GENDER from member where user_name = '이상진상'; -- 조회

update member set GENDER = 'female' where user_num = 53 ; -- 수정

delete from member where user_name = '이상진상'; -- 삭제



-- 비디오 CRUD
insert into gottclass6.video( VIDEO_CODE, GENRE_CODE, VIDEO_TITLE, MOVIE_RATED, RELEASE_DATE, DIRECTOR )
values('AN19883333', 'Animation', '이웃집 토토로' , 7 , now(), '미야자키 하야오'); -- 생성

select * from video where VIDEO_TITLE = '이웃집 토토로'; -- 조회

update video set MOVIE_RATED = 15 where VIDEO_CODE = 'AN19883333'; -- 수정

delete from video where VIDEO_TITLE = '이웃집 토토로';



-- 장르 CRUD
insert into gottclass6.genre(GENRE_CODE, RENTAL_FEE, LATE_FEE, GENRE_NAME, LEND_TIME )
values('Gore', 2000, 200, '고어', 3); -- 생성

select * from genre where GENRE_CODE = 'Gore'; -- 조회

update genre set RENTAL_FEE = 2500 where GENRE_CODE = 'Gore'; -- 수정

delete from genre where GENRE_CODE = 'Gore';



-- 대여기록 CRUD
insert into gottclass6.rent( USER_NUM, VIDEO_CODE, GENRE_CODE, RENTDATE, ISRETURN, RETURN_DUE_DATE) 
values ('7', 'AN19883333' , 'Animation' , now(), 'N', date_add(now(), interval + 3 day)); -- 생성

select user_num, ISRETURN from rent where VIDEO_CODE= 'AN19883333'; -- 조회

update rent set user_num = 10 where num = 78; -- 수정

DELETE FROM rent WHERE NUM = 78 ; -- 삭제


-----------------------------------------------------------------------------------------------------------------------------------------


-- 인기목록 조회
-- select VIDEO_CODE, GENRE_CODE from rent where ;

-- 매출확인
-- rent 의 num
select count(num) from rent ;

-- 연체관리

-- 회원 나이별 선호장르
-- 회원별 추천 장르
-- 신간(대여료 +1000), 연체료 +200, 대여일2, 시간기준 출시일로 부터 1달