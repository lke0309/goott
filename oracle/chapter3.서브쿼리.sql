--서브쿼리

--100번 사원이 소속되어 있는 부서의 부서명을 알아보자
--1) 100번 사원이 소속되어 있는 부서의 부서번호를 알아내야 한다.
select department_id from employees
where employee_id =100;

--2) 1)번에서 알아낸 부서 번호(90번)의 부서이름을 알아낸다.
select department_name from departments
where department_id =90;

--1)번과 2)번 문장을 하나의 서브쿼리로 합치면  --앞에것: 메인쿼리, 뒤에것: 서브쿼리
select department_name from departments
where department_id =(select department_id from employees
where employee_id =100);

--사원들이 소속되어있는 부서의 부서명을 알아보자. 사번, 이름, 소속부서명을 출력해보자
select employee_id, first_name, department_name
from departments
where department_id =(select department_id from employees); --위 문장은 에러, 서브쿼리는 메인 쿼리문의 테이블에 있는 컬럼 정보 밖에 얻지 못한다. 
--위 문제를 해결하기 위해서는 join으로 해결해야한다.

--사원들이 소속되어있는 부서의 부서명을 알아보자. 사번, 이름, 소속부서명을 출력해보자
select employee_id, first_name, department_name
from employees, departments
where employees.employees_id = departments.department_id;


-- excutive 부서의 국가, 주, 시, 도로명 주소를 출력해보자.
select country_id, state_province, city, street_address
from locations
where location_id = (select location_id from departments where department_name = initcap('executive')); --단일행 서브쿼리

-----------------------------------------------------------------------------------------------------
--서브쿼리의 종류: 단일행 서브쿼리, 다중행 서브쿼리
--단일행 서브쿼리(single row subquery) : 내부 select 문장으로 부터 하나의 행만을 반환받으며, 
--연산자로 =, >, <, >=, <=, != 를 사용할 수 있다.

--문)'diana'와 같은 부서에 다니는 동료들의 모든정보는 출력하세요.
select *
from employees
where department_id = (select department_id from employees where first_name = initcap('diana'));

--문) 사원들의 평균 급여보다 더 많은 급여를 받는 사원의 사번, 이름, 급여를 출력하세요.
select employee_id, first_name, salary
from employees
where salary > (select avg(salary) from employees);

--2) 다중행 서브쿼리(multiple row subquery): 서브쿼리에서 반환되는 행의 갯수가 2개 이상일 때 사용하는 서브쿼리
--연산자로는 아래의 연산자를 사용한다.
--in: 메인 쿼리의 비교조건이 서브쿼리의 결과중에서 하나라도 일치하면 참 -- 거의 의미상 = 과 가까우면 in을 씀.
--any: 메인 쿼리의 비교조건이 서브쿼리의 결과와 하나이상이 일치하면 참
--all: 메인 쿼리의 비교조건이 서브쿼리의 결과와 모든값이 일치하면 

--in 연산자를 사용할 경우
--문) 급여를 7000이상 받는 사원이 소속된 부서와 동일한 부서에서 근무하는 사원들의 정보 출력
--1) 급여를 7000이상 받는 사원이 소속된 부서
select * from employees
where department_id in (select distinct department_id from employees
where salary >= 7000);

--all 연산자를 사용할 경우
--문) 30번부서에 소속된 사원중에서 급여를 가장많이 받는 사원보다 더 많이 받는 사원의 이름, 급여를 출력해보자
select first_name, salary 
from employees 
where salary > ALL(select salary from employees where department_id = 30); 
--데이터가 많을 때는 그룹함수를 안씀.

--any 연산자를 사용할 경우
--문) 30번부서에 소속된 사원중에서 급여를 가장 적게 받는 사원보다 더 많이 받는 사원의 이름, 급여를 출력해보자
select first_name, salary 
from employees 
where salary > any(select salary from employees where department_id = 30);


--서브쿼리를 이용하여 테이블 복사하기(데이터만 복사, pk같은 제약조건은 복사되지 않는다.)
create table copyEmp
as select * from employees;

create table copyEmp2
as select employee_id, first_name, salary from employees where department_id =30;

--테이블의 구조만 복사 된다. (where 조건절에 맞는 행이 하나도 없으므로, 데이터응 복사 안됨.)
create table copyEmp3
as select * from employees
where 1 = 0;

--테이블 삭제
drop table copyemp;
drop table copyemp2;
drop table copyemp3;
