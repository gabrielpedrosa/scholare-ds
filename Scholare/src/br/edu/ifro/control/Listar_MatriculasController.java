package br.edu.ifro.control;

import br.edu.ifro.model.Matricula;
import br.edu.ifro.util.Essencial;
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
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

//@author Gabriel Pedrosa
public class Listar_MatriculasController implements Initializable, Essencial {

    @FXML
    private MenuItem aluno;
    @FXML
    private MenuItem funcionario;
    @FXML
    private MenuItem turma;
    @FXML
    private MenuItem listar_alunos;
    @FXML
    private MenuItem listar_funcionarios;
    @FXML
    private MenuItem listar_turmas;
    @FXML
    private MenuItem alunos;
    @FXML
    private MenuItem funcionarios;
    @FXML
    private MenuItem turmas;
    @FXML
    private MenuItem matriculas;
    @FXML
    private MenuItem relatorio_diario;
    @FXML
    private MenuItem ata_de_resultados;
    @FXML
    private MenuItem sobre;
    @FXML
    private Label window_nome;
    @FXML
    private Button bot_deletar;
    @FXML
    private Button bot_editar;
    @FXML
    private Button bot_cancelar;
    @FXML
    private TableView<Matricula> tb_matriculas;
    @FXML
    private MenuItem listar_matriculas;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        inicia();
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
    private void listar_alunos(ActionEvent event) {
    }

    @FXML
    private void listar_funcionarios(ActionEvent event) {
    }

    @FXML
    private void listar_turmas(ActionEvent event) {
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
    private void relatorio_diario(ActionEvent event) {
    }

    @FXML
    private void ata_de_resultados(ActionEvent event) {
    }

    @FXML
    private void sobre(ActionEvent event) {
    }

    @FXML
    private void deletar_listar(ActionEvent event) {
        if(tb_matriculas.getSelectionModel().getSelectedItem() == null){
            System.out.println("vazio");
        }
        else{        
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("scholare");
            EntityManager em = emf.createEntityManager();

            Matricula mat = (Matricula) tb_matriculas.getSelectionModel().getSelectedItem();

            Query query = em.createQuery("select m from Matricula as m where m.mat_id = :mat_id");
            query.setParameter("mat_id", mat.getMat_id());

            Matricula m = (Matricula) query.getSingleResult();

            em.getTransaction().begin();
            em.remove(m);
            em.getTransaction().commit();

            em.close();
            add_cbox();
        }
    }

    @FXML
    private void editar_listar(ActionEvent event) {
        if(tb_matriculas.getSelectionModel().getSelectedItem() == null){
            System.out.println("vazio");
        }
        else{
            Scene novascene = Open.abrirEditarMatricula(getClass(),tb_matriculas.getSelectionModel().getSelectedItem()); 
            Stage stage = (Stage) bot_cancelar.getScene().getWindow();
            stage.setScene(novascene);
        }
    }

    @FXML
    private void cancelar_listar(ActionEvent event) {
        Scene novascene = Open.abrirMenu(getClass()); 
        Stage stage = (Stage) bot_cancelar.getScene().getWindow();
        stage.setScene(novascene);
    }
    
    @Override
    public void inicia() {
        add_cbox();
    }

    @Override
    public void add_cbox() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("scholare");
        EntityManager em = emf.createEntityManager();
        
        Query query = em.createQuery("select m from Matricula as m");
        List<Matricula> list_matricula = query.getResultList();
        
        ObservableList<Matricula> obmatricula = FXCollections.observableArrayList(list_matricula);
        tb_matriculas.setItems(obmatricula);
    }


    @FXML
    private void listar_matriculas(ActionEvent event) {
    }
    
}
