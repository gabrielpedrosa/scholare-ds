package br.edu.ifro.control;

import br.edu.ifro.model.Funcionario;
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
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
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
        Scene novascene = Open.abrirMenu(getClass());
        Stage stage = (Stage) bot_log_login.getScene().getWindow();
        stage.setScene(novascene);
        stage.centerOnScreen();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txt_log_usuario.setOnKeyPressed((KeyEvent event) -> {
           if (event.getCode() == KeyCode.ENTER) {
               login(event);
           }
       });
        pw_log_senha.setOnKeyPressed((KeyEvent event) -> {
           if (event.getCode() == KeyCode.ENTER) {
               login(event);
           }
       });
       txt_log_senha.setOnKeyPressed((KeyEvent event) -> {
           if (event.getCode() == KeyCode.ENTER) {
               login(event);
           }
       });
    }    

    @FXML
    private void cancelar(ActionEvent event) {
        Stage stage = (Stage) bot_log_cancelar.getScene().getWindow();
        stage.close();
        System.exit(0);
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
        if(pw_log_senha.isVisible()){
            if(pw_log_senha.getText().equals("") || txt_log_usuario.getText().equals("")){
                System.out.println("Usuario ou Senha Vazios");
            }else{
                logar();
            }
        }else{
            if(txt_log_usuario.getText().equals("") || txt_log_senha.getText().equals("")){
                System.out.println("Usuario ou Senha Vazios");
            }else{
                logar();
            }
        }
    }
    
    public void logar(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("scholare");
                EntityManager em = emf.createEntityManager();        

                Query query = em.createQuery("select f from Funcionario as f where f.log_usuario = :user");
                query.setParameter("user", this.txt_log_usuario.getText() );
                

                if(!query.getResultList().isEmpty()){
                 Funcionario ff = (Funcionario) query.getSingleResult();
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
                        if(ff.getLog_senha().equals(txt_log_senha.getText())){

                            abremenu(ff.getFun_nome());
                        }
                        else{
                            System.out.println("Senha Incorreta");
                        }
                    }
                }
                else{
                    System.out.println("Usuário Incorreto");
                }
                em.close();
                emf.close();
    }
    
    private void login(KeyEvent event) {
        if(pw_log_senha.isVisible()){
            if(pw_log_senha.getText().equals("") || txt_log_usuario.getText().equals("")){
                System.out.println("Usuario ou Senha Vazios");
            }else{
                logar();
            }
        }else{
            if(txt_log_usuario.getText().equals("") || txt_log_senha.getText().equals("")){
                System.out.println("Usuario ou Senha Vazios");
            }else{
                logar();
            }
        }
    }

    public String getNomeeeee() {
        return nomeeeee;
    }

    public void setNomeeeee(String nomeeeee) {
        this.nomeeeee = nomeeeee;
    }

    
}
