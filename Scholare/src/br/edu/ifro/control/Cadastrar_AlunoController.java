package br.edu.ifro.control;

import br.edu.ifro.model.Aluno;
import br.edu.ifro.util.Basico_Cadastro;
import br.edu.ifro.util.Open;
import br.eti.diegofonseca.MaskFieldUtil;
import java.net.URL;
import java.text.SimpleDateFormat;
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
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//@author Gabriel Pedrosa
public class Cadastrar_AlunoController implements Initializable, Basico_Cadastro {
    @FXML
    private TextField txt_alu_nome;
    @FXML
    private TextField txt_alu_cpf;
    @FXML
    private RadioButton rad_alu_feminino;
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
    private TextField txt_alu_bairro;
    @FXML
    private TextField txt_alu_numero;
    @FXML
    private TextField txt_alu_deficiencia;
    @FXML
    private TextField txt_alu_cidade;
    @FXML
    private ComboBox cbox_alu_estado;
    @FXML
    private TextField txt_alu_datacadastro;
    @FXML
    private TextField txt_alu_rua;
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
    private Button bot_cadastrar;
    @FXML
    private Button bot_limpar;
    @FXML
    private Button bot_cancelar;
    @FXML
    private MenuItem listar_matriculas;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       add_mask();
       add_data();
       add_cbox();
       add_estados();
    }
    
    @Override
    public void add_cbox(){
       
    }
    public void add_estados(){
        ObservableList ob_estados = FXCollections.observableArrayList("Acre", "Alagoas", "Amapá", "Amazonas", "Bahia", "Ceará",
                "Distrito Federal", "Espírito Santo", "Goiás", "Maranhão", "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais",
                "Pará", "Paraíba", "Paraná", "Pernambuco", "Piauí", "Rio de Janeiro", "Rio Grande do Norte", "Rio Grande do Sul",
                "Rondônias", "Roraima", "Santa Catarina", "São Paulo", "Sergipe", "Tocantins");
        cbox_alu_estado.setItems(ob_estados);
    }
    
    @Override
    public void add_mask(){
        MaskFieldUtil.cpfField(txt_alu_cpf);
        MaskFieldUtil.foneField(txt_alu_telefone);
        MaskFieldUtil.numericField(txt_alu_rg);
        MaskFieldUtil.numericField(txt_alu_numero);
        MaskFieldUtil.dateField(txt_alu_datanascimento);
    }
    
    @Override
    public void add_data(){
       java.util.Date d = new java.util.Date();
       SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
       String datasrt = (String) f.format(d);
       txt_alu_datacadastro.setText(datasrt);
    }
    
    @Override
    public boolean verifica_vazio(){
        boolean preenchido;
        boolean txt_preenchido = false;
        boolean cbox_preenchido = false;
        TextField[] campo_txt = {txt_alu_nome, txt_alu_datanascimento, txt_alu_rua, txt_alu_bairro, txt_alu_numero, txt_alu_cidade, txt_alu_deficiencia};
        ComboBox[] campo_cbox = {cbox_alu_estado};
        
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
    private void cadastrar_aluno(ActionEvent event) {
        if(verifica_vazio() == true){
            System.out.println("Campos obrigatórios preenchidos");
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("scholare");
            EntityManager em = emf.createEntityManager();
            
            Aluno a = new Aluno();
            a.setAlu_datacadastro(txt_alu_datacadastro.getText());
            a.setAlu_nome(txt_alu_nome.getText());
            RadioButton radioselected = (RadioButton) tg_alu_sexo.getSelectedToggle();
            String rad_alu_sexo = radioselected.getText();
            a.setAlu_sexo(rad_alu_sexo);
            a.setAlu_cpf(txt_alu_cpf.getText());
            a.setAlu_rg(txt_alu_rg.getText());
            a.setAlu_telefone(txt_alu_telefone.getText());
            a.setAlu_nascimento(txt_alu_datanascimento.getText());
            a.setAlu_filiacao1(txt_alu_filiacao1.getText());
            a.setAlu_filiacao2(txt_alu_filiacao2.getText());
            a.setAlu_logradouro(txt_alu_rua.getText());
            a.setAlu_bairro(txt_alu_bairro.getText());
            a.setAlu_numero(txt_alu_numero.getText());
            a.setAlu_cidade(txt_alu_cidade.getText());
            a.setAlu_estado(cbox_alu_estado.getSelectionModel().getSelectedItem().toString());
            a.setAlu_deficiencia(txt_alu_deficiencia.getText());
            
            limpar_aluno(event);
            
            em.getTransaction().begin();
            em.persist(a);
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
    private void limpar_aluno(ActionEvent event) {
        txt_alu_nome.setText("");
        rad_alu_feminino.setSelected(true);
        txt_alu_cpf.setText("");
        txt_alu_rg.setText("");
        txt_alu_datanascimento.setText("");
        txt_alu_telefone.setText("");
        txt_alu_filiacao1.setText("");
        txt_alu_filiacao2.setText("");
        txt_alu_rua.setText("");
        txt_alu_bairro.setText("");
        txt_alu_numero.setText("");
        txt_alu_deficiencia.setText("");
        txt_alu_cidade.setText("");
        cbox_alu_estado.setValue("");
    }

    @FXML
    private void sair_aluno(ActionEvent event) {
        Scene novascene = Open.abrirMenu(getClass()); 
        Stage stage = (Stage) bot_cancelar.getScene().getWindow();
        stage.setScene(novascene);
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