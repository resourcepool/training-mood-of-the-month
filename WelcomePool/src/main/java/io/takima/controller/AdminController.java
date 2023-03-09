package io.takima.controller;

import io.takima.service.AdminService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@SuppressWarnings("serial")
@WebServlet("/admin")
public class AdminController extends HttpServlet {

    AdminService adminService = new AdminService();

    @Override
    public void init() {
        System.out.println("Servlet initialized successfully");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            req.setAttribute("Employee", adminService.getEmployee());
            req.setAttribute("Employees", adminService.getEmployees());

            req.setAttribute("GradeStats", adminService.getGradeStats());
            req.setAttribute("EmployeeCount", adminService.getEmployeeCount());
            req.setAttribute("MotmCount", adminService.getMOTMCount());
            RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
            dispatcher.forward(req, resp);
    }

}