/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subscriptiontrackersprint;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author hoovb
 */
public class FreeTrialList implements Serializable {

    private static ArrayList<FreeTrial> freeList1 = new ArrayList<>();

    public void addToList(String name, LocalDate date) {
        FreeTrial s = new FreeTrial(name, date);
        getFreeList1().add(s);
        getFreeList1().sort((d1, d2) -> d1.getDate().compareTo(d2.getDate()));
    }

    public void printList(ArrayList<FreeTrial> f) {
        for (int i = 0; i < f.size(); i++) {
            System.out.println("Free Trial #" + (i + 1) + "\n" + f.get(i).toString(f.get(i)) + "\n");
        }
    }

    public void addTableData(TableColumn freeSub, TableColumn freeDate,
            TableView t, ObservableList<FreeTrial> f) {
        freeSub.setCellValueFactory(
                new PropertyValueFactory<PaidSubscription, String>("name"));
        freeDate.setCellValueFactory(
                new PropertyValueFactory<PaidSubscription, String>("date"));
        t.setItems(f);
    }


    /**
     * @return the freeList
     */
    public static ArrayList<FreeTrial> getFreeList1() {
        return freeList1;
    }

    /**
     * @param aFreeList the freeList to set
     */
    public static void setFreeList1(ArrayList<FreeTrial> aFreeList) {
        freeList1 = aFreeList;
    }

}
