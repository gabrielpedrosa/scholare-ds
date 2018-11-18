package br.edu.ifro.control;

import br.edu.ifro.model.Disciplina;
import br.edu.ifro.model.Funcionario;
import br.edu.ifro.util.Essencial;
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
public class Cadastrar_FuncionarioController implements Initializable, Essencial {
    @FXML
    private Button bot_pro_cadastrar;
    @FXML
    private Button bot_pro_limpar;
    @FXML
    private Button bot_pro_sair;
    @FXML
    private TextField txt_fun_datacadastro;
    @FXML
    private TextField txt_fun_nome;
    @FXML
    private RadioButton rad_fun_feminino;
    @FXML
    private ToggleGroup tg_fun_sexo;
    @FXML
    private RadioButton rad_fun_masculino;
    @FXML
    private TextField txt_fun_cpf;
    @FXML
    private TextField txt_fun_rg;
    @FXML
    private TextField txt_fun_telefone;
    @FXML
    private TextField txt_fun_datanascimento;
    @FXML
    private TextField txt_fun_cidade;
    @FXML
    private ComboBox cbox_fun_estado;
    @FXML
    private TextField txt_fun_email;
    @FXML
    private TextField txt_fun_logradouro;
    @FXML
    private TextField txt_fun_bairro;
    @FXML
    private TextField txt_fun_numero;
    @FXML
    private ComboBox cbox_fun_funcao;
    @FXML
    private TextField txt_fun_usuario;
    @FXML
    private PasswordField pw_fun_senha;
    @FXML
    private PasswordField pw_fun_confirmarsenha;
    @FXML
    private TextField txt_fun_complemento;
    @FXML
    private TableView<Disciplina> tb_fun_disciplina;
    @FXML
    private ComboBox<Disciplina> cbox_fun_disciplina;
    @FXML
    private TextField txt_fun_resposta;
    @FXML
    private ComboBox<?> cbox_fun_pergunta;
    @FXML
    private Button bot_fun_disciplina;
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
    private final ObservableList ob_nulo = FXCollections.observableArrayList("");
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
    
    @Override
    public void inicia(){
        add_mask();
        add_disciplinas();
        add_cbox();
        add_data();
    }
    
    @Override
    public void add_cbox(){
        ObservableList ob_estados = FXCollections.observableArrayList("ACRE", "RONDONIA", "MATO GROSSO", "MATO GROSSO DO SUL");
        cbox_fun_estado.setItems(ob_estados);
        
        ObservableList ob_funcao = FXCollections.observableArrayList("Secretária", "Professor");
        cbox_fun_funcao.setItems(ob_funcao);
                
        ObservableList ob_pergunta = FXCollections.observableArrayList("Pergunta", "Pergunta 02");
        cbox_fun_pergunta.setItems(ob_pergunta);
    }
    
    public void add_mask(){
        MaskFieldUtil.cpfField(txt_fun_cpf);
        MaskFieldUtil.foneField(txt_fun_telefone);
        MaskFieldUtil.numericField(txt_fun_rg);
        MaskFieldUtil.numericField(txt_fun_numero);
        MaskFieldUtil.dateField(txt_fun_datanascimento);
    }
    
    public void add_data(){
        java.util.Date d = new java.util.Date();
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
        String datasrt = (String) f.format(d);
        txt_fun_datacadastro.setText(datasrt);
    }
    
