package io.takima.dao;

import io.takima.ProjectMOTM.DbConfig;
import io.takima.ProjectMOTM.Employee;

import javax.annotation.Resource;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class EmployeeDAO {

    @Resource(name = "PostgresDS")
    private DataSource dataSource;

    private Connection connection;
    public EmployeeDAO() {
    }

    public void insertEmployee(Employee e) {

        try {
            connection = DbConfig.getConnection();
            System.out.println("Connected");
            String sql = "INSERT INTO employee (uuid, name, email, birthdate, created_at) VALUES(?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            Date date = java.sql.Date.valueOf(java.time.LocalDate.now());
            Date date_birth = Date.valueOf(e.getBirthdate());
            statement.setInt(1, e.getUuid());
            statement.setString(2, e.getName());
            statement.setString(3, e.getEmail());
            statement.setDate(4, date_birth);
            statement.setDate(5, date);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated == 0) {
                throw new SQLException("Failed to insert employee ");
            }
            statement.close();
            connection.close();
            System.out.println("Connection closed");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void updateNameEmployee(Employee e, String newName) {

        try {
            connection = DbConfig.getConnection();
            System.out.println("Connected");
            String sql = "UPDATE employee SET name = ? , updated_at = ? WHERE uuid = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            Date date = java.sql.Date.valueOf(java.time.LocalDate.now());
            statement.setString(1, newName);
            statement.setDate(2, date);
            statement.setInt(3, e.getUuid());
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated == 0) {
                throw new SQLException("Failed to update name employee with ID: " + e.getUuid());
            }
            statement.close();
            connection.close();
            System.out.println("Connection closed");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void updateEmailEmployee(Employee e, String newEmail) {

        try {
            connection = DbConfig.getConnection();
            System.out.println("Connected");
            String sql = "UPDATE employee SET email = ? , updated_at = ? WHERE uuid = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            Date date = java.sql.Date.valueOf(java.time.LocalDate.now());
            statement.setString(1, newEmail);
            statement.setDate(2, date);
            statement.setInt(3, e.getUuid());
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated == 0) {
                throw new SQLException("Failed to update email employee with ID: " + e.getUuid());
            }
            statement.close();
            connection.close();
            System.out.println("Connection closed");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void updateBirthdayEmployee(Employee e, LocalDate newBirthday) {

        try {
            connection = DbConfig.getConnection();
            System.out.println("Connected");
            String sql = "UPDATE employee SET birthdate = ? , updated_at = ? WHERE uuid = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            Date date = java.sql.Date.valueOf(java.time.LocalDate.now());
            statement.setDate(1, java.sql.Date.valueOf(newBirthday));
            statement.setDate(2, date);
            statement.setInt(3, e.getUuid());
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated == 0) {
                throw new SQLException("Failed to update birthdate employee with ID: " + e.getUuid());
            }
            statement.close();
            connection.close();
            System.out.println("Connection closed");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void DeleteEmployee(Employee e) {

        try {
            connection = DbConfig.getConnection();
            System.out.println("Connected");
            String sql = "DELETE FROM employee WHERE uuid = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            Date date = java.sql.Date.valueOf(java.time.LocalDate.now());
            statement.setInt(1, e.getUuid());
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated == 0) {
                throw new SQLException("Failed to delete employee with ID: " + e.getUuid());
            }
            statement.close();
            connection.close();
            System.out.println("Connection closed");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    public ArrayList<Employee> getAllEmployees() {

        ArrayList<Employee> employeeList = new ArrayList<>();

        try {
            InitialContext ctx = new InitialContext();
            DataSource dataSource = (DataSource) ctx.lookup("java:jboss/datasources/PostgresDS");
            Connection connection = dataSource.getConnection();
            System.out.println("Connected");
            String sqlQuery = "SELECT * FROM employee";
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sqlQuery);
            while (result.next()){
                Employee employee = new Employee(result.getInt("uuid"), result.getString("name"), result.getString("email"), result.getDate("birthdate").toLocalDate(), result.getDate("created_at").toLocalDate(), result.getDate("updated_at").toLocalDate());
                employeeList.add(employee);

                System.out.println(employee);
            }
            result.close();
            connection.close();
            System.out.println("Connection closed");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return employeeList;
    }
}