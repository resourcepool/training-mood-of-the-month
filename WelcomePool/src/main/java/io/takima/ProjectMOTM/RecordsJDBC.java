package io.takima.ProjectMOTM;

import java.sql.*;
import java.util.Date;

public class RecordsJDBC {

    public RecordsJDBC() {
    }

    public void insertRecordsInEmployeeOnInit(){
        EmployeeDAO employeeDAO = new EmployeeDAO();

        Employee emp = new Employee(125, "Loic Ortola", "lortola@e-biz", java.time.LocalDate.of(1998,10,02));
        employeeDAO.insertEmployee(emp);
        employeeDAO.updateNameEmployee(emp,"Loc");
        employeeDAO.updateEmailEmployee(emp, "test@test");
        employeeDAO.updateBirthdayEmployee(emp, java.time.LocalDate.of(1997,10,02));
    }

    public void flushEmployeeOnInit() {
        try {
            Connection connection = DbConfig.getConnection();
            Statement stat = connection.createStatement();
            stat.executeUpdate("DELETE FROM employee");
            System.out.println("Clean employee table");
            connection.close();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    public void insertRecordsInMotmOnInit() {
        MotmDAO MotmDAO = new MotmDAO();

        MOTM motm = new MOTM(1,"test", "message1", "page1");
        MotmDAO.insertMotm(motm);
        MotmDAO.updateTitleMotm(motm,"test2");
        MotmDAO.updateMessageMotm(motm, "message2");
        MotmDAO.updatePageMotm(motm, "page2");
    }
    public void flushMotmOnInit() {
        try {
            Connection connection = DbConfig.getConnection();
            Statement stat = connection.createStatement();
            stat.executeUpdate("DELETE FROM motm");
            System.out.println("Clean employee table");
            connection.close();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }

}
