package br.edu.ifro.control;

import br.edu.ifro.model.Funcionario;
import br.edu.ifro.model.Login;
import br.edu.ifro.util.Open;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


//@author Gabriel
public class LoginController implements Initializable {

    @FXML
    private Button bot_log_cancelar;
    @FXML
    private TextField txt_log_usuario;
    @FXML
    private TextField txt_log_senha;
    @FXML
    private CheckBox chk_log_mostrarsenha;
    @FXML
    private Button bot_log_login;
    @FXML
    private PasswordField pw_log_senha;
    private String nomeeeee;
    
    
    public void abremenu(String nome){
        Scene novascene = Open.abrirMenuLog(getClass(),nome);
        Stage stage = (Stage) bot_log_login.getScene().getWindow();
        stage.setScene(novascene);
        stage.centerOnScreen();
    }

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void cancelar(ActionEvent event) {
        Stage stage = (Stage) bot_log_cancelar.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void mostra_senha(ActionEvent event) {
        if(pw_log_senha.isVisible()){
            String senha = pw_log_senha.getText();
            pw_log_senha.setVisible(false);
            txt_log_senha.setText(senha);
            txt_log_senha.setVisible(true);
        }
        else{
            String senha = txt_log_senha.getText();
            pw_log_senha.setText(senha);
            pw_log_senha.setVisible(true);
            txt_log_senha.setVisible(false);
        }
    }

    @FXML
    private void login(ActionEvent event) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("scholare");
        EntityManager em = emf.createEntityManager();        
        
        Query query = em.createQuery("select f from Funcionario as f where f.log_usuario = :user");
        query.setParameter("user", this.txt_log_usuario.getText() );
        Funcionario ff = (Funcionario) query.getSingleResult();
        
        if(ff==null){
            System.out.println("Usuário Incorreto");            
        }
        else{
            
            if(pw_log_senha.isVisible()){
                if(ff.getLog_senha().equals(pw_log_senha.getText())){ 
                    String nome = ff.getLog_usuario();
                    setNomeeeee(ff.getLog_usuario());
                    //System.out.println(nome);
                    abremenu(nome);
                }
                else{
                    System.out.println("Senha Incorreta");
                }
            }
            else{
                if(ff.getLog_senha().equals(pw_log_senha.getText())){
                    
                    abremenu(ff.getFun_nome());
                }
                else{
                    System.out.println("Senha Incorreta");
                }
            }
        }
        em.close();
        emf.close();
    }

    public String getNomeeeee() {
        return nomeeeee;
    }

    public void setNomeeeee(String nomeeeee) {
        this.nomeeeee = nomeeeee;
    }

    
}
