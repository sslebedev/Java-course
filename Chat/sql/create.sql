create database Chat;
show databases;
use Chat;
create table Users (id int auto_increment primary key, login varchar(255), password varchar(255));
desc Users;
select * from Users;
insert into Users values(0, 'usr@test', '123');