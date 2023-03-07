package io.takima.ProjectMOTM;

public class Answer{
    private int id;
    private Employee employee;
    private MOTM motm;
    private int note;
    private String commentaire;

    public Answer(int id, Employee employee, MOTM motm, int note, String commentaire) {
        this.id = id;
        this.employee = employee;
        this.motm = motm;
        this.note = note;
        this.commentaire = commentaire;
    }

    // Getters et setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public MOTM getMotm() {
        return motm;
    }

    public void setMotm(MOTM motm) {
        this.motm = motm;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }
}