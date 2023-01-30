commit;

insert into member values('abcd');

select * from member;

savepoint after_insert;--세이브 포인트는 여러개 만들어도 됨.

update member  set userid = 'bbbb' where userid = 'abcd';

rollback to after_insert; --7번 시점으로 감.

rollback; --커밋한 시점으로 돌아감.

-------------------------------------------------------------------------

--다음의 쿼리문이 순서대로 실행되었다면, db에 영구 반영되는 문장은?
--1. insert문 수행  --o
--2. savepoint a;
--3. delete 문 수행
--4. savepoint b;
--5. update 문 수행
--6. rollback to a;
--7. insert문 수행 --o
--8. savepoint c;
--9. delete문 수행 --o
--10. commit;

--1,7,9 번이 영구 반영됨.