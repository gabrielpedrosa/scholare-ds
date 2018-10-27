/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifro.control;

import br.edu.ifro.model.Aluno;
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
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
    private TextField txt_alu_cidade;
    @FXML
    private ComboBox cbox_alu_estado;
    @FXML
    private TextField txt_alu_datacadastro;
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
        TextField[] campo_txt = {txt_alu_nome, txt_alu_cpf, txt_alu_rg, txt_alu_telefone, txt_alu_datanascimento, txt_alu_logradouro, txt_alu_bairro, txt_alu_numero, txt_alu_cidade, txt_alu_deficiencia};
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
        MaskFieldUtil.cpfField(txt_alu_cpf);
        MaskFieldUtil.foneField(txt_alu_telefone);
        MaskFieldUtil.numericField(txt_alu_rg);
        MaskFieldUtil.numericField(txt_alu_numero);
        MaskFieldUtil.dateField(txt_alu_datanascimento);
    }
    
    @FXML
    private void cadastrar_aluno(ActionEvent event) {
        if(verifica_vazio() == true){
            System.out.println("Campos obrigatórios preenchidos");
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("scholare");
            EntityManager em = emf.createEntityManager();
            
            Aluno a = new Aluno();
            a.setAlu_datacadastro(txt_alu_datacadastro.getText());
            a.setAlu_nome(txt_alu_nome.getText());
            RadioButton radioselected = (RadioButton) tg_alu_sexo.getSelectedToggle();
            String rad_alu_sexo = radioselected.getText();
            a.setAlu_sexo(rad_alu_sexo);
            a.setAlu_cpf(txt_alu_cpf.getText());
            a.setAlu_rg(txt_alu_rg.getText());
            a.setAlu_telefone(txt_alu_telefone.getText());
            a.setAlu_nascimento(txt_alu_datanascimento.getText());
            a.setAlu_filiacao1(txt_alu_filiacao1.getText());
            a.setAlu_filiacao2(txt_alu_filiacao2.getText());
            a.setAlu_logradouro(txt_alu_logradouro.getText());
            a.setAlu_bairro(txt_alu_bairro.getText());
            a.setAlu_numero(txt_alu_numero.getText());
            a.setAlu_cidade(txt_alu_cidade.getText());
            a.setAlu_estado(cbox_alu_estado.getSelectionModel().getSelectedItem().toString());
            a.setAlu_deficiencia(txt_alu_deficiencia.getText());
            
            limpar_aluno(event);
            
            em.getTransaction().begin();
            em.persist(a);
            em.getTransaction().commit();
            em.close();
        }
        else{
            System.out.println("Campos obrigatórios não preenchidos");
        }
        
    }

    @FXML
    private void limpar_aluno(ActionEvent event) {
        txt_alu_nome.setText("");
        txt_alu_cpf.setText("");
        txt_alu_rg.setText("");
        txt_alu_datanascimento.setText("");
        txt_alu_telefone.setText("");
        txt_alu_filiacao1.setText("");
        txt_alu_filiacao2.setText("");
        txt_alu_logradouro.setText("");
        txt_alu_bairro.setText("");
        txt_alu_numero.setText("");
        txt_alu_deficiencia.setText("");
        txt_alu_cidade.setText("");
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
       txt_alu_datacadastro.setText(datasrt);
       ObservableList ob_estados = FXCollections.observableArrayList("ACRE", "RONDONIA", "MATO GROSSO", "MATO GROSSO DO SUL");
       cbox_alu_estado.setItems(ob_estados);
    }    

    
    
}
