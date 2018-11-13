drop database if exists scholare;
create database if not exists scholare;
use scholare;

select * from Funcionario_Disciplina;
select * from Login;
select * from matricula;
select * from disciplina;

insert into disciplina values(null, '1000','nome');
insert into disciplina values(null, '2000','nome2');

select Funcionario.fun_nome, Disciplina.dis_nome from Funcionario inner join Funcionario_Disciplina on Funcionario.fun_id = Funcionario_Disciplina.Funcionario_fun_id inner join Disciplina on Disciplina.dis_id = Funcionario_Disciplina.Disciplina_dis_id;