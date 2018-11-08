package br.edu.ifro.control;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Gabriel
 */
public class SucessoController implements Initializable {

    @FXML
    private Button sus_ok;
    @FXML
    private Label sus_mensagem;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    

    @FXML
    private void sucesso(ActionEvent event) {
        Stage stage = (Stage) sus_ok.getScene().getWindow();
        stage.close();
    }
    
}
