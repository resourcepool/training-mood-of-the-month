package io.takima.ProjectMOTM;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MotmDAO{

    private Connection connection;
    public MotmDAO() {
    }

    public void insertMotm(MOTM m) {

        try {
            connection = DbConfig.getConnection();
            System.out.println("Connected");
            String sql = "INSERT INTO motm (title, message_template, page_template, created_at) VALUES(?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            Date date = java.sql.Date.valueOf(java.time.LocalDate.now());
            statement.setString(1, m.getTitle());
            statement.setString(2, m.getMessage_template());
            statement.setString(3, m.getPage_template());
            statement.setDate(4, date);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated == 0) {
                throw new SQLException("Failed to insert motm ");
            }
            statement.close();
            connection.close();
            System.out.println("Connection closed");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void updateTitleMotm(MOTM m, String title) {

        try {
            connection = DbConfig.getConnection();
            System.out.println("Connected");
            String sql = "UPDATE motm SET title = ? , update_at = ? WHERE uuid = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            Date date = java.sql.Date.valueOf(java.time.LocalDate.now());
            statement.setString(1, title);
            statement.setDate(2, date);
            statement.setInt(3, m.getUuid());
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated == 0) {
                throw new SQLException("Failed to update \"title\" motm with ID: " + m.getUuid());
            }
            statement.close();
            connection.close();
            System.out.println("Connection closed");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void updateMessageMotm(MOTM m, String newMsg) {

        try {
            connection = DbConfig.getConnection();
            System.out.println("Connected");
            String sql = "UPDATE motm SET message_template = ? , update_at = ? WHERE uuid = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            Date date = java.sql.Date.valueOf(java.time.LocalDate.now());
            statement.setString(1, newMsg);
            statement.setDate(2, date);
            statement.setInt(3, m.getUuid());
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated == 0) {
                throw new SQLException("Failed to update \"message_template\" motm with ID: " + m.getUuid());
            }
            statement.close();
            connection.close();
            System.out.println("Connection closed");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void updatePageMotm(MOTM m, String newPage) {

        try {
            connection = DbConfig.getConnection();
            System.out.println("Connected");
            String sql = "UPDATE motm SET page_template = ? , update_at = ? WHERE uuid = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            Date date = java.sql.Date.valueOf(java.time.LocalDate.now());
            statement.setString(1, newPage);
            statement.setDate(2, date);
            statement.setInt(3, m.getUuid());
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated == 0) {
                throw new SQLException("Failed to update \"page_template\" motm with ID: " + m.getUuid());
            }
            statement.close();
            connection.close();
            System.out.println("Connection closed");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void DeleteMotm(MOTM m) {

        try {
            connection = DbConfig.getConnection();
            System.out.println("Connected");
            String sql = "DELETE FROM motm WHERE uuid = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            Date date = java.sql.Date.valueOf(java.time.LocalDate.now());
            statement.setInt(1, m.getUuid());
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated == 0) {
                throw new SQLException("Failed to delete employee with ID: " + m.getUuid());
            }
            statement.close();
            connection.close();
            System.out.println("Connection closed");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    public List<MOTM> getAllMotm() {

        List<MOTM> motmList = new ArrayList<>();

        try {
            connection = DbConfig.getConnection();
            System.out.println("Connected");
            String sqlQuery = "SELECT * FROM motm";
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sqlQuery);
            while (result.next()){
                MOTM motm = new MOTM(result.getInt("uuid"), result.getString("title"), result.getString("message_template"), result.getString("page_template"));
                motmList.add(motm);
                System.out.println(motm);
            }
            connection.close();
            System.out.println("Connection closed");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return motmList;
    }

}
