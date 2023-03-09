package io.takima.ProjectMOTM;


public class Main {

    public static void main(String[] args) {
        RecordsOnInitService recordsOnInitService = new RecordsOnInitService();
        recordsOnInitService.onInit();

        EmployeeService employeeService = new EmployeeService();
        employeeService.getEmployees();

        MotmService motmService = new MotmService();
        motmService.getAllMotm();

        MOTM_AnswerService motmAnsService = new MOTM_AnswerService();
        motmAnsService.getAllMotmAnswer();
    }
}
