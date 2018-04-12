/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subscriptiontrackersprint;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

/**
 *
 * @author hoovb
 */
public class PaidSubscriptionList implements Serializable {

    private static ArrayList<PaidSubscription> paidList1 = new ArrayList<PaidSubscription>();

    public void addToList(String name, LocalDate date, double price) {
        PaidSubscription s = new PaidSubscription(name, date, price);
        getPaidList1().add(s);
        getPaidList1().sort((d1, d2) -> d1.getDate().compareTo(d2.getDate()));
        SerializedCollection t = new SerializedCollection();
        t.writeSubscriptionsFile();

    }
    

    // SANITY TEST: PRINTS PAID LIST 
    public void printList(ArrayList<PaidSubscription> p) {
        for (int i = 0; i < p.size(); i++) {
            System.out.println("Paid subscription #" + (i + 1) + "\n" + p.get(i).toString(p.get(i)) + "\n");
        }
    }

    public void setHomeText(Text n1, Text n2, Text n3, Text d1, Text d2, Text d3) {
        if (this.getPaidList1().size() >= 1) {
            n1.setText(this.getPaidList1().get(0).getName());
            d1.setText(this.getPaidList1().get(0).getDate().toString().substring(5));
            n1.setVisible(true);
            d1.setVisible(true);
        } else {
            n1.setVisible(false);
            d1.setVisible(false);
        }
        if (this.getPaidList1().size() >= 2) {
            n2.setText(this.getPaidList1().get(1).getName());
            d2.setText(this.getPaidList1().get(1).getDate().toString().substring(5));
            n2.setVisible(true);
            d2.setVisible(true);
        } else {
            n2.setVisible(false);
            d2.setVisible(false);
        }
        if (this.getPaidList1().size() >= 3) {
            n3.setText(this.getPaidList1().get(2).getName());
            d3.setText(this.getPaidList1().get(2).getDate().toString().substring(5));
            n3.setVisible(true);
            d3.setVisible(true);
        } else {
            n3.setVisible(false);
            d3.setVisible(false);
        }
    }

    public void addTableData(TableColumn paidSub, TableColumn date, TableColumn cost,
            TableView t, ObservableList<PaidSubscription> p) {
        paidSub.setCellValueFactory(
                new PropertyValueFactory<PaidSubscription, String>("name"));
        date.setCellValueFactory(
                new PropertyValueFactory<PaidSubscription, String>("formattedDate"));
        cost.setCellValueFactory(
                new PropertyValueFactory<PaidSubscription, String>("formattedCost"));
        t.setItems(p);
    }

    /**
     * @return the paidList1
     */
    public static ArrayList<PaidSubscription> getPaidList1() {
        return paidList1;
    }

    /**
     * @param aPaidList the paidList1 to set
     */
    public static void setPaidList1(ArrayList<PaidSubscription> aPaidList) {
        paidList1 = aPaidList;
    }

}
