/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifro.control;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author Gabriel Pedrosa
 */
public class FrequenciaController implements Initializable {

    @FXML
    private MenuItem aluno;
    @FXML
    private MenuItem funcionario;
    @FXML
    private MenuItem turma;
    @FXML
    private MenuItem listar_alunos;
    @FXML
    private MenuItem listar_funcionarios;
    @FXML
    private MenuItem listar_turmas;
    @FXML
    private MenuItem listar_matriculas;
    @FXML
    private MenuItem alunos;
    @FXML
    private MenuItem funcionarios;
    @FXML
    private MenuItem turmas;
    @FXML
    private MenuItem matriculas;
    @FXML
    private MenuItem relatorio_diario;
    @FXML
    private MenuItem ata_de_resultados;
    @FXML
    private MenuItem sobre;
    @FXML
    private Label window_nome;
    @FXML
    private Button bot_cancelar;
    @FXML
    private ComboBox<?> cbox_turma;
    @FXML
    private TableView<?> tb_alunos;
    @FXML
    private TableColumn<?, ?> nota1;
    @FXML
    private TableColumn<?, ?> nota2;
    @FXML
    private TableColumn<?, ?> nota3;
    @FXML
    private TableColumn<?, ?> nota4;
    @FXML
    private ComboBox<?> cbox_disciplina;
    @FXML
    private Button bot_salvar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    @FXML
    private void cancelar_notas(ActionEvent event) {
    }

    @FXML
    private void selecionar_turma(ActionEvent event) {
    }

    @FXML
    private void selecionar_disciplina(ActionEvent event) {
    }

    @FXML
    private void salvar_notas(ActionEvent event) {
    }

    @FXML
    private void aluno(ActionEvent event) {
    }

    @FXML
    private void funcionario(ActionEvent event) {
    }

    @FXML
    private void turma(ActionEvent event) {
    }

    @FXML
    private void listar_alunos(ActionEvent event) {
    }

    @FXML
    private void listar_funcionarios(ActionEvent event) {
    }

    @FXML
    private void listar_turmas(ActionEvent event) {
    }

    @FXML
    private void listar_matriculas(ActionEvent event) {
    }

    @FXML
    private void alunos(ActionEvent event) {
    }

    @FXML
    private void funcionarios(ActionEvent event) {
    }

    @FXML
    private void turmas(ActionEvent event) {
    }

    @FXML
    private void relatorio_diario(ActionEvent event) {
    }

    @FXML
    private void ata_de_resultados(ActionEvent event) {
    }

    @FXML
    private void sobre(ActionEvent event) {
    }

    
    
}
