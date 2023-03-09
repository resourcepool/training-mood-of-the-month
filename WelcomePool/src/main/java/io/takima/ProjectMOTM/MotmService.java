package io.takima.ProjectMOTM;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MotmService {

    MotmDAO motmJDBC = new MotmDAO();
    public void insertMotm(MOTM m) {
        motmJDBC.insertMotm(m);
    }

    public void updateTitleMotm(MOTM m,String title) {
        motmJDBC.updateTitleMotm(m,title);
    }

    public void updateMsgMotm(MOTM m, String msg_template) {
        motmJDBC.updateMessageMotm(m,msg_template);
    }

    public void updatePageMotm(MOTM m, String page_template) {
        motmJDBC.updatePageMotm(m,page_template);
    }

    public void DeleteMotm(MOTM m) {
        motmJDBC.DeleteMotm(m);
    }
    public List<MOTM> getAllMotm() {
        List<MOTM> motmList = motmJDBC.getAllMotm();

        return motmList;
    }

}
