--chapter. DDL문
--(1) create table로 테이블의 구조 정의
--create table 테이블명(
--컬럼명1 데이터 타입 표현식, 
--컬럼명2 데이터 타입 표현식,
--........
--컬럼명n 데이터 타입 표현식);

-- oracle 데이터 베이스의 데이터 타입
-- notion 정리 참조 <chapter.DDL문> 에 있음

--emp01 이라는 이름으로, 사번, 사원명, 급여와 입사일을 저장할 수 있는 테이블 생성
create table emp01(
empno number(4),
ename varchar2(10),
sal number(6),
hiredate date);

--member01이라는 이름으로 
--회원아이디(문자형12자리), 비밀번호(문자16자리), 이름(문자10), 전화번호, 생년월일, 성별(M,F)을 저장할 수 있는 테이블 생성
create table member01(
userid varchar2(12),
password varchar2(16),
name varchar2(10),
tel varchar2(13),
birthday date,
gender char(1));

--DML) insert into 문으로 데이터 저장해보자 (매우중요!)
--insert into 테이블명[(컬럼명,...)] valus(값1, 값2, ...);
insert into member01 values('dooly123', '1234', '둘리', '010-1234-1234', '1998-01-01', 'M');

insert into member01 values('douner', '2222', '도우너', '010-3333-4444', '1998-04-05', 'F');

insert into member01 values('douner456', '2222', '도우너', '010-3333-4444', '1998-04-05', 'F');
--insert into member01 values('douner456', '2222', '도우너', '010-3333-4444', '1998-04-05');--에러:값이 하나 덜들어감

select * from member01;--출력

--원하는 컬럼에만 데이터 넣기(테이블명 위에 데이터를 넣을 컬럼명을 기술한다.)
insert into member01(userid, password, name) values('abcd123', '1234', '아무개');--나머지는 null로 들어감.
select md5('1234') from dual;
select * from member01; --출력


---------------------------------------------------------------------------------------------


--(2) alter table 구문으로 테이블 구조 수정하기
--1) add column: 새로운 컬럼 추가
alter table emp01
add(job varchar2(10));

--member01 테이블에 hobby라는 컬럼을 문자열 50자 저장할 수 있도록 추가하세요.
alter table member01
add(hobby varchar2(50));



--2) modify column: 기존 컬럼 수정
--해당 컬럼에 데이터가 없는 경우: 데이터 타입, 사이즈 모두 변경 가능하다.

alter table emp01
modify(ename varchar2(6));

alter table emp01
modify(job char(14));

--해당 컬럼에 데이터가 있는 경우: 데이터 타입 변경불가, 사이즈는 업(줄이는건 불가능)만 가능.
alter table member01
modify(gender varchar2(1));


alter table member01
modify(birthday varchar2(15)); --에러 : 비어있어야 타입 변겨이 가능

alter table member01
modify(userid varchar2(6)); --에러 :  데이터가 6자이상이기 떄문에 줄일 수 없음.

alter table member01
modify(userid varchar2(26)); --늘리는건 가능

--3) drop column:기존의 컬럼 삭제
alter table member01
drop column birthday;

-------------------------------------------------------------------

--(3) drop table로 테이블 삭제하기
drop table emp01;
drop table member01;



--(4)truncate table 로 테이블의 데이터 삭제하기
truncate table member01;
select * from member01;
 
drop table member01;
select * from member01;
 
 
 
--(5) rename to로 테이블 이름 변경하기
rename member01 to member;
select * from member01;
 

 
