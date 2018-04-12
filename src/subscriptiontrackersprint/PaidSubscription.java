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
public class PaidSubscription extends Subscription implements Serializable {

    private double price;
    
    //Formatted variables are used for tableview!
    private String formattedCost;
    private String formattedDate;
    

    public PaidSubscription(String name, LocalDate date, double price) {
        super(name, date);
        this.price = price;

    }


    public String toString(PaidSubscription s) {
        DecimalFormat df = new DecimalFormat();
        df.setMinimumFractionDigits(2);
        df.setMaximumFractionDigits(2);
        return "Name: " + s.getName() + "\nDate: " + s.getDate().toString().substring(5) + "\nPrice: $" + df.format(s.getPrice());
    }


    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * @return the formattedCost
     * USED TO DISPLAY THE COST PROPERLY IN THE TABLE!
     */
    public String getFormattedCost() {
        DecimalFormat df = new DecimalFormat();
        df.setMinimumFractionDigits(2);
        df.setMaximumFractionDigits(2);
        return "$"+df.format(getPrice());
    }

    /**
     * @param formattedCost the formattedCost to set
     */
    public void setFormattedCost(String formattedCost) {
        this.formattedCost = formattedCost;
    }

    /**
     * @return the formattedDate
     */
    public String getFormattedDate() {
        return this.getDate().toString().substring(5);
    }

    /**
     * @param formattedDate the formattedDate to set
     */
    public void setFormattedDate(String formattedDate) {
        this.formattedDate = formattedDate;
    }

}
