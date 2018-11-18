drop database if exists scholare;
create database if not exists scholare;
use scholare;

select * from Aluno;
select * from Funcionario;
select * from Funcionario_Disciplina;
select * from Turma;
select * from Turma_Funcionario;
select * from Login;
select * from matricula;
select * from disciplina;

insert into disciplina values(null, '1000','Portugues');
insert into disciplina values(null, '2000','Matemática');

select alu_nome from Aluno inner join Matricula on aluno.alu_id = matricula.aluno_alu_id inner join Turma on turma.tur_id = matricula.turma_tur_id

select Funcionario.fun_nome, Disciplina.dis_nome from Funcionario inner join Funcionario_Disciplina on Funcionario.fun_id = Funcionario_Disciplina.Funcionario_fun_id inner join Disciplina on Disciplina.dis_id = Funcionario_Disciplina.Disciplina_dis_id;