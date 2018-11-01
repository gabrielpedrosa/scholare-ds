/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifro.control;

import br.edu.ifro.model.Login;
import br.edu.ifro.model.Funcionario;
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
public class Cadastrar_FuncionarioController implements Initializable {

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
    private Button bot_pro_cadastrar;
    @FXML
    private Button bot_pro_limpar;
    @FXML
    private Button bot_pro_sair;
    @FXML
    private TextField txt_fun_datacadastro;
    @FXML
    private TextField txt_fun_nome;
    @FXML
    private RadioButton rad_fun_feminino;
    @FXML
    private ToggleGroup tg_fun_sexo;
    @FXML
    private RadioButton rad_fun_masculino;
    @FXML
    private TextField txt_fun_cpf;
    @FXML
    private TextField txt_fun_rg;
    @FXML
    private TextField txt_fun_telefone;
    @FXML
    private TextField txt_fun_datanascimento;
    @FXML
    private TextField txt_fun_cidade;
    @FXML
    private ComboBox cbox_fun_estado;
    @FXML
    private TextField txt_fun_email;
    @FXML
    private TextField txt_fun_logradouro;
    @FXML
    private TextField txt_fun_bairro;
    @FXML
    private TextField txt_fun_numero;
    @FXML
    private ComboBox cbox_fun_funcao;
    @FXML
    private TextField txt_fun_usuario;
    @FXML
    private PasswordField pw_fun_senha;
    @FXML
    private PasswordField pw_fun_confirmarsenha;
    
    

    public boolean verifica_vazio(){
        boolean preenchido;
        boolean txt_preenchido = false;
        boolean cbox_preenchido = false;
        TextField[] campo_txt = {txt_fun_nome, txt_fun_cpf, txt_fun_rg, txt_fun_telefone, txt_fun_email, txt_fun_datanascimento, txt_fun_logradouro, txt_fun_bairro, txt_fun_numero, txt_fun_cidade, txt_fun_usuario, pw_fun_senha, pw_fun_confirmarsenha};
        ComboBox[] campo_cbox = {cbox_fun_estado, cbox_fun_funcao};
        
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
        if(pw_fun_senha.getText().equals(pw_fun_confirmarsenha.getText())){
            igual = true;
        }
        else{
            igual = false;
        }
        
        return igual;
    }
    
    public void addmask(){
        MaskFieldUtil.cpfField(txt_fun_cpf);
        MaskFieldUtil.foneField(txt_fun_telefone);
        MaskFieldUtil.numericField(txt_fun_rg);
        MaskFieldUtil.numericField(txt_fun_numero);
        MaskFieldUtil.dateField(txt_fun_datanascimento);
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
        txt_fun_datacadastro.setText(datasrt);
        ObservableList ob_estados = FXCollections.observableArrayList("ACRE", "RONDONIA", "MATO GROSSO", "MATO GROSSO DO SUL");
        cbox_fun_estado.setItems(ob_estados);
        ObservableList ob_disciplina = FXCollections.observableArrayList("Secretária", "Professor");
        cbox_fun_funcao.setItems(ob_disciplina);
    }    

    @FXML
    private void cadastrar_professor(ActionEvent event) {
        if(verifica_vazio() == true){
            System.out.println("Campos obrigatórios preenchidos");
            if(verifica_senha() == true){
                System.out.println("Senhas Conferem");
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("scholare");
                EntityManager em = emf.createEntityManager();

                Funcionario p = new Funcionario();
                p.setFun_nome(txt_fun_nome.getText());
                p.setFun_cpf(txt_fun_cpf.getText());
                p.setFun_rg(txt_fun_rg.getText());
                RadioButton radioselected = (RadioButton) tg_fun_sexo.getSelectedToggle();
                String rad_pro_sexo = radioselected.getText();
                p.setFun_sexo(rad_pro_sexo);
                p.setFun_nascimento(txt_fun_datanascimento.getText());
                p.setFun_telefone(txt_fun_telefone.getText());
                p.setFun_email(txt_fun_email.getText());
                p.setFun_disciplina(cbox_fun_funcao.getSelectionModel().getSelectedItem().toString());
                p.setFun_logradouro(txt_fun_logradouro.getText());
                p.setFun_bairro(txt_fun_bairro.getText());
                p.setFun_numero(txt_fun_numero.getText());
                p.setFun_cidade(txt_fun_cidade.getText());
                p.setFun_estado(cbox_fun_estado.getSelectionModel().getSelectedItem().toString());
                p.setFun_datacadastro(txt_fun_datacadastro.getText());

                Login l = new Login();
                l.setLog_usuario(txt_fun_usuario.getText());
                l.setLog_senha(pw_fun_senha.getText());
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
        txt_fun_nome.setText("");
        txt_fun_cpf.setText("");
        txt_fun_rg.setText("");
        txt_fun_telefone.setText("");
        txt_fun_datanascimento.setText("");
        txt_fun_cidade.setText("");
        cbox_fun_estado.setValue("");
        txt_fun_email.setText("");
        txt_fun_logradouro.setText("");
        txt_fun_bairro.setText("");
        txt_fun_numero.setText("");
        cbox_fun_funcao.setValue("");
        txt_fun_usuario.setText("");
        pw_fun_senha.setText("");
        pw_fun_confirmarsenha.setText("");
    }

    @FXML
    private void sair_professor(ActionEvent event) {
        Scene novascene = Open.abrirMenu(getClass()); 
        Stage stage = (Stage) bot_pro_sair.getScene().getWindow();
        stage.setScene(novascene);
    }
    
}
