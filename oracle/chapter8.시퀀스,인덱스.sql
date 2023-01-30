create sequence seq_test
start with 1
increment by 1; --1부터 시작해서 1씩 증가하는 값


create table board(
no number(6)primary key,
title varchar2(100),
writer varchar2(20));

insert into board values( seq_test.nextval, 'test1', '둘리');
select * from board;

select seq_test.currval from dual;
select * from board;

create sequence seq_test2
start with 1
increment by 1
maxvalue 5
cycle;
cache 2;

create table product(
serialNo varchar(10) primary key,
prodName varchar2(14));

select to_char(sysdate, 'yymmdd') from dual;

insert into product values(to_char(sysdate, 'yymmdd') || '_' || seq_test2.nextval, '모니터');

select  seq_test2.currval from dual;

select * from product;

drop sequence seq_test2;
