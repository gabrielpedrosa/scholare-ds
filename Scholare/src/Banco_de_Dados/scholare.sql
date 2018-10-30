drop database if exists scholare;
create database if not exists scholare;
use scholare;

select * from Professor;
select * from Login;

insert into Login values (null, '1234', 'Gabriel');