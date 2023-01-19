-- SQL 함수 연습문제

-- 1. 사번이 짝수인 사원들의 사번, 이름, 직급 출력
select empno, ename, job from emp where mod(empno,2) = 0;

-- 2. 'Smith'란 이름을 가진 사원의 사번, 이름, 급여, 커미션을 출력하라
 -- 1) initcap 이용
select empno, ename, sal, comm from emp where initcap(ename) = 'Smith';

 -- 2) upper 이용
select empno, ename, sal, comm from emp where ename = upper('smith');

-- 3. 이름의 두번째 자리에 A 가 있는 사원의 사번,ㅡ 이름, 직급을 출력
-- 1) substr 이용
select empno,ename, job from emp where substr(ename, 2,1) ='A';

-- 2) instr 이용
select empno,ename, job from emp where instr(ename,'A') =2;


-- 3) like 이용
select empno,ename, job from emp where ename like '_A%';


-- 4. 이름이 K로 끝나는 사원의 사번, 이름, 직급 출력
select empno,ename, job from emp where substr(ename, -1,1) ='K';
select empno,ename, job from emp where ename like '%k';

-- 5. 82년도에 입사한 사원의 사번, 이름, 입사일 출력

select empno,ename, hiredate from emp where substr(hiredate,1,2) = '82';
select empno,ename, hiredate from emp where instr(hiredate, '82') ;


-- 6. 이름이 6글자 이상인 사원의 사번, 이름, 급여 출력
--select first_name, salary, to_char(salary, 'L999,999') from employees; --L999,999: L은 단위 붙여라 999,999은  세자리수 마다 , 를 찍어라.
select lower(ename) from emp where length(ename) >=6;

--7. 모든 사원은 자신의 상관이 있다. 하지만 emp 테이블에 유일하게 상관이 없는 로우가 있는데
-- 그 사원의 mgr 컬럼에는 null이 있다. 상관이 없는 사원만 출력하되 mgr 컬럼 값에 null대신 'CEO'를 출력하세요
--nvl
select empno, ename, nvl(to_char(mgr, '9999'),'CEO')
from emp
where mgr is null;

-- 8. 직급에 따라 급여를 인상하여 출력하도록 한다. 직급이 'analyst'인 사원은 5%, 'salesman'인 사원은 10%,
--  'manager'인 사원은 15%, 'clerk'인 사원은 20% 인상한다.
--case나 decode 이용하기
select empno, ename, job, decode(job, upper('analyst'), sal * 1.05,
                                    upper('salesman'),sal *1.1,
                                    upper('manager'),sal *1.15,
                                    upper('clerk'),sal *1.2) as upsal
                                    from emp;


-- 9. 직업의 종류가 몇개인지 즉, 중복되지 않은 직업의 수를 카운트 하세요
select  count(distinct job)  from emp;


-- 10. 부서별 사원의 수와 커미션을 받는 사원의 수를 카운트 하세요.
--count 함수는 null을 세지 않는다.
select deptno, count(*), count(comm) 
from emp
group by deptno;
