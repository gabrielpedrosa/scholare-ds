package br.edu.ifro.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//@author Gabriel
@Entity
public class Turma implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tur_id;
    private String tur_ano;
    private String tur_serie_ano;
    private String tur_turno;
    private String tur_tipo;

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
    
    
    
    
}
