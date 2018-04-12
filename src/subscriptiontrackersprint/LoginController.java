/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subscriptiontrackersprint;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

/**
/**
 *
 * @author hoovb
 */
public class LoginController extends View implements Initializable {

    private User user = new User();
    @FXML
    private BorderPane rootPane;
    @FXML
    private JFXTextField usernameField;
    @FXML
    private JFXPasswordField passwordField;
 
    @FXML
    private Label errorMessage;

    @FXML
    private void authenticateListener(ActionEvent event) throws IOException{
        String username = getUsernameField().getText();
        String password = getPasswordField().getText();
        User user = new User(username, password);    
        user.addDefaultUsers();
        user.authenticate(user);
        if (user.isAuthenticated() == true) {  
            changeView(rootPane, "HomeView.fxml");
            System.out.println("AUTHORIZED, PROCEED");
        } else {
            getErrorMessage().setVisible(true);
        } 
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * @return the usernameField
     */
    public JFXTextField getUsernameField() {
        return usernameField;
    }

    /**
     * @param usernameField the usernameField to set
     */
    public void setUsernameField(JFXTextField usernameField) {
        this.usernameField = usernameField;
    }

    /**
     * @return the passwordField
     */
    public JFXPasswordField getPasswordField() {
        return passwordField;
    }

    /**
     * @param passwordField the passwordField to set
     */
    public void setPasswordField(JFXPasswordField passwordField) {
        this.passwordField = passwordField;
    }

   

    /**
     * @return the rootPane
     */
    public BorderPane getRootPane() {
        return rootPane;
    }

    /**
     * @param rootPane the rootPane to set
     */
    public void setRootPane(BorderPane rootPane) {
        this.rootPane = rootPane;
    }

    /**
     * @return the errorMessage
     */
    public Label getErrorMessage() {
        return errorMessage;
    }

    /**
     * @param errorMessage the errorMessage to set
     */
    public void setErrorMessage(Label errorMessage) {
        this.errorMessage = errorMessage;
    }
    
    
}
