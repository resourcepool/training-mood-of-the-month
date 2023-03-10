package io.takima.service;

import io.takima.dao.models.MOTM_Answer;
import io.takima.dao.MOTM_AnswerDAO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class MOTM_AnswerService {
    MOTM_AnswerDAO motm_AnswerDAO = new MOTM_AnswerDAO();
    public void insertMotmAnswer(MOTM_Answer motmAnswer) {
        motm_AnswerDAO.insertMotmAnswer(motmAnswer);

    }

    public void updateMsgMotmAns(MOTM_Answer mAns, String msg) {
        motm_AnswerDAO.updateMsgMotmAns(mAns,msg);
    }

    public void updateGradeMotmAns(MOTM_Answer mAns, MOTM_Answer.Grade grade) {
        motm_AnswerDAO.updateGradeMotmAns(mAns,grade);
    }

    public void DeleteMotmAns(MOTM_Answer mAns) {
        motm_AnswerDAO.DeleteMotmAns(mAns);
    }
    public List<MOTM_Answer> getAllMotmAnswer() {

        List<MOTM_Answer> motmAnswerList = motm_AnswerDAO.getAllMotmAnswer();

        return motmAnswerList;
    }

    public ArrayList<MOTM_Answer> getMotmAnswers() {

        return new ArrayList<>(Arrays.asList(new MOTM_Answer("message", MOTM_Answer.Grade.A, "test", 1, LocalDate.now(), LocalDate.now())));
    }
}
