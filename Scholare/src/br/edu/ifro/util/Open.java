package br.edu.ifro.util;

// @author Gabriel

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Open {
    
    public static void abrirMenu(Class cls){
    }
    
    public static void abrirAluno(Class cls){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(cls.getResource("/br/edu/ifro/view/Cadastrar_Aluno.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setResizable(false);
            stage.setTitle("Cadastrar Aluno");
            stage.setScene(scene);
            stage.show();
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    public static void abrirExibirAluno(Class cls){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(cls.getResource("/br/edu/ifro/view/Editar_Aluno.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setResizable(false);
            stage.setTitle("Exibir Aluno");
            stage.setScene(scene);
            stage.show();
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    
    public static void abrirProfessor(Class cls){
    }
    
    public static void abrirNotas(Class cls){
    }
    
    public static void abrirMatricula(Class cls){
    }
    
    public static void abrirFrequencia(Class cls){
    }
    
    public static void abrirErro(Class cls){
    }
    
    public static void abrirConfirmacao(Class cls){
    }
}
