package io.takima.service;

import io.takima.ProjectMOTM.Employee;
import io.takima.ProjectMOTM.EmployeeDAO;

import java.time.LocalDate;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmployeeService {
    EmployeeDAO employeeDAO = new EmployeeDAO();
    public void insertEmployee(Employee e) {
        employeeDAO.insertEmployee(e);
    }

    public void updateNameEmployee(Employee e, String name) {
        employeeDAO.updateNameEmployee(e,name);
    }

    public void updateEmailEmployee(Employee e,String email) {
        employeeDAO.updateEmailEmployee(e,email);
    }

    public void updateBirthdayEmployee(Employee e, LocalDate Birthday) {
        employeeDAO.updateBirthdayEmployee(e, Birthday);
    }

    public void DeleteEmployee(Employee e) {
        employeeDAO.DeleteEmployee(e);
    }
    public ArrayList<Employee> getEmployees() {
        ArrayList<Employee> listEmployees = employeeDAO.getAllEmployees();
        return listEmployees;
    }

}
