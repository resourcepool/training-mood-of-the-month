package io.takima.ProjectMOTM;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeJDBC {
    // TODO Connect DB : open statement close

    // TODO Statement : insert et select

    // TODO
    String dbURL = "jdbc:postgresql://localhost:5432/welcomepool";
    String username = "postgres";
    String password = "postgres";

    public EmployeeJDBC() {
    }

    public EmployeeJDBC(String dbURL, String username, String password) {
        this.dbURL = dbURL;
        this.username = username;
        this.password = password;
    }


    public void updateEmployee(String sqlQuery) {

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


    public List<Employee> getAllEmployees(String sqlQuery) {

        List<Employee> employeeList = new ArrayList<>();

        try {
            Connection conn = DriverManager.getConnection(dbURL, username, password);

            if (conn != null) {
                System.out.println("Connected");

                Statement statement = conn.createStatement();
                ResultSet result = statement.executeQuery(sqlQuery);


                while (result.next()){
                    Employee employee = new Employee(result.getString("name"), result.getString("email"), result.getDate("birthdate"));
                    employeeList.add(employee);

                    System.out.println(employee);
                }

                conn.close();
                System.out.println("Connection closed");


            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return employeeList;
    }
}