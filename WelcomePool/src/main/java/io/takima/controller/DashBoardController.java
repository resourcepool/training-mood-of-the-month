package io.takima.controller;

import io.takima.service.AdminService;
import io.takima.service.DashBoardService;
import io.takima.service.EmployeeService;
import io.takima.service.MOTM_AnswerService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/dashboard")
public class DashBoardController extends HttpServlet {


    DashBoardService dashBoardService = new DashBoardService();
    EmployeeService employeeService = new EmployeeService();
    MOTM_AnswerService motmAnswerService = new MOTM_AnswerService();

    @Override
    public void init() {
        System.out.println("Servlet initialized successfully");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("Employees", employeeService.getEmployees());
        req.setAttribute("MotmAnswers", motmAnswerService.getMotmAnswers());
        req.setAttribute("LastMotm", dashBoardService.getLastMotm());
        req.setAttribute("GradeStats", dashBoardService.getGradeStats());
        RequestDispatcher dispatcher = req.getRequestDispatcher("/dashboard.jsp");
        dispatcher.forward(req, resp);
    }




}
