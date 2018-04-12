/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subscriptiontrackersprint;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

/**
 *
 * @author hoovb
 */
public class AddViewController extends View implements Initializable {

    @FXML
    private BorderPane addPane, homePane;
    @FXML
    private JFXTextField nameField, costField;
    @FXML
    private JFXDatePicker dateField;
    @FXML
    private HBox costMessage;
    @FXML
    private JFXRadioButton paidButton, freeButton;
    @FXML
    private Label nameError, dateError, priceError, typeError;
    @FXML
    private Pane successPane;
    private Form form = new Form();
    private PaidSubscriptionList paidList = new PaidSubscriptionList();
    private FreeTrialList freeList = new FreeTrialList();

    

    @FXML
    private void addListener(ActionEvent event) {
        
        //CHECKS FOR ANY ERRORS IN THE FORM
        Boolean formComplete = getForm().fieldChecker(getNameField(), getNameError(), getDateField(), 
                getDateError(), getPaidButton(), getPriceError(), getFreeButton(), getTypeError(), getCostField());
        if (formComplete && getPaidButton().isSelected()) {
            //getPaid().addToList(getNameField().getText(), getDateField().getValue(), Double.parseDouble(getCostField().getText()));
            paidList.addToList(getNameField().getText(), getDateField().getValue(), Double.parseDouble(getCostField().getText()));
            //SANITY CHECK
            paidList.printList(paidList.getPaidList1());
            
            //CLEAR FIELDS, SHOW SUCCESS MESSAGE
            getForm().successNotification(getSuccessPane());
            getForm().clearFields(getNameField(), getDateField(), getPaidButton(), getFreeButton(), getCostField(), getCostMessage());
        } else if (formComplete && getFreeButton().isSelected()) {
            freeList.addToList(getNameField().getText(), getDateField().getValue());
            
            
            // SANITY CHECK
            freeList.printList(freeList.getFreeList1());
            
            //CLEAR FIELDS, SHOW SUCCESS MESSAGE
            getForm().successNotification(getSuccessPane());
            getForm().clearFields(getNameField(), getDateField(), getPaidButton(), getFreeButton(), getCostField(), getCostMessage());
        }

    }
    
    @FXML
    private void paidListener(ActionEvent event) {
        getCostMessage().setVisible(true);
        getFreeButton().setSelected(false);
    }

    @FXML
    private void freeListener(ActionEvent event) {
        getCostMessage().setVisible(false);
        getPaidButton().setSelected(false);
    }

    @FXML
    private void homeListener(ActionEvent event) {
        changeView(getAddPane(), "HomeView.fxml");
    }
    @FXML
    private void subscriptionsListener(ActionEvent event) {
        changeView(getAddPane(), "SubscriptionsView.fxml");
    }
    @FXML
    private void costListener(ActionEvent event) {
        changeView(getAddPane(), "CostView.fxml");
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    /**
     * @return the addPane
     */
    public BorderPane getAddPane() {
        return addPane;
    }

    /**
     * @param addPane the addPane to set
     */
    public void setAddPane(BorderPane addPane) {
        this.addPane = addPane;
    }

    /**
     * @return the nameField
     */
    public JFXTextField getNameField() {
        return nameField;
    }

    /**
     * @param nameField the nameField to set
     */
    public void setNameField(JFXTextField nameField) {
        this.nameField = nameField;
    }

    /**
     * @return the dateField
     */
    public JFXDatePicker getDateField() {
        return dateField;
    }

    /**
     * @param dateField the dateField to set
     */
    public void setDateField(JFXDatePicker dateField) {
        this.dateField = dateField;
    }

    /**
     * @return the costField
     */
    public JFXTextField getCostField() {
        return costField;
    }

    /**
     * @param costField the costField to set
     */
    public void setCostField(JFXTextField costField) {
        this.costField = costField;
    }

    /**
     * @return the costMessage
     */
    public HBox getCostMessage() {
        return costMessage;
    }

    /**
     * @param costMessage the costMessage to set
     */
    public void setCostMessage(HBox costMessage) {
        this.costMessage = costMessage;
    }

    /**
     * @return the paidButton
     */
    public JFXRadioButton getPaidButton() {
        return paidButton;
    }

    /**
     * @param paidButton the paidButton to set
     */
    public void setPaidButton(JFXRadioButton paidButton) {
        this.paidButton = paidButton;
    }

    /**
     * @return the freeButton
     */
    public JFXRadioButton getFreeButton() {
        return freeButton;
    }

    /**
     * @param freeButton the freeButton to set
     */
    public void setFreeButton(JFXRadioButton freeButton) {
        this.freeButton = freeButton;
    }

    /**
     * @return the nameError
     */
    public Label getNameError() {
        return nameError;
    }

    /**
     * @param nameError the nameError to set
     */
    public void setNameError(Label nameError) {
        this.nameError = nameError;
    }

    /**
     * @return the dateError
     */
    public Label getDateError() {
        return dateError;
    }

    /**
     * @param dateError the dateError to set
     */
    public void setDateError(Label dateError) {
        this.dateError = dateError;
    }

    /**
     * @return the priceError
     */
    public Label getPriceError() {
        return priceError;
    }

    /**
     * @param priceError the priceError to set
     */
    public void setPriceError(Label priceError) {
        this.priceError = priceError;
    }

    /**
     * @return the typeError
     */
    public Label getTypeError() {
        return typeError;
    }

    /**
     * @param typeError the typeError to set
     */
    public void setTypeError(Label typeError) {
        this.typeError = typeError;
    }

    
    /**
     * @return the homePane
     */
    public BorderPane getHomePane() {
        return homePane;
    }

    /**
     * @param homePane the homePane to set
     */
    public void setHomePane(BorderPane homePane) {
        this.homePane = homePane;
    }

   
    /**
     * @return the successPane
     */
    public Pane getSuccessPane() {
        return successPane;
    }

    /**
     * @param successPane the successPane to set
     */
    public void setSuccessPane(Pane successPane) {
        this.successPane = successPane;
    }

    /**
     * @return the form
     */
    public Form getForm() {
        return form;
    }

    /**
     * @param form the form to set
     */
    public void setForm(Form form) {
        this.form = form;
    }
    
}
