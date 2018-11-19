package br.edu.ifro.control;

import br.edu.ifro.model.Funcionario;
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
public class Editar_TurmaController implements Initializable {
    @FXML
    private RadioButton rad_tur_a;
    @FXML
    private ToggleGroup tg_tur_turno;
    @FXML
    private RadioButton rad_tur_b;
    @FXML
    private Button bot_tur_cancelar;
    @FXML
    private ComboBox cbox_tur_ano;
    @FXML
    private ComboBox cbox_tur_tipo;
    @FXML
    private TableView<?> tb_tur_professores;
    @FXML
    private ComboBox cbox_tur_serie_ano;
    @FXML
    private Label window_nome;
    @FXML
    private Button bot_tur_salvar;
    @FXML
    private Button bot_tur_deletar;
    @FXML
    private Button bot_tur_editar;
    @FXML
    private TextField txt_tur_datacadastro;
    @FXML
    private ComboBox<Turma> cbox_tur_nome;
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
    private MenuItem listar_alunos;
    @FXML
    private MenuItem listar_funcionarios;
    @FXML
    private MenuItem listar_turmas;
    @FXML
    private MenuItem lsitar_matriculas;
    @FXML
    private MenuItem matriculas;
    @FXML
    private MenuItem relatorio_diario;
    @FXML
    private MenuItem ata_de_resultados;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        inicia();
    }
    
    public void inicia(){
        add_cbox();
    }
    
    public void add_cbox(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("scholare");
        EntityManager em = emf.createEntityManager();
        
        Query query = em.createQuery("select t from Turma as t");
        List<Turma> list_turma = query.getResultList();
        
        ObservableList<Turma> obturma = FXCollections.observableArrayList(list_turma);
        cbox_tur_nome.setItems(obturma);
    
    }
    
    public void desabilita_campos(){
        cbox_tur_ano.setDisable(true);
        cbox_tur_serie_ano.setDisable(true);
        cbox_tur_tipo.setDisable(true);
    }
    
    public void habilita_campos(){
        cbox_tur_ano.setDisable(false);
        cbox_tur_serie_ano.setDisable(false);
        cbox_tur_tipo.setDisable(false);
        bot_tur_deletar.setDisable(false);
        bot_tur_salvar.setDisable(false);
    }
    
    public void limpar_turma(){
        cbox_tur_ano.setValue(null);
        cbox_tur_serie_ano.setValue(null);
        cbox_tur_tipo.setValue(null);
    }
    

    //Funções FXML<--
    @FXML
    private void salvar_editar_turma(ActionEvent event) {
    }

    @FXML
    private void deletar_editar_turma(ActionEvent event) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("scholare");
        EntityManager em = emf.createEntityManager();
        
        Turma tur = (Turma) cbox_tur_nome.getSelectionModel().getSelectedItem();
        
        Query query =em.createQuery("select t from Turma as t where t.tur_id = :tur_id");
        query.setParameter("tur_id", tur.getTur_id());
        
        Turma t = (Turma) query.getSingleResult();
        
        em.getTransaction().begin();
        em.remove(t);
        em.getTransaction().commit();
        
        em.close();
    }

    @FXML
    private void editar_editar_turma(ActionEvent event) {
        if(cbox_tur_nome.getSelectionModel().getSelectedIndex()==-1){
            System.out.println("Selecione uma Turma");
        }
        else{
            habilita_campos();
        } 
    }

    @FXML
    private void cancelar_editar_turma(ActionEvent event) {
        Scene novascene = Open.abrirMenu(getClass()); 
        Stage stage = (Stage) bot_tur_cancelar.getScene().getWindow();
        stage.setScene(novascene);
    }

    @FXML
    private void selecionar(ActionEvent event) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("scholare");
        EntityManager em = emf.createEntityManager();
        
        Turma tur = (Turma) cbox_tur_nome.getSelectionModel().getSelectedItem();
        
        Query query =em.createQuery("select t from Turma as t where t.tur_id = :tur_id");
        query.setParameter("tur_id", tur.getTur_id());
        
        if(query.getResultList().isEmpty()){
            System.out.println("Erro");
        }
        else{
            //deshabilita_campos();
            
            Turma t = (Turma) query.getSingleResult();
            editar(t);
        }
    }
    
    public void editar(Turma t){
        cbox_tur_ano.setValue(t.getTur_ano());
        cbox_tur_serie_ano.setValue(t.getTur_serie_ano());
        cbox_tur_tipo.setValue(t.getTur_tipo());
        
    }
    //Funções FXML-->

    //Funções Menu<--
    @FXML
    private void aluno(ActionEvent event){
        Scene novascene = Open.abrirAluno(getClass()); 
        Stage stage = (Stage) bot_tur_editar.getScene().getWindow();
        stage.setScene(novascene);
    }
    @FXML
    private void funcionario(ActionEvent event) {
        Scene novascene = Open.abrirFuncionario(getClass()); 
        Stage stage = (Stage) bot_tur_editar.getScene().getWindow();
        stage.setScene(novascene);
    }
    @FXML
    private void turma(ActionEvent event) {
        Scene novascene = Open.abrirTurma(getClass()); 
        Stage stage = (Stage) bot_tur_editar.getScene().getWindow();
        stage.setScene(novascene);
    }
    @FXML
    private void alunos(ActionEvent event) {
        Scene novascene = Open.abrirExibirAluno(getClass()); 
        Stage stage = (Stage) bot_tur_editar.getScene().getWindow();
        stage.setScene(novascene);
    }
    @FXML
    private void funcionarios(ActionEvent event) {
        Scene novascene = Open.abrirExibirFuncionario(getClass()); 
        Stage stage = (Stage) bot_tur_editar.getScene().getWindow();
        stage.setScene(novascene);
    }
    @FXML
    private void turmas(ActionEvent event) {
    }
    @FXML
    private void sobre(ActionEvent event) {
    }
    //Funções Menu-->

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
    private void lsitar_matriculas(ActionEvent event) {
    }

    @FXML
    private void relatorio_diario(ActionEvent event) {
    }

    @FXML
    private void ata_de_resultados(ActionEvent event) {
    }
}
