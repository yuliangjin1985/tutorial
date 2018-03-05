package com.yuliang.tutorial.mum.mpp.lesson6.assignment.prob1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AddressForm extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("AddressForm");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Label userName = new Label("Name");
        grid.add(userName, 0, 1);
        TextField userTextField = new TextField();
        grid.add(userTextField, 0, 2);

        Label street = new Label("Street");
        grid.add(street,1, 1);
        TextField streetTextField = new TextField();
        grid.add(streetTextField,1, 2);

        Label cityName = new Label("City");
        grid.add(cityName, 2, 1);
        TextField cityTextField = new TextField();
        grid.add(cityTextField, 2, 2);

        Label state = new Label("State");
        grid.add(state, 0, 3);
        TextField stateTextField = new TextField();
        grid.add(stateTextField, 0, 4);

        Label zip = new Label("Zip");
        grid.add(zip, 1, 3);
        TextField zipTextField = new TextField();
        grid.add(zipTextField, 1, 4);

        Button btn = new Button("Submit");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BASELINE_CENTER);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 0, 5);
		btn.setOnAction(new EventHandler<ActionEvent>() {
        	@Override
        	public void handle(ActionEvent e) {
                System.out.println(userTextField.getText().trim());
                System.out.println(streetTextField.getText().trim());
                System.out.println(cityTextField.getText().trim() + ", " + stateTextField.getText().trim()
                 + " " + zipTextField.getText().trim());
        	}
        });

        //Scene scene = new Scene(grid, 300, 200);
        Scene scene = new Scene(grid);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}