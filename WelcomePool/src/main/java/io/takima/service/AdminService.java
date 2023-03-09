package io.takima.service;

import io.takima.ProjectMOTM.Employee;
import io.takima.ProjectMOTM.EmployeeService;
import io.takima.ProjectMOTM.MOTM;
import io.takima.ProjectMOTM.MOTM_Answer;
import io.takima.controller.GradeStats;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class AdminService {

    public Employee getEmployee() {
        return new Employee("Jackie", "jackie@jackie.com", new Date(1994,10,14));
    }

    public ArrayList<Employee> getEmployees() {
        EmployeeService employeeService = new EmployeeService();
        ArrayList<Employee> employeeArrayList = employeeService.getEmployees();

        return employeeArrayList;
    }

    public ArrayList<GradeStats> getGradeStats() {
        return new ArrayList<GradeStats>(Arrays.asList(
                new GradeStats(MOTM_Answer.Grade.E, 10, 0.1),
                new GradeStats(MOTM_Answer.Grade.D, 5 , 0.05),
                new GradeStats(MOTM_Answer.Grade.C, 20, 0.2),
                new GradeStats(MOTM_Answer.Grade.B, 40, 0.4),
                new GradeStats(MOTM_Answer.Grade.A, 25, 0.25)
        ));
    }


    public int getEmployeeCount() {
        return new ArrayList<Employee>(Arrays.asList(
                new Employee("Jackie", "jackie@jackie.com", new Date(1994,10,14)),
                new Employee("Patrick", "patrick@jackie.com", new Date(1978,2,4)),
                new Employee("Pejman", "pejman@jackie.com", new Date(2000,10,12))
        )).size();
    }

    public int getMOTMCount() {
        return new ArrayList<MOTM>(Arrays.asList(
                new MOTM(1,"Mars", "MOTM de mars", "template1"),
                new MOTM(1,"Mars", "MOTM de mars", "template1")
        )).size();
    }
}
