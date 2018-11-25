package br.edu.ifro.control;

import br.edu.ifro.model.Funcionario;
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
import javafx.scene.control.PasswordField;
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
public class Editar_FuncionarioController implements Initializable {
    @FXML
    private Label window_nome;
    @FXML
    private Button bot_fun_cancelar;
    @FXML
    private TextField txt_fun_cpf;
    @FXML
    private RadioButton rad_fun_feminino;
    @FXML
    private RadioButton rad_fun_masculino;
    @FXML
    private TextField txt_fun_rg;
    @FXML
    private TextField txt_fun_telefone;
    @FXML
    private TextField txt_fun_datanascimento;
    @FXML
    private TextField txt_fun_logradouro;
    @FXML
    private TextField txt_fun_bairro;
    @FXML
    private TextField txt_fun_numero;
    @FXML
    private TextField txt_fun_email;
    @FXML
    private TextField txt_fun_cidade;
    @FXML
    private ComboBox cbox_fun_estado;
    @FXML
    private ComboBox<Funcionario> cbox_fun_nome;
    @FXML
    private TextField txt_fun_nome;
    @FXML
    private ComboBox cbox_fun_funcao;
    @FXML
    private TextField txt_fun_usuario;
    @FXML
    private PasswordField pw_fun_senha;
    @FXML
    private PasswordField pw_fun_confirmarsenha;
    @FXML
    private ToggleGroup tg_fun_sexo;
    @FXML
    private Button bot_fun_salvar;
    @FXML
    private Button bot_fun_deletar;
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
    private Button bot_fun_editar;
    @FXML
    private TextField txt_fun_datacadastro;
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
    @FXML
    private TextField txt_fun_complemento;
    @FXML
    private TableView<?> tb_fun_disciplina;
    @FXML
    private ComboBox<?> cbox_fun_disciplina;
    @FXML
    private Button bot_fun_disciplina;
    @FXML
    private TextField txt_fun_resposta;
    @FXML
    private ComboBox<?> cbox_fun_pergunta;
    
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
        
        Query query = em.createQuery("select f from Funcionario as f");
        List<Funcionario> list_funcionario = query.getResultList();
        
