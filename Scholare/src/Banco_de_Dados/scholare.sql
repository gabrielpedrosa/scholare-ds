drop database if exists scholare;
create database if not exists scholare;
use scholare;

select * from Funcionario;
select * from Login;
select * from matricula;
select * from disciplina;

insert into disciplina (null, '1000','nome');