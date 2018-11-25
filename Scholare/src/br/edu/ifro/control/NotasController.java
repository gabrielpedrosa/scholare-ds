package br.edu.ifro.control;

import br.edu.ifro.model.Aluno;
import br.edu.ifro.model.Disciplina;
import br.edu.ifro.model.Matricula;
import br.edu.ifro.model.Notas;
import br.edu.ifro.model.Turma;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

//@author Gabriel Pedrosa
public class NotasController implements Initializable, Essencial {

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
    private MenuItem listar_matriculas;
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
    private Button bot_cancelar;
    @FXML
    private ComboBox<Turma> cbox_turma;
    @FXML
    private TableView<Aluno> tb_alunos;
    @FXML
    private ComboBox<Disciplina> cbox_disciplina;
    @FXML
    private Button bot_salvar;

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
    private void listar_matriculas(ActionEvent event) {
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
    private void cancelar_notas(ActionEvent event) {
        Scene novascene = Open.abrirMenu(getClass()); 
        Stage stage = (Stage) bot_cancelar.getScene().getWindow();
        stage.setScene(novascene);
    }

    @FXML
    private void selecionar_turma(ActionEvent event) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("scholare");
        EntityManager em = emf.createEntityManager();
        
        Query query = em.createQuery("select a from Aluno as a, Matricula m where a.alu_id = m.aluno and m.turma = :turma order by a.alu_nome");
        query.setParameter("turma", cbox_turma.getSelectionModel().getSelectedItem());
        List<Aluno> list_alunos = query.getResultList();
        
        ObservableList<Aluno> obaluno = FXCollections.observableArrayList(list_alunos);
        tb_alunos.setItems(obaluno);
        tb_alunos.setDisable(false);
        
        Turma t = (Turma)cbox_turma.getSelectionModel().getSelectedItem();
        
        Query querydis = em.createQuery("select d from Disciplina as d ");
        //querydis.setParameter("tur_fun", 1);
        
        List<Disciplina> list_disciplina = querydis.getResultList();
        
        ObservableList<Disciplina> obdis = FXCollections.observableArrayList(list_disciplina);
        System.out.println(obdis);
        cbox_disciplina.setItems(obdis);
    }

    @FXML
    private void selecionar_disciplina(ActionEvent event) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("scholare");
        EntityManager em = emf.createEntityManager();
        
        Turma t = (Turma)cbox_turma.getSelectionModel().getSelectedItem();
        
        Query query = em.createQuery("select n from Notas as n where n.disciplina = :disc ");
        query.setParameter("disc", cbox_disciplina.getSelectionModel().getSelectedItem());
        
        System.out.println(query.getResultList());

        tb_alunos.setDisable(false);
    }

    @FXML
    private void salvar_notas(ActionEvent event) {
    }

    @Override
    public void inicia() {
        add_cbox();
    }

    @Override
    public void add_cbox() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("scholare");
        EntityManager em = emf.createEntityManager();

        Query queryturma = em.createQuery("select t from Turma as t");
        List<Turma> list_turma = queryturma.getResultList();
        
        ObservableList<Turma> obturma = FXCollections.observableArrayList(list_turma);
        cbox_turma.setItems(obturma);
        
        
    }
    
}
