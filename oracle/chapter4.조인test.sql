
--3)Non_Equi Join: 조인할 테이블의 사이의 컬럼값이 직접적으로 일치 하지 않을 때 사용하는 조인.
-- '=' 연산자를 제외한 연산자를 사용한다.--사원의 호봉이 얼마인지 . 사번, 이름, 급여 , 호봉을 출력해보자
select e.empno, e.ename, e.sal, s.grade
from emp e, salgrade s
where e.sal >= s.losal and e.sal <= s.hisal;

-- between and 이용
select e.empno, e.ename, e.sal, s.grade
from emp e, salgrade s
where e.sal between s.losal and s.hisal;
---------------------------------------------------------------------------------------------------------------------


-- Chapter. 조인 연습문제

-- 1. 급여가 3000에서 5000사이인 직원의 이름과 소속 부서명을 출력
select e.ename, d.dname
from emp e inner join dept d
using (deptno)
where e.sal between 3000 and 5000;


-- 2. 직급이 manager인 사원의 이름, 부서명을 출력하세요
select e.ename, d.dname
from emp e inner join dept d
using (deptno)
where e.job = upper('manager');

-- 3. accounting 부서 소속 사원의 이름과 입사일 출력하세요
select e.ename, e.hiredate
from emp e inner join dept d
on  e.deptno = d.deptno
where d.dname= upper('accounting');


-- 4. 커미션을 받는 사원의 이름과 그가 속한 부서명을 출력
select e.ename, d.dname
from emp e inner join dept d
on  e.deptno = d.deptno
where e.comm is not null;


--- 5. 뉴욕에서 근무하는 사원의 이름과 급여를 출력
select e.ename, e.sal
from emp e inner join dept d
on  e.deptno = d.deptno
where d.loc = upper('new york');

--- 6. 급여가 1200 이하인 사원 이름과 급여와 그가 근무하는 근무지를 출력하세요
select e.ename, e.sal, d.loc
from emp e inner join dept d
on  e.deptno = d.deptno
where e.sal <= 1200;


-- 7. smith와 동일한 근무지에서 근무하는 사원의 이름을 출력하세요
select coworker.ename as 동료이름
from emp worker inner join emp coworker
on  worker.deptno = coworker.deptno
where worker.ename = upper('smith')
and coworker.ename <> upper('smith');

-- 8. 매니저가 king인 사원들의 이름과 직급을 출력하세요
select worker.ename, worker.job
from emp worker inner join emp manager
on worker.mgr =  manager.empno
where manager.ename = upper('king');



