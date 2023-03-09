package io.takima.ProjectMOTM;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MOTM_AnswerDAO {

   /* public MOTM_AnswerDAO() {
    }

    public void updateMotmAnswer(String sqlQuery) {

        try {
            Connection conn = DriverManager.getConnection(dbURL, username, password);

            if (conn != null) {
                System.out.println("Connected");
                Statement statement = conn.createStatement();
                statement.executeUpdate(sqlQuery);
                conn.close();
                System.out.println("Connection closed");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<MOTM_Answer> getAllMotmAnswer(String sqlQuery) {

        List<MOTM_Answer> motmAnswerList = new ArrayList<>();

        try {
            Connection conn = DriverManager.getConnection(dbURL, username, password);

            if (conn != null) {
                System.out.println("Connected");

                Statement statement = conn.createStatement();
                ResultSet result = statement.executeQuery(sqlQuery);

                while (result.next()){
                    MOTM_Answer motm = new MOTM_Answer(result.getString("message"), result.getInt("grade"), result.getInt("Employee_id"),result.getInt("MOTM_id"));
                    motmAnswerList.add(motm);

                    System.out.println(motmAnswerList);
                }

                conn.close();
                System.out.println("Connection closed");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return motmAnswerList;
    }*/
}
