create database Chat;
show databases;
use Chat;
drop table Users;
create table Users (id int auto_increment primary key, login varchar(255) unique, password varchar(255));
desc Users;
insert into Users values(0, 'usr@test', '12345');
select * from Users;