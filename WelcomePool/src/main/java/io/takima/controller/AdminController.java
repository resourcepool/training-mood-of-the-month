package io.takima.controller;

import io.takima.ProjectMOTM.RecordsOnInitService;
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

    // TODO : il faut trouver comment initialiser la base : vide ou avec des données, si avec des données il faut initialiser UNE SEULE fois et pas à chaque refresh de l'uri /admin
    @Override
    public void init() {
        RecordsOnInitService recordsOnInitService = new RecordsOnInitService();
        recordsOnInitService.onInit();
        System.out.println("Servlet initialized successfully");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("Employees", adminService.getEmployees());

        req.setAttribute("GradeStats", adminService.getGradeStats());
        req.setAttribute("EmployeeCount", adminService.getEmployeeCount());
        req.setAttribute("MotmCount", adminService.getMOTMCount());
        RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
        dispatcher.forward(req, resp);
    }

}