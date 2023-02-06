SELECT * FROM gottclass6.rent; -- 대여
SELECT * FROM gottclass6.genre; -- 장르
SELECT * FROM gottclass6.member; -- 회원
SELECT * FROM gottclass6.video; -- 비디오

-- 회원 CRUD
-- 비디오 CRUD
-- 장르 CRUD
-- 대여기록 CRUD
insert into gottclass6.rent( USER_NUM, VIDEO_CODE, GENRE_CODE, RENTDATE, RETURN_DUE_DATE, RETURN_DATE) 
values ('8', 'AN20203335' , 'Animation' , now(), date_add(now(), interval + 3 day), date_add(now(), interval + 2 day)); -- 생성

select user_num, ISRETURN from rent; -- 조회

update rent set user_num = '9' where num = 20; -- 수정

DELETE FROM rent WHERE RENT_REC = '2023-02-06 17:54:31' ; -- 삭제

-- 블랙리스트 조회
-- 인기목록 조회
-- 매출확인
-- 연체관리
-- 블랙리스트
-- 회원 나이별 선호장르
-- 회원별 추천 장르
-- 신간(대여료 +1000), 연체료 +200, 대여일2, 시간기준 출시일로 부터 1달