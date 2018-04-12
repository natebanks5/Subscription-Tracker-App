/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subscriptiontrackersprint;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author hoovb
 */
public class SubscriptionsViewController extends View implements Initializable {

    @FXML
    private BorderPane subscriptionsPane;
    @FXML
    private TableView paidTable, freeTable;
    @FXML
    private TableColumn<PaidSubscription, String> paidSubCol = new TableColumn<>();
    @FXML
    private TableColumn<PaidSubscription, LocalDate> paidDateCol = new TableColumn<>();
    @FXML
    private TableColumn<PaidSubscription, String> paidPriceCol = new TableColumn<>();
    @FXML
    private TableColumn freeSubCol = new TableColumn<>();
    @FXML
    private TableColumn freeDateCol = new TableColumn<>();
    private ObservableList<PaidSubscription> paidData = FXCollections.observableArrayList(PaidSubscriptionList.getPaidList1());
    private ObservableList<FreeTrial> freeData = FXCollections.observableArrayList(FreeTrialList.getFreeList1());
    @FXML
    private Button deleteButton;
    @FXML 
    private AnchorPane deletePane;
    private SubscriptionTable tableLogic = new SubscriptionTable();
    private PaidSubscriptionList paidListTest = new PaidSubscriptionList();
    private FreeTrialList freeList = new FreeTrialList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // Adds data to tables
        getPaidListTest().addTableData(getPaidSubCol(), getPaidDateCol(), getPaidPriceCol(), getPaidTable(), getPaidData());
        getFreeList().addTableData(getFreeSubCol(), getFreeDateCol(), getFreeTable(), getFreeData());
    }

    @FXML
    private void deleteListener(ActionEvent e) {
        getTableLogic().deleteListener(getPaidTable(), getFreeTable(), getPaidListTest(), getFreeList());
    }

    @FXML
    private void homeListener(ActionEvent event) {
        this.changeView(getSubscriptionsPane(), "HomeView.fxml");
    }

    @FXML
    private void addListener(ActionEvent event) {
        this.changeView(getSubscriptionsPane(), "AddView.fxml");
    }

    @FXML
    private void costListener(ActionEvent event) {
        this.changeView(getSubscriptionsPane(), "CostView.fxml");
    }

    /**
     * @return the subscriptionsPane
     */
    public BorderPane getSubscriptionsPane() {
        return subscriptionsPane;
    }

    /**
     * @param subscriptionsPane the subscriptionsPane to set
     */
    public void setSubscriptionsPane(BorderPane subscriptionsPane) {
        this.subscriptionsPane = subscriptionsPane;
    }

    /**
     * @return the paidTable
     */
    public TableView getPaidTable() {
        return paidTable;
    }

    /**
     * @param paidTable the paidTable to set
     */
    public void setPaidTable(TableView paidTable) {
        this.paidTable = paidTable;
    }

    /**
     * @return the freeTable
     */
    public TableView getFreeTable() {
        return freeTable;
    }

    /**
     * @param freeTable the freeTable to set
     */
    public void setFreeTable(TableView freeTable) {
        this.freeTable = freeTable;
    }

    /**
     * @return the paidData
     */
    public ObservableList<PaidSubscription> getPaidData() {
        return paidData;
    }

    /**
     * @param paidData the paidData to set
     */
    public void setPaidData(ObservableList<PaidSubscription> paidData) {
        this.paidData = paidData;
    }

    /**
     * @return the paidSubCol
     */
    public TableColumn getPaidSubCol() {
        return paidSubCol;
    }

    /**
     * @param paidSubCol the paidSubCol to set
     */
    public void setPaidSubCol(TableColumn paidSubCol) {
        this.paidSubCol = paidSubCol;
    }

    /**
     * @return the paidDateCol
     */
    public TableColumn getPaidDateCol() {
        return paidDateCol;
    }

    /**
     * @param paidDateCol the paidDateCol to set
     */
    public void setPaidDateCol(TableColumn paidDateCol) {
        this.paidDateCol = paidDateCol;
    }

    /**
     * @return the paidCostCol
     */
    public TableColumn getPaidPriceCol() {
        return paidPriceCol;
    }

    /**
     * @param paidCostCol the paidCostCol to set
     */
    public void setPaidCostCol(TableColumn paidPriceCol) {
        this.paidPriceCol = paidPriceCol;
    }

    /**
     * @return the freeSubCol
     */
    public TableColumn getFreeSubCol() {
        return freeSubCol;
    }

    /**
     * @param freeSubCol the freeSubCol to set
     */
    public void setFreeSubCol(TableColumn freeSubCol) {
        this.freeSubCol = freeSubCol;
    }

    /**
     * @return the freeDateCol
     */
    public TableColumn getFreeDateCol() {
        return freeDateCol;
    }

    /**
     * @param freeDateCol the freeDateCol to set
     */
    public void setFreeDateCol(TableColumn freeDateCol) {
        this.freeDateCol = freeDateCol;
    }

    /**
     * @return the freeData
     */
    public ObservableList<FreeTrial> getFreeData() {
        return freeData;
    }

    /**
     * @param freeData the freeData to set
     */
    public void setFreeData(ObservableList<FreeTrial> freeData) {
        this.freeData = freeData;
    }

   
    /**
     * @return the tableLogic
     */
    public SubscriptionTable getTableLogic() {
        return tableLogic;
    }

    /**
     * @param tableLogic the tableLogic to set
     */
    public void setTableLogic(SubscriptionTable tableLogic) {
        this.tableLogic = tableLogic;
    }

    /**
     * @return the deletePane
     */
    public AnchorPane getDeletePane() {
        return deletePane;
    }

    /**
     * @param deletePane the deletePane to set
     */
    public void setDeletePane(AnchorPane deletePane) {
        this.deletePane = deletePane;
    }

    /**
     * @return the deleteButton
     */
    public Button getDeleteButton() {
        return deleteButton;
    }

    /**
     * @param deleteButton the deleteButton to set
     */
    public void setDeleteButton(Button deleteButton) {
        this.deleteButton = deleteButton;
    }

    /**
     * @return the paidListTest
     */
    public PaidSubscriptionList getPaidListTest() {
        return paidListTest;
    }

    /**
     * @param paidListTest the paidListTest to set
     */
    public void setPaidListTest(PaidSubscriptionList paidListTest) {
        this.paidListTest = paidListTest;
    }

    /**
     * @return the freeList
     */
    public FreeTrialList getFreeList() {
        return freeList;
    }

    /**
     * @param freeList the freeList to set
     */
    public void setFreeList(FreeTrialList freeList) {
        this.freeList = freeList;
    }
}
