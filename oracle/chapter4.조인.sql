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