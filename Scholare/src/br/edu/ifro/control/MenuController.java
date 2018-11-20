package br.edu.ifro.control;

import br.edu.ifro.util.Open;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

// @author Gabriel Pedrosa
public class MenuController implements Initializable {    
    @FXML
    private Button bot_marticula;
    @FXML
    private Button bot_notas;
    @FXML
    private Button bot_frequencia;
    @FXML
    private Button bot_sair;
    @FXML
    private Label lab_log_nome;
    private String nome;
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
        System.out.println();
    }    

    @FXML
    private void matricula(ActionEvent event) {
        Scene novascene = Open.abrirMatricula(getClass()); 
        Stage stage = (Stage) bot_marticula.getScene().getWindow();
        stage.setScene(novascene);
    }
    
    @FXML
    private void notas(ActionEvent event) {
        Scene novascene = Open.abrirNotas(getClass()); 
        Stage stage = (Stage) bot_marticula.getScene().getWindow();
        stage.setScene(novascene);
        
    }

    @FXML
    private void frequencia(ActionEvent event) {
    }

    @FXML
    private void sair(ActionEvent event) {
        Stage stage = (Stage) bot_sair.getScene().getWindow();
        stage.close();
        System.exit(0);
    }
    
    //Funções Menu<--
    @FXML
    private void aluno(ActionEvent event){
        Scene novascene = Open.abrirAluno(getClass()); 
        Stage stage = (Stage) bot_marticula.getScene().getWindow();
        stage.setScene(novascene);
    }
    @FXML
    private void funcionario(ActionEvent event) {
        Scene novascene = Open.abrirFuncionario(getClass()); 
        Stage stage = (Stage) bot_marticula.getScene().getWindow();
        stage.setScene(novascene);
    }
    @FXML
    private void turma(ActionEvent event) {
        Scene novascene = Open.abrirTurma(getClass()); 
        Stage stage = (Stage) bot_marticula.getScene().getWindow();
        stage.setScene(novascene);
    }
    @FXML
    private void alunos(ActionEvent event) {
        Scene novascene = Open.abrirExibirAluno(getClass()); 
        Stage stage = (Stage) bot_marticula.getScene().getWindow();
        stage.setScene(novascene);
    }
    @FXML
    private void funcionarios(ActionEvent event) {
        Scene novascene = Open.abrirExibirFuncionario(getClass()); 
        Stage stage = (Stage) bot_marticula.getScene().getWindow();
        stage.setScene(novascene);
    }
    @FXML
    private void turmas(ActionEvent event) {
        Scene novascene = Open.abrirExibirTurma(getClass()); 
        Stage stage = (Stage) bot_marticula.getScene().getWindow();
        stage.setScene(novascene);
        
    }
    @FXML
    private void sobre(ActionEvent event) {
        Scene novascene = Open.abrirSobre(getClass()); 
        Stage stage = (Stage) bot_marticula.getScene().getWindow();
        stage.setScene(novascene);
        
    }
    @FXML
    private void listar_alunos(ActionEvent event) {
        Scene novascene = Open.abrirListarAluno(getClass()); 
        Stage stage = (Stage) bot_marticula.getScene().getWindow();
        stage.setScene(novascene);
    }
    @FXML
    private void listar_funcionarios(ActionEvent event) {
        Scene novascene = Open.abrirListarFuncionario(getClass()); 
        Stage stage = (Stage) bot_marticula.getScene().getWindow();
        stage.setScene(novascene);
    }
    @FXML
    private void listar_turmas(ActionEvent event) {
        Scene novascene = Open.abrirListarTurma(getClass()); 
        Stage stage = (Stage) bot_marticula.getScene().getWindow();
        stage.setScene(novascene);
    }
    @FXML
    private void lsitar_matriculas(ActionEvent event) {
        Scene novascene = Open.abrirListarMatricula(getClass()); 
        Stage stage = (Stage) bot_marticula.getScene().getWindow();
        stage.setScene(novascene);
    }
    @FXML
    private void relatorio_diario(ActionEvent event) {
        Scene novascene = Open.abrirDiario(getClass()); 
        Stage stage = (Stage) bot_marticula.getScene().getWindow();
        stage.setScene(novascene);
    }
    @FXML
    private void ata_de_resultados(ActionEvent event) {
        Scene novascene = Open.abrirAtadeResultado(getClass()); 
        Stage stage = (Stage) bot_marticula.getScene().getWindow();
        stage.setScene(novascene);
    }
    //Funções Menu-->
}