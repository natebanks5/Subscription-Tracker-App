/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subscriptiontrackersprint;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author hoovb
 */
public class CostViewController extends View implements Initializable {

    @FXML
    private BorderPane costPane;
    @FXML
    private Label costTotal;
    @FXML
    private PieChart costChart = new PieChart();
    private PaidSubscriptionList paidList = new PaidSubscriptionList();
    private Chart chart = new Chart();


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //ADD DATA TO PIE CHART
        getChart().addData(costChart, getPaidList(), getCostTotal());

}    

   
    @FXML
    private void homeListener(ActionEvent event) {
        this.changeView(costPane, "HomeView.fxml");
    }

    @FXML
    private void subscriptionsListener(ActionEvent event) {
        this.changeView(costPane, "SubscriptionsView.fxml");
    }

    @FXML
    private void addListener(ActionEvent event) {
        this.changeView(costPane, "AddView.fxml");
    }

    /**
     * @return the costPane
     */
    public BorderPane getCostPane() {
        return costPane;
    }

    /**
     * @param costPane the costPane to set
     */
    public void setCostPane(BorderPane costPane) {
        this.costPane = costPane;
    }

    /**
     * @return the costTotal
     */
    public Label getCostTotal() {
        return costTotal;
    }

    /**
     * @param costTotal the costTotal to set
     */
    public void setCostTotal(Label costTotal) {
        this.costTotal = costTotal;
    }

    /**
     * @return the costChart
     */
    public PieChart getCostChart() {
        return costChart;
    }

    /**
     * @param costChart the costChart to set
     */
    public void setCostChart(PieChart costChart) {
        this.costChart = costChart;
    }

    /**
     * @return the chart
     */
    public Chart getChart() {
        return chart;
    }

    /**
     * @param chart the chart to set
     */
    public void setChart(Chart chart) {
        this.chart = chart;
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
