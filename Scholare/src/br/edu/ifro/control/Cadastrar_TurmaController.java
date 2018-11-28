package br.edu.ifro.control;

import br.edu.ifro.model.Funcionario;
import br.edu.ifro.model.Turma;
import br.edu.ifro.util.Basico_Cadastro;
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
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

//@author Gabriel Pedrosa
public class Cadastrar_TurmaController implements Initializable, Basico_Cadastro {
    @FXML
    private RadioButton rad_tur_a;
    @FXML
    private RadioButton rad_tur_b;
    @FXML
    private ComboBox cbox_tur_ano;
    @FXML
    private ComboBox cbox_tur_tipo;
    @FXML
    private ComboBox<Funcionario> cbox_tur_professor;
    @FXML
    private Button bot_tur_inserir;
    @FXML
    private TableView<Funcionario> tb_tur_professores;
    @FXML
    private ToggleGroup tg_tur_turno;
    @FXML
    private ComboBox cbox_tur_serie_ano;
    @FXML
    private MenuItem aluno;
    @FXML
    private MenuItem funcionario;
    @FXML
    private MenuItem alunos;
    @FXML
    private MenuItem funcionarios;
    @FXML
    private MenuItem turmas;
    @FXML
    private MenuItem sobre;
    @FXML
    private RadioButton rad_tur_c;
    @FXML
    private RadioButton rad_tur_d;
    @FXML
    private RadioButton rad_tur_f;
    @FXML
    private ComboBox cbox_tur_turno;
    @FXML
    private Button bot_tur_remover;
    @FXML
    private MenuItem turma;
    @FXML
    private MenuItem listar_alunos;
    @FXML
    private MenuItem listar_funcionarios;
    @FXML
    private MenuItem listar_turmas;
    @FXML
    private MenuItem matriculas;
    @FXML
    private MenuItem relatorio_diario;
    @FXML
    private MenuItem ata_de_resultados;
    @FXML
    private RadioButton rad_tur_e;
    @FXML
    private MenuItem listar_matriculas;
    @FXML
    private Button bot_cadastrar;
    @FXML
    private Button bot_limpar;
    @FXML
    private Button bot_cancelar;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        add_cbox();
    }
    
    @Override
    public void add_cbox(){
        ObservableList ob_anos = FXCollections.observableArrayList("2018");
        cbox_tur_ano.setItems(ob_anos);
        
        ObservableList ob_tipo = FXCollections.observableArrayList("Educação Infantil", "Ensino Fundamental I", "EJA", "HFB");
        cbox_tur_tipo.setItems(ob_tipo);
        
        ObservableList ob_serie = FXCollections.observableArrayList("1", "2", "3", "4");
        cbox_tur_serie_ano.setItems(ob_serie);
        
        ObservableList ob_turno = FXCollections.observableArrayList("Matutino","Verpertino");
        cbox_tur_turno.setItems(ob_turno);
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("scholare");
        EntityManager em = emf.createEntityManager();
        
        Query query = em.createQuery("select f from Funcionario as f where f.fun_funcao=:tipo");
        query.setParameter("tipo", "Professor");
        List<Funcionario> list_professor = query.getResultList();
        
        ObservableList<Funcionario> ob_professor = FXCollections.observableArrayList(list_professor);
        cbox_tur_professor.setItems(ob_professor);
    }
        @Override
    public void add_mask() {
    }

    @Override
    public void add_data() {
    }
    
    @Override
    public boolean verifica_vazio(){
        boolean preenchido;
        boolean cbox_preenchido = false;
        ComboBox[] campo_cbox = {cbox_tur_ano, cbox_tur_tipo, cbox_tur_serie_ano, cbox_tur_turno};
        
        for (ComboBox campo_cbox1 : campo_cbox) {
            if (campo_cbox1.getSelectionModel().getSelectedIndex() == -1) {
                cbox_preenchido = false;
                break;
            } else {
                cbox_preenchido = true;
            }
        }
        
        preenchido = cbox_preenchido == true;
        
        return preenchido;
    }
    
    //Funções FXML<--
    @FXML
    private void cadastrar_turma(ActionEvent event) {
        if(verifica_vazio() == true){
            System.out.println("Campos obrigatórios preenchidos");
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("scholare");
            EntityManager em = emf.createEntityManager();
            
            Turma t = new Turma();
            t.setTur_ano(cbox_tur_ano.getSelectionModel().getSelectedItem().toString());
            t.setTur_serie_ano(cbox_tur_serie_ano.getSelectionModel().getSelectedItem().toString());
            RadioButton radioselected = (RadioButton) tg_tur_turno.getSelectedToggle();
            String rad_tur_classe = radioselected.getText();
            t.setTur_classe(rad_tur_classe);
            t.setTur_turno(cbox_tur_turno.getSelectionModel().getSelectedItem().toString());
            t.setTur_tipo(cbox_tur_tipo.getSelectionModel().getSelectedItem().toString());
            t.setTur_nome(cbox_tur_ano.getSelectionModel().getSelectedItem().toString()+" - "+
                    cbox_tur_serie_ano.getSelectionModel().getSelectedItem().toString()+" - "+
                    rad_tur_classe+" - "+cbox_tur_turno.getSelectionModel().getSelectedItem().toString()
                    +" - "+cbox_tur_tipo.getSelectionModel().getSelectedItem().toString());
            
            ObservableList<Funcionario> ob_professores = FXCollections.observableArrayList(tb_tur_professores.getItems());
            List<Funcionario> lista_professor = ob_professores.subList(0, ob_professores.size());
            t.setFuncionario(lista_professor);
            
            limpar_turma(event);
            
            em.getTransaction().begin();
            em.persist(t);
            em.getTransaction().commit();
            em.close();
            emf.close();
            
            Open.abrirSucesso(getClass());
            
            add_cbox();
        }
        else{
            Open.abrirErro(getClass());
        }
    }

    @FXML
    private void limpar_turma(ActionEvent event) {
        cbox_tur_serie_ano.setValue("");
        cbox_tur_ano.setValue("");
        cbox_tur_tipo.setValue("");
        cbox_tur_professor.setValue(null);
        tb_tur_professores.getItems().clear();
        cbox_tur_turno.setValue("");
        rad_tur_a.setSelected(true);
    }

    @FXML
    private void cancelar_turma(ActionEvent event) {
        Scene novascene = Open.abrirMenu(getClass()); 
        Stage stage = (Stage) bot_cancelar.getScene().getWindow();
        stage.setScene(novascene);
    }
    
    @FXML
    private void inserir_professor(ActionEvent event) {
        Funcionario f = cbox_tur_professor.getSelectionModel().getSelectedItem();
        if(f == null){
            System.out.println("Tabela Vazio");
        }else{
        ObservableList<Funcionario> ob_lastprofessor = FXCollections.observableArrayList(tb_tur_professores.getItems());
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("scholare");
        EntityManager em = emf.createEntityManager();
        
        Query query = em.createQuery("select f from Funcionario as f where f.fun_nome = :fun_nome order by f.fun_nome");
        query.setParameter("fun_nome", cbox_tur_professor.getSelectionModel().getSelectedItem().toString());
        
        List<Funcionario> list_professor = query.getResultList();
        list_professor.addAll(ob_lastprofessor);
        
        ObservableList<Funcionario> ob_professor = FXCollections.observableArrayList(list_professor);

        tb_tur_professores.setItems(ob_professor);
        
        Funcionario p = cbox_tur_professor.getSelectionModel().getSelectedItem();
        ObservableList a = cbox_tur_professor.getItems();
        a.remove(p);
        cbox_tur_professor.setItems(a);
        }
    }
    @FXML
    private void remover_professor(ActionEvent event) {
        Funcionario f = tb_tur_professores.getSelectionModel().getSelectedItem();
        if(f == null){
            System.out.println("Tabela Vazio");
        }else{
        ObservableList a = tb_tur_professores.getItems();
        ObservableList b = cbox_tur_professor.getItems();
        a.remove(f);
        b.add(f);
        tb_tur_professores.setItems(a);
        cbox_tur_professor.setItems(b);
        }
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