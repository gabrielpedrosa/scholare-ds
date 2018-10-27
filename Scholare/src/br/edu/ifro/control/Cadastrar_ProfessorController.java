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
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author Gabriel
 */
public class Cadastrar_ProfessorController implements Initializable {

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
    private TextField txt_alu_nome;
    @FXML
    private TextField txt_alu_cpf;
    @FXML
    private RadioButton rad_alu_feminino;
    @FXML
    private ToggleGroup tg_alu_sexo;
    @FXML
    private TextField txt_alu_rg;
    @FXML
    private TextField txt_alu_telefone;
    @FXML
    private TextField txt_alu_datanascimento;
    @FXML
    private TextField txt_alu_filiacao1;
    @FXML
    private TextField txt_alu_filiacao2;
    @FXML
    private TextField txt_alu_logradouro;
    @FXML
    private TextField txt_alu_bairro;
    @FXML
    private TextField txt_alu_numero;
    @FXML
    private TextField txt_alu_deficiencia;
    @FXML
    private TextField txt_alu_datacadastro;
    @FXML
    private Button bot_alu_cadastrar;
    @FXML
    private Button bot_alu_limpar;
    @FXML
    private Button bot_alu_sair;
    @FXML
    private TextField txt_alu_cidade;
    @FXML
    private ComboBox<?> cbox_alu_estado;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void cadastrar_aluno(ActionEvent event) {
    }

    @FXML
    private void limpar_aluno(ActionEvent event) {
    }

    @FXML
    private void sair_aluno(ActionEvent event) {
    }
    
}