package br.edu.ifro.model;

//@author Gabriel

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Login implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int log_id;
    private String log_usuario;
    private String log_senha;
    private String log_pergunta;
    private String log_resposta;
    @OneToOne(cascade = CascadeType.ALL)
    private Funcionario funcionario;

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public int getLog_id() {
        return log_id;
    }

    public void setLog_id(int log_id) {
        this.log_id = log_id;
    }

    public String getLog_usuario() {
        return log_usuario;
    }

    public void setLog_usuario(String log_usuario) {
        this.log_usuario = log_usuario;
    }

    public String getLog_senha() {
        return log_senha;
    }

    public void setLog_senha(String log_senha) {
        this.log_senha = log_senha;
    }

    public String getLog_pergunta() {
        return log_pergunta;
    }

    public void setLog_pergunta(String log_pergunta) {
        this.log_pergunta = log_pergunta;
    }

    public String getLog_resposta() {
        return log_resposta;
    }

    public void setLog_resposta(String log_resposta) {
        this.log_resposta = log_resposta;
    }
    
    
}
