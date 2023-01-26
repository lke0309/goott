create table member(
id varchar2(20),
password varchar2(40),
regno varchar2(13)constraint member_regno_nn not null,
mobile varchar2(13),
address varchar2(100),
constraint member_id_pk primary key(id),
constraint member_reg_uq unique(regno),
constraint member_mobile_uq unique(mobile)
);



create table book(
code number(4),
title varchar2(50)constraint member_title_nn not null,
count number(6),
price number(10),
publish varchar2(50),
constraint books_code_pk primary key(code));


create table bookOrder(
no varchar2(10),
id varchar2(20),
code number(4),
count number(6),
orderDate date,
constraint bookOrder_no_pk primary key(no),
constraint bookOrder_id_fk foreign key(id) references member(id),
constraint bookOrder_code_fk foreign key(code) references book(code));



drop table member;
drop table book;
drop table bookOrder;