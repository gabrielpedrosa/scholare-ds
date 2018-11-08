/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifro.control;

import br.edu.ifro.model.Aluno;
import br.edu.ifro.model.Funcionario;
import br.edu.ifro.model.Matricula;
import br.edu.ifro.model.Turma;
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
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
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
    private ComboBox<Aluno> cbox_mat_aluno;
    @FXML
    private ComboBox<Turma> cbox_mat_turma;
    @FXML
    private TextField txt_mat_telefone;
    @FXML
    private TextArea txa_mat_observacoes;
    @FXML
    private ToggleGroup tg_mat_triagem;
    @FXML
    private ComboBox<Funcionario> cbox_mat_funcionario;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        inicia();
    }
    
    public void inicia(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("scholare");
        EntityManager em = emf.createEntityManager();
        
        Query query = em.createQuery("select a from Aluno as a");
        List<Aluno> list_alunos = query.getResultList();
        
        ObservableList<Aluno> obaluno = FXCollections.observableArrayList(list_alunos);
        cbox_mat_aluno.setItems(obaluno);
        
        ObservableList ob_fun = FXCollections.observableArrayList("EU");
        cbox_mat_funcionario.setItems(ob_fun);
    }
    

    @FXML
    private void matricular_matricula(ActionEvent event) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("scholare");
        EntityManager em = emf.createEntityManager();
        
        Matricula m = new Matricula();
        m.setAluno(cbox_mat_aluno.getSelectionModel().getSelectedItem());
        m.setMat_data(txt_mat_datacadastro.getText());
        RadioButton radioselected = (RadioButton) tg_mat_triagem.getSelectedToggle();
        String rad_fun_triangem = radioselected.getText();
        m.setMat_triagem(rad_fun_triangem);
        m.setMat_telefone_responsavel(txt_mat_responsavel.getText());
        m.setFuncionario(null);
        m.setMat_observacoes(txa_mat_observacoes.getText());
        m.setMat_responsavel(txt_mat_responsavel.getText());
        if(radioselected.getText() == "Sim"){
            m.setTurma(null);
        }
        else{
            m.setTurma(cbox_mat_turma.getSelectionModel().getSelectedItem());
        }
        
        
        em.getTransaction().begin();
        em.persist(m);
        em.getTransaction().commit();
        em.close();
        emf.close();
        
        
    }

    @FXML
    private void limpar_matricula(ActionEvent event) {
    }

    @FXML
    private void cancelar_matricula(ActionEvent event) {
        Scene novascene = Open.abrirMenu(getClass()); 
        Stage stage = (Stage) bot_mat_cancelar.getScene().getWindow();
        stage.setScene(novascene);
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
