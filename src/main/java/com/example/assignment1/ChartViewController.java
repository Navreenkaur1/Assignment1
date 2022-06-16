package com.example.assignment1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ChartViewController implements Initializable {
    @FXML
    private BarChart<Integer, Integer> barChart;

    @FXML
    private void viewTable(ActionEvent event) throws IOException {
        SceneChanger.changeScenes(event,"table-view.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        barChart.getData().addAll(DBUtility.getnumberofcarswithinapricerange());
    }
}
