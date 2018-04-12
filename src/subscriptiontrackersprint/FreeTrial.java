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

/**
 *
 * @author hoovb
 */
public class FreeTrial extends Subscription implements Serializable {

    private static ArrayList<FreeTrial> freeList = new ArrayList<>();

    public FreeTrial(String name, LocalDate date) {
        super(name, date);
    }

    public String toString(FreeTrial f) {
        return "Name: " + f.getName() + "\nDate: " + f.getDate().toString().substring(5);
    }

    /**
     * @return the freeList
     */
    public ArrayList<FreeTrial> getFreeList() {
        return freeList;
    }

    /**
     * @param freeTrials the freeList to set
     */
    public void setFreeList(ArrayList<FreeTrial> freeTrials) {
        this.freeList = freeTrials;
    }
}
