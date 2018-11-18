package br.edu.ifro.control;

import br.edu.ifro.util.Open;
import com.sun.media.jfxmediaimpl.platform.Platform;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

// @author Gabriel Pedrosa
public class MenuController implements Initializable {    
    @FXML
    private Button bot_marticula;
    @FXML
    private Button bot_notas;
    @FXML
    private Button bot_frequencia;
    @FXML
    private Button bot_sair;
    @FXML
    private Label lab_log_nome;
    private String nome;
    @FXML
    private MenuItem aluno;
    @FXML
    private MenuItem funcionario;
    @FXML
    private MenuItem turma;
    @FXML
    private MenuItem alunos;
    @FXML
    private MenuItem funcionarios;
    @FXML
    private MenuItem turmas;
    @FXML
    private MenuItem sobre;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println();
    }    

    @FXML
    private void matricula(ActionEvent event) {
        Scene novascene = Open.abrirMatricula(getClass()); 
        Stage stage = (Stage) bot_marticula.getScene().getWindow();
        stage.setScene(novascene);
    }
    
    @FXML
    private void notas(ActionEvent event) {   
    }

    @FXML
    private void frequencia(ActionEvent event) {
    }

    @FXML
    private void sair(ActionEvent event) {
        Stage stage = (Stage) bot_sair.getScene().getWindow();
        stage.close();
        System.exit(0);
    }
    
    //Funções Menu<--
    @FXML
    private void aluno(ActionEvent event){
        Scene novascene = Open.abrirAluno(getClass()); 
        Stage stage = (Stage) bot_marticula.getScene().getWindow();
        stage.setScene(novascene);
    }
    @FXML
    private void funcionario(ActionEvent event) {
        Scene novascene = Open.abrirFuncionario(getClass()); 
        Stage stage = (Stage) bot_marticula.getScene().getWindow();
        stage.setScene(novascene);
    }
    @FXML
    private void turma(ActionEvent event) {
        Scene novascene = Open.abrirTurma(getClass()); 
        Stage stage = (Stage) bot_marticula.getScene().getWindow();
        stage.setScene(novascene);
    }
    @FXML
    private void alunos(ActionEvent event) {
        Scene novascene = Open.abrirExibirAluno(getClass()); 
        Stage stage = (Stage) bot_marticula.getScene().getWindow();
        stage.setScene(novascene);
    }
    @FXML
    private void funcionarios(ActionEvent event) {
        Scene novascene = Open.abrirExibirFuncionario(getClass()); 
        Stage stage = (Stage) bot_marticula.getScene().getWindow();
        stage.setScene(novascene);
    }
    @FXML
    private void turmas(ActionEvent event) {
        
    }
    @FXML
    private void sobre(ActionEvent event) {
        
    }
    //Funções Menu-->
}