/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifro.control;

import br.edu.ifro.model.Login;
import br.edu.ifro.model.Professor;
import br.edu.ifro.util.Open;
import br.eti.diegofonseca.MaskFieldUtil;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
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
    private TextField txt_pro_nome;
    @FXML
    private TextField txt_pro_cpf;
    @FXML
    private RadioButton rad_pro_feminino;
    @FXML
    private RadioButton rad_pro_masculino;
    @FXML
    private ToggleGroup tg_pro_sexo;
    @FXML
    private TextField txt_pro_rg;
    @FXML
    private TextField txt_pro_telefone;
    @FXML
    private TextField txt_pro_email;
    @FXML
    private TextField txt_pro_datanascimento;
    @FXML
    private TextField txt_pro_logradouro;
    @FXML
    private TextField txt_pro_bairro;
    @FXML
    private TextField txt_pro_numero;
    @FXML
    private TextField txt_pro_datacadastro;
    @FXML
    private Button bot_pro_cadastrar;
    @FXML
    private Button bot_pro_limpar;
    @FXML
    private Button bot_pro_sair;
    @FXML
    private TextField txt_pro_cidade;
    @FXML
    private ComboBox cbox_pro_estado;
    @FXML
    private ComboBox cbox_pro_disciplina;
    @FXML
    private TextField txt_pro_usuario;
    @FXML
    private PasswordField pw_pro_senha;
    @FXML
    private PasswordField pw_pro_confirmarsenha;
    
    

    public boolean verifica_vazio(){
        boolean preenchido;
        boolean txt_preenchido = false;
        boolean cbox_preenchido = false;
        TextField[] campo_txt = {txt_pro_nome, txt_pro_cpf, txt_pro_rg, txt_pro_telefone, txt_pro_email, txt_pro_datanascimento, txt_pro_logradouro, txt_pro_bairro, txt_pro_numero, txt_pro_cidade, txt_pro_usuario, pw_pro_senha, pw_pro_confirmarsenha};
        ComboBox[] campo_cbox = {cbox_pro_estado, cbox_pro_disciplina};
        
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
    public boolean verifica_senha(){
        boolean igual = false;
        if(pw_pro_senha.getText().equals(pw_pro_confirmarsenha.getText())){
            igual = true;
        }
        else{
            igual = false;
        }
        
        return igual;
    }
    
    public void addmask(){
        MaskFieldUtil.cpfField(txt_pro_cpf);
        MaskFieldUtil.foneField(txt_pro_telefone);
        MaskFieldUtil.numericField(txt_pro_rg);
        MaskFieldUtil.numericField(txt_pro_numero);
        MaskFieldUtil.dateField(txt_pro_datanascimento);
    }
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        addmask();
        java.util.Date d = new java.util.Date();
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
        String datasrt = (String) f.format(d);
        txt_pro_datacadastro.setText(datasrt);
        ObservableList ob_estados = FXCollections.observableArrayList("ACRE", "RONDONIA", "MATO GROSSO", "MATO GROSSO DO SUL");
        cbox_pro_estado.setItems(ob_estados);
        ObservableList ob_disciplina = FXCollections.observableArrayList("Artes","Ciências", "Educação Física", "Ensino Religioso", "Geografia", "História", "Matematica", "Portugues");
        cbox_pro_disciplina.setItems(ob_disciplina);
    }    

    @FXML
    private void cadastrar_professor(ActionEvent event) {
        if(verifica_vazio() == true){
            System.out.println("Campos obrigatórios preenchidos");
            if(verifica_senha() == true){
                System.out.println("Senhas Conferem");
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("scholare");
                EntityManager em = emf.createEntityManager();

                Professor p = new Professor();
                p.setPro_nome(txt_pro_nome.getText());
                p.setPro_cpf(txt_pro_cpf.getText());
                p.setPro_rg(txt_pro_rg.getText());
                RadioButton radioselected = (RadioButton) tg_pro_sexo.getSelectedToggle();
                String rad_pro_sexo = radioselected.getText();
                p.setPro_sexo(rad_pro_sexo);
                p.setPro_nascimento(txt_pro_datanascimento.getText());
                p.setPro_telefone(txt_pro_telefone.getText());
                p.setPro_email(txt_pro_email.getText());
                p.setPro_disciplina(cbox_pro_disciplina.getSelectionModel().getSelectedItem().toString());
                p.setPro_logradouro(txt_pro_logradouro.getText());
                p.setPro_bairro(txt_pro_bairro.getText());
                p.setPro_numero(txt_pro_numero.getText());
                p.setPro_cidade(txt_pro_cidade.getText());
                p.setPro_estado(cbox_pro_estado.getSelectionModel().getSelectedItem().toString());
                p.setPro_datacadastro(txt_pro_datacadastro.getText());

                Login l = new Login();
                l.setLog_usuario(txt_pro_usuario.getText());
                l.setLog_senha(pw_pro_senha.getText());
                p.setLogin(l);

                limpar_professor(event);
                
                em.getTransaction().begin();
                em.persist(p);
                em.getTransaction().commit();
                em.close();
                emf.close();
            }
            else{
                System.out.println("Senhas não Conferem");
            }
            
        }
        else{
             System.out.println("Campos obrigatórios não preenchidos");
        }
        
    }

    @FXML
    private void limpar_professor(ActionEvent event) {
        txt_pro_nome.setText("");
        txt_pro_cpf.setText("");
        txt_pro_rg.setText("");
        txt_pro_telefone.setText("");
        txt_pro_datanascimento.setText("");
        txt_pro_cidade.setText("");
        cbox_pro_estado.setValue("");
        txt_pro_email.setText("");
        txt_pro_logradouro.setText("");
        txt_pro_bairro.setText("");
        txt_pro_numero.setText("");
        txt_pro_usuario.setText("");
        pw_pro_senha.setText("");
        pw_pro_confirmarsenha.setText("");
    }

    @FXML
    private void sair_professor(ActionEvent event) {
        Scene novascene = Open.abrirMenu(getClass()); 
        Stage stage = (Stage) bot_pro_sair.getScene().getWindow();
        stage.setScene(novascene);
    }
    
}
