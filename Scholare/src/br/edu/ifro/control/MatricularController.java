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
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author Gabriel
 */
public class MatricularController implements Initializable {

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
    private Button bot_mat_matricular;
    @FXML
    private Button bot_mat_limpar;
    @FXML
    private Button bot_mat_cancelar;
    @FXML
    private TextField txt_mat_datacadastro;
    @FXML
    private RadioButton sim;
    @FXML
    private RadioButton nao;
    @FXML
    private TextField txt_mat_responsavel;
    @FXML
    private ComboBox<?> cbox_mat_aluno;
    @FXML
    private ComboBox<?> cbox_mat_turma;
    @FXML
    private TextField txt_mat_telefone;
    @FXML
    private TextArea txa_mat_observacoes;
    @FXML
    private ToggleGroup tg_mat_triagem;
    @FXML
    private TextField txt_mat_datacadastro1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void matricular_matricula(ActionEvent event) {
    }

    @FXML
    private void limpar_matricula(ActionEvent event) {
    }

    @FXML
    private void cancelar_matricula(ActionEvent event) {
    }

    @FXML
    private void sim(ActionEvent event) {
        cbox_mat_turma.setDisable(true);
    }

    @FXML
    private void nao(ActionEvent event) {
        cbox_mat_turma.setDisable(false);
    }
    
}
