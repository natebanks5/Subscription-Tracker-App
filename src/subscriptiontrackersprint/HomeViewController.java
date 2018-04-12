package subscriptiontrackersprint;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author hoovb
 */
public class HomeViewController extends View implements Initializable {

    @FXML
    private BorderPane homePane;
    @FXML
    private Text name1, name2, name3, date1, date2, date3;
    private PaidSubscriptionList paidList = new PaidSubscriptionList();
    
    @FXML
    private void addListener(ActionEvent event) {
        changeView(homePane, "AddView.fxml");
    }
    
    @FXML
    private void subscriptionsListener(ActionEvent event) {
        changeView(homePane, "SubscriptionsView.fxml");
    }
    
    @FXML 
    private void costListener(ActionEvent event) {
        changeView(homePane, "CostView.fxml");
    }

     /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        getPaidList().setHomeText(this.getName1(), this.getName2(), this.getName3(), this.getDate1(), 
                this.getDate2(), this.getDate3());
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
     * @return the name1
     */
    public Text getName1() {
        return name1;
    }

    /**
     * @param name1 the name1 to set
     */
    public void setName1(Text name1) {
        this.name1 = name1;
    }

    /**
     * @return the name2
     */
    public Text getName2() {
        return name2;
    }

    /**
     * @param name2 the name2 to set
     */
    public void setName2(Text name2) {
        this.name2 = name2;
    }

    /**
     * @return the name3
     */
    public Text getName3() {
        return name3;
    }

    /**
     * @param name3 the name3 to set
     */
    public void setName3(Text name3) {
        this.name3 = name3;
    }

    /**
     * @return the date1
     */
    public Text getDate1() {
        return date1;
    }

    /**
     * @param date1 the date1 to set
     */
    public void setDate1(Text date1) {
        this.date1 = date1;
    }

    /**
     * @return the date2
     */
    public Text getDate2() {
        return date2;
    }

    /**
     * @param date2 the date2 to set
     */
    public void setDate2(Text date2) {
        this.date2 = date2;
    }

    /**
     * @return the date3
     */
    public Text getDate3() {
        return date3;
    }

    /**
     * @param date3 the date3 to set
     */
    public void setDate3(Text date3) {
        this.date3 = date3;
    }

    /**
     * @return the paidList
     */
    public PaidSubscriptionList getPaidList() {
        return paidList;
    }

    /**
     * @param paidList the paidList to set
     */
    public void setPaidList(PaidSubscriptionList paidList) {
        this.paidList = paidList;
    }


   
}
