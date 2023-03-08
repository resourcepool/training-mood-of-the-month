package io.takima.ProjectMOTM;

import java.sql.*;

public class RecordsJDBC {

    String dbURL = "jdbc:postgresql://localhost:5432/welcomepool";
    String username = "postgres";
    String password = "postgres";

    public RecordsJDBC(String dbURL, String username, String password) {
        this.dbURL = dbURL;
        this.username = username;
        this.password = password;
    }

    public RecordsJDBC() {
    }

    public void insertRecordsOnInit(){

        try {
            Connection conn = DriverManager.getConnection(dbURL, username, password);

            if (conn != null) {
                System.out.println("Connected");

                Statement statement = conn.createStatement();
                System.out.println("Inserting records in DB before everything else");
                String sqlQuery = "INSERT INTO employee (name, email, birthdate) VALUES ('Arthur', 'mail@arthur.fr', '01/01/2000')";
                statement.executeUpdate(sqlQuery);
                System.out.println("New record inserted");
                sqlQuery = "INSERT INTO employee (name, email, birthdate) VALUES ('Pejman', 'mail@pejman.fr', '02/02/2000')";
                statement.executeUpdate(sqlQuery);
                System.out.println("New record inserted");
                sqlQuery = "INSERT INTO employee (name, email, birthdate) VALUES ('Zineb', 'mail@zineb.fr', '03/03/2000')";
                statement.executeUpdate(sqlQuery);
                System.out.println("New record inserted");
                sqlQuery = "INSERT INTO employee (name, email, birthdate) VALUES ('Ivan', 'mail@ivan.fr', '04/04/2000')";
                statement.executeUpdate(sqlQuery);
                System.out.println("New record inserted");

                conn.close();
                System.out.println("Connection closed");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
