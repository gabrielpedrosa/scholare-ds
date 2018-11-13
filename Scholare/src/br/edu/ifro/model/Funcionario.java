package br.edu.ifro.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

//@author Gabriel Pedrosa
@Entity
public class Funcionario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int fun_id;
    private String fun_datacadastro;
    private String fun_nome;
    private String fun_sexo;
    private String fun_cpf;
    private String fun_rg;
    private String fun_telefone;
    private String fun_email;
    private String fun_nascimento; 
    private String fun_funcao;
    private String fun_logradouro;
    private String fun_bairro;
    private String fun_numero;
    private String fun_cidade;
    private String fun_estado;
    @OneToOne(cascade = CascadeType.ALL)
    private Login login;

    @Override
    public String toString(){
        return this.fun_nome;
    }

    public int getFun_id() {
        return fun_id;
    }

    public void setfun_id(int fun_id) {
        this.fun_id = fun_id;
    }

    public String getFun_datacadastro() {
        return fun_datacadastro;
    }

    public void setFun_datacadastro(String fun_datacadastro) {
        this.fun_datacadastro = fun_datacadastro;
    }

    public String getFun_nome() {
        return fun_nome;
    }

    public void setFun_nome(String fun_nome) {
        this.fun_nome = fun_nome;
    }

    public String getFun_sexo() {
        return fun_sexo;
    }

    public void setFun_sexo(String fun_sexo) {
        this.fun_sexo = fun_sexo;
    }

    public String getFun_cpf() {
        return fun_cpf;
    }

    public void setFun_cpf(String fun_cpf) {
        this.fun_cpf = fun_cpf;
    }

    public String getFun_rg() {
        return fun_rg;
    }

    public void setFun_rg(String fun_rg) {
        this.fun_rg = fun_rg;
    }

    public String getFun_telefone() {
        return fun_telefone;
    }

    public void setFun_telefone(String fun_telefone) {
        this.fun_telefone = fun_telefone;
    }

    public String getFun_email() {
        return fun_email;
    }

    public void setFun_email(String fun_email) {
        this.fun_email = fun_email;
    }

    public String getFun_nascimento() {
        return fun_nascimento;
    }

    public void setFun_nascimento(String fun_nascimento) {
        this.fun_nascimento = fun_nascimento;
    }

    public String getFun_funcao() {
        return fun_funcao;
    }

    public void setFun_funcao(String fun_funcao) {
        this.fun_funcao = fun_funcao;
    }

    public String getFun_logradouro() {
        return fun_logradouro;
    }

    public void setFun_logradouro(String fun_logradouro) {
        this.fun_logradouro = fun_logradouro;
    }

    public String getFun_bairro() {
        return fun_bairro;
    }

    public void setFun_bairro(String fun_bairro) {
        this.fun_bairro = fun_bairro;
    }

    public String getFun_numero() {
        return fun_numero;
    }

    public void setFun_numero(String fun_numero) {
        this.fun_numero = fun_numero;
    }

    public String getFun_cidade() {
        return fun_cidade;
    }

    public void setFun_cidade(String fun_cidade) {
        this.fun_cidade = fun_cidade;
    }
 
    public String getFun_estado() {
        return fun_estado;
    }

    public void setFun_estado(String fun_estado) {
        this.fun_estado = fun_estado;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
}
