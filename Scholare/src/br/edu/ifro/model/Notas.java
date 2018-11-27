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
    private String not_nota1;
    private String not_nota2;
    private String not_nota3;
    private String not_nota4;
    @OneToOne
    private Matricula matriculaaluno;
    @OneToOne
    private Disciplina disciplina;

    public int getNot_id() {
        return not_id;
    }

    public void setNot_id(int not_id) {
        this.not_id = not_id;
    }

    public String getNot_nota1() {
        return not_nota1;
    }

    public void setNot_nota1(String not_nota1) {
        this.not_nota1 = not_nota1;
    }

    public String getNot_nota2() {
        return not_nota2;
    }

    public void setNot_nota2(String not_nota2) {
        this.not_nota2 = not_nota2;
    }

    public String getNot_nota3() {
        return not_nota3;
    }

    public void setNot_nota3(String not_nota3) {
        this.not_nota3 = not_nota3;
    }

    public String getNot_nota4() {
        return not_nota4;
    }

    public void setNot_nota4(String not_nota4) {
        this.not_nota4 = not_nota4;
    }

    

    public Matricula getMatriculaaluno() {
        return matriculaaluno;
    }

    public void setMatriculaaluno(Matricula matriculaaluno) {
        this.matriculaaluno = matriculaaluno;
    }


    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }
    
    
    
}
