package io.takima.controller;

import io.takima.ProjectMOTM.Employee;
import io.takima.service.EmployeeService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

@WebServlet("/addMember")
public class AddMemberController extends HttpServlet {

    private EmployeeService employeeService = new EmployeeService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/addMember.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String birthdate = req.getParameter("birthdate");

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        boolean isDate = false;
        df.setLenient(false);
        try {
            df.parse(birthdate);
            isDate = true;
        } catch (Exception e) {
            isDate = false;
        }

        boolean isEmail = Pattern.compile("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$").matcher(email).matches();

        if (name != null && isEmail && isDate) {
            Employee employee = new Employee(name, email, LocalDate.parse(birthdate, formatter));
            employeeService.insertEmployee(employee);
            resp.sendRedirect("admin");
        } else {
            resp.sendRedirect("addMember");
        }

        System.out.println(name);
        System.out.println(email);
        System.out.printf("birthdate: %s", birthdate);
    }
}
