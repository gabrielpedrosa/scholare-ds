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
import javafx.scene.Group;
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
    private Group bot_ed_alu_editar;
    @FXML
    private Button bot_ed_alu_cancelar;
    @FXML
    private Button bot_ed_al_editar;
    @FXML
    private TextField txt_alu_nome;
    @FXML
    private ComboBox<?> cbox_alu_turma;

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
    }

    @FXML
    private void deletar_editar_Aluno(ActionEvent event) {
    }

    @FXML
    private void editar_editar_aluno(ActionEvent event) {
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
            Aluno a = (Aluno) query.getSingleResult();
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
            //cbox_alu_estado.setValue(a.getAlu_estado());
            txt_alu_deficiencia.setText(a.getAlu_deficiencia());
        }
    }

    @FXML
    private void selecionar_turma(ActionEvent event) {
    }
    
}
