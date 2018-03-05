package com.yuliang.tutorial.mum.mpp.lesson6.assignment.prob2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.HashMap;

public class StringUtility extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("String Utility");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.CENTER);

        VBox vBox1 = new VBox(5);
        vBox1.setPrefWidth(150);
        vBox1.setAlignment(Pos.CENTER);

        Label inputLabel = new Label("Input");
        Label outputLabel = new Label("Output");
        TextField input = new TextField();
        TextField output = new TextField();

        Button count_letters = new Button("Count Letters");
        //alignment for button
        count_letters.setAlignment(Pos.BOTTOM_LEFT);
        Button reverse_letters = new Button("Reverse Letters");
        Button remove_duplicates = new Button("Remove Duplicates");

        count_letters.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                output.setText(String.valueOf(input.getText().trim().length()));
            }
        });

        reverse_letters.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                output.setText(reverseString(input.getText().trim()));
            }

            private String reverseString(String trim) {
                return new StringBuilder(trim).reverse().toString();
            }
        });

        remove_duplicates.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                output.setText(removeDuplicates(input.getText()));
            }

            private String removeDuplicates(String text) {
                StringBuilder stringBuilder = new StringBuilder();
                HashMap<Character, Integer> map = new HashMap<>();

                for (char c : text.toCharArray()) {
                    if(!map.containsKey(c)) {
                        map.put(c, 1);
                        stringBuilder.append(c);
                    }
                }

                return stringBuilder.toString();
            }
        });

        //Set button width
        count_letters.setPrefWidth(vBox1.getPrefWidth());
        reverse_letters.setPrefWidth(vBox1.getPrefWidth());
        remove_duplicates.setPrefWidth(vBox1.getPrefWidth());

        vBox1.getChildren().add(count_letters);
        vBox1.getChildren().add(reverse_letters);
        vBox1.getChildren().add(remove_duplicates);

        VBox vBox2 = new VBox(5);


        vBox2.getChildren().add(inputLabel);
        vBox2.getChildren().add(input);
        vBox2.getChildren().add(outputLabel);
        vBox2.getChildren().add(output);



        hBox.getChildren().add(vBox1);
        hBox.getChildren().add(vBox2);

        grid.add(hBox, 0, 0);


        Scene scene = new Scene(grid, 700, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}