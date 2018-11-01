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
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author 80923755268
 */
public class Editar_TurmaController implements Initializable {

    @FXML
    private MenuItem cadastrar_aluno;
    @FXML
    private MenuItem cadastrar_professor;
    @FXML
    private MenuItem cadastrar_turma;
    @FXML
    private MenuItem exibir_alunos;
    @FXML
    private MenuItem exibir_professores;
    @FXML
    private MenuItem exibir_turna;
    @FXML
    private MenuItem ajuda_sobre;
    @FXML
    private RadioButton rad_tur_a;
    @FXML
    private ToggleGroup tg_tur_turno;
    @FXML
    private RadioButton rad_tur_b;
    @FXML
    private Button bot_tur_cadastrar;
    @FXML
    private Button bot_tur_limpar;
    @FXML
    private Button bot_tur_cancelar;
    @FXML
    private ComboBox<?> cbox_tur_ano;
    @FXML
    private ComboBox<?> cbox_tur_tipo;
    @FXML
    private ComboBox<?> cbox_tur_professor;
    @FXML
    private Button bot_tur_inserir;
    @FXML
    private TableView<?> tb_tur_professores;
    @FXML
    private ComboBox<?> cbox_tur_serie_ano;

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
    private void cadastrar_turma(ActionEvent event) {
    }

    @FXML
    private void limpar_turma(ActionEvent event) {
    }

    @FXML
    private void cancelar_turma(ActionEvent event) {
        Scene novascene = Open.abrirMenu(getClass()); 
        Stage stage = (Stage) bot_tur_cancelar.getScene().getWindow();
        stage.setScene(novascene);
    }

    @FXML
    private void inserir_professor(ActionEvent event) {
    }
    
}
