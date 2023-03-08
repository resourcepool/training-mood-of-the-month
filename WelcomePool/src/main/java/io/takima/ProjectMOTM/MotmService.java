package io.takima.ProjectMOTM;

import java.util.ArrayList;
import java.util.List;

public class MotmService {

    public List<MOTM> getAllMotm() {

        String sql = "SELECT * FROM MOTM;";

        MotmJDBC motmJDBC = new MotmJDBC();
        List<MOTM> motmList = motmJDBC.getAllMotm(sql);

        return motmList;
    }

}
