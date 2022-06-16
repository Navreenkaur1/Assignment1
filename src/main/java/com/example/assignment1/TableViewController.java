package com.example.assignment1;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static com.example.assignment1.DBUtility.getcarmodelFromDB;


public class TableViewController implements Initializable {
    @FXML
    private TableColumn<carmodel, String> carmodelIDColumn;

    @FXML
    private TableColumn<carmodel, String> name_Column;

    @FXML
    private TableColumn<carmodel,  Integer> year_Column;

    @FXML
    private TableColumn<carmodel, Integer> selling_priceColumn;

    @FXML
    private TableColumn<carmodel, Integer> KmdrivenColumn;

    @FXML
    private TableColumn<carmodel, String> fuelColumn;

    @FXML
    private TableColumn<carmodel, String> seller_typeColumn;
    @FXML
    private TableColumn<carmodel, String> transmissionColumn;

    @FXML
    private TableColumn<carmodel, String> owner_Column;

    @FXML
    private TableView<carmodel> tableview;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        carmodelIDColumn.setCellValueFactory(new PropertyValueFactory<>("carmodelID"));
        name_Column.setCellValueFactory(new PropertyValueFactory<>("name_"));
        year_Column.setCellValueFactory(new PropertyValueFactory<>("year_"));
        selling_priceColumn.setCellValueFactory(new PropertyValueFactory<>("Price"));
        KmdrivenColumn.setCellValueFactory(new PropertyValueFactory<>("Kmdriven"));
        fuelColumn.setCellValueFactory(new PropertyValueFactory<>("fuel"));
        seller_typeColumn.getStyleClass().add("seller_type");
        transmissionColumn.getStyleClass().add("transmission");
        owner_Column.getStyleClass().add("owner_");
        try {
            tableview.getItems().addAll(getcarmodelFromDB());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    private void viewCharts(ActionEvent event) throws IOException {
        SceneChanger.changeScenes(event,"chart-view.fxml");
    }


}
