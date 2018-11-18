package br.edu.ifro.control;

import br.edu.ifro.model.Aluno;
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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

//@author Gabriel Pedrosa
public class Listar_AlunosController implements Initializable, Essencial {
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
    private Label window_nome;
    @FXML
    private ComboBox<Turma> cbox_alu_turma;
    @FXML
    private TableView<Aluno> tb_alu_alunos;
    @FXML
    private Button bot_alu_salvar;
    @FXML
    private Button bot_alu_deletar;
    @FXML
    private Button bot_alu_editar;
    @FXML
    private Button bot_alu_cancelar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       inicia();
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
        cbox_alu_turma.setItems(obturma);
    }

    @FXML
    private void selecionar_turma(ActionEvent event) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("scholare");
        EntityManager em = emf.createEntityManager();
        
        Query query = em.createQuery("select a from Aluno as a, Matricula m where a.alu_id = m.aluno and m.turma = :turma");
        query.setParameter("turma", cbox_alu_turma.getSelectionModel().getSelectedItem());
        List<Aluno> list_alunos = query.getResultList();
        
        ObservableList<Aluno> obaluno = FXCollections.observableArrayList(list_alunos);
        tb_alu_alunos.setItems(obaluno);
        tb_alu_alunos.setDisable(false);
    }    

    @FXML
    private void salvar_listar_aluno(ActionEvent event) {
    }

    @FXML
    private void deletar_listar_Aluno(ActionEvent event) {
    }

    @FXML
    private void editar_listar_aluno(ActionEvent event) {
        
    }
    @FXML
    private void cancelar_listar_aluno(ActionEvent event) {
        Scene novascene = Open.abrirMenu(getClass()); 
        Stage stage = (Stage) bot_alu_cancelar.getScene().getWindow();
        stage.setScene(novascene);
    }
    
    //Funções Menu<--
    @FXML
    private void aluno(ActionEvent event){
        Scene novascene = Open.abrirAluno(getClass()); 
        Stage stage = (Stage) bot_alu_editar.getScene().getWindow();
        stage.setScene(novascene);
    }
    @FXML
    private void funcionario(ActionEvent event) {
        Scene novascene = Open.abrirFuncionario(getClass()); 
        Stage stage = (Stage) bot_alu_editar.getScene().getWindow();
        stage.setScene(novascene);
    }
    @FXML
    private void turma(ActionEvent event) {
        Scene novascene = Open.abrirTurma(getClass()); 
        Stage stage = (Stage) bot_alu_editar.getScene().getWindow();
        stage.setScene(novascene);
    }
    @FXML
    private void alunos(ActionEvent event) {
        Scene novascene = Open.abrirExibirAluno(getClass()); 
        Stage stage = (Stage) bot_alu_editar.getScene().getWindow();
        stage.setScene(novascene);
    }
    @FXML
    private void funcionarios(ActionEvent event) {
        Scene novascene = Open.abrirExibirFuncionario(getClass()); 
        Stage stage = (Stage) bot_alu_editar.getScene().getWindow();
        stage.setScene(novascene);
    }
    @FXML
    private void turmas(ActionEvent event) {
        
    }
    @FXML
    private void sobre(ActionEvent event) {
        
    }
    @FXML
    private void listar_alunos(ActionEvent event) {
        Scene novascene = Open.abrirListarAluno(getClass()); 
        Stage stage = (Stage) bot_alu_editar.getScene().getWindow();
        stage.setScene(novascene);
    }
    @FXML
    private void listar_funcionarios(ActionEvent event) {
    }
    @FXML
    private void listar_turmas(ActionEvent event) {
    }
    @FXML
    private void lsitar_matriculas(ActionEvent event) {
    }
    @FXML
    private void relatorio_diario(ActionEvent event) {
    }
    @FXML
    private void ata_de_resultados(ActionEvent event) {
    }
    //Funções Menu-->
}
