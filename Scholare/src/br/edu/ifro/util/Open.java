package br.edu.ifro.util;

import br.edu.ifro.control.Editar_AlunoController;
import br.edu.ifro.control.Editar_FuncionarioController;
import br.edu.ifro.control.Editar_MatriculaController;
import br.edu.ifro.control.Editar_TurmaController;
import br.edu.ifro.model.Aluno;
import br.edu.ifro.model.Funcionario;
import br.edu.ifro.model.Matricula;
import br.edu.ifro.model.Turma;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

//@author Gabriel Pedrosa
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
    
    public static Scene abrirEditarAluno(Class cls, Aluno alu){
        Scene cena = null ;
        try{
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(cls.getResource("/br/edu/ifro/view/Editar_Aluno.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            cena = scene;
            Editar_AlunoController edc = fxmlLoader.getController();
            edc.editar(alu);
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
    
    public static Scene abrirEditarFuncionario(Class cls, Funcionario fun){
        Scene cena = null ;
        try{
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(cls.getResource("/br/edu/ifro/view/Editar_Funcionario.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            cena = scene;
            Editar_FuncionarioController edc = fxmlLoader.getController();
            edc.editar(fun);
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
        return cena;
    }
    
    public static Scene abrirListarFuncionario(Class cls){
        Scene cena = null ;
        try{
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(cls.getResource("/br/edu/ifro/view/Listar_Funcionarios.fxml"));
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
    
    public static Scene abrirExibirTurma(Class cls){
        Scene cena = null ;
        try{
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(cls.getResource("/br/edu/ifro/view/Editar_Turma.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            cena = scene;
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
        return cena;
    }
    
    public static Scene abrirEditarTurma(Class cls, Turma tur){
        Scene cena = null ;
        try{
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(cls.getResource("/br/edu/ifro/view/Editar_Turma.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            cena = scene;
            Editar_TurmaController edc = fxmlLoader.getController();
            edc.editar(tur);
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
        return cena;
    }
    
    public static Scene abrirListarTurma(Class cls){
        Scene cena = null ;
        try{
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(cls.getResource("/br/edu/ifro/view/Listar_Turmas.fxml"));
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
            fxmlLoader.setLocation(cls.getResource("/br/edu/ifro/view/Notas.fxml"));
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
    
    public static Scene abrirExibirMatricula(Class cls){
        Scene cena = null ;
        try{
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(cls.getResource("/br/edu/ifro/view/Editar_Matricula.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            cena = scene;
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
        return cena;
    }
    
    public static Scene abrirEditarMatricula(Class cls, Matricula mat){
        Scene cena = null ;
        try{
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(cls.getResource("/br/edu/ifro/view/Editar_Matricula.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            cena = scene;
            Editar_MatriculaController edc = fxmlLoader.getController();
            edc.editar(mat);
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
        return cena;
    }
    
    public static Scene abrirListarMatricula(Class cls){
        Scene cena = null ;
        try{
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(cls.getResource("/br/edu/ifro/view/Listar_Matriculas.fxml"));
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
    
    public static Scene abrirAtadeResultado(Class cls){
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
    
    public static Scene abrirDiario(Class cls){
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
    
    public static Scene abrirSobre(Class cls){
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
