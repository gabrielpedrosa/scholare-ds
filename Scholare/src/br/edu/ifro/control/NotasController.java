package br.edu.ifro.control;

import br.edu.ifro.model.Disciplina;
import br.edu.ifro.model.Notas;
import br.edu.ifro.model.Turma;
import br.edu.ifro.util.Open;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

//@author Gabriel Pedrosa
public class NotasController implements Initializable {

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
    private TableView<?> tb_alunos;
    @FXML
    private ComboBox<Disciplina> cbox_disciplina;
    @FXML
    private Button bot_salvar;
    @FXML
    private TableColumn<Teste, String> nota1;
    @FXML
    private TableColumn<Teste, String> nota2;
    @FXML
    private TableColumn<Teste, String> nota3;
    @FXML
    private TableColumn<Teste, String> nota4;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        inicia();
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
        
        Turma t = (Turma)cbox_turma.getSelectionModel().getSelectedItem();
        
        Query querydis = em.createQuery("select d from Disciplina as d ");
        //querydis.setParameter("tur_fun", 1);
        
        List<Disciplina> list_disciplina = querydis.getResultList();
        
        ObservableList<Disciplina> obdis = FXCollections.observableArrayList(list_disciplina);
        System.out.println(obdis);
        cbox_disciplina.setItems(obdis);
        
        /*Query querya = em.createQuery("select a, n from Notas as n LEFT JOIN n.aluno a");
        //query.setParameter("disc", cbox_disciplina.getSelectionModel().getSelectedItem());
        
        
        ObservableList ob = FXCollections.observableArrayList(querya.getResultList());
        
        tb_alunos.setItems(ob);
        
        tb_alunos.setDisable(false);*/
    }

    @FXML
    private void selecionar_disciplina(ActionEvent event) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("scholare");
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("select a.alu_id as id, a.alu_nome as nome, n.not_nota1 as nota1,n.not_nota2 as nota2, n.not_nota3 as nota3, n.not_nota4 as nota4, n.disciplina as disciplina from Aluno as a, Matricula m, Notas n where a.alu_id = m.aluno and m.turma = :turma and n.matriculaaluno = m.aluno and n.disciplina = :disciplina order by a.alu_nome");
        query.setParameter("turma", cbox_turma.getSelectionModel().getSelectedItem());
        query.setParameter("disciplina", cbox_disciplina.getSelectionModel().getSelectedItem());
        
        List list_alunos = query.getResultList();
        
        List r = new ArrayList();
        for (Object a: list_alunos) {
            Object[] objects = (Object[]) a;  
            Teste t = new Teste();
            t.setId((int) objects[0]);
            t.setNome((String) objects[1]);
            t.setNota1((String) objects[2]);
            t.setNota2((String) objects[3]);
            t.setNota3((String) objects[4]);
            t.setNota4((String) objects[5]);
            t.setDisciplina((Disciplina) objects[6]);
            r.add(t);
        }

        ObservableList obaluno = FXCollections.observableArrayList(r);
        tb_alunos.setItems(obaluno);
        tb_alunos.setDisable(false);
       
        nota1.setCellFactory(TextFieldTableCell.forTableColumn());
        nota2.setCellFactory(TextFieldTableCell.forTableColumn());
        nota3.setCellFactory(TextFieldTableCell.forTableColumn());
        nota4.setCellFactory(TextFieldTableCell.forTableColumn());
       
        
        nota1.setOnEditCommit((TableColumn.CellEditEvent<Teste, String> t) -> {
        ((Teste) t.getTableView().getItems(). get(t.getTablePosition().getRow())).setNota1(t.getNewValue());});
        nota2.setOnEditCommit((TableColumn.CellEditEvent<Teste, String> t) -> {
        ((Teste) t.getTableView().getItems(). get(t.getTablePosition().getRow())).setNota2(t.getNewValue());});
        nota3.setOnEditCommit((TableColumn.CellEditEvent<Teste, String> t) -> {
        ((Teste) t.getTableView().getItems(). get(t.getTablePosition().getRow())).setNota3(t.getNewValue());});
        nota4.setOnEditCommit((TableColumn.CellEditEvent<Teste, String> t) -> {
        ((Teste) t.getTableView().getItems(). get(t.getTablePosition().getRow())).setNota4(t.getNewValue());});

    }

    @FXML
    private void salvar_notas(ActionEvent event) {
       /**/
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("scholare");
        EntityManager em = emf.createEntityManager();
        
        List list = tb_alunos.getItems();
         em.getTransaction().begin();       
        for (Object a: list) {
            Teste teste = (Teste) a;              
            Query query = em.createQuery("select n from Notas as n, Matricula m where m.mat_id = :mat_id ");
            query.setParameter("mat_id", teste.getId());
            query.setMaxResults(1);
            
            Notas n1 = (Notas) query.getSingleResult();
            
            n1.setNot_nota1((String) teste.getNota1());
            n1.setNot_nota2((String) teste.getNota2());
            n1.setNot_nota3((String) teste.getNota3());
            n1.setNot_nota4((String) teste.getNota4());
            // TODO
            
            em.persist(n1);
        }
        em.getTransaction().commit();
        em.close();
        emf.close();
        /**/
        
    }

    public void inicia() {
        add_cbox();
    }

    public void add_cbox() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("scholare");
        EntityManager em = emf.createEntityManager();

        Query queryturma = em.createQuery("select t from Turma as t");
        List<Turma> list_turma = queryturma.getResultList();
        
        ObservableList<Turma> obturma = FXCollections.observableArrayList(list_turma);
        cbox_turma.setItems(obturma);
        
        
    }

    public TableColumn<Teste, String> getNota1() {
        return nota1;
    }

    public void setNota1(TableColumn<Teste, String> nota1) {
        this.nota1 = nota1;
    }
    
    
    public TableColumn getNota2() {
        return nota2;
    }

    public void setNota2(TableColumn nota2) {
        this.nota2 = nota2;
    }

    public TableColumn getNota3() {
        return nota3;
    }

    public void setNota3(TableColumn nota3) {
        this.nota3 = nota3;
    }

    public TableColumn getNota4() {
        return nota4;
    }

    public void setNota4(TableColumn nota4) {
        this.nota4 = nota4;
    }
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

