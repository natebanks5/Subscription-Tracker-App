/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subscriptiontrackersprint;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author hoovb
 */
public class SerializedCollection implements Serializable {

    private PaidSubscriptionList paidList = new PaidSubscriptionList();
    private FreeTrialList freeList = new FreeTrialList();
    ArrayList<PaidSubscription> savedPaid = new ArrayList<PaidSubscription>();
    ArrayList<FreeTrial> savedFree = new ArrayList<FreeTrial>();

    public SerializedCollection() {
        this.readSubscriptionsFile();
        this.writeSubscriptionsFile();
    }

    public void readSubscriptionsFile() {
        FileInputStream fis = null;
        ObjectInputStream in = null;
        try {
            fis = new FileInputStream("Subscriptions.ser");
            in = new ObjectInputStream(fis);
            savedPaid = (ArrayList<PaidSubscription>) in.readObject();
            savedFree = (ArrayList<FreeTrial>) in.readObject();
            in.close();
            if (!savedPaid.isEmpty()) {
                System.out.println("There are users in the user list");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public void writeSubscriptionsFile() {
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try {
            fos = new FileOutputStream("Subscriptions.ser");
            out = new ObjectOutputStream(fos);
            out.writeObject(PaidSubscriptionList.getPaidList1());
            out.writeObject(FreeTrialList.getFreeList1());
            out.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
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
