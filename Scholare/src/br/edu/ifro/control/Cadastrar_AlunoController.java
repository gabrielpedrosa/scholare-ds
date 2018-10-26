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
 * @author Gabriel Pedrosa
 */
public class Cadastrar_AlunoController implements Initializable {

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
    private TextField txt__alu_nome;
    @FXML
    private TextField txt__alu_cpf;
    @FXML
    private RadioButton rad_alu_feminino;
    @FXML
    private ToggleGroup tg_alu_sexo;
    @FXML
    private TextField txt__alu_rg;
    @FXML
    private TextField txt__alu_telefone;
    @FXML
    private TextField txt__alu_datanascimento;
    @FXML
    private TextField txt__alu_filiacao1;
    @FXML
    private TextField txt__alu_filiacao2;
    @FXML
    private TextField txt__alu_logradouro;
    @FXML
    private TextField txt__alu_bairro;
    @FXML
    private TextField txt__alu_numero;
    @FXML
    private TextField txt__alu_complemento;
    @FXML
    private TextField txt__alu_cidade;
    @FXML
    private ComboBox<?> cbox_alu_estado;
    @FXML
    private TextField txt__alu_datacadastro;
    @FXML
    private Button bot_alu_cadastrar;
    @FXML
    private Button bot_alu_limpar;
    @FXML
    private Button bot_alu_sair;
    
    public boolean verifica_vazio(){
        boolean preenchido;
        boolean txt_preenchido = false;
        boolean cbox_preenchido = false;
        TextField[] campo_txt = {txt__alu_nome, txt__alu_cpf, txt__alu_rg, txt__alu_telefone, txt__alu_datanascimento, txt__alu_logradouro, txt__alu_bairro, txt__alu_numero, txt__alu_cidade};
        ComboBox[] campo_cbox = {cbox_alu_estado};
        
        for (int i= 0; i< campo_txt.length; i++) {
            if (campo_txt[i].getText().equals("") || campo_txt[i].getText() == null) {
                txt_preenchido = false;
                break;
            } else {
                txt_preenchido = true;
            }
        }
        
        for (int i= 0; i< campo_cbox.length; i++) {
            if (campo_cbox[i].getValue().equals("") || campo_cbox[i].getValue() == null) {
                cbox_preenchido = false;
                break;
            } else {
                cbox_preenchido = true;
            }
        }
        
        preenchido = txt_preenchido == true && cbox_preenchido == true;
        
        return preenchido;
    }
    
    @FXML
    private void cadastrar_aluno(ActionEvent event) {
        if(verifica_vazio() == true){
            System.out.print("Campos obrigatórios preenchidos");
        }
        else{
            System.out.print("Campos obrigatórios não preenchidos");
        }
    }

    @FXML
    private void limpar_aluno(ActionEvent event) {
    }

    @FXML
    private void sair_aluno(ActionEvent event) {
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    
    
}
