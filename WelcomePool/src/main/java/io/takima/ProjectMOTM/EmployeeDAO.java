package io.takima.ProjectMOTM;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    // TODO Connect DB : open statement close

    // TODO Statement : insert et select

    // TODO

    private Connection connection;
    public EmployeeDAO() {
        try{
            connection = DbConfig.getConnection();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void insertEmployee(Employee e) {

        try {
            System.out.println("Connected");
            String sql = "INSERT INTO employee (name, email, birthdate, created_at) VALUES(?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            Date date = java.sql.Date.valueOf(java.time.LocalDate.now());
            statement.setString(1, e.getName());
            statement.setString(2, e.getEmail());
            statement.setDate(3, (Date) e.getBirthdate());
            statement.setDate(4, date);
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
            System.out.println("Connected");
            String sql = "UPDATE employee SET name = ? , update_at = ? WHERE id = ?";
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
            System.out.println("Connected");
            String sql = "UPDATE employee SET email = ? , update_at = ? WHERE id = ?";
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

    public void updateBirthdayEmployee(Employee e, Date newBirthday) {

        try {
            System.out.println("Connected");
            String sql = "UPDATE employee SET birthday = ? , update_at = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            Date date = java.sql.Date.valueOf(java.time.LocalDate.now());
            statement.setDate(1, newBirthday);
            statement.setDate(2, date);
            statement.setInt(3, e.getUuid());
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated == 0) {
                throw new SQLException("Failed to update birthday employee with ID: " + e.getUuid());
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
            System.out.println("Connected");
            String sql = "DELETE FROM employee WHERE id = ?";
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


    public List<Employee> getAllEmployees(String sqlQuery) {

        List<Employee> employeeList = new ArrayList<>();

        try {
            if (connection != null) {
                System.out.println("Connected");

                Statement statement = connection.createStatement();
                ResultSet result = statement.executeQuery(sqlQuery);


                while (result.next()){
                    Employee employee = new Employee(result.getInt("uuid"), result.getString("name"), result.getString("email"), result.getDate("birthdate"));
                    employeeList.add(employee);

                    System.out.println(employee);
                }

                result.close();
                connection.close();
                System.out.println("Connection closed");


            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return employeeList;
    }
}