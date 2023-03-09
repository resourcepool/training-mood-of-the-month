package io.takima.ProjectMOTM;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MotmJDBC {

    String dbURL = "jdbc:postgresql://localhost:5432/welcomepool";
    String username = "postgres";
    String password = "postgres";

    // TODO : lomboker constructeurs

    public MotmJDBC() {
    }

    public MotmJDBC(String dbURL, String username, String password) {
        this.dbURL = dbURL;
        this.username = username;
        this.password = password;
    }

    public void updateMotm(String sqlQuery) {

        try {
            Connection conn = DriverManager.getConnection(dbURL, username, password);

            if (conn != null) {
                System.out.println("Connected");
                Statement statement = conn.createStatement();
                statement.executeUpdate(sqlQuery);
                conn.close();
                System.out.println("Connection closed");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<MOTM> getAllMotm(String sqlQuery) {

        List<MOTM> motmList = new ArrayList<>();

        try {
            Connection conn = DriverManager.getConnection(dbURL, username, password);

            if (conn != null) {
                System.out.println("Connected");

                Statement statement = conn.createStatement();
                ResultSet result = statement.executeQuery(sqlQuery);


                while (result.next()){
                    MOTM motm = new MOTM(result.getInt("uuid"), result.getString("title"), result.getString("message_template"), result.getString("page_template"));
                    motmList.add(motm);

                    System.out.println(motm);
                }

                conn.close();
                System.out.println("Connection closed");


            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return motmList;
    }

}
