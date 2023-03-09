package io.takima.service;

import io.takima.ProjectMOTM.Employee;
import io.takima.ProjectMOTM.MOTM;
import io.takima.ProjectMOTM.MOTM_Answer;
import io.takima.controller.GradeStats;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

public class DashBoardService {

    public ArrayList<Employee> getEmployees() {
        return new ArrayList<Employee>(Arrays.asList(
                new Employee("Jackie", "jackie@jackie.com", new Date(1994,10,14)),
                new Employee("Patrick", "patrick@jackie.com", new Date(1978,2,4)),
                new Employee("Pejman", "pejman@jackie.com", new Date(2000,10,12))
        ));
    }


    public ArrayList<MOTM_Answer> getMotmAnswers() {
        ArrayList<Employee> employees = getEmployees();
        return new ArrayList<MOTM_Answer>(Arrays.asList(
                new MOTM_Answer("je suis content", MOTM_Answer.Grade.A, employees.indexOf(0),1 ),
                new MOTM_Answer("je suis pas content", MOTM_Answer.Grade.E, employees.indexOf(1),1 ),
                new MOTM_Answer("je suis moyen content", MOTM_Answer.Grade.C, employees.indexOf(2),1 ),
                new MOTM_Answer("Ayaya", MOTM_Answer.Grade.B, employees.indexOf(1),1 ),
        new MOTM_Answer("je suis moyen content", MOTM_Answer.Grade.C, employees.indexOf(2),1 ),
                new MOTM_Answer("je suis moyen content", MOTM_Answer.Grade.C, employees.indexOf(2),1 ),
                new MOTM_Answer("je suis moyen content", MOTM_Answer.Grade.C, employees.indexOf(2),1 ),
                new MOTM_Answer("je suis moyen content", MOTM_Answer.Grade.C, employees.indexOf(2),1 ),
                new MOTM_Answer("je suis moyen content", MOTM_Answer.Grade.C, employees.indexOf(2),1 ),
                new MOTM_Answer("je suis moyen content", MOTM_Answer.Grade.C, employees.indexOf(2),1 ),
                new MOTM_Answer("je suis moyen content", MOTM_Answer.Grade.C, employees.indexOf(2),1 ),
                new MOTM_Answer("je suis moyen content", MOTM_Answer.Grade.C, employees.indexOf(2),1 ),
                new MOTM_Answer("je suis moyen content", MOTM_Answer.Grade.C, employees.indexOf(2),1 ),
                new MOTM_Answer("je suis moyen content", MOTM_Answer.Grade.C, employees.indexOf(2),1 ),
                new MOTM_Answer("je suis moyen content", MOTM_Answer.Grade.C, employees.indexOf(2),1 ),
                new MOTM_Answer("je suis moyen content", MOTM_Answer.Grade.C, employees.indexOf(2),1 ),
                new MOTM_Answer("je suis moyen content", MOTM_Answer.Grade.C, employees.indexOf(2),1 ),
                new MOTM_Answer("je suis moyen content", MOTM_Answer.Grade.C, employees.indexOf(2),1 ),
                new MOTM_Answer("je suis moyen content", MOTM_Answer.Grade.C, employees.indexOf(2),1 ),
                new MOTM_Answer("je suis moyen content", MOTM_Answer.Grade.C, employees.indexOf(2),1 ),
                new MOTM_Answer("je suis moyen content", MOTM_Answer.Grade.C, employees.indexOf(2),1 ),
                new MOTM_Answer("je suis moyen content", MOTM_Answer.Grade.C, employees.indexOf(2),1 ),
                new MOTM_Answer("je suis moyen content", MOTM_Answer.Grade.C, employees.indexOf(2),1 ),
                new MOTM_Answer("je suis moyen content", MOTM_Answer.Grade.C, employees.indexOf(2),1 ),
                new MOTM_Answer("je suis moyen content", MOTM_Answer.Grade.C, employees.indexOf(2),1 ),
                new MOTM_Answer("je suis moyen content", MOTM_Answer.Grade.C, employees.indexOf(2),1 ),
                new MOTM_Answer("je suis moyen content", MOTM_Answer.Grade.C, employees.indexOf(2),1 ),
                new MOTM_Answer("je suis moyen content", MOTM_Answer.Grade.C, employees.indexOf(2),1 ),
                new MOTM_Answer("je suis moyen content", MOTM_Answer.Grade.C, employees.indexOf(2),1 ),
                new MOTM_Answer("je suis moyen content", MOTM_Answer.Grade.C, employees.indexOf(2),1 ),
                new MOTM_Answer("je suis moyen content", MOTM_Answer.Grade.C, employees.indexOf(2),1 ),
                new MOTM_Answer("je suis moyen content", MOTM_Answer.Grade.C, employees.indexOf(2),1 ),
                new MOTM_Answer("je suis moyen content", MOTM_Answer.Grade.C, employees.indexOf(2),1 ),
                new MOTM_Answer("je suis moyen content", MOTM_Answer.Grade.C, employees.indexOf(2),1 ),
                new MOTM_Answer("je suis moyen content", MOTM_Answer.Grade.C, employees.indexOf(2),1 ),
                new MOTM_Answer("je suis moyen content", MOTM_Answer.Grade.C, employees.indexOf(2),1 ),
                new MOTM_Answer("je suis moyen content", MOTM_Answer.Grade.C, employees.indexOf(2),1 ),
                new MOTM_Answer("je suis moyen content", MOTM_Answer.Grade.C, employees.indexOf(2),1 ),
                new MOTM_Answer("je suis moyen content", MOTM_Answer.Grade.C, employees.indexOf(2),1 ),
                new MOTM_Answer("je suis moyen content", MOTM_Answer.Grade.C, employees.indexOf(2),1 ),
                new MOTM_Answer("je suis moyen content", MOTM_Answer.Grade.C, employees.indexOf(2),1 ),
                new MOTM_Answer("je suis moyen content", MOTM_Answer.Grade.C, employees.indexOf(2),1 )

        ));

    }


    public MOTM getLastMotm() {
        return new ArrayList<MOTM>(Arrays.asList(
                new MOTM(1,"MarsBB", "MOTM de mars", "template1"),
                new MOTM(1,"MarsAA", "MOTM de mars", "template1")
        )).stream().max(Comparator.comparing(MOTM::getCreated_at)).get();
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



}
