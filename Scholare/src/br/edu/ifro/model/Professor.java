package br.edu.ifro.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//@author Gabriel Pedrosa
@Entity
public class Professor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pro_id;
    private String pro_datacadastro;
    private String pro_nome;
    private String pro_sexo;
    private String pro_cpf;
    private String pro_rg;
    private String pro_telefone;
    private String pro_nascimento; 
    private String pro_filiacao1;
    private String pro_filiacao2;
    private String pro_logradouro;
    private String pro_bairro;
    private String pro_numero;
    private String pro_cidade;
    private String pro_estado;
}
