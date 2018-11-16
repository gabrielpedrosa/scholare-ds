package br.edu.ifro.control;

import br.edu.ifro.model.Aluno;
import br.edu.ifro.model.Funcionario;
import br.edu.ifro.model.Matricula;
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
    private MenuItem cadastrar_aluno;
    @FXML
    private MenuItem cadastrar_professor;
    @FXML
    private MenuItem cadastrar_turma;
    @FXML
    private MenuItem exibir_alunos;
    @FXML
    private MenuItem exibir_professores;
    @FXML
    private MenuItem exibir_turna;
    @FXML
    private MenuItem ajuda_sobre;
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
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        inicia();
    }
     public void addmask(){
        MaskFieldUtil.foneField(txt_mat_telefone);
    }
    
    public void inicia(){
        java.util.Date d = new java.util.Date();
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
        String datasrt = (String) f.format(d);
        txt_mat_datacadastro.setText(datasrt);
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
    
    public boolean verifica_vazio(){
        boolean preenchido;
        boolean txt_preenchido = false;
        boolean cbox_preenchido = false;
        TextField[] campo_txt = {txt_mat_responsavel, txt_mat_telefone};
        ComboBox[] campo_cbox = {cbox_mat_aluno, cbox_mat_funcionario};
        
        for (int i= 0; i< campo_txt.length; i++) {
            if (campo_txt[i].getText().equals("") || campo_txt[i].getText() == null) {
                txt_preenchido = false;
                break;
            } else {
                txt_preenchido = true;
            }
        }
        
        for (int i= 0; i< campo_cbox.length; i++) {
            if (campo_cbox[i].getSelectionModel().getSelectedIndex() == -1) {
                cbox_preenchido = false;
                break;
            } else {
                cbox_preenchido = true;
            }
        }
        
        preenchido = txt_preenchido == true && cbox_preenchido == true;
        
        return preenchido;
    }
    
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
            
            limpar_matricula(event);

            em.getTransaction().begin();
            em.persist(m);
            em.getTransaction().commit();
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
}
