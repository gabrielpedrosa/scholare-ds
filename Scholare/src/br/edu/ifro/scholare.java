package br.edu.ifro;

import br.edu.ifro.util.Admin;
import br.edu.ifro.util.Disciplinas;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

//@author Gabriel Pedrosa
public class scholare extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/br/edu/ifro/view/Login.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.setResizable(false);
        
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Scholare");
        stage.show();
        
        Admin ad = new Admin();
        Disciplinas dis = new Disciplinas();
    }
    
    public static void main(String[] args) {
        launch(args);
    } 
}
