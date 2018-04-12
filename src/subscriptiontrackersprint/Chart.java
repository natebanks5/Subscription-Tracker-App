/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subscriptiontrackersprint;

import static java.lang.System.in;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;

/**
 *
 * @author hoovb
 */
public class Chart {
    private PieChart costChart;
    private PaidSubscriptionList paidList = new PaidSubscriptionList();
    
    
    public Chart(){
        
    }
    
    public void addData(PieChart pie, PaidSubscriptionList p, Label totalCost) {
        ObservableList<PieChart.Data> chartData = FXCollections.observableArrayList(new ArrayList<PieChart.Data>());
        double total = 0;
            for (int i = 0; i<p.getPaidList1().size();  i++) {
            chartData.add(new PieChart.Data(getPaidList().getPaidList1().get(i).getName(), getPaidList().getPaidList1().get(i).getPrice()));
            total += getPaidList().getPaidList1().get(i).getPrice();
        }  
        if (total >0) {
        DecimalFormat df = new DecimalFormat();
        df.setMinimumFractionDigits(2);
        df.setMaximumFractionDigits(2);        
        totalCost.setText(""+df.format(total));
        }
        pie.setData(chartData);
        pie.setStartAngle(90);    
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
