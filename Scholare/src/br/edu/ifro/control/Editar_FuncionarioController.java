/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifro.control;

import br.edu.ifro.model.Aluno;
import br.edu.ifro.model.Funcionario;
import br.edu.ifro.model.Login;
import br.edu.ifro.util.Open;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * FXML Controller class
 *
 * @author 80923755268
 */
public class Editar_FuncionarioController implements Initializable {

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
    private Label window_nome;
    @FXML
    private Button bot_fun_cancelar;
    @FXML
    private TextField txt_fun_cpf;
    @FXML
    private RadioButton rad_fun_feminino;
    @FXML
    private RadioButton rad_fun_masculino;
    @FXML
    private TextField txt_fun_rg;
    @FXML
    private TextField txt_fun_telefone;
    @FXML
    private TextField txt_fun_datanascimento;
    @FXML
    private TextField txt_fun_logradouro;
    @FXML
    private TextField txt_fun_bairro;
    @FXML
    private TextField txt_fun_numero;
    @FXML
    private TextField txt_fun_email;
    @FXML
    private TextField txt_fun_datacadastro;
    @FXML
    private TextField txt_fun_cidade;
    @FXML
    private ComboBox cbox_fun_estado;
    @FXML
    private ComboBox cbox_fun_nome;
    @FXML
    private TextField txt_fun_nome;
    @FXML
    private ComboBox cbox_fun_funcao;
    @FXML
    private TextField txt_fun_usuario;
    @FXML
    private PasswordField pw_fun_senha;
    @FXML
    private PasswordField pw_fun_confirmarsenha;
    @FXML
    private ToggleGroup tg_fun_sexo;
    @FXML
    private Button bot_fun_salvar;
    @FXML
    private Button bot_fun_deletar;
    @FXML
    private Button bot_fun_editar;
    
    public void deshabilita_campos(){
        txt_fun_nome.setDisable(true);
        rad_fun_feminino.setDisable(true);
        rad_fun_masculino.setDisable(true);
        txt_fun_cpf.setDisable(true);
        txt_fun_rg.setDisable(true);
        txt_fun_telefone.setDisable(true);
        txt_fun_datanascimento.setDisable(true);
        cbox_fun_funcao.setDisable(true);
        txt_fun_usuario.setDisable(true);
        pw_fun_senha.setDisable(true);
        pw_fun_confirmarsenha.setDisable(true);
        txt_fun_logradouro.setDisable(true);
        txt_fun_bairro.setDisable(true);
        txt_fun_numero.setDisable(true);
        txt_fun_cidade.setDisable(true);
        cbox_fun_estado.setDisable(true);
        txt_fun_email.setDisable(true);
        bot_fun_salvar.setDisable(true);
    }
    
    public void habilita_campos(){
        txt_fun_nome.setDisable(false);
        rad_fun_feminino.setDisable(false);
        rad_fun_masculino.setDisable(false);
        txt_fun_cpf.setDisable(false);
        txt_fun_rg.setDisable(false);
        txt_fun_telefone.setDisable(false);
        txt_fun_datanascimento.setDisable(false);
        cbox_fun_funcao.setDisable(false);
        txt_fun_usuario.setDisable(false);
        pw_fun_senha.setDisable(false);
        pw_fun_confirmarsenha.setDisable(false);
        txt_fun_logradouro.setDisable(false);
        txt_fun_bairro.setDisable(false);
        txt_fun_numero.setDisable(false);
        txt_fun_cidade.setDisable(false);
        cbox_fun_estado.setDisable(false);
        txt_fun_email.setDisable(false);
        bot_fun_deletar.setDisable(false);
        bot_fun_salvar.setDisable(false);
    }
    
    public void limpar_professor(ActionEvent event) {
        txt_fun_nome.setText("");
        txt_fun_cpf.setText("");
        txt_fun_rg.setText("");
        txt_fun_telefone.setText("");
        txt_fun_datanascimento.setText("");
        txt_fun_cidade.setText("");
        cbox_fun_estado.setValue(null);
        txt_fun_email.setText("");
        txt_fun_logradouro.setText("");
        txt_fun_bairro.setText("");
        txt_fun_numero.setText("");
        cbox_fun_funcao.setValue(null);
        txt_fun_usuario.setText("");
        pw_fun_senha.setText("");
        pw_fun_confirmarsenha.setText("");
    }
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("scholare");
        EntityManager em = emf.createEntityManager();
        
        Query query = em.createQuery("select f from Funcionario as f");
        List<Funcionario> list_funcionario = query.getResultList();
        
        ObservableList<Funcionario> obfuncionario = FXCollections.observableArrayList(list_funcionario);
        cbox_fun_nome.setItems(obfuncionario);
    }    

    @FXML
    private void salvar_editar_funcionario(ActionEvent event) {
    }

    @FXML
    private void deletar_editar_funcionario(ActionEvent event) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("scholare");
        EntityManager em = emf.createEntityManager();
        
        Funcionario funcionario = (Funcionario) cbox_fun_nome.getSelectionModel().getSelectedItem();
        
        Query query =em.createQuery("select a from Aluno as a where a.alu_id = :alu_id");
        query.setParameter("alu_id", funcionario.getFun_id());
        
        Funcionario f = (Funcionario) query.getSingleResult();
        
        em.getTransaction().begin();
        em.remove(f);
        em.getTransaction().commit();
        
        em.close();
    }

    @FXML
    private void editar_editar_funcionario(ActionEvent event) {
        habilita_campos();
    }

    @FXML
    private void cancelar_editar_funcionario(ActionEvent event) {
        Scene novascene = Open.abrirMenu(getClass()); 
        Stage stage = (Stage) bot_fun_cancelar.getScene().getWindow();
        stage.setScene(novascene);
    }

    @FXML
    private void selecionar(ActionEvent event) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("scholare");
        EntityManager em = emf.createEntityManager();
        
        Query query =em.createQuery("select f from Funcionario as f where f.fun_nome = :fun_nome");
        query.setParameter("fun_nome", cbox_fun_nome.getSelectionModel().getSelectedItem().toString());
        
        if(query.getResultList().isEmpty()){
            System.out.println("Erro");
        }
        else{
            deshabilita_campos();
            
            Funcionario f = (Funcionario) query.getSingleResult();
            
            //Query querylogin = em.createQuery("select l from Login as l where l.funcionario = :fun_id");
            //query.setParameter("fun_id", f.getFun_nome());
            
            //Login l = (Login) querylogin.getSingleResult();
            txt_fun_nome.setText(f.getFun_nome());
            if(f.getFun_sexo().equals("Feminino")){
                rad_fun_feminino.setSelected(true);
            }
            else{
                rad_fun_masculino.setSelected(true);
            }
            txt_fun_cpf.setText(f.getFun_nome());
            txt_fun_rg.setText(f.getFun_rg());
            txt_fun_telefone.setText(f.getFun_telefone());
            txt_fun_datanascimento.setText(f.getFun_nascimento());
            cbox_fun_funcao.setValue(f.getFun_funcao());
            //txt_fun_usuario.setText(l.getLog_usuario());
            //pw_fun_senha.setText(l.getLog_senha());
            //pw_fun_confirmarsenha.setText(l.getLog_senha());
            txt_fun_logradouro.setText(f.getFun_logradouro());
            txt_fun_bairro.setText(f.getFun_bairro());
            txt_fun_numero.setText(f.getFun_numero());
            txt_fun_cidade.setText(f.getFun_cidade());
            cbox_fun_estado.setValue(f.getFun_estado());
            txt_fun_email.setText(f.getFun_email());
        }
    }
    
}