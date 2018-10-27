package br.edu.ifro.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//@author Gabriel
@Entity
public class Aluno implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int alu_id;
    private String alu_datacadastro;
    private String alu_nome;
    private String alu_sexo;
    private String alu_cpf;
    private String alu_rg;
    private String alu_telefone;
    private String alu_nascimento; 
    private String alu_filiacao1;
    private String alu_filiacao2;
    private String alu_logradouro;
    private String alu_bairro;
    private String alu_numero;
    private String alu_cidade;
    private String alu_estado;
    private String alu_deficiencia;

    public int getAlu_id() {
        return alu_id;
    }

    public void setAlu_id(int alu_id) {
        this.alu_id = alu_id;
    }

    public String getAlu_datacadastro() {
        return alu_datacadastro;
    }

    public void setAlu_datacadastro(String alu_datacadastro) {
        this.alu_datacadastro = alu_datacadastro;
    }

    public String getAlu_nome() {
        return alu_nome;
    }

    public void setAlu_nome(String alu_nome) {
        this.alu_nome = alu_nome;
    }

    public String getAlu_sexo() {
        return alu_sexo;
    }

    public void setAlu_sexo(String alu_sexo) {
        this.alu_sexo = alu_sexo;
    }

    public String getAlu_cpf() {
        return alu_cpf;
    }

    public void setAlu_cpf(String alu_cpf) {
        this.alu_cpf = alu_cpf;
    }

    public String getAlu_rg() {
        return alu_rg;
    }

    public void setAlu_rg(String alu_rg) {
        this.alu_rg = alu_rg;
    }

    public String getAlu_telefone() {
        return alu_telefone;
    }

    public void setAlu_telefone(String alu_telefone) {
        this.alu_telefone = alu_telefone;
    }

    public String getAlu_nascimento() {
        return alu_nascimento;
    }

    public void setAlu_nascimento(String alu_nascimento) {
        this.alu_nascimento = alu_nascimento;
    }

    public String getAlu_filiacao1() {
        return alu_filiacao1;
    }

    public void setAlu_filiacao1(String alu_filiacao1) {
        this.alu_filiacao1 = alu_filiacao1;
    }

    public String getAlu_filiacao2() {
        return alu_filiacao2;
    }

    public void setAlu_filiacao2(String alu_filiacao2) {
        this.alu_filiacao2 = alu_filiacao2;
    }

    public String getAlu_logradouro() {
        return alu_logradouro;
    }

    public void setAlu_logradouro(String alu_logradouro) {
        this.alu_logradouro = alu_logradouro;
    }

    public String getAlu_bairro() {
        return alu_bairro;
    }

    public void setAlu_bairro(String alu_bairro) {
        this.alu_bairro = alu_bairro;
    }

    public String getAlu_numero() {
        return alu_numero;
    }

    public void setAlu_numero(String alu_numero) {
        this.alu_numero = alu_numero;
    }

    public String getAlu_cidade() {
        return alu_cidade;
    }

    public void setAlu_cidade(String alu_cidade) {
        this.alu_cidade = alu_cidade;
    }

    public String getAlu_estado() {
        return alu_estado;
    }

    public void setAlu_estado(String alu_estado) {
        this.alu_estado = alu_estado;
    }

    public String getAlu_deficiencia() {
        return alu_deficiencia;
    }

    public void setAlu_deficiencia(String alu_deficiencia) {
        this.alu_deficiencia = alu_deficiencia;
    }
    
    
}
