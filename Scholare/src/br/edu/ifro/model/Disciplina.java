package br.edu.ifro.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//@author Gabriel Pedrosa
@Entity
public class Disciplina implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int dis_id;
    private String dis_nome;
    private String dis_cargahoraria;
    
    @Override
    public String toString(){
        return this.dis_nome;
    }

    public int getDis_id() {
        return dis_id;
    }

    public void setDis_id(int dis_id) {
        this.dis_id = dis_id;
    }

    public String getDis_nome() {
        return dis_nome;
    }

    public void setDis_nome(String dis_nome) {
        this.dis_nome = dis_nome;
    }

    public String getDis_cargahoraria() {
        return dis_cargahoraria;
    }

    public void setDis_cargahoraria(String dis_cargahoraria) {
        this.dis_cargahoraria = dis_cargahoraria;
    }
}