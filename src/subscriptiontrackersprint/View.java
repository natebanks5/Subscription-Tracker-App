/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subscriptiontrackersprint;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author hoovb
 */
public class View {
    /* 
       Parent class for all View controllers
       Responsible for changing the view
   
    */
    
    public void changeView(BorderPane currentPane, String resourceName) {
        try {
            BorderPane pane = FXMLLoader.load(getClass().getResource(resourceName));
            currentPane.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(AddViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
 }
    
}