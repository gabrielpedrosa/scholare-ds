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
    private TableView<Funcionario> tb_tur_professores;
    @FXML
    private Label window_nome;
    @FXML
    private TextField txt_tur_datacadastro;
    @FXML
    private ComboBox cbox_tur_nome;
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
    private MenuItem matriculas;
    @FXML
    private MenuItem relatorio_diario;
    @FXML
    private MenuItem ata_de_resultados;
    @FXML
    private ComboBox<Funcionario> cbox_tur_professor;
    @FXML
    private Button bot_tur_inserir;
    @FXML
    private Button bot_tur_remover;
    @FXML
    private ComboBox cbox_tur_ano;
    @FXML
    private ComboBox cbox_tur_tipo;
    @FXML
    private ComboBox cbox_tur_serie_ano;
    @FXML
    private ComboBox cbox_tur_turno;
    @FXML
    private RadioButton rad_tur_a;
    @FXML
    private ToggleGroup tg_tur_turno;
    @FXML
    private RadioButton rad_tur_b;
    @FXML
    private RadioButton rad_tur_c;
    @FXML
    private RadioButton rad_tur_d;
    @FXML
    private RadioButton rad_tur_e;
    @FXML
    private RadioButton rad_tur_f;
    @FXML
    private MenuItem listar_matriculas;
    @FXML
    private Button bot_salvar;
    @FXML
    private Button bot_deletar;
    @FXML
    private Button bot_editar;
    @FXML
    private Button bot_cancelar;
    @FXML
    private ComboBox<Turma> nome_turma;

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
        
        Query query = em.createQuery("select t from Turma as t order by t.tur_nome");
        List<Turma> list_turma = query.getResultList();
        
        ObservableList<Turma> obturma = FXCollections.observableArrayList(list_turma);
        cbox_tur_nome.setItems(obturma);
        
        ObservableList ob_anos = FXCollections.observableArrayList("2018");
        cbox_tur_ano.setItems(ob_anos);
        
        ObservableList ob_tipo = FXCollections.observableArrayList("Educação Infantil", "Ensino Fundamental I", "EJA", "HFB");
        cbox_tur_tipo.setItems(ob_tipo);
        
        ObservableList ob_serie = FXCollections.observableArrayList("1", "2", "3", "4");
        cbox_tur_serie_ano.setItems(ob_serie);
        
        ObservableList ob_turno = FXCollections.observableArrayList("Matutino","Verpertino");
        cbox_tur_turno.setItems(ob_turno);
                
        Query queryfun = em.createQuery("select f from Funcionario as f where f.fun_funcao=:tipo");
        queryfun.setParameter("tipo", "Professor");
        List<Funcionario> list_professor = queryfun.getResultList();
        
        ObservableList<Funcionario> ob_professor = FXCollections.observableArrayList(list_professor);
        cbox_tur_professor.setItems(ob_professor);
        
        cbox_tur_nome.getSelectionModel().select("Selecione");
    }
    
    public void deshabilita_campos(){
        cbox_tur_ano.setDisable(true);
        cbox_tur_serie_ano.setDisable(true);
        cbox_tur_tipo.setDisable(true);
        cbox_tur_turno.setDisable(true);
        rad_tur_a.setDisable(true);
        rad_tur_b.setDisable(true);
        rad_tur_c.setDisable(true);
        rad_tur_d.setDisable(true);
        rad_tur_e.setDisable(true);
        rad_tur_f.setDisable(true);
        cbox_tur_professor.setDisable(true);
        tb_tur_professores.setDisable(true);
        bot_salvar.setDisable(true);
        bot_deletar.setDisable(true);
        bot_editar.setDisable(true);
        bot_tur_inserir.setDisable(true);
        bot_tur_remover.setDisable(true);
    }
    
    public void habilita_campos(){
        cbox_tur_ano.setDisable(false);
        cbox_tur_serie_ano.setDisable(false);
        cbox_tur_tipo.setDisable(false);
        cbox_tur_turno.setDisable(false);
        rad_tur_a.setDisable(false);
        rad_tur_b.setDisable(false);
        rad_tur_c.setDisable(false);
        rad_tur_d.setDisable(false);
        rad_tur_e.setDisable(false);
        rad_tur_f.setDisable(false);
        cbox_tur_professor.setDisable(false);
        tb_tur_professores.setDisable(false);
        bot_salvar.setDisable(false);
        bot_deletar.setDisable(false);
        bot_editar.setDisable(false);
        bot_tur_inserir.setDisable(false);
        bot_tur_remover.setDisable(false);
    }
    
    private void limpar_turma() {
        cbox_tur_serie_ano.setValue("");
        cbox_tur_ano.setValue("");
        cbox_tur_tipo.setValue("");
        cbox_tur_professor.setValue(null);
        tb_tur_professores.getItems().clear();
        cbox_tur_turno.setValue("");
        rad_tur_a.setSelected(true);
    }
    

    //Funções FXML<--
    @FXML
    private void salvar_editar_turma(ActionEvent event) {
         EntityManagerFactory emf = Persistence.createEntityManagerFactory("scholare");
        EntityManager em = emf.createEntityManager();
        
        Turma tur = (Turma) nome_turma.getSelectionModel().getSelectedItem();
        
        Query query =em.createQuery("select t from Turma as t where t.tur_id = :tur_id");
        query.setParameter("tur_id", tur.getTur_id());
        
        Turma t = (Turma) query.getSingleResult();
        
        t.setTur_ano(cbox_tur_ano.getSelectionModel().getSelectedItem().toString());
        
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
            
            limpar_turma();
            
            em.getTransaction().begin();
            em.persist(t);
            em.getTransaction().commit();
            em.close();
            emf.close();
            
            Open.abrirSucesso(getClass());
            
            add_cbox();
    }

    @FXML
    private void deletar_editar_turma(ActionEvent event) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("scholare");
        EntityManager em = emf.createEntityManager();
        
        Turma tur = (Turma) nome_turma.getSelectionModel().getSelectedItem();
        
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
        if(cbox_tur_nome.getSelectionModel().getSelectedItem().equals("Selecione") && (cbox_tur_ano.getValue().equals(""))){
            System.out.println("Selecione uma Turma");
        }
        else{
            habilita_campos();
        } 
    }

    @FXML
    private void cancelar_editar_turma(ActionEvent event) {
        Scene novascene = Open.abrirMenu(getClass()); 
        Stage stage = (Stage) bot_cancelar.getScene().getWindow();
        stage.setScene(novascene);
    }

    @FXML
    private void selecionar(ActionEvent event) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("scholare");
        EntityManager em = emf.createEntityManager();
        
        Turma tur = (Turma) cbox_tur_nome.getSelectionModel().getSelectedItem();
        
        
        Query query = em.createQuery("select t from Turma as t where t.tur_nome = :tur_nome");
        query.setParameter("tur_nome", cbox_tur_nome.getSelectionModel().getSelectedItem().toString());
        
        if(query.getResultList().isEmpty()){
            System.out.println("Erro");
        }
        else{
            deshabilita_campos();
            
            Turma t = (Turma) query.getSingleResult();
            System.out.println(query.getSingleResult());
            editar(t);
        }
    }
    
    public void editar(Turma t){
        nome_turma.setValue(t);
        cbox_tur_ano.getSelectionModel().select(t.getTur_ano());
        cbox_tur_ano.getSelectionModel().select(t.getTur_ano());
        cbox_tur_serie_ano.getSelectionModel().select(t.getTur_serie_ano());
        cbox_tur_tipo.getSelectionModel().select(t.getTur_tipo());
        cbox_tur_turno.getSelectionModel().select(t.getTur_turno());
        switch (t.getTur_classe()) {
            case "A":
                rad_tur_a.setSelected(true);
                break;
            case "B":
                rad_tur_b.setSelected(true);
                break;
            case "C":
                rad_tur_c.setSelected(true);
                break;
            case "D":
                rad_tur_d.setSelected(true);
                break;
            case "E":
                rad_tur_e.setSelected(true);
                break;
            default:
                rad_tur_f.setSelected(true);
                break;
        }
        ObservableList<Funcionario> obfuncionario = FXCollections.observableArrayList(t.getFuncionario());
        tb_tur_professores.setItems(obfuncionario);
        
    }
    
    @FXML
    private void inserir_professor(ActionEvent event) {
        String cbox_professor = cbox_tur_professor.getSelectionModel().getSelectedItem().toString();
        ObservableList<Funcionario> ob_lastprofessor = FXCollections.observableArrayList(tb_tur_professores.getItems());
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("scholare");
        EntityManager em = emf.createEntityManager();
        
        Query query = em.createQuery("select f from Funcionario as f where f.fun_nome = :fun_nome");
        query.setParameter("fun_nome", cbox_professor);
        
        List<Funcionario> list_professor = query.getResultList();
        list_professor.addAll(ob_lastprofessor);
        
        ObservableList<Funcionario> ob_professor = FXCollections.observableArrayList(list_professor);

        tb_tur_professores.setItems(ob_professor);
        
        Funcionario p = cbox_tur_professor.getSelectionModel().getSelectedItem();
        ObservableList a = cbox_tur_professor.getItems();
        a.remove(p);
        cbox_tur_professor.setItems(a);
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
