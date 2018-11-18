package br.edu.ifro.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

//@author Gabriel Pedrosa
@Entity
public class Matricula implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mat_id;
    private String mat_data;
    private String mat_triagem;
    private String mat_responsavel;
    private String mat_telefone_responsavel;
    private String mat_observacoes;
    @ManyToOne(cascade = CascadeType.ALL)
    private Aluno aluno;
    @ManyToOne(cascade = CascadeType.ALL)
    private Turma turma;
    @ManyToOne(cascade = CascadeType.ALL)
    private Funcionario funcionario;

    public int getMat_id() {
        return mat_id;
    }

    public void setMat_id(int mat_id) {
        this.mat_id = mat_id;
    }

    public String getMat_data() {
        return mat_data;
    }

    public void setMat_data(String mat_data) {
        this.mat_data = mat_data;
    }

    public String getMat_triagem() {
        return mat_triagem;
    }

    public void setMat_triagem(String mat_triagem) {
        this.mat_triagem = mat_triagem;
    }

    public String getMat_responsavel() {
        return mat_responsavel;
    }

    public void setMat_responsavel(String mat_responsavel) {
        this.mat_responsavel = mat_responsavel;
    }

    public String getMat_telefone_responsavel() {
        return mat_telefone_responsavel;
    }

    public void setMat_telefone_responsavel(String mat_telefone_responsavel) {
        this.mat_telefone_responsavel = mat_telefone_responsavel;
    }

    public String getMat_observacoes() {
        return mat_observacoes;
    }

    public void setMat_observacoes(String mat_observacoes) {
        this.mat_observacoes = mat_observacoes;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
}
