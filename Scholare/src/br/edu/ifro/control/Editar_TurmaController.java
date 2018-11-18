package br.edu.ifro.control;

import br.edu.ifro.util.Open;
import java.net.URL;
import java.util.ResourceBundle;
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

//@author Gabriel Pedrosa
public class Editar_TurmaController implements Initializable {
    @FXML
    private RadioButton rad_tur_a;
    @FXML
    private ToggleGroup tg_tur_turno;
    @FXML
    private RadioButton rad_tur_b;
    @FXML
    private Button bot_tur_cancelar;
    @FXML
    private ComboBox<?> cbox_tur_ano;
    @FXML
    private ComboBox<?> cbox_tur_tipo;
    @FXML
    private TableView<?> tb_tur_professores;
    @FXML
    private ComboBox<?> cbox_tur_serie_ano;
    @FXML
    private Label window_nome;
    @FXML
    private Button bot_tur_salvar;
    @FXML
    private Button bot_tur_deletar;
    @FXML
    private Button bot_tur_editar;
    @FXML
    private TextField txt_tur_datacadastro;
    @FXML
    private ComboBox<?> cbox_tur_nome;
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
    private MenuItem lsitar_matriculas;
    @FXML
    private MenuItem matriculas;
    @FXML
    private MenuItem relatorio_diario;
    @FXML
    private MenuItem ata_de_resultados;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    public void inicia(){
        
    }
    
    public void add_cbox(){
    
    }

    //Funções FXML<--
    @FXML
    private void salvar_editar_turma(ActionEvent event) {
    }

    @FXML
    private void deletar_editar_turma(ActionEvent event) {
    }

    @FXML
    private void editar_editar_turma(ActionEvent event) {
    }

    @FXML
    private void cancelar_editar_turma(ActionEvent event) {
        Scene novascene = Open.abrirMenu(getClass()); 
        Stage stage = (Stage) bot_tur_cancelar.getScene().getWindow();
        stage.setScene(novascene);
    }

    @FXML
    private void selecionar(ActionEvent event) {
    }
    //Funções FXML-->

    //Funções Menu<--
    @FXML
    private void aluno(ActionEvent event){
        Scene novascene = Open.abrirAluno(getClass()); 
        Stage stage = (Stage) bot_tur_editar.getScene().getWindow();
        stage.setScene(novascene);
    }
    @FXML
    private void funcionario(ActionEvent event) {
        Scene novascene = Open.abrirFuncionario(getClass()); 
        Stage stage = (Stage) bot_tur_editar.getScene().getWindow();
        stage.setScene(novascene);
    }
    @FXML
    private void turma(ActionEvent event) {
        Scene novascene = Open.abrirTurma(getClass()); 
        Stage stage = (Stage) bot_tur_editar.getScene().getWindow();
        stage.setScene(novascene);
    }
    @FXML
    private void alunos(ActionEvent event) {
        Scene novascene = Open.abrirExibirAluno(getClass()); 
        Stage stage = (Stage) bot_tur_editar.getScene().getWindow();
        stage.setScene(novascene);
    }
    @FXML
    private void funcionarios(ActionEvent event) {
        Scene novascene = Open.abrirExibirFuncionario(getClass()); 
        Stage stage = (Stage) bot_tur_editar.getScene().getWindow();
        stage.setScene(novascene);
    }
    @FXML
    private void turmas(ActionEvent event) {
    }
    @FXML
    private void sobre(ActionEvent event) {
    }
    //Funções Menu-->

    @FXML
    private void listar_alunos(ActionEvent event) {
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
}
