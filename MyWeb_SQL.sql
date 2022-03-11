show databases; -- database 목록 조회
create database my_web; -- database 생성
drop database my_web; -- database 삭제

use my_web; -- my_web database 선택

use mysql; -- mysql database 선택
select user from user; -- mysql db의 user 테이블에서 user 목록 조회

create user 'my_web_admin'@'localhost' identified by '1234'; -- user 생성
grant all privileges on my_web.* to my_web_admin@'localhost'; -- my_web_admin에게 my_web db의 모든 테이블 권한 부여

-- grant all privileges on my_web.* to my_web_admin@'localhost' identified by '1234';

create table user_info (
	-- primary key : 중복 불가, null을 가질 수 없음 
    -- auto_increment : insert 문을 통해 컬럼이 추가되면 자동으로 1씩 증가하여 컬럼을 저장
	-- uno int unsigned primary key auto_increment,
    
    -- 가변형 문자열 자료형 varchar
    user_name varchar(100) not null,
    
    user_id varchar(200) primary key,
    -- Binary Large OBject의 약자로 이진 데이터를 저장하기 위한 필드 자료형이다.
    user_pw blob not null
) engine=InnoDB auto_increment=1 default charset=utf8;

alter table user_info change column uid uno int unsigned primary key auto_increment;
alter table user_info modify column uid int unsigned primary key auto_increment;
alter table user_info modify column user_pw blob not null;
alter table user_info add column user_key blob not null;

drop table user_info;

insert into user_info(user_name, user_id, user_pw)
values("adminstrator", "admin", aes_encrypt("1234", sha2(concat("admin", "1234"), 256)));

select * from user_info;
select * from user_info where user_id = "admin";

delete from user_info;

select convert(aes_decrypt(user_pw, sha2(concat("admin", "1234"), 256)) using utf8), sha2(user_pw, 256) from user_info;

select concat(user_id, user_pw)
from user_info;