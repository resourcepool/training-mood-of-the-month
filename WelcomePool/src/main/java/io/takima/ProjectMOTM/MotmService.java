package io.takima.ProjectMOTM;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MotmService {

    MotmDAO motmDAO = new MotmDAO();
    public void insertMotm(MOTM m) {
        motmDAO.insertMotm(m);
    }

    public void updateTitleMotm(MOTM m,String title) {
        motmDAO.updateTitleMotm(m,title);
    }

    public void updateMsgMotm(MOTM m, String msg_template) {
        motmDAO.updateMessageMotm(m,msg_template);
    }

    public void updatePageMotm(MOTM m, String page_template) {
        motmDAO.updatePageMotm(m,page_template);
    }

    public void DeleteMotm(MOTM m) {
        motmDAO.DeleteMotm(m);
    }
    public List<MOTM> getAllMotm() {
        List<MOTM> motmList = motmDAO.getAllMotm();

        return motmList;
    }

}
