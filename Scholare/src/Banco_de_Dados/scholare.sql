drop database if exists scholare;
create database if not exists scholare;
use scholare;

select * from Funcionario;
select * from Funcionario_Disciplina;
select * from Turma_Funcionario;
select * from Aluno;
select * from Login;
select * from matricula;
select * from disciplina;
select * from notas;
select * from turma;

select tur_nome from Turma as t, Funcionario as f where f.fun_id = 2;

select Funcionario.fun_nome, Disciplina.dis_nome from Funcionario inner join Funcionario_Disciplina on Funcionario.fun_id = Funcionario_Disciplina.Funcionario_fun_id inner join Disciplina on Disciplina.dis_id = Funcionario_Disciplina.Disciplina_dis_id;