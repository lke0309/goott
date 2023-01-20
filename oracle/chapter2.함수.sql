--dual 테이블 : 가상의 테이블
select 5 + 3 from dual;

--1)  lower():소문자로 변환
select 'DataBase', lower('DataBase') from dual;

--이름이 lex인 사원의 모든 정보를 출력
select * from employees where lower(first_name) ='lex';

--2)   upper():대문자로 변환
select 'DataBase', upper('DataBase') from dual;

--이름이 LEX인 사원의 모든 정보를 출력
select * from employees where upper(first_name) ='LEX';

--직급이 'it_prog'인 사원의 모든 정보를 출력
select * from employees where lower(job_id) ='it_prog';
select * from employees where job_id =upper('it_prog');

--3)  첫글자만 대문자로 나머지는 소문자로 변환하는 initcap 함수
select 'database', initcap('database') from dual;

--이름이 LEX인 사원의 모든 정보를 출력
select * from employees where first_name =initcap('LEX');

--4)  문자를 연결하는 concat함수
select concat('data','base')from dual;
--select concat('data','base','oracle')from dual;--3개 이상 불가능
select 'data' || 'base' || 'oracle' from dual; --더하기 연산자라고 생각하면 됨.

--모든 사원의 이름과 성을 합하여 이름, 성 으로 출력하시고, 컬럼명을 fullName으로 하세요.
select first_name || ',' || last_name as fullName from employees;

--5)  문자의 길이를 구하는 length 함수
select length('database') from dual;
select length('데이터베이스') from dual;

--이름이 6글자 이하인 사원들의 이름을 소문자로 출력하는 쿼리문
select lower(first_name) from employees where length(first_name) <=6;

--6)  문자열의 일부를 추출하는 substr 함수
--substr(대상, 시작위치, 추출할 갯수)
select substr('database',1,3) from dual; --dat
select substr('database',-4,3) from dual; --bas -번째는 문자열의 끝부터

--입사연도가 2005년인 사원들의 모든 정보 출력
select *
from employees 
where substr(hire_date,1,2) = '05'; --날짜가 문자로 변환돼서 출력할 수 있는 것

--이름의 마지막 글자가 el 로 끝나는 사원들의 모든 정보 출력
select * from employees where substr(first_name,-2,2) ='el'; -- 끝에서 두번째부터 두글자 떼어냄.
select * from employees where first_name like '%el'; -- 끝에서 두번째부터 두글자 떼어냄.


--7)  특정 문자의 위치를 구하는 instr()
-- instr(대상문자열, 찾을 문자열)
select instr('database', 'b') from dual; --5
select instr('database', 'a') from dual; --2
select instr('database', 'a', 3) from dual; --4 ('database'에서 'a'를 찾는데 3번째 위치부터 찾기 시작)

-- 이름의 3번째 자리가 i인 사원들의 모든 정보를 출력
select * from employees where instr(first_name, 'i') = 3; --instr
select * from employees where substr(first_name, 3,1) = 'i'; --substr
select * from employees where first_name like '__i%'; --like

--8)  trim: 특정 문자를 잘라주는 함수
select trim('a'from'aaaaDataBaseaaaaaa') from dual; --앞뒤에 있는 a를 잘라줌. 가운데a는 못 자름.
select trim(' 'from '    DataBase    ') from dual; --앞뒤에 있는 공백을 잘라줌.

-------------------------------------------------------------------------------------------
--숫자 데이터 처리 함수
--1) 절대값을 구하는 abs()
select abs(-15) from dual;

--2) 소수점 아래를 버리는  floor()
select floor(3.141592)from dual;

--3)특정 자리수에서 반올림하는  round()
--round(대상, 표시할 자리수)
select round(3.141592, 2) from dual; --소수점 2자리 표현해라 
select round(3.141592, 4) from dual; --소수점 4자리 표현해라 --3.1416
select round(314.1592, -2) from dual; --표시할 자리수가 음수가 되면 소숫점의 정수부분으로 반올림됨.
select round(314.1592, -0) from dual; --소수점 아래자리 다 자름.

--4) 특정 자릿수에서 잘라내는 trunc()
select trunc(3.141592, 2)from dual;
select trunc(3.141592, 4)from dual; --3.1415 --표시할 자리수가 음수가 되면 소숫점의 정수부분으로 잘림

--5) 나머지 값을 반환하는 mod()
select mod(34,2) from dual; --34를 2로 나눈 나머지값이 나옴 =0

--사원들의 연봉을 구하려고 한다. 연봉 =(기본급 *12) + (기본급 * 12 * 커미션)을 구해 , 소수점 이하 2자리 까지만 출력되도록 하세요.
--연봉 컬럼명은 annual salary 라고 출력하세요.

select employee_id, first_name, round((salary * 12 * commission_pct),2) as "annual salary"
from employees;

---------------------------------------------------------------------------------------
--날짜 관련 함수: 데이터 타입이 DATE인  데이터를 대상으로 하는 함수
--날짜 타입도 연산이 가능하다.
---------------------------------------------------------------------------------------
--1) 현재날짜를 반환하는 sysdate
select sysdate from dual;
select sysdate +1 내일 from dual; --현재로 부터 +1 한 날짜 --date타입도 연산이 된다.

-- 사원들이 입사일로부터 현재까지 입사한지 며칠지났는지 구해보자.
select first_name, floor(sysdate - hire_date) || '일 지났다' as 근무일수 from employees;

--2) 두 날짜 사이 간격(개월 수)을 계산하는 months_between 함수
select first_name, hire_date, floor(months_between(sysdate, hire_date)) from employees;

--3) 개월 수를 더하는 add_months 함수
select first_name, hire_date, add_months(hire_date, 3) from employees;--입사일로 부터 3개월 지난 날짜

