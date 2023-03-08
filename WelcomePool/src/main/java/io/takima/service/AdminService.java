package io.takima.service;

import io.takima.ProjectMOTM.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class AdminService {

    public Employee getEmployee() {
        return new Employee("Jackie", "jackie@jackie.com", new Date(1994,10,14));
    }

    public ArrayList<Employee> getEmployees() {
        return new ArrayList<Employee>(Arrays.asList(
       new Employee("Jackie", "jackie@jackie.com", new Date(1994,10,14)),
       new Employee("Patrick", "patrick@jackie.com", new Date(1978,2,4)),
       new Employee("Pejman", "pejman@jackie.com", new Date(2000,10,12))
        ));
    }
}
