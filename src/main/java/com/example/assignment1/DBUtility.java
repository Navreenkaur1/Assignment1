package com.example.assignment1;

import javafx.scene.chart.XYChart;

import java.sql.*;
import java.util.ArrayList;

public class DBUtility {
    private static String user = DBCredentials.user;
    private static String password = DBCredentials.password;

    private static String connectURL = "jdbc:mysql://127.0.0.1:3306/Assignment";

    public static int insertcarmodelintoDB(carmodel carmodel) throws SQLException {

        int carmodelID = 1;

        ResultSet resultSet = null;


        String sql = "Insert into carmodel(carmodelID,name_,year_,selling_price,kmdriven,fuel,seller_type, transmission,owner_)" +
                "values(?, '?',?,?,?,'?','?', '?', '?')";
        try (
                Connection conn = DriverManager.getConnection(connectURL, user, password);
                PreparedStatement ps = conn.prepareStatement(sql, new String[]{"carmodelID"})
        ) {
            ps.setInt(1, carmodel.getCarmodelID());
            ps.setString(2, carmodel.getName_());
            ps.setInt(3, carmodel.getYear_());
            ps.setInt(4, carmodel.getSelling_price());
            ps.setInt(5, carmodel.getKmdriven());
            ps.setString(6, carmodel.getFuel());
            ps.setString(7, carmodel.getSeller_type());
            ps.setString(8, carmodel.getTransmission());
            ps.setString(9, carmodel.getOwner_());
            ps.executeUpdate();

            resultSet = ps.getGeneratedKeys();
            while (resultSet.next()) {
                carmodelID = resultSet.getInt(1);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null)
                resultSet.close();
        }
        return carmodelID;
    }

    public static ArrayList<carmodel> getcarmodelFromDB() throws SQLException {
        ArrayList<carmodel> carmodel = new ArrayList<>();
        String sql = "SELECT * FROM carmodel";
        try (
                Connection conn = DriverManager.getConnection(connectURL, user, password);
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
        ) {
            while (resultSet.next()) {
                int carmodelID = resultSet.getInt("carmodelID");
                String name_ = resultSet.getString("name_");
                int year_ = resultSet.getInt("year_");
                int selling_price = resultSet.getInt("selling_price");
                int kmdriven = resultSet.getInt("kmdriven");
                String fuel = resultSet.getString("fuel");
                String seller_type = resultSet.getString("seller_type");
                String transmission = resultSet.getString("transmission");
                String Owner_ = resultSet.getString("Owner_");
                carmodel.add(new carmodel(carmodelID, name_, year_, selling_price, kmdriven, fuel, seller_type, transmission, Owner_));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return carmodel;
    }

    public static XYChart.Series<Integer, Integer> getnumberofcarswithinapricerange() {
        XYChart.Series<Integer, Integer> series = new XYChart.Series<>();
        series.setName("cars avalible");
        String sql = "SELECT  selling_price AS price, COUNT(carmodelID) AS ID FROM carmodel GROUP BY selling_price ORDER BY selling_price;";
        try (
                Connection conn = DriverManager.getConnection(connectURL, user, password);
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
        ) {
            while (resultSet.next()) {
                int carmodelID = resultSet.getInt("carmodelID");
                int selling_price = resultSet.getInt("selling_price");
                series.getData().add(new XYChart.Data<>(carmodelID, selling_price));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}






