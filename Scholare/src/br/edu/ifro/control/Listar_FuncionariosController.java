package br.edu.ifro.control;

import br.edu.ifro.model.Aluno;
import br.edu.ifro.model.Funcionario;
import br.edu.ifro.util.Essencial;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableView;
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
    }

    @FXML
    private void editar_listar_funcionario(ActionEvent event) {
    }

    @FXML
    private void cancelar_listar_funcionario(ActionEvent event) {
    }

    @Override
    public void inicia() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void add_cbox() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
