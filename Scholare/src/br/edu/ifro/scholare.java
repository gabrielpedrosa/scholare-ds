package br.edu.ifro;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

//@author Gabriel
public class scholare extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/br/edu/ifro/view/Menu.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setMaximized(true);
        stage.initStyle(StageStyle.UTILITY);
        stage.setTitle("Menu");
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
