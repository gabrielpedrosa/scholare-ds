/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifro.control;

import br.edu.ifro.model.Aluno;
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
 * @author Gabriel Pedrosa
 */
public class Editar_AlunoController implements Initializable {

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
    private TextField txt_alu_cpf;
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
    private TextField txt_alu_cidade;
    @FXML
    private ComboBox cbox_alu_estado;
    @FXML
    private ComboBox cbox_alu_nome;
    @FXML
    private Button bot_ed_alu_salvar;
    @FXML
    private Button bot_ed_alu_deletar;
    @FXML
    private Button bot_ed_alu_editar;
    @FXML
    private Button bot_ed_alu_cancelar;
    @FXML
    private TextField txt_alu_nome;
    @FXML
    private ComboBox<?> cbox_alu_turma;
    @FXML
    private RadioButton rad_ed_alu_feminino;
    @FXML
    private RadioButton rad_ed_alu_masculino;
    
    public void deshabilita_campos(){
        txt_alu_nome.setDisable(true);
        rad_ed_alu_feminino.setDisable(true);
        rad_ed_alu_masculino.setDisable(true);
        txt_alu_cpf.setDisable(true);
        txt_alu_rg.setDisable(true);
        txt_alu_telefone.setDisable(true);
        txt_alu_datanascimento.setDisable(true);
        txt_alu_filiacao1.setDisable(true);
        txt_alu_filiacao2.setDisable(true);
        txt_alu_logradouro.setDisable(true);
        txt_alu_bairro.setDisable(true);
        txt_alu_numero.setDisable(true);
        txt_alu_cidade.setDisable(true);
        cbox_alu_estado.setDisable(true);
        txt_alu_deficiencia.setDisable(true);
        bot_ed_alu_salvar.setDisable(true);
    }
    
    public void habilita_campos(){
        txt_alu_nome.setDisable(false);
        rad_ed_alu_feminino.setDisable(false);
        rad_ed_alu_masculino.setDisable(false);
        txt_alu_cpf.setDisable(false);
        txt_alu_rg.setDisable(false);
        txt_alu_telefone.setDisable(false);
        txt_alu_datanascimento.setDisable(false);
        txt_alu_filiacao1.setDisable(false);
        txt_alu_filiacao2.setDisable(false);
        txt_alu_logradouro.setDisable(false);
        txt_alu_bairro.setDisable(false);
        txt_alu_numero.setDisable(false);
        txt_alu_cidade.setDisable(false);
        cbox_alu_estado.setDisable(false);
        txt_alu_deficiencia.setDisable(false);
        bot_ed_alu_salvar.setDisable(false);
    }

       public void limpar_aluno(ActionEvent event) {
        txt_alu_nome.setText("");
        rad_ed_alu_feminino.setSelected(true);
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
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("scholare");
        EntityManager em = emf.createEntityManager();
        
        Query query = em.createQuery("select a from Aluno as a");
        List<Aluno> list_alunos = query.getResultList();
        
        ObservableList<Aluno> obaluno = FXCollections.observableArrayList(list_alunos);
        cbox_alu_nome.setItems(obaluno);
    }

    @FXML
    private void salvar_editar_aluno(ActionEvent event) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("scholare");
        EntityManager em = emf.createEntityManager();
        
        Aluno alu = (Aluno) cbox_alu_nome.getSelectionModel().getSelectedItem();
        
        Query query =em.createQuery("select a from Aluno as a where a.alu_id = :alu_id");
        query.setParameter("alu_id", alu.getAlu_id());
        
        alu = (Aluno) query.getSingleResult();
        
        alu.setAlu_nome(txt_alu_nome.getText());
        RadioButton radioselected = (RadioButton) tg_alu_sexo.getSelectedToggle();
        String rad_alu_sexo = radioselected.getText();
        alu.setAlu_sexo(rad_alu_sexo);
        alu.setAlu_cpf(txt_alu_cpf.getText());
        alu.setAlu_rg(txt_alu_rg.getText());
        alu.setAlu_nascimento(txt_alu_datanascimento.getText());
        alu.setAlu_telefone(txt_alu_telefone.getText());
        alu.setAlu_filiacao1(txt_alu_filiacao1.getText());
        alu.setAlu_filiacao2(txt_alu_filiacao2.getText());
        alu.setAlu_logradouro(txt_alu_logradouro.getText());
        alu.setAlu_bairro(txt_alu_bairro.getText());
        alu.setAlu_numero(txt_alu_numero.getText());
        alu.setAlu_cidade(txt_alu_cidade.getText());
        alu.setAlu_estado(cbox_alu_estado.getSelectionModel().getSelectedItem().toString());
        alu.setAlu_deficiencia(txt_alu_deficiencia.getText());
        
        limpar_aluno(event);
        
        em.getTransaction().begin();
        em.persist(alu);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    @FXML
    private void deletar_editar_Aluno(ActionEvent event) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("scholare");
        EntityManager em = emf.createEntityManager();
        
        Aluno aluno = (Aluno) cbox_alu_nome.getSelectionModel().getSelectedItem();
        
        Query query =em.createQuery("select a from Aluno as a where a.alu_id = :alu_id");
        query.setParameter("alu_id", aluno.getAlu_id());
        
        Aluno a = (Aluno) query.getSingleResult();
        
        em.getTransaction().begin();
        em.remove(a);
        em.getTransaction().commit();
        
        em.close();
        
    }

    @FXML
    private void editar_editar_aluno(ActionEvent event) {
        if(cbox_alu_nome.getSelectionModel().getSelectedIndex()==-1){
            System.out.println("Selecione um Aluno");
        }
        else{
            habilita_campos();
        }
        
    }

    @FXML
    private void cancelar_editar_aluno(ActionEvent event) {
        Scene novascene = Open.abrirMenu(getClass()); 
        Stage stage = (Stage) bot_ed_alu_cancelar.getScene().getWindow();
        stage.setScene(novascene);
    }

    @FXML
    private void selecionar(ActionEvent event) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("scholare");
        EntityManager em = emf.createEntityManager();
        
        Query query =em.createQuery("select a from Aluno as a where a.alu_nome = :alu_nome");
        query.setParameter("alu_nome", cbox_alu_nome.getSelectionModel().getSelectedItem().toString());
        
        if(query.getResultList().isEmpty()){
            System.out.println("Erro");
        }
        else{
            deshabilita_campos();
            
            Aluno a = (Aluno) query.getSingleResult();
            txt_alu_nome.setText(a.getAlu_nome());
            if(a.getAlu_sexo().equals("Feminino")){
                rad_ed_alu_feminino.setSelected(true);
            }
            else{
                rad_ed_alu_masculino.setSelected(true);
            }
            txt_alu_cpf.setText(a.getAlu_cpf());
            txt_alu_rg.setText(a.getAlu_rg());
            txt_alu_telefone.setText(a.getAlu_telefone());
            txt_alu_datanascimento.setText(a.getAlu_nascimento());
            txt_alu_filiacao1.setText(a.getAlu_filiacao1());
            txt_alu_filiacao2.setText(a.getAlu_filiacao2());
            txt_alu_logradouro.setText(a.getAlu_logradouro());
            txt_alu_bairro.setText(a.getAlu_bairro());
            txt_alu_numero.setText(a.getAlu_numero());
            txt_alu_cidade.setText(a.getAlu_cidade());
            cbox_alu_estado.setValue(a.getAlu_estado());
            txt_alu_deficiencia.setText(a.getAlu_deficiencia());
            bot_ed_alu_deletar.setDisable(false);
        }
    }

    @FXML
    private void selecionar_turma(ActionEvent event) {
    }
    
}
