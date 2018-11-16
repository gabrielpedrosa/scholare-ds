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
 * @author Gabriel Pedrosa
 */
public class ErroController implements Initializable {

    @FXML
    private Button err_ok;
    @FXML
    private Label err_mensagem;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    @FXML
    private void erro(ActionEvent event) {
        Stage stage = (Stage) err_ok.getScene().getWindow();
        stage.close();
    }
    
}
