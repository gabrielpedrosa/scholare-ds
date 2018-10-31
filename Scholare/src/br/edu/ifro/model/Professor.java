package br.edu.ifro.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

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
    private String pro_email;
    private String pro_nascimento; 
    private String pro_disciplina;
    private String pro_logradouro;
    private String pro_bairro;
    private String pro_numero;
    private String pro_cidade;
    private String pro_estado;
    @OneToOne(cascade = CascadeType.ALL)
    private Login login;
    
    public String toString(){
        return this.pro_nome;
    }

    public int getPro_id() {
        return pro_id;
    }

    public void setPro_id(int pro_id) {
        this.pro_id = pro_id;
    }

    public String getPro_datacadastro() {
        return pro_datacadastro;
    }

    public void setPro_datacadastro(String pro_datacadastro) {
        this.pro_datacadastro = pro_datacadastro;
    }

    public String getPro_nome() {
        return pro_nome;
    }

    public void setPro_nome(String pro_nome) {
        this.pro_nome = pro_nome;
    }

    public String getPro_sexo() {
        return pro_sexo;
    }

    public void setPro_sexo(String pro_sexo) {
        this.pro_sexo = pro_sexo;
    }

    public String getPro_cpf() {
        return pro_cpf;
    }

    public void setPro_cpf(String pro_cpf) {
        this.pro_cpf = pro_cpf;
    }

    public String getPro_rg() {
        return pro_rg;
    }

    public void setPro_rg(String pro_rg) {
        this.pro_rg = pro_rg;
    }

    public String getPro_telefone() {
        return pro_telefone;
    }

    public void setPro_telefone(String pro_telefone) {
        this.pro_telefone = pro_telefone;
    }

    public String getPro_email() {
        return pro_email;
    }

    public void setPro_email(String pro_email) {
        this.pro_email = pro_email;
    }

    public String getPro_nascimento() {
        return pro_nascimento;
    }

    public void setPro_nascimento(String pro_nascimento) {
        this.pro_nascimento = pro_nascimento;
    }

    public String getPro_disciplina() {
        return pro_disciplina;
    }

    public void setPro_disciplina(String pro_disciplina) {
        this.pro_disciplina = pro_disciplina;
    }

    public String getPro_logradouro() {
        return pro_logradouro;
    }

    public void setPro_logradouro(String pro_logradouro) {
        this.pro_logradouro = pro_logradouro;
    }

    public String getPro_bairro() {
        return pro_bairro;
    }

    public void setPro_bairro(String pro_bairro) {
        this.pro_bairro = pro_bairro;
    }

    public String getPro_numero() {
        return pro_numero;
    }

    public void setPro_numero(String pro_numero) {
        this.pro_numero = pro_numero;
    }

    public String getPro_cidade() {
        return pro_cidade;
    }

    public void setPro_cidade(String pro_cidade) {
        this.pro_cidade = pro_cidade;
    }

    public String getPro_estado() {
        return pro_estado;
    }

    public void setPro_estado(String pro_estado) {
        this.pro_estado = pro_estado;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
    
    
}
