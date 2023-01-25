--조인(join)
--두개 이상의 테이블에서 결과를 얻기 위한 sql문장.
-- 사번이 100인 사원의 정보( 사번, 이름, 부서번호)와 그가 소속한 부서의 부서명까지 출력해보자
--테이블 별칭을 from절에 사용하여, 해당하는 조인문장에서는 테이블 별칭을 이용하여 기술 할 수 있다.
select e.employee_id, e.first_name, e.department_id, d.department_name
from employees e, departments d --테이블에도 별칭 가능
where e.department_id = d.department_id --조인 조건
and e.employee_id = 100;
--의미없는 조인: 크로스조인
--데이터를 일부러 나눠놓는것, 데이터의 중복을 감소: "정규화"라고 함. --때에 따라서는 역정규화도 할 수 있다.(자주쓰는 것을 한번에 몰아 넣기도 함.=역정규화)
--의미있는 데이터이며, 더이상 쪼개지지 않아야한다.: 아토믹

--(!중요)조인 조건은 조인문에 사용되는 테이블의 총 갯수 -1개가 되어야 한다.
--ceo가 설날을 맞이하여 모든 직원들에게 선물을 택배로 보내려한다.
--모든 직원들이 택배를 무사히 받을 수 있도록 사무실의 주소, 사원 정보를 출력하세요. (주소, 부서, 이름)
select e.job_id, e.first_name || ','|| e.last_name,  
d.department_name, l.street_address,l.postal_code, l.city, l.state_province, c.country_name, r.region_name
from employees e, departments d, locations l, countries c, regions r
where e.department_id = d.department_id
and d.location_id = l.location_id
and l.country_id = c.country_id
and c.region_id = r.region_id;

--1) Cross join: 의미없는 조인(조건이 없기 떄문에), 단순하게 두개 이상의 테이블을 곱연산 결과를 냄, 조인 조건에 해당하는 wheere 절이 존재하지 않기 때문에 테이블간의 관계를 파악하여 조인하지 않음.
--(사용 안함)
select count(*) from employees, departments;--2889개의 행 = 107* 27
select count(*) from employees; --107
select count(*) from departments; --27


--조인문장이 지켜야할 것들
--1) primary key와  foreign key  컬럼을 통해 서로 다른 테이블을 연결한다.(mandatory(필수적인_멘다토리)--필수까진 아니지만 꼭 지켜야함.!!
--not null이며 , 유니크 해야함. 

--2) where절을 사용하여 조인조건을 기술한다(조인조건의 갯수 =연결하는 테이블 수 -1)
--3) 명확성을 위해 컬럼명 앞에 테이블 별칭을 기술한다.

--2) Equi Join(=equal join):가장많이 사용되는 조인. 조인 대상이 되는 테이블에서 공통적으로 존재하는 컬럼을 연결(=로 연결)하여 결과를 생성하는 조인.
--(반드시 그런것은 아님. 컬럼명은 다를 수 있다. 하지만 컬럼의 데이터 타입과 크기는 같아야 함.
select e.first_name, d.department_name
from employees e, departments d
where e.department_id = d.department_id;

--3)Non_Equi Join: 조인할 테이블의 사이의 컬럼값이 직접적으로 일치 하지 않을 때 사용하는 조인.
-- '=' 연산자를 제외한 연산자를 사용한다.

--사원의 호봉이 얼마인지 . 사번, 이름, 급여 , 호봉을 출력해보자(scoott 계정 이용)
select e.empno, e.ename, e.sal, s.grade
from emp e, salgrade s
where e.sal >= s.losal and e.sal <= s.hisal;

-- between and 이용(scoott 계정 이용)
select e.empno, e.ename, e.sal, s.grade
from emp e, salgrade s
where e.sal between s.losal and s.hisal;


--3) outer join: 행이 조인 조건에 만족하지 않을 경우 그 행은 조인 결과에 나타나지 않는다. 
--그러나 가끔 조인 조건에 만족하지 않는 행들도 나타나기 위해 outer join을 사용해야 할 때가 있다.
--기타 누군가를 찾기위해 쓰임.
select e.first_name, d.department_name
from employees e, departments d
where e.department_id = d.department_id;

--위의 결과에서 178번 사원이 부서번호가 null이라 누락 되어 있다.
-- outer join을 사용하여 누락된 정보까지 표현해보자.
-- 누락된 정보는 표현하라는 의미에서 !!반대쪽!! 컬럼명뒤에 (+) 기호를 붙여준다.
-- 아무 부서에도 배치되지 않은 178번 사원의 정보까지 출력 
select e.first_name, d.department_name
from employees e, departments d
where e.department_id = d.department_id(+); 


--아무사원도 배치하지 않은 부서까지 보고 싶을 때는
select e.first_name, d.department_name
from employees e, departments d
where e.department_id(+) = d.department_id; 

--양쪽 다 누락된걸 보고 싶을 때는 안씨 조인을 써야함.


--4) self Join: 하나의 테이블 내에서 조인을 하여 원하는 데이터를 얻는 조인
-- from 절에 동일한 테이블 이름을 주고 조인조건을 주어야하는데, 
--이때 서로 다른 테이블 인것처럼 하기위해 반드시!! 테이블 별칭을 준다.
select worker.first_name || '의 직속상사는 ' || manager.first_name || '입니다' as 직속상사
from employees worker, employees manager
where worker.manager_id =  manager.employee_id;

----------------------------------------------------------------------------------------
--ANSI Join: ANSI(미국표준 연구소)에서 재정한 다른 DBMS와의 호환성을 위해 만든 것
--1) ANSI Cross Join
select count(*)
from employees cross join departments;


--2) ANSI INNER JOIN : EQUI JOIN과 동일
--join 조건을 where절이 아니라 on절에 기술한다.
select e.first_name, d.department_name
from employees e inner join departments d
on e.department_id = d.department_id;

--아래와 같이 일반조건은 where 절에 기술한다.
select e.first_name, d.department_name
from employees e inner join departments d
on e.department_id = d.department_id
where first_name like '%n';

--using절을 이용하여 조인 조건 지정하기.
--조인이 되는 컬럼명이 동일해야하고, using 절에서는 테이블 별칭 사용 못함.
select e.first_name, d.department_name
from employees e inner join departments d
using (department_id);

--natural join
--조인이 되는 컬럼명은 반드시 동일 해야함.
--DBMS가 알아서 테이블을 살펴보고 동일한 컬럼으로 inner join진행.
--동일한 컬럼명이 있으면 알아서 조인됨, 
select e.first_name, d.department_name
from employees e natural join departments d;


--3) ANSI Outer Join: outer join
-- left outer join, right outer join, full outer join
select e.first_name, d.department_name
from employees e, departments d
where e.department_id = d.department_id(+); 

--부서에 배치되지 않은 정보 까지 출력 (employees 테이블은 from 절을 기준으로 왼쪽에 있으므로 lefr outer join)
select e.first_name, d.department_name
from employees e left outer join departments d
on e.department_id = d.department_id;

--사원이 배치되지 않은 부서정보까지 출력( 오른쪽에 있다.)
select e.first_name, d.department_name
from employees e right outer join departments d
on e.department_id = d.department_id;

--양쪽에 누락된 정보까지 모두 보고 싶다.
select e.first_name, d.department_name
from employees e full outer join departments d
on e.department_id = d.department_id;