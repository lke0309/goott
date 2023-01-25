--제약조건을 컬럼 단위로 기술하는 방법
--(1)not null 제약조건

create  table emp01(
empno number(4),
ename varchar2(10));


--not null 제약조건을 위반하면 아래와 같은 메시지가 나온다.
--ORA-01400: cannot insert NULL into ("HR"."EMP01"."EMPNO")
insert into emp01 values(null, '둘리');
select * from emp01;

drop table emp01;


create  table emp01(
empno number(4) not null, --제약조건 넣음.
ename varchar2(10)not null);

-------------------------------------------------------------------------
--(2)unique 제약조건
create table emp01
(
empno number(4) not null,
ename varchar2(10) unique);

--unique 제약조건에 위배하면 아래와 같은 에러가 발생한다.
--ORA-00001: unique constraint(제약조건) (HR.SYS_C007020) violated(위배)
insert into emp01 values(1000, '둘리');
insert into emp01 values(1000, '둘셋');

--unique 제약조건을 건 ename 컬럼은 null을 허용할 수 있다.--null은 여러번 들어가도됨.
insert into emp01 values(1000, null);


drop table emp01;
-----------------------------------------------------------------------
--(3)primary key 제약조건: not null + unique

create table emp01
(
empno number(4) primary key,
ename varchar2(10) not null);

--ORA-01400: cannot insert NULL into ("HR"."EMP01"."EMPNO")
insert into emp01 values(null, '둘리'); --null을 저장 할 수 없다.
insert into emp01 values(1000, '둘리'); 
--ORA-00001: unique constraint (HR.SYS_C007024) violated
insert into emp01 values(1000, '둘셋'); --중복된 값을 허용하지 않는다.

insert into emp01 values(1001, '둘넷');
insert into emp01 values(1002, '둘넷');

select * from emp01;

alter table emp01
add(sal number(6));


--primary key: null이 아니고, unique한 값이기 때문에, 이 컬럼을 통해 검색, 수정, 삭제를 하는 것이 좋다.
--수정과 삭제 작업을 할 때는 where문의 조건식을 primary key컬럼을 통해 만드는 것이 좋고
--데이터 검색 작업을 할 때에도 primary key를 통해서 검색하는것이 indexing(정렬) 되어 있어 성능이 향상된다.

--1000번 사원의 급여를 5000으로 수정
update emp01 set sal =5000 where empno=1000;--where문을 쓰지 않으면 모든 사람의 sal이 5000 이 된다.


--사번이 1001인 사람 지우기
delete from emp01 where empno = 1001;

drop table emp01;
commit;--
rollback;--되돌아감
---------------------------------------------------------------------------------------------------------
--(4) foreign key 제약조건: 참조되는 테이블의 컬럼에 해당하는 값이 존재해야함.
--foreign key 제약조건을 위배하면..
--부서번호가 부서 테이블에 존재하지 않는 값을 넣으려 할 때
--ORA-02291: integrity constraint (HR.EMP_DEPT_FK) violated - parent key not found(부모키(부서테이블의 부서번호)가 없다.)
insert into employees values(207, '길동', '홍', 'KILDONG',null, sysdate, 'IT_PROG',5000, null, 115, 300);-- 있지도 않은 300번 부서에 넣음--에러
insert into employees values(207, '길동', '홍', 'KILDONG',null, sysdate, 'IT_PROG',5000, null, 115, 60);

--사원이 있는 부서를 삭제하려 할 때
--ORA-02292: integrity constraint (HR.EMP_DEPT_FK) violated - child record found(자식이 있어서 부모를 삭제 못함.)
--소속부서가 60번인 사원들이 존재 하기 떄문에 삭제 불가
delete from departments where department_id =40;

select * from employees where department_id = 40;

update employees set department_id = 250 where department_id = 40;
--부서번호가 40번인 사람들을 250번 부서로 옮긴다.

rollback;

--부모테이블인 dept01을 먼저 생성
create table dept01(
deptno number(2) primary key,
dname varchar2(10) not null);

--자식 테이블은 emp01 생성
create table emp01
(
empno number(4) primary key,
ename varchar2(10) not null,
deptno number(2) REFERENCES dept01(deptno)); --foreign key 부여

insert into dept01 values(10, '총무부');
insert into dept01 values(20, '개발부');

insert into emp01 values(1000, '둘리', 10);

select * from emp01;
select * from dept01;

delete from dept01 where deptno =10; --에러 (부서번호가 10번인 사원이 존재함)

update emp01 set deptno=20 where empno =1000; --10번 부서 사원을 20번으로 이동
delete from dept01 where deptno =10; --10번 부서 삭제 가능

drop table emp01;--자식 먼저 삭제
drop table dept01; --테이블을 삭제 할 때도 부모 테이블부터 삭제 불가 -- 자식 삭제후 부모 삭제


----------------------------------------------------------------------------------------------------
--check 제약 조건: 입력되는 값을 체크하여 설정된 값 이외의 값이 들어오면 안되도록
create table emp01(
empno number(4) primary key,
ename varchar2(10) not null,
gender char(1) check (gender in('M','F')));--성별 컬럼의 값은 'M' 또는 'F'


insert into emp01 values(1000, '홍길동' , 'm');
insert into emp01 values(1000, '홍길동' , 'M');
insert into emp01 values(1001, '홍길순' , 'F');
insert into emp01 values(1002, '홍길길' , 'Z');

drop table emp01;
create table member(
userid varchar2(10) primary key,
pass varchar2(20) not null,
age number(3) check (age between 20 and 150));--나이 컬럼의 값은 20~150살

insert into member values('abcd', '1234', 20);
insert into member values('ddd', '1234', 160);

drop table member;
------------------------------------------------------------
--default 제약조건 : 값이 주어지지 않으면 기본값으로 들어가도록 한다.

create table dept01(

deptno number(3) primary key,
dname varchar2(10),
loc varchar2(16) default '서울');


insert into dept01(deptno, dname) values(10, '개발부'); --loc값을 명시하지 않으면 default  값이 들어감

select * from dept01; 

insert into dept01 values(20, '총무부' , null); --컬럼에 null을 넣겠다고 명시하면 null이 들어간다(주의)

drop table dept01;
------------------------------------------------------------------------------------------
--제약조건 이름 기술하기: 제약조건 이름만 보더라도 어떤 테이블의 어떤 컬럼에 어떤 재약조건이 걸려있는지 쉽게 파악이 되도록 하자
--필수는 아니다.

--제약조건 이름의 예
--[테이블명]_[컬럼명]_[제약조건명]

--제약조건 이름을 명시하는 방법
--컬럼명 데이터 타입 constaint 제약조건이름 제약조건타입

create table dept01(
deptno number(2)  constraint dept01_deptno_pk primary key,
dname varchar2(10) constraint dept01_dname_nn not null,
loc varchar2(20) default 'seoul');

create table emp01(
empno number(4) constraint emp01_empno_pk primary key,
ename varchar2(10) constraint emp01_ename_nn not null,
email varchar2(20) constraint emp01_email_uq unique,
gender varchar2(5) constraint emp01_gender_ck check (gender in('male' , 'female')),
deptno number(2) constraint emp01_deptno_fk references dept01(deptno));


insert into dept01 values(10, '총무부' ,'부산');