    public boolean verifica_vazio(){
        boolean preenchido;
        boolean txt_preenchido = false;
        boolean cbox_preenchido = false;
        TextField[] campo_txt = {txt_fun_nome, txt_fun_cpf, txt_fun_rg, txt_fun_datanascimento, txt_fun_logradouro, txt_fun_bairro, txt_fun_numero, txt_fun_cidade, txt_fun_usuario, pw_fun_senha, pw_fun_confirmarsenha};
        ComboBox[] campo_cbox = {cbox_fun_estado, cbox_fun_funcao, cbox_fun_pergunta};
        
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
    
    public boolean verifica_senha(){
        boolean igual;
        igual = pw_fun_senha.getText().equals(pw_fun_confirmarsenha.getText());
        
        return igual;
    }
    
    public void desabilita(){
        cbox_fun_disciplina.setDisable(true);
        tb_fun_disciplina.setDisable(true);
        bot_fun_disciplina.setDisable(true);
    }
    
    public void add_disciplinas(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("scholare");
        EntityManager em = emf.createEntityManager();
        
        Query querydisciplina = em.createQuery("select d from Disciplina as d");
        List<Disciplina> list_disciplina = querydisciplina.getResultList();
        
        ObservableList<Disciplina> obdisciplina = FXCollections.observableArrayList(list_disciplina);
        cbox_fun_disciplina.setItems(obdisciplina);
    }
    
    //Funções FXML<--
    @FXML
    private void cadastrar_professor(ActionEvent event) {
        if(verifica_vazio() == true){
            System.out.println("Campos obrigatórios preenchidos");
            if(verifica_senha() == true){
                System.out.println("Senhas Conferem");
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("scholare");
                EntityManager em = emf.createEntityManager();

                Funcionario p = new Funcionario();
                p.setFun_nome(txt_fun_nome.getText());
                p.setFun_cpf(txt_fun_cpf.getText());
                p.setFun_rg(txt_fun_rg.getText());
                RadioButton radioselected = (RadioButton) tg_fun_sexo.getSelectedToggle();
                String rad_pro_sexo = radioselected.getText();
                p.setFun_sexo(rad_pro_sexo);
                p.setFun_nascimento(txt_fun_datanascimento.getText());
                p.setFun_telefone(txt_fun_telefone.getText());
                p.setFun_email(txt_fun_email.getText());
                p.setFun_funcao(cbox_fun_funcao.getSelectionModel().getSelectedItem().toString());
                p.setFun_logradouro(txt_fun_logradouro.getText());
                p.setFun_bairro(txt_fun_bairro.getText());
                p.setFun_numero(txt_fun_numero.getText());
                p.setFun_cidade(txt_fun_cidade.getText());
                p.setFun_estado(cbox_fun_estado.getSelectionModel().getSelectedItem().toString());
                p.setFun_datacadastro(txt_fun_datacadastro.getText());
                
                if(cbox_fun_funcao.getSelectionModel().getSelectedItem().equals("Secretária")){
                    p.setDisciplina(null);
                }else{
                    ObservableList<Disciplina> ob_disciplinas;
                    ob_disciplinas = FXCollections.observableArrayList(tb_fun_disciplina.getItems());
                    List<Disciplina> listaDis = ob_disciplinas.subList(0, ob_disciplinas.size());
                    p.setDisciplina(listaDis);
                }

                p.setLog_usuario(txt_fun_usuario.getText());
                p.setLog_senha(pw_fun_senha.getText());
                p.setLog_pergunta(cbox_fun_pergunta.getSelectionModel().getSelectedItem().toString());
                p.setLog_resposta(txt_fun_resposta.getText());

                limpar_professor(event);
                
                em.getTransaction().begin();
                em.persist(p);
                em.getTransaction().commit();
                em.close();
                emf.close();
                
                Open.abrirSucesso(getClass()); 
            }
            else{
                System.out.println("Senhas não Conferem");
            }
            
        }
        else{
             Open.abrirErro(getClass());
        } 
    }

    @FXML
    private void limpar_professor(ActionEvent event) {
        txt_fun_nome.setText("");
        txt_fun_cpf.setText("");
        txt_fun_rg.setText("");
        txt_fun_telefone.setText("");
        txt_fun_datanascimento.setText("");
        txt_fun_cidade.setText("");
        cbox_fun_estado.setValue("");
        txt_fun_email.setText("");
        txt_fun_logradouro.setText("");
        txt_fun_bairro.setText("");
        txt_fun_numero.setText("");
        txt_fun_complemento.setText("");
        cbox_fun_funcao.setValue("");
        txt_fun_usuario.setText("");
        pw_fun_senha.setText("");
        pw_fun_confirmarsenha.setText("");
        cbox_fun_pergunta.setValue(null);
        txt_fun_resposta.setText("");
        tb_fun_disciplina.setItems(ob_nulo);
        cbox_fun_disciplina.setDisable(true);
        tb_fun_disciplina.setDisable(true);
        bot_fun_disciplina.setDisable(true);
        add_disciplinas();
    }

    @FXML
    private void sair_professor(ActionEvent event) {
        Scene novascene = Open.abrirMenu(getClass()); 
        Stage stage = (Stage) bot_pro_sair.getScene().getWindow();
        stage.setScene(novascene);
    }
    
    @FXML
    private void fun_inserir(ActionEvent event) {
        String cbox_disciplina = cbox_fun_disciplina.getSelectionModel().getSelectedItem().toString();
        ObservableList<Disciplina> ob_lastdisciplina = FXCollections.observableArrayList(tb_fun_disciplina.getItems());
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("scholare");
        EntityManager em = emf.createEntityManager();
        
        Query query = em.createQuery("select d from Disciplina as d where d.dis_nome = :dis_nome");
        query.setParameter("dis_nome", cbox_disciplina);
        
        List<Disciplina> list_disciplina = query.getResultList();
        list_disciplina.addAll(ob_lastdisciplina);
        
        ObservableList<Disciplina> ob_disciplina = FXCollections.observableArrayList(list_disciplina);

        tb_fun_disciplina.setItems(ob_disciplina);
        
        Disciplina d = cbox_fun_disciplina.getSelectionModel().getSelectedItem();
        ObservableList a = cbox_fun_disciplina.getItems();
        a.remove(d);
        cbox_fun_disciplina.setItems(a);
    }

    @FXML
    private void verifica_funcao(ActionEvent event) {
        if(cbox_fun_funcao.getSelectionModel().getSelectedItem().equals("Secretária")){
            cbox_fun_disciplina.setDisable(true);
            tb_fun_disciplina.setDisable(true);
            bot_fun_disciplina.setDisable(true);
        }
        else{
            cbox_fun_disciplina.setDisable(false);
            tb_fun_disciplina.setDisable(false);
            bot_fun_disciplina.setDisable(false);
        }
    }
    //Funções FXML-->

    //Funções Menu<--
    @FXML
    private void aluno(ActionEvent event){
        Scene novascene = Open.abrirAluno(getClass()); 
        Stage stage = (Stage) bot_pro_sair.getScene().getWindow();
        stage.setScene(novascene);
    }
    @FXML
    private void funcionario(ActionEvent event) {
        Scene novascene = Open.abrirFuncionario(getClass()); 
        Stage stage = (Stage) bot_pro_sair.getScene().getWindow();
        stage.setScene(novascene);
    }
    @FXML
    private void turma(ActionEvent event) {
        Scene novascene = Open.abrirTurma(getClass()); 
        Stage stage = (Stage) bot_pro_sair.getScene().getWindow();
        stage.setScene(novascene);
    }
    @FXML
    private void alunos(ActionEvent event) {
        Scene novascene = Open.abrirExibirAluno(getClass()); 
        Stage stage = (Stage) bot_pro_sair.getScene().getWindow();
        stage.setScene(novascene);
    }
    @FXML
    private void funcionarios(ActionEvent event) {
        Scene novascene = Open.abrirExibirFuncionario(getClass()); 
        Stage stage = (Stage) bot_pro_sair.getScene().getWindow();
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
        Stage stage = (Stage) bot_pro_sair.getScene().getWindow();
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
}