        ObservableList<Funcionario> obfuncionario = FXCollections.observableArrayList(list_funcionario);
        cbox_fun_nome.setItems(obfuncionario);
    }
    
    public void deshabilita_campos(){
        txt_fun_nome.setDisable(true);
        rad_fun_feminino.setDisable(true);
        rad_fun_masculino.setDisable(true);
        txt_fun_cpf.setDisable(true);
        txt_fun_rg.setDisable(true);
        txt_fun_telefone.setDisable(true);
        txt_fun_datanascimento.setDisable(true);
        cbox_fun_funcao.setDisable(true);
        txt_fun_usuario.setDisable(true);
        pw_fun_senha.setDisable(true);
        pw_fun_confirmarsenha.setDisable(true);
        txt_fun_logradouro.setDisable(true);
        txt_fun_bairro.setDisable(true);
        txt_fun_numero.setDisable(true);
        txt_fun_cidade.setDisable(true);
        cbox_fun_estado.setDisable(true);
        txt_fun_email.setDisable(true);
        bot_fun_salvar.setDisable(true);
        bot_fun_deletar.setDisable(true);
    }
    
    public void habilita_campos(){
        txt_fun_nome.setDisable(false);
        rad_fun_feminino.setDisable(false);
        rad_fun_masculino.setDisable(false);
        txt_fun_cpf.setDisable(false);
        txt_fun_rg.setDisable(false);
        txt_fun_telefone.setDisable(false);
        txt_fun_datanascimento.setDisable(false);
        cbox_fun_funcao.setDisable(false);
        txt_fun_usuario.setDisable(false);
        pw_fun_senha.setDisable(false);
        pw_fun_confirmarsenha.setDisable(false);
        txt_fun_logradouro.setDisable(false);
        txt_fun_bairro.setDisable(false);
        txt_fun_numero.setDisable(false);
        txt_fun_cidade.setDisable(false);
        cbox_fun_estado.setDisable(false);
        txt_fun_email.setDisable(false);
        bot_fun_deletar.setDisable(false);
        bot_fun_salvar.setDisable(false);
    }
    
    public void limpar_professor(ActionEvent event) {
        txt_fun_nome.setText("");
        txt_fun_cpf.setText("");
        txt_fun_rg.setText("");
        txt_fun_telefone.setText("");
        txt_fun_datanascimento.setText("");
        txt_fun_cidade.setText("");
        cbox_fun_estado.setValue(null);
        txt_fun_email.setText("");
        txt_fun_logradouro.setText("");
        txt_fun_bairro.setText("");
        txt_fun_numero.setText("");
        cbox_fun_funcao.setValue(null);
        txt_fun_usuario.setText("");
        pw_fun_senha.setText("");
        pw_fun_confirmarsenha.setText("");
    }
    
    //Funções FXML<--
    @FXML
    private void salvar_editar_funcionario(ActionEvent event) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("scholare");
        EntityManager em = emf.createEntityManager();
        
        Funcionario fun = (Funcionario) cbox_fun_nome.getSelectionModel().getSelectedItem();
        
        Query query = em.createQuery("select f from Funcionario as f where f.fun_id = :fun_id");
        query.setParameter("fun_id", fun.getFun_id());
        
        fun = (Funcionario) query.getSingleResult();
        
        fun.setFun_nome(txt_fun_nome.getText());
        RadioButton radioselected = (RadioButton) tg_fun_sexo.getSelectedToggle();
        String rad_fun_sexo = radioselected.getText();
        fun.setFun_sexo(rad_fun_sexo);
        fun.setFun_cpf(txt_fun_cpf.getText());
        fun.setFun_rg(txt_fun_rg.getText());
        fun.setFun_telefone(txt_fun_telefone.getText());
        fun.setFun_nascimento(txt_fun_datanascimento.getText());
        fun.setFun_funcao(cbox_fun_funcao.getSelectionModel().getSelectedItem().toString());
        fun.setFun_logradouro(txt_fun_logradouro.getText());
        fun.setFun_bairro(txt_fun_bairro.getText());
        fun.setFun_numero(txt_fun_numero.getText());
        fun.setFun_cidade(txt_fun_cidade.getText());
        fun.setFun_estado(cbox_fun_estado.getSelectionModel().getSelectedItem().toString());
        fun.setFun_email(txt_fun_email.getText());
        fun.setLog_usuario(txt_fun_usuario.getText());
        fun.setLog_senha(pw_fun_senha.getText());
        fun.setLog_pergunta(null);
        fun.setLog_resposta(null);
        
        limpar_professor(event);
        
        em.getTransaction().begin();
        em.persist(fun);
        em.getTransaction().commit();
        em.close();
        emf.close();
        
        add_cbox();
        deshabilita_campos();
    }

    @FXML
    private void deletar_editar_funcionario(ActionEvent event) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("scholare");
        EntityManager em = emf.createEntityManager();
        
        Funcionario func = (Funcionario) cbox_fun_nome.getSelectionModel().getSelectedItem();
        
        Query query =em.createQuery("select a from Aluno as a where a.alu_id = :alu_id");
        query.setParameter("alu_id", func.getFun_id());
        
        Funcionario f = (Funcionario) query.getSingleResult();
        
        em.getTransaction().begin();
        em.remove(f);
        em.getTransaction().commit();
        
        em.close();
    }

    @FXML
    private void editar_editar_funcionario(ActionEvent event) {
        if(cbox_fun_nome.getSelectionModel().getSelectedIndex()==-1){
            System.out.println("Selecione um Aluno");
        }
        else{
            habilita_campos();
        } 
    }

    @FXML
    private void cancelar_editar_funcionario(ActionEvent event) {
        Scene novascene = Open.abrirMenu(getClass()); 
        Stage stage = (Stage) bot_fun_cancelar.getScene().getWindow();
        stage.setScene(novascene);
    }

    @FXML
    private void selecionar(ActionEvent event) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("scholare");
        EntityManager em = emf.createEntityManager();
        
        Query query =em.createQuery("select f from Funcionario as f where f.fun_nome = :fun_nome");
        query.setParameter("fun_nome", cbox_fun_nome.getSelectionModel().getSelectedItem().toString());
        
        if(query.getResultList().isEmpty()){
            System.out.println("Erro");
        }
        else{
            deshabilita_campos();
            
            Funcionario f = (Funcionario) query.getSingleResult();
            editar(f);
        }
    }
    
    public void editar(Funcionario f){
        
        txt_fun_nome.setText(f.getFun_nome());
        if(f.getFun_sexo().equals("Feminino")){
            rad_fun_feminino.setSelected(true);
        }
        else{
            rad_fun_masculino.setSelected(true);
        }
        txt_fun_cpf.setText(f.getFun_nome());
        txt_fun_rg.setText(f.getFun_rg());
        txt_fun_telefone.setText(f.getFun_telefone());
        txt_fun_datanascimento.setText(f.getFun_nascimento());
        cbox_fun_funcao.getSelectionModel().select(f.getFun_funcao());
        txt_fun_usuario.setText(f.getLog_usuario());
        pw_fun_senha.setText(f.getLog_senha());
        pw_fun_confirmarsenha.setText(f.getLog_senha());
        txt_fun_logradouro.setText(f.getFun_logradouro());
        txt_fun_bairro.setText(f.getFun_bairro());
        txt_fun_numero.setText(f.getFun_numero());
        txt_fun_cidade.setText(f.getFun_cidade());
        cbox_fun_estado.getSelectionModel().select(f.getFun_estado());
        txt_fun_email.setText(f.getFun_email());
        
        bot_fun_deletar.setDisable(false);
        
    }
    //Funções FXML-->
    
    //Funções Menu<--
    @FXML
    private void aluno(ActionEvent event){
        Scene novascene = Open.abrirAluno(getClass()); 
        Stage stage = (Stage) bot_fun_deletar.getScene().getWindow();
        stage.setScene(novascene);
    }
    @FXML
    private void funcionario(ActionEvent event) {
        Scene novascene = Open.abrirFuncionario(getClass()); 
        Stage stage = (Stage) bot_fun_deletar.getScene().getWindow();
        stage.setScene(novascene);
    }
    @FXML
    private void turma(ActionEvent event) {
        Scene novascene = Open.abrirTurma(getClass()); 
        Stage stage = (Stage) bot_fun_deletar.getScene().getWindow();
        stage.setScene(novascene);
    }
    @FXML
    private void alunos(ActionEvent event) {
        Scene novascene = Open.abrirExibirAluno(getClass()); 
        Stage stage = (Stage) bot_fun_deletar.getScene().getWindow();
        stage.setScene(novascene);
    }
    @FXML
    private void funcionarios(ActionEvent event) {
        Scene novascene = Open.abrirExibirFuncionario(getClass()); 
        Stage stage = (Stage) bot_fun_deletar.getScene().getWindow();
        stage.setScene(novascene);
    }
    @FXML
    private void turmas(ActionEvent event) {
        
    }
    @FXML
    private void sobre(ActionEvent event) {
        
    }
    @FXML
    private void listar_alunos(ActionEvent event) {
        Scene novascene = Open.abrirListarAluno(getClass()); 
        Stage stage = (Stage) bot_fun_deletar.getScene().getWindow();
        stage.setScene(novascene);
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
    //Funções Menu-->

    @FXML
    private void verifica_funcao(ActionEvent event) {
    }

    @FXML
    private void fun_inserir(ActionEvent event) {
    }
}
