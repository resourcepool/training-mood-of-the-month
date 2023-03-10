package io.takima.controller;

import io.takima.ProjectMOTM.MOTM;
import io.takima.ProjectMOTM.MOTM_Answer;
import io.takima.service.MOTM_AnswerService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/createmotm")
public class CreateMotmController extends HttpServlet {

    private String empid;
    @Override
    public void init() {
        System.out.println("Servlet CreateMotm initialized successfully");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/createmotm.jsp");
        this.empid = req.getParameter("empid");
        System.out.println("___________# GO GET #______________");
        System.out.println(empid);
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String motmContent = req.getParameter("motmcontent");
//        String empid = req.getParameter("empid");
        Integer grade = Integer.parseInt(req.getParameter("note"));

        MOTM_Answer motm = new MOTM_Answer();
        motm.setMessage(motmContent);
        motm.setGrade(MOTM_Answer.Grade.fromValue(grade));
        motm.setEmployee_id(this.empid);

        MOTM_AnswerService motmAnswerService = new MOTM_AnswerService();
        motmAnswerService.insertMotmAnswer(motm);

        resp.sendRedirect("admin");

        System.out.println("___________#______________");
        System.out.println(motmContent);
        System.out.println(grade);
        System.out.println(empid);

    }
}
