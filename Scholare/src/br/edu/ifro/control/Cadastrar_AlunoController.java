/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifro.control;

import br.edu.ifro.util.Open;
import br.eti.diegofonseca.MaskFieldUtil;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

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
    private ComboBox cbox_alu_estado;
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
            if (campo_cbox[i].getSelectionModel().getSelectedIndex() == -1) {
                cbox_preenchido = false;
                break;
            } else {
                cbox_preenchido = true;
            }
        }
        
        preenchido = txt_preenchido == true && cbox_preenchido == true;
        
        return preenchido;
    }
    
    public void addmask(){
        MaskFieldUtil.cpfField(txt__alu_cpf);
        MaskFieldUtil.foneField(txt__alu_telefone);
        MaskFieldUtil.onlyDigitsValue(txt__alu_numero);
        MaskFieldUtil.dateField(txt__alu_datanascimento);
        MaskFieldUtil.numericField(txt__alu_rg);
    }
    
    @FXML
    private void cadastrar_aluno(ActionEvent event) {
        if(verifica_vazio() == true){
            System.out.println("Campos obrigatórios preenchidos");
        }
        else{
            System.out.println("Campos obrigatórios não preenchidos");
        }
        
    }

    @FXML
    private void limpar_aluno(ActionEvent event) {
        txt__alu_nome.setText("");
        txt__alu_cpf.setText("");
        txt__alu_rg.setText("");
        txt__alu_datanascimento.setText("");
        txt__alu_telefone.setText("");
        txt__alu_filiacao1.setText("");
        txt__alu_filiacao2.setText("");
        txt__alu_logradouro.setText("");
        txt__alu_bairro.setText("");
        txt__alu_numero.setText("");
        txt__alu_complemento.setText("");
        txt__alu_cidade.setText("");
        cbox_alu_estado.setValue("");
    }

    @FXML
    private void sair_aluno(ActionEvent event) {
        Open.abrirMenu(getClass());
        Stage stage = (Stage) bot_alu_sair.getScene().getWindow();
        stage.close();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       addmask();
       java.util.Date d = new java.util.Date();
       SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
       String datasrt = (String) f.format(d);
       txt__alu_datacadastro.setText(datasrt);
       ObservableList ob_estados = FXCollections.observableArrayList("ACRE", "RONDONIA", "MATO GROSSO", "MATO GROSSO DO SUL");
       cbox_alu_estado.setItems(ob_estados);
    }    

    
    
}
