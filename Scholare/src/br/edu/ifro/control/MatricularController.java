package br.edu.ifro.control;

import br.edu.ifro.model.Aluno;
import br.edu.ifro.model.Disciplina;
import br.edu.ifro.model.Funcionario;
import br.edu.ifro.model.Matricula;
import br.edu.ifro.model.Notas;
import br.edu.ifro.model.Turma;
import br.edu.ifro.util.Open;
import br.eti.diegofonseca.MaskFieldUtil;
import java.net.URL;
import java.text.SimpleDateFormat;
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
public class MatricularController implements Initializable {
    @FXML
    private Button bot_mat_matricular;
    @FXML
    private Button bot_mat_limpar;
    @FXML
    private Button bot_mat_cancelar;
    @FXML
    private TextField txt_mat_datacadastro;
    @FXML
    private RadioButton sim;
    @FXML
    private RadioButton nao;
    @FXML
    private TextField txt_mat_responsavel;
    @FXML
    private ComboBox<Aluno> cbox_mat_aluno;
    @FXML
    private ComboBox<Turma> cbox_mat_turma;
    @FXML
    private TextField txt_mat_telefone;
    @FXML
    private TextArea txa_mat_observacoes;
    @FXML
    private ToggleGroup tg_mat_triagem;
    @FXML
    private ComboBox<Funcionario> cbox_mat_funcionario;
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        inicia();
    }
    
    public void inicia(){
       add_cbox();
       add_data();
       add_mask();
    }
    
    public void add_cbox(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("scholare");
        EntityManager em = emf.createEntityManager();
        
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
    
    public void add_data(){
        java.util.Date d = new java.util.Date();
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
        String datasrt = (String) f.format(d);
        txt_mat_datacadastro.setText(datasrt);
    }
    
    public boolean verifica_vazio(){
        boolean preenchido;
        boolean txt_preenchido = false;
        boolean cbox_preenchido = false;
        TextField[] campo_txt = {txt_mat_responsavel, txt_mat_telefone};
        ComboBox[] campo_cbox = {cbox_mat_aluno, cbox_mat_funcionario};
        
        for (TextField campo_txt1 : campo_txt) {
            if (campo_txt1.getText().equals("") || campo_txt1.getText() == null) {
                txt_preenchido = false;
                break;
            } else {
                txt_preenchido = true;
            }
        }
        
        for (ComboBox campo_cbox1 : campo_cbox) {
            if (campo_cbox1.getSelectionModel().getSelectedIndex() == -1) {
                cbox_preenchido = false;
                break;
            } else {
                cbox_preenchido = true;
            }
        }
        
        preenchido = txt_preenchido == true && cbox_preenchido == true;
        
        return preenchido;
    }
    //Funções FXML<--
    @FXML
    private void matricular_matricula(ActionEvent event) {
        if(verifica_vazio() == true){
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("scholare");
            EntityManager em = emf.createEntityManager();

            Matricula m = new Matricula();
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
            
            Turma tur = (Turma) cbox_mat_turma.getSelectionModel().getSelectedItem();
            
            Query queryfun = em.createQuery("select d from Disciplina as d ");
            
            List[] notas = {queryfun.getResultList()};
            
            for(int i = 0; i <= notas.length; i++){
                Notas n = new Notas();
                n.setMatriculaaluno(m);
                n.setNot_nota1("0");
                n.setNot_nota2("0");
                n.setNot_nota3("");
                n.setNot_nota4("");
                n.setDisciplina((Disciplina) queryfun.getResultList().get(i));
                em.getTransaction().begin();
                em.persist(n);
                em.getTransaction().commit();
            }
            limpar_matricula(event);

            
            em.close();
            emf.close();
            
            Open.abrirSucesso(getClass());
        }
        else{
             Open.abrirErro(getClass());
        }   
    }

    @FXML
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
    private void cancelar_matricula(ActionEvent event) {
        Scene novascene = Open.abrirMenu(getClass()); 
        Stage stage = (Stage) bot_mat_cancelar.getScene().getWindow();
        stage.setScene(novascene);
    }

    @FXML
    private void sim(ActionEvent event) {
        cbox_mat_turma.setDisable(true);
    }

    @FXML
    private void nao(ActionEvent event) {
        cbox_mat_turma.setDisable(false);
    }
    //Funções FXML-->

    //Funções Menu<--
    @FXML
    private void aluno(ActionEvent event){
        Scene novascene = Open.abrirAluno(getClass()); 
        Stage stage = (Stage) bot_mat_matricular.getScene().getWindow();
        stage.setScene(novascene);
    }

    @FXML
    private void funcionario(ActionEvent event) {
        Scene novascene = Open.abrirFuncionario(getClass()); 
        Stage stage = (Stage) bot_mat_matricular.getScene().getWindow();
        stage.setScene(novascene);
    }

    @FXML
    private void turma(ActionEvent event) {
        Scene novascene = Open.abrirTurma(getClass()); 
        Stage stage = (Stage) bot_mat_matricular.getScene().getWindow();
        stage.setScene(novascene);
    }

    @FXML
    private void alunos(ActionEvent event) {
        Scene novascene = Open.abrirExibirAluno(getClass()); 
        Stage stage = (Stage) bot_mat_matricular.getScene().getWindow();
        stage.setScene(novascene);
    }

    @FXML
    private void funcionarios(ActionEvent event) {
        Scene novascene = Open.abrirExibirFuncionario(getClass()); 
        Stage stage = (Stage) bot_mat_matricular.getScene().getWindow();
        stage.setScene(novascene);
    }
    
    @FXML
    private void turmas(ActionEvent event) {
    }

    @FXML
    private void sobre(ActionEvent event) {
    }
    //Funções Menu-->
}
