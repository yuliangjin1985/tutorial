package com.yuliang.tutorial.mum.mpp.midterm;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
//import javafx.scene.layout.HBoxBuilder;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import static javafx.application.Application.launch;

public class H2app extends Application{

    private static final Logger logger = Logger.getLogger(H2app.class.getName());
    private static final String[] SAMPLE_NAME_DATA = { "John", "Jill", "Jack", "Jerry", "Sam" };

    public static void main(String[] args) { launch(args); }

    @Override
    public void start(Stage stage) {
        final ListView<String> nameView = new ListView();

        final Button fetchNames = new Button("Fetch names from the database");
        fetchNames.setOnAction(e -> fetchNamesFromDatabaseToListView(nameView));

        final Button clearNameList = new Button("Clear the name list");
        clearNameList.setOnAction(e -> nameView.getItems().clear());

        VBox layout = new VBox(10);
        layout.setStyle("-fx-background-color: cornsilk; -fx-padding: 15;");
//        layout.getChildren().setAll(
//                HBoxBuilder.create().spacing(10).children(
//                        fetchNames,
//                        clearNameList
//                ).build(),
//                nameView
//        );
        layout.setPrefHeight(200);

        stage.setScene(new Scene(layout));
        stage.show();
    }

    private void fetchNamesFromDatabaseToListView(ListView listView) {
        try (Connection con = getConnection()) {
            if (!schemaExists(con)) {
                createSchema(con);
                populateDatabase(con);
            }
            listView.setItems(fetchNames(con));
        } catch (SQLException | ClassNotFoundException ex) {
            logger.log(Level.SEVERE, null, ex);
        }
    }

    private Connection getConnection() throws ClassNotFoundException, SQLException {
        logger.info("Getting a database connection");
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/testnew", "sa", "");
    }

    private void createSchema(Connection con) throws SQLException {
        logger.info("Creating schema");
        Statement st = con.createStatement();
        String table = "create table employee(id integer, name varchar(64))";
        st.executeUpdate(table);
        logger.info("Created schema");
    }

    private void populateDatabase(Connection con) throws SQLException {
        logger.info("Populating database");
        Statement st = con.createStatement();
        int i = 1;
        for (String name: SAMPLE_NAME_DATA) {
            String sql = "insert into employee values(" + i + ","  + "'" + name + "')";
            st.executeUpdate(sql);
            i++;
        }
        logger.info("Populated database");
    }

    private boolean schemaExists(Connection con) {
        logger.info("Checking for Schema existence");
        try {
            Statement st = con.createStatement();
            st.executeQuery("select count(*) from employee");
            logger.info("Schema exists");
        } catch (SQLException ex) {
            logger.info("Existing DB not found will create a new one");
            return false;
        }

        return true;
    }

    private ObservableList<String> fetchNames(Connection con) throws SQLException {
        logger.info("Fetching names from database");
        ObservableList<String> names = FXCollections.observableArrayList();

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select name from employee");
        while (rs.next()) {
            names.add(rs.getString("name"));
        }

        logger.info("Found " + names.size() + " names");

        return names;
    }
}
