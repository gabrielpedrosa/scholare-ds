/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifro.control;

import br.edu.ifro.model.Aluno;
import br.edu.ifro.model.Professor;
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
public class Cadastrar_TurmaController implements Initializable {

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
    private RadioButton rad_tur_a;
    @FXML
    private RadioButton rad_tur_b;
    @FXML
    private ComboBox cbox_tur_ano;
    @FXML
    private ComboBox cbox_tur_tipo;
    @FXML
    private ComboBox cbox_tur_professor;
    @FXML
    private Button bot_tur_inserir;
    @FXML
    private TableView tb_tur_professores;
    @FXML
    private ToggleGroup tg_tur_turno;
    @FXML
    private Button bot_tur_cadastrar;
    @FXML
    private Button bot_tur_limpar;
    @FXML
    private Button bot_tur_cancelar;
    @FXML
    private TextField txt_tur_serie_ano;
    
    public boolean verifica_vazio(){
        boolean preenchido;
        boolean txt_preenchido = false;
        boolean cbox_preenchido = false;
        TextField[] campo_txt = {txt_tur_serie_ano};
        ComboBox[] campo_cbox = {cbox_tur_ano, cbox_tur_tipo};
        
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        add_cbox_turma();
    }    
    
    public void add_cbox_turma(){
        ObservableList ob_anos = FXCollections.observableArrayList("2015", "2016", "2017", "2018");
        cbox_tur_ano.setItems(ob_anos);
        ObservableList ob_tipo = FXCollections.observableArrayList("Educação Infantil", "Ensino Fundamental I", "EJA", "HFB");
        cbox_tur_tipo.setItems(ob_tipo);
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("scholare");
        EntityManager em = emf.createEntityManager();
        
        Query query = em.createQuery("select p from Professor as p");
        List<Professor> list_professor = query.getResultList();
        
        ObservableList<Professor> ob_professor = FXCollections.observableArrayList(list_professor);
        cbox_tur_professor.setItems(ob_professor);
    }


    @FXML
    private void inserir_professor(ActionEvent event) {
        String cbox_professor = cbox_tur_professor.getSelectionModel().getSelectedItem().toString();
        ObservableList<Professor> ob_lastprofessor = FXCollections.observableArrayList(tb_tur_professores.getItems());
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("scholare");
        EntityManager em = emf.createEntityManager();
        
        Query query = em.createQuery("select p from Professor as p where p.pro_nome = :pro_nome");
        query.setParameter("pro_nome", cbox_professor);
        
        List<Professor> list_professor = query.getResultList();
        list_professor.addAll(ob_lastprofessor);
        
        ObservableList<Professor> ob_professor = FXCollections.observableArrayList(list_professor);

        tb_tur_professores.setItems(ob_professor);
        
        
    }

    @FXML
    private void cadastrar_turma(ActionEvent event) {
        if(verifica_vazio() == true){
            System.out.println("Campos obrigatórios preenchidos");
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("scholare");
            EntityManager em = emf.createEntityManager();
            
            Turma t = new Turma();
            t.setTur_ano(cbox_tur_ano.getSelectionModel().getSelectedItem().toString());
            t.setTur_serie_ano(txt_tur_serie_ano.getText());
            RadioButton radioselected = (RadioButton) tg_tur_turno.getSelectedToggle();
            String rad_tur_turno = radioselected.getText();
            t.setTur_turno(rad_tur_turno);
            t.setTur_tipo(cbox_tur_tipo.getSelectionModel().getSelectedItem().toString());
            
            limpar_turma(event);
            
            em.getTransaction().begin();
            em.persist(t);
            em.getTransaction().commit();
            em.close();
            emf.close();
            
        }
        else{
            System.out.println("Campos obrigatórios não preenchidos");
        }
    }

    @FXML
    private void limpar_turma(ActionEvent event) {
        txt_tur_serie_ano.setText("");
        cbox_tur_ano.setValue("");
        cbox_tur_tipo.setValue("");
        cbox_tur_professor.setValue("");
    }

    @FXML
    private void cancelar_turma(ActionEvent event) {
        Scene novascene = Open.abrirMenu(getClass()); 
        Stage stage = (Stage) bot_tur_cancelar.getScene().getWindow();
        stage.setScene(novascene);
    }
    
}
