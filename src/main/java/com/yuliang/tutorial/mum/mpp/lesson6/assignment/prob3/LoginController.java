package com.yuliang.tutorial.mum.mpp.lesson6.assignment.prob3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class LoginController {

    @FXML
    private TextField nameField;
    @FXML
    private Text actiontarget;

    @FXML protected void handleSubmitButtonAction(ActionEvent event) {
        actiontarget.setText(nameField.getText() + " loged in.");
    }
}
