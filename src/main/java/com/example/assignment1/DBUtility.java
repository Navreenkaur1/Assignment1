package com.example.assignment1;

import java.sql.*;

public class DBUtility {
    private static String user = DBCredentials.user;
    private static String password = DBCredentials.password;

    private static String connectURL="jbdc:mysql://127.0.0.1:3306/Assignment";

    private static int insertcarmodelintoDB (carmodel carmodel) throws SQLException {

        int carmodelID = -1;

        ResultSet resultSet = null;


        String sql="Insert into carmodel(carmodelID,name_,year_,selling_price,kmdriven,fuel,seller_type, transmission,Owner_)"+
        "values(?, '?',?,?,?,'?','?', '?', '?')";
        try(
                Connection conn = DriverManager.getConnection(connectURL,user,password);
                PreparedStatement ps = conn.prepareStatement(sql, new String[]{"carmodelID"})
        ) {
            ps.setString(1, carmodel.getName_());
            ps.setInt(2, carmodel.getYear_());
            ps.setInt(3, carmodel.getSelling_price());
            ps.setInt(4, carmodel.getKmdriven());
            ps.setString(5, carmodel.getFuel());
            ps.setString(6, carmodel.getSeller_type());
            ps.setString(7, carmodel.getTransmission());
            ps.setString(8, carmodel.getOwner_());

            ps.executeUpdate();

            resultSet = ps.getGeneratedKeys();
            while (resultSet.next())
            {
                carmodelID = resultSet.getInt(1);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if (resultSet != null)
                resultSet.close();
        }
        return carmodelID;
    }}

