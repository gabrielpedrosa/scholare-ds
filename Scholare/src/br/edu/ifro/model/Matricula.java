package br.edu.ifro.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Gabriel
 */
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
    //@OneToOne(cascade = CascadeType.ALL)
    private Aluno aluno;
    //@OneToMany(cascade = CascadeType.ALL)
    private Turma turma;
    
}
