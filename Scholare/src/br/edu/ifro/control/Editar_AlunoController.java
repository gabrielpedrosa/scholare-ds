package br.edu.ifro.control;

import br.edu.ifro.model.Aluno;
import br.edu.ifro.model.Funcionario;
import br.edu.ifro.model.Matricula;
import br.edu.ifro.model.Notas;
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
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

//@author Gabriel Pedrosa
public class Editar_AlunoController implements Initializable {
    @FXML
    private Label window_nome;
    @FXML
    private TextField txt_alu_cpf;
    @FXML
    private ToggleGroup tg_alu_sexo;
    @FXML
    private TextField txt_alu_rg;
    @FXML
    private TextField txt_alu_telefone;
    @FXML
    private TextField txt_alu_datanascimento;
    @FXML
    private TextField txt_alu_filiacao1;
    @FXML
    private TextField txt_alu_filiacao2;
    @FXML
    private TextField txt_alu_logradouro;
    @FXML
    private TextField txt_alu_bairro;
    @FXML
    private TextField txt_alu_numero;
    @FXML
    private TextField txt_alu_deficiencia;
    @FXML
    private TextField txt_alu_datacadastro;
    @FXML
    private TextField txt_alu_cidade;
    @FXML
    private ComboBox cbox_alu_estado;
    @FXML
    private ComboBox cbox_alu_nome;
    @FXML
    private TextField txt_alu_nome;
    @FXML
    private ComboBox<Turma> cbox_alu_turma;
    @FXML
    private RadioButton rad_ed_alu_feminino;
    @FXML
    private RadioButton rad_ed_alu_masculino;
    private final ObservableList ob_nulo = FXCollections.observableArrayList("");
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
    private ComboBox<Aluno> nome_aluno;
    @FXML
    private MenuItem aluno;
    @FXML
    private MenuItem funcionario;
    @FXML
    private MenuItem turma;
    @FXML
    private MenuItem listar_matriculas;
    @FXML
    private MenuItem alunos;
    @FXML
    private MenuItem funcionarios;
    @FXML
    private MenuItem turmas;
    @FXML
    private MenuItem sobre;
    @FXML
    private Button bot_salvar;
    @FXML
    private Button bot_deletar;
    @FXML
    private Button bot_editar;
    @FXML
    private Button bot_cancelar;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        add_cbox();
        add_mask();
        add_estados();
    }
    
    public void add_cbox(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("scholare");
        EntityManager em = emf.createEntityManager();
        
        /*Query query = em.createQuery("select a.alu_nome from Aluno a, Matricula m where a.alu_id = m.aluno and m.turma = :turma");
        query.setParameter("turma", cbox_alu_turma);
        List<Aluno> list_alunos = query.getResultList();
        
        ObservableList<Aluno> obaluno = FXCollections.observableArrayList(list_alunos);
        cbox_alu_nome.setItems(obaluno);*/
        
        Query queryturma = em.createQuery("select t from Turma as t order by t.tur_nome");
        List<Turma> list_turma = queryturma.getResultList();
        
        ObservableList<Turma> obturma = FXCollections.observableArrayList(list_turma);
        cbox_alu_turma.setItems(obturma);
        
        cbox_alu_nome.getSelectionModel().select("Selecione");
    }
    
    public void add_estados(){
        ObservableList ob_estados = FXCollections.observableArrayList("Acre", "Alagoas", "Amapá", "Amazonas", "Bahia", "Ceará",
                "Distrito Federal", "Espírito Santo", "Goiás", "Maranhão", "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais",
                "Pará", "Paraíba", "Paraná", "Pernambuco", "Piauí", "Rio de Janeiro", "Rio Grande do Norte", "Rio Grande do Sul",
                "Rondônias", "Roraima", "Santa Catarina", "São Paulo", "Sergipe", "Tocantins");
        cbox_alu_estado.setItems(ob_estados);
    }
    
    public void add_mask(){
        MaskFieldUtil.cpfField(txt_alu_cpf);
        MaskFieldUtil.foneField(txt_alu_telefone);
        MaskFieldUtil.numericField(txt_alu_rg);
        MaskFieldUtil.numericField(txt_alu_numero);
        MaskFieldUtil.dateField(txt_alu_datanascimento);
    }
    
    public void deshabilita_campos(){
        txt_alu_nome.setDisable(true);
        rad_ed_alu_feminino.setDisable(true);
        rad_ed_alu_masculino.setDisable(true);
        txt_alu_cpf.setDisable(true);
        txt_alu_rg.setDisable(true);
        txt_alu_telefone.setDisable(true);
        txt_alu_datanascimento.setDisable(true);
        txt_alu_filiacao1.setDisable(true);
        txt_alu_filiacao2.setDisable(true);
        txt_alu_logradouro.setDisable(true);
        txt_alu_bairro.setDisable(true);
        txt_alu_numero.setDisable(true);
        txt_alu_cidade.setDisable(true);
        cbox_alu_estado.setDisable(true);
        txt_alu_deficiencia.setDisable(true);
        bot_salvar.setDisable(true);
        cbox_alu_nome.setDisable(true);
    }
    
    public void habilita_campos(){
        txt_alu_nome.setDisable(false);
        rad_ed_alu_feminino.setDisable(false);
        rad_ed_alu_masculino.setDisable(false);
        txt_alu_cpf.setDisable(false);
        txt_alu_rg.setDisable(false);
        txt_alu_telefone.setDisable(false);
        txt_alu_datanascimento.setDisable(false);
        txt_alu_filiacao1.setDisable(false);
        txt_alu_filiacao2.setDisable(false);
        txt_alu_logradouro.setDisable(false);
        txt_alu_bairro.setDisable(false);
        txt_alu_numero.setDisable(false);
        txt_alu_cidade.setDisable(false);
        cbox_alu_estado.setDisable(false);
        txt_alu_deficiencia.setDisable(false);
        bot_salvar.setDisable(false);
    }

    public void limpar_aluno(ActionEvent event) {
        txt_alu_nome.setText("");
        rad_ed_alu_feminino.setSelected(true);
        txt_alu_cpf.setText("");
        txt_alu_rg.setText("");
        txt_alu_datanascimento.setText("");
        txt_alu_telefone.setText("");
        txt_alu_filiacao1.setText("");
        txt_alu_filiacao2.setText("");
        txt_alu_logradouro.setText("");
        txt_alu_bairro.setText("");
        txt_alu_numero.setText("");
        txt_alu_deficiencia.setText("");
        txt_alu_cidade.setText("");
        cbox_alu_estado.setValue("");
        cbox_alu_nome.setItems(ob_nulo);
    }
    
    //Funções FXML<--
    @FXML
    private void salvar_editar_aluno(ActionEvent event) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("scholare");
        EntityManager em = emf.createEntityManager();
        
        Aluno alu = (Aluno) nome_aluno.getSelectionModel().getSelectedItem();
        
        Query query = em.createQuery("select a from Aluno as a where a.alu_id = :alu_id");
        query.setParameter("alu_id", alu.getAlu_id());
        
        alu = (Aluno) query.getSingleResult();
        
        alu.setAlu_nome(txt_alu_nome.getText());
        RadioButton radioselected = (RadioButton) tg_alu_sexo.getSelectedToggle();
        String rad_alu_sexo = radioselected.getText();
        alu.setAlu_sexo(rad_alu_sexo);
        alu.setAlu_cpf(txt_alu_cpf.getText());
        alu.setAlu_rg(txt_alu_rg.getText());
        alu.setAlu_nascimento(txt_alu_datanascimento.getText());
        alu.setAlu_telefone(txt_alu_telefone.getText());
        alu.setAlu_filiacao1(txt_alu_filiacao1.getText());
        alu.setAlu_filiacao2(txt_alu_filiacao2.getText());
        alu.setAlu_logradouro(txt_alu_logradouro.getText());
        alu.setAlu_bairro(txt_alu_bairro.getText());
        alu.setAlu_numero(txt_alu_numero.getText());
        alu.setAlu_cidade(txt_alu_cidade.getText());
        alu.setAlu_estado(cbox_alu_estado.getSelectionModel().getSelectedItem().toString());
        alu.setAlu_deficiencia(txt_alu_deficiencia.getText());
        
        em.getTransaction().begin();
        em.persist(alu);
        em.getTransaction().commit();
        em.close();
        emf.close();
        
        add_cbox();
        limpar_aluno(event);
        deshabilita_campos();
    }

    @FXML
    private void deletar_editar_Aluno(ActionEvent event) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("scholare");
        EntityManager em = emf.createEntityManager();
        
        Aluno alun = (Aluno) nome_aluno.getSelectionModel().getSelectedItem();
        
        Query query = em.createQuery("select a from Aluno as a where a.alu_id = :alu_id");
        query.setParameter("alu_id", alun.getAlu_id());
        
        Query querymatricula = em.createQuery("select m from Matricula as m where m.aluno = :alu_i");
        querymatricula.setParameter("alu_i", nome_aluno.getSelectionModel().getSelectedItem());
        
        Aluno a = (Aluno) query.getSingleResult();
        Matricula m = (Matricula) querymatricula.getSingleResult();
        
        Query querynotas = em.createQuery("select n from Notas as n where n.matriculaaluno = :alu_i");
        querynotas.setParameter("alu_i", m); 
        
        List listnotas = querynotas.getResultList();
        ObservableList ob = FXCollections.observableArrayList(listnotas);
        em.getTransaction().begin();
        
        for(Object z :ob){
            em.remove(z);
        }
        /*
        for(int i = 0; i <= querynotas.getResultList().size(); i++){
            Notas[] notas = (Notas[]) ob.get(i);
            System.out.println(notas);
            em.remove(notas);  
        }*/
        
        
        em.remove(m);
        em.remove(a);
        em.getTransaction().commit();
        
        em.close();
        limpar_aluno(event);
    }

    @FXML
    private void editar_editar_aluno(ActionEvent event) {
        if(cbox_alu_nome.getSelectionModel().getSelectedItem().equals("Selecione") && (txt_alu_nome.getText().equals(""))){
            System.out.println("Selecione um Aluno");
        }
        else{
            habilita_campos();
        }   
    }

    @FXML
    private void cancelar_editar_aluno(ActionEvent event) {
        Scene novascene = Open.abrirMenu(getClass()); 
        Stage stage = (Stage) bot_cancelar.getScene().getWindow();
        stage.setScene(novascene);
    }

    @FXML
    private void selecionar(ActionEvent event) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("scholare");
            EntityManager em = emf.createEntityManager();

            Query query = em.createQuery("select a from Aluno as a where a.alu_nome = :alu_nome");
            query.setParameter("alu_nome", cbox_alu_nome.getSelectionModel().getSelectedItem().toString());
            
            nome_aluno.setItems(ob_nulo);
            if(query.getResultList().isEmpty()){
                System.out.println("Erro");
            }
            else{
                Aluno a = (Aluno) query.getSingleResult();
                editar(a);
            }
    }
    
    public void editar(Aluno a){
        nome_aluno.getSelectionModel().select(a);
        txt_alu_nome.setText(a.getAlu_nome());
        if(a.getAlu_sexo().equals("Feminino")){
            rad_ed_alu_feminino.setSelected(true);
        }
        else{
            rad_ed_alu_masculino.setSelected(true);
        }
        txt_alu_cpf.setText(a.getAlu_cpf());
        txt_alu_rg.setText(a.getAlu_rg());
        txt_alu_telefone.setText(a.getAlu_telefone());
        txt_alu_datanascimento.setText(a.getAlu_nascimento());
        txt_alu_filiacao1.setText(a.getAlu_filiacao1());
        txt_alu_filiacao2.setText(a.getAlu_filiacao2());
        txt_alu_logradouro.setText(a.getAlu_logradouro());
        txt_alu_bairro.setText(a.getAlu_bairro());
        txt_alu_numero.setText(a.getAlu_numero());
        txt_alu_cidade.setText(a.getAlu_cidade());
        cbox_alu_estado.getSelectionModel().select(a.getAlu_estado());
        txt_alu_deficiencia.setText(a.getAlu_deficiencia());
        bot_deletar.setDisable(false);
    }

    @FXML
    private void selecionar_turma(ActionEvent event) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("scholare");
        EntityManager em = emf.createEntityManager();
        
        Query query = em.createQuery("select a from Aluno as a, Matricula m where a.alu_id = m.aluno and m.turma = :turma");
        query.setParameter("turma", cbox_alu_turma.getSelectionModel().getSelectedItem());
        List<Aluno> list_alunos = query.getResultList();
        
        ObservableList<Aluno> obaluno = FXCollections.observableArrayList(list_alunos);
        limpar_aluno(event);
        cbox_alu_nome.setItems(obaluno);
        cbox_alu_nome.setDisable(false);
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