/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subscriptiontrackersprint;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.time.LocalDate;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

/**
 *
 * @author hoovb
 *
 * RESPONSIBLE FOR MANIPULATIONS IN ADDVIEW
 */
public class Form {

    private Boolean formComplete;

    public void successNotification(Pane p) {
        p.setVisible(true);
        FadeTransition ft = new FadeTransition(Duration.millis(1600), p);
        ft.setFromValue(1);
        ft.setToValue(0);
        ft.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                p.setVisible(false);
            }
        });
        ft.play();
    }

    public void clearFields(JFXTextField name, JFXDatePicker date, JFXRadioButton paid, JFXRadioButton free, JFXTextField cost, HBox costMessage) {
        name.clear();
        date.setValue(null);
        paid.setSelected(false);
        free.setSelected(false);
        cost.clear();
        costMessage.setVisible(false);
    }

    public Boolean fieldChecker(JFXTextField name, Label nameError,
            JFXDatePicker date, Label dateError, JFXRadioButton paid, Label priceError,
            JFXRadioButton free, Label typeError, JFXTextField cost) {

        formComplete = true;

        if (name.getText().isEmpty()) {
            nameError.setVisible(true);
        formComplete = false;
        } else {
            nameError.setVisible(false);
        }

        if (date.getValue() == null) {
            dateError.setVisible(true);
            dateError.setText("Enter a valid date");
        formComplete = false;
        } else if (date.getValue().isBefore(LocalDate.now())) {
            dateError.setText("Enter a future date");
            dateError.setVisible(true);
        formComplete = false;
        } else {
            dateError.setVisible(false);
        }

        if (paid.isSelected() && cost.getText().trim().isEmpty()) {
            priceError.setVisible(true);
        formComplete = false;
        } else if (paid.isSelected() && cost.getText().isEmpty() == false && isDouble(cost.getText()) == false) {
            priceError.setText("Enter a double");
            priceError.setVisible(true);
        formComplete = false;
        } else {
            priceError.setVisible(false);
        }

        if (!paid.isSelected() && !free.isSelected()) {
            typeError.setVisible(true);
        formComplete = false;
        } else {
            typeError.setVisible(false);
        }
        return formComplete;
    }

    public boolean isDouble(String cost) {
        try {
            Double.parseDouble(cost);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * @return the formComplete
     */
    public Boolean getFormComplete() {
        return formComplete;
    }

    /**
     * @param formComplete the formComplete to set
     */
    public void setFormComplete(Boolean formComplete) {
        this.formComplete = formComplete;
    }

}
