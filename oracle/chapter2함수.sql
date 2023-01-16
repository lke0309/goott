--dual 테이블
select 5 + 3 from dual;

--lower():소문자로 변환
select 'DataBase', lower('DataBase') from dual;

--이름이 lex인 사원의 모든 정보를 출력
select * from employees where lower(first_name) ='lex';

--upper():대문자로 변환
select 'DataBase', upper('DataBase') from dual;

--이름이 LEX인 사원의 모든 정보를 출력
select * from employees where upper(first_name) ='LEX';

--직급이 'it_prog'인 사원의 모든 정보를 출력
select * from employees where lower(job_id) ='it_prog';
select * from employees where job_id =upper('it_prog');

--첫글자만 대문자로 나머지는 소문자로 변환하는 initcap 함수
select 'database', initcap('database') from dual;

--이름이 LEX인 사원의 모든 정보를 출력
select * from employees where first_name =initcap('LEX');

--문자를 연결하는 concat함수
select concat('data','base')from dual;
--select concat('data','base','oracle')from dual;--3개 이상 불가능
select 'data' || 'base' || 'oracle' from dual; --더하기 연산자라고 생각하면 됨.

--모든 사원의 이름과 성을 합하여 이름, 성 으로 출력하시고, 컬럼명을 fullName으로 하세요.
select first_name || ',' || last_name as fullName from employees;

--문자의 길이를 구하는 length 함수
select length('database') from dual;
select length('데이터베이스') from dual;

--이름이 6글자 이하인 사원들의 이름을 소문자로 출력하는 쿼리문
select lower(first_name) from employees where length(first_name) <=6;

-- 문자열의 일부를 추출하는 substr 함수
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


-- 특정 문자의 위치를 구하는 instr()
-- instr(대상문자열, 찾을 문자열)
select instr('database', 'b') from dual; --5
select instr('database', 'a') from dual; --2
select instr('database', 'a', 3) from dual; --4 ('database'에서 'a'를 찾는데 3번째 위치부터 찾기 시작)

-- 이름의 3번째 자리가 i인 사원들의 모든 정보를 출력
select * from employees where instr(first_name, 'i') = 3; --instr
select * from employees where substr(first_name, 3,1) = 'i'; --substr
select * from employees where first_name like '__i%'; --like







