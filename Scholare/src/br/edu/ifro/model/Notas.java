package br.edu.ifro.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author Gabriel Pedrosa
 */
@Entity
public class Notas implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int not_id;
    private int not_nota1;
    private int not_nota2;
    private int not_nota3;
    private int not_nota4;
    @OneToOne
    private Aluno aluno;
    @OneToOne
    private Disciplina disciplina;

    public int getNot_id() {
        return not_id;
    }

    public void setNot_id(int not_id) {
        this.not_id = not_id;
    }

    public int getNot_nota1() {
        return not_nota1;
    }

    public void setNot_nota1(int not_nota1) {
        this.not_nota1 = not_nota1;
    }

    public int getNot_nota2() {
        return not_nota2;
    }

    public void setNot_nota2(int not_nota2) {
        this.not_nota2 = not_nota2;
    }

    public int getNot_nota3() {
        return not_nota3;
    }

    public void setNot_nota3(int not_nota3) {
        this.not_nota3 = not_nota3;
    }

    public int getNot_nota4() {
        return not_nota4;
    }

    public void setNot_nota4(int not_nota4) {
        this.not_nota4 = not_nota4;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }
    
    
    
}
