package io.takima.ProjectMOTM;

import java.util.Date;
import java.util.List;

public class EmployeeService {

    public List<Employee> getEmployees() {

        String sql = "SELECT * FROM Employee;";

        EmployeeJDBC employeeJDBC = new EmployeeJDBC();
        List<Employee> listEmployees = employeeJDBC.getAllEmployees(sql);

        return listEmployees;
    }

}
