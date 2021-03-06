package br.edu.ifro.control;

import br.edu.ifro.model.Aluno;
import br.edu.ifro.model.Matricula;
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
import javax.swing.JOptionPane;

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
    private ComboBox<Turma> cbox_turma;
    @FXML
    private TableView<Aluno> tb_alunos;
    @FXML
    private Button bot_deletar;
    @FXML
    private Button bot_editar;
    @FXML
    private Button bot_cancelar;
    @FXML
    private MenuItem listar_alunos;
    @FXML
    private MenuItem listar_funcionarios;
    @FXML
    private MenuItem listar_turmas;
    @FXML
    private MenuItem listar_matriculas;
    @FXML
    private MenuItem matriculas;
    @FXML
    private MenuItem relatorio_diario;
    @FXML
    private MenuItem ata_de_resultados;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        add_cbox();
        bot_editar.setDisable(false);
    }

    @Override
    public void add_cbox() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("scholare");
        EntityManager em = emf.createEntityManager();

        Query queryturma = em.createQuery("select t from Turma as t");
        List<Turma> list_turma = queryturma.getResultList();
        
        ObservableList<Turma> obturma = FXCollections.observableArrayList(list_turma);
        cbox_turma.setItems(obturma);
        
        Query queryaluno = em.createQuery("select a from Aluno as a order by a.alu_nome");
        List<Aluno> list_alunos = queryaluno.getResultList();
        
        ObservableList<Aluno> obaluno = FXCollections.observableArrayList(list_alunos);
        tb_alunos.setItems(obaluno);
        tb_alunos.setDisable(false);
    }
    
    //Funções FXML<--
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
    }
    @FXML
    private void deletar_aluno(ActionEvent event) {
        if(tb_alunos.getSelectionModel().getSelectedItem() == null){
            System.out.println("vazio");
        }
        else{
            Object[] options = { "Confirmar", "Cancelar" };
            int retorno = JOptionPane.showOptionDialog(null, "Tem certeza que deseja Excluir", "Excluir", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
            
            if(retorno == 0){
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("scholare");
                EntityManager em = emf.createEntityManager();

                Aluno alun = (Aluno) tb_alunos.getSelectionModel().getSelectedItem();

                Query query = em.createQuery("select a from Aluno as a where a.alu_id = :alu_id");
                query.setParameter("alu_id", alun.getAlu_id());

                Query querymatricula = em.createQuery("select m from Matricula as m where m.aluno = :alu_id");
                querymatricula.setParameter("alu_id", tb_alunos.getSelectionModel().getSelectedItem());

                Aluno a = (Aluno) query.getSingleResult();
                Matricula m = (Matricula) querymatricula.getSingleResult();

                em.getTransaction().begin();
                em.remove(m);
                em.remove(a);
                em.getTransaction().commit();

                em.close();
                selecionar_turma(event);
            }
            else{
                
            }
        }
    }
    @FXML
    private void editar_aluno(ActionEvent event) {
        if(tb_alunos.getSelectionModel().getSelectedItem() == null){
            System.out.println("vazio");
        }
        else{
            Scene novascene = Open.abrirEditarAluno(getClass(),tb_alunos.getSelectionModel().getSelectedItem()); 
            Stage stage = (Stage) bot_cancelar.getScene().getWindow();
            stage.setScene(novascene);
        }
    }
    @FXML
    private void cancelar_aluno(ActionEvent event) {
        Scene novascene = Open.abrirMenu(getClass()); 
        Stage stage = (Stage) bot_cancelar.getScene().getWindow();
        stage.setScene(novascene);
    }
    //Funções FXML-->
    
    //Funções Menu<--
    @FXML
    private void aluno(ActionEvent event){
        Scene novascene = Open.abrirAluno(getClass()); 
        Stage stage = (Stage) bot_cancelar.getScene().getWindow();
        stage.setScene(novascene);
    }
    @FXML
    private void funcionario(ActionEvent event) {
        Scene novascene = Open.abrirFuncionario(getClass()); 
        Stage stage = (Stage) bot_cancelar.getScene().getWindow();
        stage.setScene(novascene);
    }
    @FXML
    private void turma(ActionEvent event) {
        Scene novascene = Open.abrirTurma(getClass()); 
        Stage stage = (Stage) bot_cancelar.getScene().getWindow();
        stage.setScene(novascene);
    }
    @FXML
    private void alunos(ActionEvent event) {
        Scene novascene = Open.abrirExibirAluno(getClass()); 
        Stage stage = (Stage) bot_cancelar.getScene().getWindow();
        stage.setScene(novascene);
    }
    @FXML
    private void funcionarios(ActionEvent event) {
        Scene novascene = Open.abrirExibirFuncionario(getClass()); 
        Stage stage = (Stage) bot_cancelar.getScene().getWindow();
        stage.setScene(novascene);
    }
    @FXML
    private void turmas(ActionEvent event) {
        Scene novascene = Open.abrirExibirTurma(getClass()); 
        Stage stage = (Stage) bot_cancelar.getScene().getWindow();
        stage.setScene(novascene);
    }
    
    @FXML
    private void matriculas(ActionEvent event) {
        Scene novascene = Open.abrirExibirMatricula(getClass()); 
        Stage stage = (Stage) bot_cancelar.getScene().getWindow();
        stage.setScene(novascene);
    }
    @FXML
    private void sobre(ActionEvent event) {
        Scene novascene = Open.abrirSobre(getClass()); 
        Stage stage = (Stage) bot_cancelar.getScene().getWindow();
        stage.setScene(novascene); 
    }
    @FXML
    private void listar_alunos(ActionEvent event) {
        Scene novascene = Open.abrirListarAluno(getClass()); 
        Stage stage = (Stage) bot_cancelar.getScene().getWindow();
        stage.setScene(novascene);
    }
    @FXML
    private void listar_funcionarios(ActionEvent event) {
        Scene novascene = Open.abrirListarFuncionario(getClass()); 
        Stage stage = (Stage) bot_cancelar.getScene().getWindow();
        stage.setScene(novascene);
    }
    @FXML
    private void listar_turmas(ActionEvent event) {
        Scene novascene = Open.abrirListarTurma(getClass()); 
        Stage stage = (Stage) bot_cancelar.getScene().getWindow();
        stage.setScene(novascene);
    }
    @FXML
    private void listar_matriculas(ActionEvent event) {
        Scene novascene = Open.abrirListarMatricula(getClass()); 
        Stage stage = (Stage) bot_cancelar.getScene().getWindow();
        stage.setScene(novascene);
    }
    @FXML
    private void relatorio_diario(ActionEvent event) {
        Scene novascene = Open.abrirDiario(getClass()); 
        Stage stage = (Stage) bot_cancelar.getScene().getWindow();
        stage.setScene(novascene);
    }
    @FXML
    private void ata_de_resultados(ActionEvent event) {
        Scene novascene = Open.abrirAtadeResultado(getClass()); 
        Stage stage = (Stage) bot_cancelar.getScene().getWindow();
        stage.setScene(novascene);
    }
    //Funções Menu-->
}
