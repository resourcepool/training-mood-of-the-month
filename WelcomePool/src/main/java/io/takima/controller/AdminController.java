package io.takima.controller;

import io.takima.service.ServiceAdmin;

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

    ServiceAdmin serviceAdmin = new ServiceAdmin();

    @Override
    public void init() {
        System.out.println("Servlet initialized successfully");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            req.setAttribute("Employee", serviceAdmin.getEmployee());
            RequestDispatcher dispatcher = req.getRequestDispatcher("/admin.jsp");
            dispatcher.forward(req, resp);
    }

}