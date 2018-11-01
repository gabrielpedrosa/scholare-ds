/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifro.control;

import br.edu.ifro.util.Open;
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

// @author Gabriel
public class MenuController implements Initializable {    
    @FXML
    private MenuItem cadastrar_aluno;
    @FXML
    private MenuItem cadastrar_professor;
    @FXML
    private MenuItem cadastrar_turma;
    @FXML
    private MenuItem exibir_alunos;
    @FXML
    private MenuItem exibir_professores;
    @FXML
    private MenuItem exibir_turna;
    @FXML
    private MenuItem ajuda_sobre;
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
    
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    

    @FXML
    private void matricula(ActionEvent event) {
        Scene novascene = Open.abrirMatricula(getClass()); 
        Stage stage = (Stage) bot_marticula.getScene().getWindow();
        stage.setScene(novascene);
    }

    @FXML
    private void cadastrar_aluno(ActionEvent event) throws InterruptedException {
        Scene novascene = Open.abrirAluno(getClass()); 
        Stage stage = (Stage) bot_marticula.getScene().getWindow();
        stage.setScene(novascene);
    }

    @FXML
    private void cadastrar_funcionario(ActionEvent event) {
        Scene novascene = Open.abrirFuncionario(getClass()); 
        Stage stage = (Stage) bot_marticula.getScene().getWindow();
        stage.setScene(novascene);
    }

    @FXML
    private void cadastrar_turma(ActionEvent event) {
        Scene novascene = Open.abrirTurma(getClass()); 
        Stage stage = (Stage) bot_marticula.getScene().getWindow();
        stage.setScene(novascene);
    }

    @FXML
    private void exibir_alunos(ActionEvent event) {
        Scene novascene = Open.abrirExibirAluno(getClass()); 
        Stage stage = (Stage) bot_marticula.getScene().getWindow();
        stage.setScene(novascene);
    }

    @FXML
    private void exibir_professores(ActionEvent event) {
        Scene novascene = Open.abrirExibirFuncionario(getClass()); 
        Stage stage = (Stage) bot_marticula.getScene().getWindow();
        stage.setScene(novascene);
    }

    @FXML
    private void exibir_turmas(ActionEvent event) {   
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
    }
}
