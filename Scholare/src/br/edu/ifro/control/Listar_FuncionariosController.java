package br.edu.ifro.control;

import br.edu.ifro.model.Funcionario;
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

/**
 * FXML Controller class
 *
 * @author Gabriel Pedrosa
 */
public class Listar_FuncionariosController implements Initializable, Essencial {

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
    private TableView<Funcionario> tb_fun_funcionario;
    @FXML
    private Button bot_fun_deletar;
    @FXML
    private Button bot_fun_editar;
    @FXML
    private Button bot_fun_cancelar;
    @FXML
    private MenuItem listar_matriculas;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        inicia();
    }    

    //Funções Menu<--
    @FXML
    private void aluno(ActionEvent event){
        Scene novascene = Open.abrirAluno(getClass()); 
        Stage stage = (Stage) bot_fun_cancelar.getScene().getWindow();
        stage.setScene(novascene);
    }
    @FXML
    private void funcionario(ActionEvent event) {
        Scene novascene = Open.abrirFuncionario(getClass()); 
        Stage stage = (Stage) bot_fun_cancelar.getScene().getWindow();
        stage.setScene(novascene);
    }
    @FXML
    private void turma(ActionEvent event) {
        Scene novascene = Open.abrirTurma(getClass()); 
        Stage stage = (Stage) bot_fun_cancelar.getScene().getWindow();
        stage.setScene(novascene);
    }
    @FXML
    private void alunos(ActionEvent event) {
        Scene novascene = Open.abrirExibirAluno(getClass()); 
        Stage stage = (Stage) bot_fun_cancelar.getScene().getWindow();
        stage.setScene(novascene);
    }
    @FXML
    private void funcionarios(ActionEvent event) {
        Scene novascene = Open.abrirExibirFuncionario(getClass()); 
        Stage stage = (Stage) bot_fun_cancelar.getScene().getWindow();
        stage.setScene(novascene);
    }
    @FXML
    private void turmas(ActionEvent event) {
        Scene novascene = Open.abrirExibirTurma(getClass()); 
        Stage stage = (Stage) bot_fun_cancelar.getScene().getWindow();
        stage.setScene(novascene);
        
    }
    @FXML
    private void sobre(ActionEvent event) {
        Scene novascene = Open.abrirSobre(getClass()); 
        Stage stage = (Stage) bot_fun_cancelar.getScene().getWindow();
        stage.setScene(novascene);
        
    }
    @FXML
    private void listar_alunos(ActionEvent event) {
        Scene novascene = Open.abrirListarAluno(getClass()); 
        Stage stage = (Stage) bot_fun_cancelar.getScene().getWindow();
        stage.setScene(novascene);
    }
    @FXML
    private void listar_funcionarios(ActionEvent event) {
        Scene novascene = Open.abrirListarFuncionario(getClass()); 
        Stage stage = (Stage) bot_fun_cancelar.getScene().getWindow();
        stage.setScene(novascene);
    }
    @FXML
    private void listar_turmas(ActionEvent event) {
        Scene novascene = Open.abrirListarTurma(getClass()); 
        Stage stage = (Stage) bot_fun_cancelar.getScene().getWindow();
        stage.setScene(novascene);
    }
    @FXML
    private void listar_matriculas(ActionEvent event) {
        Scene novascene = Open.abrirListarMatricula(getClass()); 
        Stage stage = (Stage) bot_fun_cancelar.getScene().getWindow();
        stage.setScene(novascene);
    }
    @FXML
    private void relatorio_diario(ActionEvent event) {
        Scene novascene = Open.abrirDiario(getClass()); 
        Stage stage = (Stage) bot_fun_cancelar.getScene().getWindow();
        stage.setScene(novascene);
    }
    @FXML
    private void ata_de_resultados(ActionEvent event) {
        Scene novascene = Open.abrirAtadeResultado(getClass()); 
        Stage stage = (Stage) bot_fun_cancelar.getScene().getWindow();
        stage.setScene(novascene);
    }
    //Funções Menu-->


    private void selecionar_funcionario(ActionEvent event) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("scholare");
        EntityManager em = emf.createEntityManager();
        
        Query query = em.createQuery("select f from Funcionario as f");
        List<Funcionario> list_funcionario = query.getResultList();
        
        ObservableList<Funcionario> obfuncionario = FXCollections.observableArrayList(list_funcionario);
        tb_fun_funcionario.setItems(obfuncionario);
        tb_fun_funcionario.setDisable(false);
    }

    @FXML
    private void deletar_listar_funcionario(ActionEvent event) {
        if(tb_fun_funcionario.getSelectionModel().getSelectedItem() == null){
            System.out.println("vazio");
        }
        else{        
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("scholare");
            EntityManager em = emf.createEntityManager();

            Funcionario fun = (Funcionario) tb_fun_funcionario.getSelectionModel().getSelectedItem();

            Query query = em.createQuery("select f from Funcionario as f where f.fun_id = :fun_id");
            query.setParameter("fun_id", fun.getFun_id());

            Funcionario f = (Funcionario) query.getSingleResult();

            em.getTransaction().begin();
            em.remove(f);
            em.getTransaction().commit();

            em.close();
            add_cbox();
        }
    }

    @FXML
    private void editar_listar_funcionario(ActionEvent event) {
        if(tb_fun_funcionario.getSelectionModel().getSelectedItem() == null){
            System.out.println("vazio");
        }
        else{
            Scene novascene = Open.abrirEditarFuncionario(getClass(),tb_fun_funcionario.getSelectionModel().getSelectedItem()); 
            Stage stage = (Stage) bot_fun_cancelar.getScene().getWindow();
            stage.setScene(novascene);
        }
    }

    @FXML
    private void cancelar_listar_funcionario(ActionEvent event) {
        Scene novascene = Open.abrirMenu(getClass()); 
        Stage stage = (Stage) bot_fun_cancelar.getScene().getWindow();
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
        
        Query query = em.createQuery("select f from Funcionario as f");
        List<Funcionario> list_professor = query.getResultList();
        
        ObservableList<Funcionario> ob_professor = FXCollections.observableArrayList(list_professor);
        tb_fun_funcionario.setItems(ob_professor);  
    }
    
}
