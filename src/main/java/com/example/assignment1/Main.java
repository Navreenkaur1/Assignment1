package com.example.assignment1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException, SQLException {
        ArrayList<carmodel> carmodel = DBUtility.getcarmodelFromDB();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("chart-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Welcome to car dekho!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws SQLException {
    DBUtility.getcarmodelFromDB();
    {
        launch();
    }
}}
