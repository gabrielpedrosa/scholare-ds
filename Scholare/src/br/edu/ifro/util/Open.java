package br.edu.ifro.util;

// @author Gabriel

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Open {
    
    public static Scene abrirMenu(Class cls){
        Scene cena = null ;
        try{
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(cls.getResource("/br/edu/ifro/view/Menu.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            cena = scene;
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
        return cena;
    }
    /*public static Scene abrirMenuLog(Class cls, String nome){
        Scene cena = null ;
        try{
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(cls.getResource("/br/edu/ifro/view/Menu.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            cena = scene;
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
        return cena;
    }*/
    
    public static Scene abrirAluno(Class cls){
        Scene cena = null ;
        try{
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(cls.getResource("/br/edu/ifro/view/Cadastrar_Aluno.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            cena = scene;
            /*Stage stage = new Stage();
            stage.setResizable(false);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle("Cadastrar Aluno");
            stage.setScene(scene);
            stage.show();*/
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
        return cena;
    }
    public static Scene abrirExibirAluno(Class cls){
        Scene cena = null ;
        try{
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(cls.getResource("/br/edu/ifro/view/Editar_Aluno.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            cena = scene;
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
        return cena;
    }
    
    public static Scene abrirListarAluno(Class cls){
        Scene cena = null ;
        try{
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(cls.getResource("/br/edu/ifro/view/Listar_Alunos.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            cena = scene;
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
        return cena;
    }
    
    public static Scene abrirFuncionario(Class cls){
        Scene cena = null ;
        try{
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(cls.getResource("/br/edu/ifro/view/Cadastrar_Funcionario.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            cena = scene;
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
        return cena;
    }
    
    public static Scene abrirExibirFuncionario(Class cls){
        Scene cena = null ;
        try{
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(cls.getResource("/br/edu/ifro/view/Editar_Funcionario.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            cena = scene;
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
        return cena;
    }
    public static Scene abrirTurma(Class cls){
        Scene cena = null;
        try{
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(cls.getResource("/br/edu/ifro/view/Cadastrar_Turma.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            cena = scene;
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
        return cena;
    }
    
    public static Scene abrirNotas(Class cls){
        Scene cena = null;
        try{
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(cls.getResource("/br/edu/ifro/view/Cadastrar_Turma.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            cena = scene;
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
        return cena;
    }
    
    public static Scene abrirMatricula(Class cls){
        Scene cena = null;
        try{
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(cls.getResource("/br/edu/ifro/view/Matricular.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            cena = scene;
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
        return cena;
    }
    
    public static Scene abrirFrequencia(Class cls){
        Scene cena = null;
        try{
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(cls.getResource("/br/edu/ifro/view/Cadastrar_Turma.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            cena = scene;
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
        return cena;
    }
    
    public static void abrirErro(Class cls){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(cls.getResource("/br/edu/ifro/view/Erro.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(scene);
            stage.showAndWait();
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    public static void abrirSucesso(Class cls){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(cls.getResource("/br/edu/ifro/view/Sucesso.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(scene);
            stage.showAndWait();
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    
    public static Scene abrirConfirmacao(Class cls){
        Scene cena = null;
        try{
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(cls.getResource("/br/edu/ifro/view/Cadastrar_Turma.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            cena = scene;
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
        return cena;
    }
}
