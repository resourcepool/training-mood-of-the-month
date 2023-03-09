package io.takima.ProjectMOTM;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class EmployeeService{
    EmployeeDAO employeeDAO = new EmployeeDAO();
    public void insertEmploye(Employee e) {
        employeeDAO.insertEmployee(e);
    }

    public void updateNameEmploye(Employee e, String name) {
        employeeDAO.updateNameEmployee(e,name);
    }

    public void updateEmailEmploye(Employee e,String email) {
        employeeDAO.updateEmailEmployee(e,email);
    }

    public void updateBirthdayEmploye(Employee e, LocalDate Birthday) {
        employeeDAO.updateBirthdayEmployee(e, Birthday);
    }

    public void DeleteEmploye(Employee e) {
        employeeDAO.DeleteEmployee(e);
    }
    public List<Employee> getEmployees() {
        List<Employee> listEmployees = employeeDAO.getAllEmployees();

        return listEmployees;
    }

}
