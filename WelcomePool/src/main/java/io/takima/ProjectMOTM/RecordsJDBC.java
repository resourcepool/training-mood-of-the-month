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
        EmployeeDAO employeeDAO = new EmployeeDAO();
        System.out.println("Clean employee table");
    }

    public void flushMotmOnInit() {

        MotmDAO motmDAO = new MotmDAO();
        System.out.println("Clean motm table");

    }
}
