/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subscriptiontrackersprint;

import com.gluonhq.impl.charm.a.b.b.f;
import com.gluonhq.impl.charm.a.b.b.p;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;

/**
 *
 * @author hoovb
 */
public class SubscriptionTable {
    
    @FXML
    public void deleteListener(TableView paidTable, TableView freeTable, PaidSubscriptionList p, FreeTrialList f) {
        PaidSubscription paidSelected = (PaidSubscription) paidTable.getSelectionModel().getSelectedItem();
        FreeTrial freeSelected = (FreeTrial) freeTable.getSelectionModel().getSelectedItem();

        if (paidSelected != null) {
            for (int i = 0; i < p.getPaidList1().size(); i++) {
                if (p.getPaidList1().get(i).getName().equals(paidSelected.getName())) {
                    p.getPaidList1().remove(i);
                }
            }
            paidTable.getItems().remove(paidSelected);
        }
        if (freeSelected != null) {
            for (int j = 0; j < f.getFreeList1().size(); j++) {
                if (f.getFreeList1().get(j).getName().equals(freeSelected.getName())) {
                    f.getFreeList1().remove(j);
                }
            }
            freeTable.getItems().remove(freeSelected);
        }
    }
}
