package br.edu.ifro.control;

import br.edu.ifro.model.Aluno;
import br.edu.ifro.model.Funcionario;
import br.edu.ifro.model.Matricula;
import br.edu.ifro.model.Turma;
import br.edu.ifro.util.Open;
import br.eti.diegofonseca.MaskFieldUtil;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

//@author Gabriel Pedrosa
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
    private ComboBox<Aluno> cbox_mat_aluno;
    @FXML
    private ComboBox<Turma> cbox_mat_turma;
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
    private ComboBox<Funcionario> cbox_mat_funcionario;
    @FXML
    private ComboBox cbox_mat_matricula;
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
    @FXML
    private Button bot_salvar;
    @FXML
    private Button bot_editar;
    @FXML
    private Button bot_cancelar;
    @FXML
    private Button bot_deletar;
    @FXML
    private ComboBox<Matricula> nome_matricula;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        add_cbox();
        
        cbox_mat_matricula.getSelectionModel().select("Selecione");
    }
    
    public void add_cbox(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("scholare");
        EntityManager em = emf.createEntityManager();
        
        Query query = em.createQuery("select m from Matricula as m");
        List<Matricula> list_matricula = query.getResultList();        
        
        ObservableList<Matricula> obmatricula = FXCollections.observableArrayList(list_matricula);
        cbox_mat_matricula.setItems(obmatricula);
        
        Query queryaluno = em.createQuery("select a from Aluno as a");
        Query queryturma = em.createQuery("select t from Turma as t");
        List<Aluno> list_alunos = queryaluno.getResultList();
        List<Turma> list_turma = queryturma.getResultList();
        
        ObservableList<Aluno> obaluno = FXCollections.observableArrayList(list_alunos);
        cbox_mat_aluno.setItems(obaluno);
        
        ObservableList ob_fun = FXCollections.observableArrayList("EU");
        cbox_mat_funcionario.setItems(ob_fun);
        
        ObservableList<Turma> obturma = FXCollections.observableArrayList(list_turma);
        cbox_mat_turma.setItems(obturma); 
    }
    
    public void add_mask(){
        MaskFieldUtil.foneField(txt_mat_telefone);
    }
    
    public void desabilita_campos(){
        txa_mat_observacoes.setDisable(true);
        txt_mat_responsavel.setDisable(true);
        txt_mat_telefone.setDisable(true);
        cbox_mat_turma.setDisable(true);
        sim.setDisable(true);
        nao.setDisable(true);
        
        bot_salvar.setDisable(true);
    }
    
    public void habilita_campos(){
        txa_mat_observacoes.setDisable(false);
        txt_mat_responsavel.setDisable(false);
        txt_mat_telefone.setDisable(false);
        if(sim.isSelected()){
            cbox_mat_turma.setDisable(true);
        }
        else{
            cbox_mat_turma.setDisable(false);
        }
        sim.setDisable(false);
        nao.setDisable(false);
        
        bot_salvar.setDisable(false);
    }

    @FXML
    private void sim(ActionEvent event) {
        cbox_mat_turma.setDisable(true);
    }

    @FXML
    private void nao(ActionEvent event) {
        cbox_mat_turma.setDisable(false);
    }

    @FXML
    private void salvar_editar(ActionEvent event) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("scholare");
            EntityManager em = emf.createEntityManager();
            
            Matricula mat = (Matricula) nome_matricula.getSelectionModel().getSelectedItem();
        
            Query query =em.createQuery("select m from Matricula as m where m.mat_id = :mat_id");
            query.setParameter("mat_id", mat.getMat_id());

            Matricula m = (Matricula) query.getSingleResult();

            m.setAluno(cbox_mat_aluno.getSelectionModel().getSelectedItem());
            m.setMat_data(txt_mat_datacadastro.getText());
            RadioButton radioselected = (RadioButton) tg_mat_triagem.getSelectedToggle();
            String rad_fun_triangem = radioselected.getText();
            m.setMat_triagem(rad_fun_triangem);
            m.setMat_telefone_responsavel(txt_mat_responsavel.getText());
            m.setFuncionario(null);
            m.setMat_observacoes(txa_mat_observacoes.getText());
            m.setMat_responsavel(txt_mat_responsavel.getText());
            if(radioselected.getText().equals("Sim")){
                m.setTurma(null);
            }
            else{
                m.setTurma(cbox_mat_turma.getSelectionModel().getSelectedItem());
            }
            
            em.getTransaction().begin();
            em.persist(m);
            em.getTransaction().commit();
            
            limpar_matricula(event);

            
            em.close();
            emf.close();
            
            Open.abrirSucesso(getClass());
    }

    @FXML
    private void editar_editar(ActionEvent event) {
        if(cbox_mat_matricula.getSelectionModel().getSelectedItem().equals("Selecione") && (cbox_mat_aluno.getValue() == null)){
            System.out.println("Selecione um Aluno");
        }
        else{
            habilita_campos();
        }
    }

    @FXML
    private void cancelar_editar(ActionEvent event) {
        Scene novascene = Open.abrirMenu(getClass()); 
        Stage stage = (Stage) bot_cancelar.getScene().getWindow();
        stage.setScene(novascene);
    }

    @FXML
    private void deletar_editar(ActionEvent event) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("scholare");
        EntityManager em = emf.createEntityManager();
        
        Matricula mat = (Matricula) nome_matricula.getSelectionModel().getSelectedItem();
        
        Query query =em.createQuery("select m from Matricula as m where m.mat_id = :mat_id");
        query.setParameter("mat_id", mat.getMat_id());
        
        Matricula m = (Matricula) query.getSingleResult();
        
        em.getTransaction().begin();
        em.remove(m);
        em.getTransaction().commit();
        
        em.close();
    }
    
    public void editar(Matricula m){
        nome_matricula.setValue(m);
        cbox_mat_aluno.setValue(m.getAluno());
        cbox_mat_turma.setValue(m.getTurma());
        txt_mat_responsavel.setText(m.getMat_responsavel());
        txt_mat_telefone.setText(m.getMat_telefone_responsavel());
        txt_mat_datacadastro.setText(m.getMat_data());
        cbox_mat_funcionario.setValue(m.getFuncionario());
        if(m.getMat_triagem().equals("Sim")){
            sim.setSelected(true);
        }
        else{
            nao.setSelected(true);
        }
        
        bot_deletar.setDisable(false);
    }
    
    private void limpar_matricula(ActionEvent event) {
        txt_mat_responsavel.setText("");
        txt_mat_telefone.setText("");
        txa_mat_observacoes.setText("");
        cbox_mat_aluno.setValue(null);
        cbox_mat_funcionario.setValue(null);
        cbox_mat_turma.setValue(null);
        sim.setSelected(true);
        cbox_mat_turma.setDisable(true);
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