--4) 해당 요일에 가장 가까운 날짜를 반환하는 next_day 함수
select sysdate, next_day(sysdate, '금요일')from dual;

--5) 해당 달의 마지막 날짜를 반환하는 last_day 함수
select sysdate, last_day(sysdate) from dual;

--6) 특정 기준으로 반올림하는 round 함수
select sysdate, round(sysdate, 'month') from dual;

-- 7) 특정 기준으로 버리는 trunc 함수
select sysdate, trunc(sysdate, 'month') from dual; --월을 기준으로 버려라(일은 날라감)


-------------------------------------------------------------------------------------
--변환함수: 데이터 타입을 변화시키고자 할 때 사용
----------------------------------------------------------------------------------------
--1) to_char(): 문자형으로 변환
--to_char(날짜 데이터, '출력 형식'): 날짜를 문자열로 변환
select sysdate, to_char(sysdate, 'yyyy-mm-dd') from dual; -- 문자열로 변환됨 (팁! 문자는 왼쪽 정렬 숫자는 오른쪽 정렬)
select sysdate, to_char(sysdate, 'yyyy-mm-dd dy') from dual;--dy:요일
select sysdate, to_char(sysdate, 'yyyy-mm-dd am HH24:mi:ss') from dual; --am,pm: 오전인지 오후인지 알아서 찍어줌, HH24:24시간 단위

--아래 3가지는 잘 안씀
select to_char(123456, '999999') from dual; --9하나가 한자리를 의미함, 6자리를 주겠다는 뜻 --9는 자릿수를 나타내며 자리수가 맞지 않아도 채우지 않는다.
select to_char(123456, '0000000') from dual; --0하나가 한자리를 의미함, 7자리를 주겠다는 뜻 --0는 자릿수를 나타내며 자리수가 맞지 않아도 0으로 채운다.
select first_name, salary, to_char(salary, 'L999,999') from employees; --L999,999: L은 단위 붙여라 999,999은  세자리수 마다 , 를 찍어라.


--2) to_date(): 날짜형의로 변환
select first_name, hire_date from employees
where hire_date = '06/01/03'; --원래 검색

select first_name, hire_date from employees
where hire_date = to_date(20060103, 'yyyymmdd'); -- 굳이 넘버타입으로 검색


--3) to_number(): 숫자형으로 변환
select '10000' + '20000'from dual; --원래 계산


select '10,000' + '20,000'from dual;
select to_number('10,000','99,999') + to_number('20,000', '99,999')from dual;


----------------------------------------------------------------------------------------
--기타함수
--1) nvl():첫번째 인자로 받은 값이 null이면 두번째 인자 값으로 변경
--사원들의 연봉을 구하려고 한다. 연봉 =(기본급 *12) + (기본급 * 12 * 커미션)을 구해 , 소수점 이하 2자리 까지만 출력되도록 하세요.
--연봉 컬럼명은 annual salary 라고 출력하세요.
select employee_id, first_name, round((salary * 12 * commission_pct),2) as "annual salary"
from employees; --  commission_pct가 null인 사원들의 연봉이 계산이 안됨


select employee_id, first_name, to_char(round((salary * 12 ) + (salary * 12 * nvl(commission_pct,0)),2), 'L999,999') as "annual salary"
from employees;

--2) decode 함수:프로그래밍 언어의 switch ~ case문 같은 역할(잘안씀)
select first_name, department_id, decode(department_id, 90, 'Executive',
                                                        60, 'IT',
                                                        100, 'Finance'
) from employees;


--3) case 함수: if else if와 비슷한 역할
select first_name, department_id, case when department_id=90 then 'Executive'
                                       when department_id=60 then 'IT'
                                       when department_id=100 then 'Finance'
                                       end --끝난걸 알려줌
from employees;




------------------------------------------------------------------------------------------------
--그룹함수
--1) sum(): 합계 구하는 함수
select sum(salary) from employees;
select first_name, sum(salary) from employees; --(에러) sum은 단일행 함수이기 떄문에 사용할 수 없다.

--2) avg(): 평균 구하는 함수
select to_char(round(avg(salary),2),'L9,999.99') from employees;

--3) max(), min(): 최대값, 최소값 구하는 함수
select max(salary), min(salary) from employees;

--4) COUNT():행의 갯수를 세어주는 함수 --count 함수는 null을 세지 않는다.
select count (commission_pct)  as "커미션 받는 직원수" from employees;
select count (*) as 전체직원수 from employees;

--5) stddev(): 표준편차 함수
select stddev(salary) from employees;

--6) variance(): 분산
select variance(salary) from employees;

--group by 절: 그룹화를 시킬 때 사용하는 절
--group by 컬럼

-- 소속부서별 급여 총액과 급여 평균을 구해보자
select department_id, sum(salary), avg(salary) from employees
group by department_id;

--직무별 급여 총액과 급여 평균
select job_id, sum(salary) 합계, avg(salary) from employees
group by job_id
order by 합계 desc; 


--(!중요) group by절 , having 절
--having 절: 그룹화를 시킨 컬럼의 조건을 부여할 때 쓰는 절
--부서별 평균 급여가 5000이상인 부서번호와 부서별 평균 급여를 출력하세요.
select department_id, avg(salary) from employees
--where avg(salary )>= 5000 --에러: 그룹화를 시킨 컬럼은 where절로 조검 제한을 하지 못한다.
group by department_id
having avg(salary )>= 5000;

--직급별 급여 최대값과 급여 최소값을 구하되, 최대급여가 7000이상인 부서만 출력하세요.
select job_id, max(salary), min(salary) from employees
group by job_id
having max(salary) >= 7000;

