package br.edu.ifro.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

//@author Gabriel Pedrosa
@Entity
public class Turma implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tur_id;
    private String tur_ano;
    private String tur_serie_ano;
    private String tur_turno;
    private String tur_tipo;
    private String tur_classe;
    private String tur_nome;
    @Column
    @ManyToMany
    private List<Funcionario> funcionario;

    @Override
    public String toString() {
        return tur_nome;
    }
    
    public int getTur_id() {
        return tur_id;
    }

    public void setTur_id(int tur_id) {
        this.tur_id = tur_id;
    }

    public String getTur_ano() {
        return tur_ano;
    }

    public void setTur_ano(String tur_ano) {
        this.tur_ano = tur_ano;
    }

    public String getTur_serie_ano() {
        return tur_serie_ano;
    }

    public void setTur_serie_ano(String tur_serie_ano) {
        this.tur_serie_ano = tur_serie_ano;
    }

    public String getTur_turno() {
        return tur_turno;
    }

    public void setTur_turno(String tur_turno) {
        this.tur_turno = tur_turno;
    }

    public String getTur_tipo() {
        return tur_tipo;
    }

    public void setTur_tipo(String tur_tipo) {
        this.tur_tipo = tur_tipo;
    }

    public List<Funcionario> getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(List<Funcionario> funcionario) {
        this.funcionario = funcionario;
    }

    public String getTur_classe() {
        return tur_classe;
    }

    public void setTur_classe(String tur_classe) {
        this.tur_classe = tur_classe;
    }

    public String getTur_nome() {
        return tur_nome;
    }

    public void setTur_nome(String tur_nome) {
        this.tur_nome = tur_nome;
    }
    
    
}
