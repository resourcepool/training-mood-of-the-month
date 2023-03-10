package io.takima.controller.models;

import io.takima.dao.models.MOTM_Answer;

public class GradeStats {

    public MOTM_Answer.Grade grade;
    public int nb;
    public double percent;

    public GradeStats(MOTM_Answer.Grade grade, int nb, double percent) {
        this.grade = grade;
        this.nb = nb;
        this.percent = percent;
    }
}
