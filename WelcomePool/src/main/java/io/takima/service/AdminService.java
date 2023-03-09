package io.takima.service;

import io.takima.ProjectMOTM.*;
import io.takima.controller.GradeStats;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class AdminService {

    public Employee getEmployee() {
        return new Employee("Jackie", "jackie@jackie.com", java.time.LocalDate.of(1994,10,14));
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

        EmployeeService employeeService = new EmployeeService();
        ArrayList<Employee> employeeArrayList = employeeService.getEmployees();

        return employeeArrayList.size();
    }

    public int getMOTMCount() {

        MotmService motmService = new MotmService();
        ArrayList<MOTM> motmList = motmService.getAllMotm();

        return motmList.size();
    }
}
