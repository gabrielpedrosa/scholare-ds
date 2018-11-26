package br.edu.ifro.control;

import br.edu.ifro.model.Matricula;
import br.edu.ifro.util.Open;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
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
 * @author 80923755268
 */
public class Editar_MatriculaController implements Initializable {

    @FXML
    private MenuItem aluno;
    @FXML
    private MenuItem funcionario;
    @FXML
    private MenuItem turma;
    @FXML
    private MenuItem alunos;
    @FXML
    private MenuItem funcionarios;
    @FXML
    private MenuItem turmas;
    @FXML
    private MenuItem sobre;
    @FXML
    private TextField txt_mat_responsavel;
    @FXML
    private Button bot_mat_cancelar;
    @FXML
    private ComboBox<?> cbox_mat_aluno;
    @FXML
    private ComboBox<?> cbox_mat_turma;
    @FXML
    private TextField txt_mat_datacadastro;
    @FXML
    private TextField txt_mat_telefone;
    @FXML
    private TextArea txa_mat_observacoes;
    @FXML
    private RadioButton sim;
    @FXML
    private ToggleGroup tg_mat_triagem;
    @FXML
    private RadioButton nao;
    @FXML
    private ComboBox<?> cbox_mat_funcionario;
    @FXML
    private ComboBox<?> cbox_mat_matricula;
    @FXML
    private Button bot_mat_salvar;
    @FXML
    private Button bot_mat_editar;
    @FXML
    private Button bot_mat_deletar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void aluno(ActionEvent event) {
    }

    @FXML
    private void funcionario(ActionEvent event) {
    }

    @FXML
    private void turma(ActionEvent event) {
    }

    @FXML
    private void alunos(ActionEvent event) {
    }

    @FXML
    private void funcionarios(ActionEvent event) {
    }

    @FXML
    private void turmas(ActionEvent event) {
    }

    @FXML
    private void sobre(ActionEvent event) {
    }


    @FXML
    private void sim(ActionEvent event) {
    }

    @FXML
    private void nao(ActionEvent event) {
    }

    @FXML
    private void salvar_editar(ActionEvent event) {
    }

    @FXML
    private void editar_editar(ActionEvent event) {
    }

    @FXML
    private void cancelar_editar(ActionEvent event) {
        Scene novascene = Open.abrirMenu(getClass()); 
        Stage stage = (Stage) bot_mat_cancelar.getScene().getWindow();
        stage.setScene(novascene);
    }

    @FXML
    private void deletar_editar(ActionEvent event) {
    }
    
    public void editar(Matricula m){
        
    }

    @FXML
    private void selecionar(ActionEvent event) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("scholare");
        EntityManager em = emf.createEntityManager();
        
        Matricula mat = (Matricula) cbox_mat_matricula.getSelectionModel().getSelectedItem();
        
        Query query = em.createQuery("select m from Matricula as m where m.mat_id = :mat_id");
        query.setParameter("mat_id", mat.getMat_id());
        
        if(query.getResultList().isEmpty()){
            System.out.println("Erro");
        }
        else{
            //deshabilita_campos();
            
            Matricula m = (Matricula) query.getSingleResult();
            editar(m);
        }
    }
    
}
