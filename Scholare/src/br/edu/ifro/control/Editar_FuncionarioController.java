package br.edu.ifro.control;

import br.edu.ifro.model.Disciplina;
import br.edu.ifro.model.Funcionario;
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
    private ComboBox cbox_fun_nome;
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
    private TextField txt_fun_datacadastro;
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
    private TextField txt_fun_complemento;
    @FXML
    private TableView<Disciplina> tb_fun_disciplina;
    @FXML
    private ComboBox<Disciplina> cbox_fun_disciplina;
    @FXML
    private Button bot_fun_disciplina;
    @FXML
    private TextField txt_fun_resposta;
    @FXML
    private ComboBox cbox_fun_pergunta;
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
    private ComboBox nome_funcionario;
    @FXML
    private ToggleGroup tg_sexo;
    @FXML
    private Button bot_fun_disciplin;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        inicia();
        deshabilita_campos();
        add_disciplinas();
    }

    public void inicia(){
        add_cbox();
    }
    
    public void add_cbox(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("scholare");
        EntityManager em = emf.createEntityManager();
        
        Query query = em.createQuery("select f from Funcionario as f");
        List<Funcionario> list_funcionario = query.getResultList();
        
        ObservableList obfuncionario = FXCollections.observableArrayList(list_funcionario);
        cbox_fun_nome.setItems(obfuncionario);
        cbox_fun_nome.getSelectionModel().select("Selecione");
        
        ObservableList ob_funcao = FXCollections.observableArrayList("Secretária", "Professor");
        cbox_fun_funcao.setItems(ob_funcao);
                
        ObservableList ob_pergunta = FXCollections.observableArrayList("Qual o Nome do Seu Cachorro?", "Qual o nome da Sua Mãe?");
        cbox_fun_pergunta.setItems(ob_pergunta);
        
        add_estados();
    }
    public void add_estados(){
        ObservableList ob_estados = FXCollections.observableArrayList("Acre", "Alagoas", "Amapá", "Amazonas", "Bahia", "Ceará",
                "Distrito Federal", "Espírito Santo", "Goiás", "Maranhão", "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais",
                "Pará", "Paraíba", "Paraná", "Pernambuco", "Piauí", "Rio de Janeiro", "Rio Grande do Norte", "Rio Grande do Sul",
                "Rondônias", "Roraima", "Santa Catarina", "São Paulo", "Sergipe", "Tocantins");
        cbox_fun_estado.setItems(ob_estados);
    }
    
    public void add_disciplinas(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("scholare");
        EntityManager em = emf.createEntityManager();
        
        Query querydisciplina = em.createQuery("select d from Disciplina as d");
        List<Disciplina> list_disciplina = querydisciplina.getResultList();
        
        ObservableList<Disciplina> obdisciplina = FXCollections.observableArrayList(list_disciplina);
        cbox_fun_disciplina.setItems(obdisciplina);
    }
    
    public void add_mask(){
        MaskFieldUtil.cpfField(txt_fun_cpf);
        MaskFieldUtil.foneField(txt_fun_telefone);
        MaskFieldUtil.numericField(txt_fun_rg);
        MaskFieldUtil.numericField(txt_fun_numero);
        MaskFieldUtil.dateField(txt_fun_datanascimento);
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
        txt_fun_complemento.setDisable(true);
        txt_fun_cidade.setDisable(true);
        cbox_fun_estado.setDisable(true);
        txt_fun_email.setDisable(true);
        txt_fun_resposta.setDisable(true);
        cbox_fun_pergunta.setDisable(true);
        bot_salvar.setDisable(true);
        bot_deletar.setDisable(true);
        tb_fun_disciplina.setDisable(true);
        cbox_fun_disciplina.setDisable(true);
        bot_fun_disciplina.setDisable(true);
        bot_fun_disciplin.setDisable(true);
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
        txt_fun_complemento.setDisable(false);
        txt_fun_cidade.setDisable(false);
        cbox_fun_estado.setDisable(false);
        txt_fun_email.setDisable(false);
        txt_fun_resposta.setDisable(false);
        cbox_fun_pergunta.setDisable(false);
        bot_deletar.setDisable(false);
        bot_salvar.setDisable(false);
        tb_fun_disciplina.setDisable(false);
        cbox_fun_disciplina.setDisable(false);
        bot_fun_disciplina.setDisable(false);
        bot_fun_disciplin.setDisable(false);
        
    }
    
    public void limpar_professor(ActionEvent event) {
        txt_fun_nome.setText("");
        txt_fun_cpf.setText("");
        txt_fun_rg.setText("");
        txt_fun_telefone.setText("");
        txt_fun_datanascimento.setText("");
        txt_fun_cidade.setText("");
        cbox_fun_estado.setValue(null);
        cbox_fun_pergunta.setValue(null);
        txt_fun_email.setText("");
        txt_fun_logradouro.setText("");
        txt_fun_bairro.setText("");
        txt_fun_numero.setText("");
        cbox_fun_funcao.setValue(null);
        txt_fun_usuario.setText("");
        pw_fun_senha.setText("");
        txt_fun_resposta.setText("");
        txt_fun_complemento.setText("");
        pw_fun_confirmarsenha.setText("");
        tb_fun_disciplina.setItems(null);
    }
    
    //Funções FXML<--
    @FXML
    private void salvar_editar_funcionario(ActionEvent event) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("scholare");
        EntityManager em = emf.createEntityManager();
        
        Funcionario fun = (Funcionario) nome_funcionario.getSelectionModel().getSelectedItem();
        
        Query query = em.createQuery("select f from Funcionario as f where f.fun_id = :fun_id");
        query.setParameter("fun_id", fun.getFun_id());
        
        fun = (Funcionario) query.getSingleResult();
        
        fun.setFun_nome(txt_fun_nome.getText());
        RadioButton radioselected = (RadioButton) tg_sexo.getSelectedToggle();
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
        fun.setFun_complemento(txt_fun_complemento.getText());
        fun.setFun_cidade(txt_fun_cidade.getText());
        fun.setFun_estado(cbox_fun_estado.getSelectionModel().getSelectedItem().toString());
        fun.setFun_email(txt_fun_email.getText());
        fun.setLog_usuario(txt_fun_usuario.getText());
        fun.setLog_senha(pw_fun_senha.getText());
        fun.setLog_pergunta(cbox_fun_pergunta.getSelectionModel().getSelectedItem().toString());
        fun.setLog_resposta(txt_fun_resposta.getText());
        
        if(cbox_fun_funcao.getSelectionModel().getSelectedItem().equals("Secretária")){
            fun.setDisciplina(null);
        }else{
            ObservableList<Disciplina> ob_disciplinas;
            ob_disciplinas = FXCollections.observableArrayList(tb_fun_disciplina.getItems());
            List<Disciplina> listaDis = ob_disciplinas.subList(0, ob_disciplinas.size());
            fun.setDisciplina(listaDis);
        }
        
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
        
        Funcionario func = (Funcionario) nome_funcionario.getSelectionModel().getSelectedItem();
        
        Query query =em.createQuery("select f from Funcionario as f where f.fun_id = :fun_id");
        query.setParameter("fun_id", func.getFun_id());
        
        Query queryturma = em.createQuery("select t from Turma as t, Funcionario as f where f.fun_id = :id");
        queryturma.setParameter("id", func.getFun_id()); 
        
        Turma t = (Turma) queryturma.getSingleResult();;
        /*
        
        
        Query queryfun = em.createQuery("select f from Funcionario as f, Turma as t where t.tur_id = :id and f.fun_id = :idd");
        queryfun.setParameter("id", t.getTur_id());
        queryfun.setParameter("idd", func.getFun_id());
        
        ObservableList<Funcionario> ob_fun= FXCollections.observableArrayList(queryfun.getResultList());
        tb_turmas.setItems(ob_fun);
        
        ObservableList<Funcionario> ob_funcionario;
        ob_funcionario = FXCollections.observableArrayList(tb_turmas.getItems());
        List<Funcionario> listafun = ob_funcionario.subList(0, ob_funcionario.size());*/
        t.setFuncionario(null);
        
        em.getTransaction().begin();
        em.persist(t);
        em.getTransaction().commit();
        
        em.getTransaction().begin();
        Object c=em.merge(func);
        em.remove(c);
        em.getTransaction().commit();
        
        em.close();
    }

    @FXML
    private void editar_editar_funcionario(ActionEvent event) {
        if(cbox_fun_nome.getSelectionModel().getSelectedItem().equals("Selecione")&& (txt_fun_nome.getText().equals(""))){
            System.out.println("Selecione um Funcionario");
        }
        else{
            habilita_campos();
        } 
    }

    @FXML
    private void cancelar_editar_funcionario(ActionEvent event) {
        Scene novascene = Open.abrirMenu(getClass()); 
        Stage stage = (Stage) bot_cancelar.getScene().getWindow();
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
            Funcionario f = (Funcionario) query.getSingleResult();
            editar(f);
        }
        deshabilita_campos();
    }
    
    public void editar(Funcionario f){
        nome_funcionario.setValue(f);
        txt_fun_nome.setText(f.getFun_nome());
        if(f.getFun_sexo().equals("Feminino")){
            rad_fun_feminino.setSelected(true);
            rad_fun_masculino.setSelected(false);
        }
        else{
            rad_fun_masculino.setSelected(true);
            rad_fun_feminino.setSelected(false);
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
        txt_fun_complemento.setText(f.getFun_complemento());
        txt_fun_cidade.setText(f.getFun_cidade());
        cbox_fun_estado.getSelectionModel().select(f.getFun_estado());
        txt_fun_email.setText(f.getFun_email());
        cbox_fun_pergunta.getSelectionModel().select(f.getLog_pergunta());
        txt_fun_resposta.setText(f.getLog_resposta());
        ObservableList<Disciplina> obdisciplina = FXCollections.observableArrayList(f.getDisciplina());
        
        ObservableList<Disciplina> a = cbox_fun_disciplina.getItems();
        cbox_fun_disciplina.setItems(a);
        for(Disciplina z :obdisciplina){
            Disciplina h = null;
            for(Disciplina y : a){
                if(y.getDis_id() == z.getDis_id()){
                    h = y;
                }
            }
            if(h != null){
            a.remove(h);
            }
        }
        
        
        tb_fun_disciplina.setItems(obdisciplina);
        bot_deletar.setDisable(false);
        
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
    private void fun_remover(ActionEvent event) {
        Disciplina d = tb_fun_disciplina.getSelectionModel().getSelectedItem();
        if(d == null){
            System.out.println("Tabela Vazio");
        }else{
        ObservableList a = tb_fun_disciplina.getItems();
        ObservableList b = cbox_fun_disciplina.getItems();
        a.remove(d);
        b.add(d);
        tb_fun_disciplina.setItems(a);
        cbox_fun_disciplina.setItems(b);
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
