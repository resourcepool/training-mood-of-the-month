package io.takima.controller.dao;

import io.takima.ProjectMOTM.DbConfig;
import io.takima.ProjectMOTM.MOTM_Answer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MOTM_AnswerDAO {

    private Connection connection;
    public MOTM_AnswerDAO() {
    }

    public void insertMotmAnswer(MOTM_Answer mAnswer) {

        try {
            connection = DbConfig.getConnection();
            System.out.println("Connected");
            String sql = "INSERT INTO motm_answer (uuid, message, grade, Employee_id, MOTM_id, created_at) VALUES(?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            Date date = java.sql.Date.valueOf(java.time.LocalDate.now());
            statement.setInt(1, mAnswer.getUuid());
            statement.setString(2, mAnswer.getMessage());
            statement.setInt(3, (int) mAnswer.getGrade().getValue());
            statement.setInt(4, mAnswer.getEmployee_id());
            statement.setInt(5, mAnswer.getMOTM_id());
            statement.setDate(6, date);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated == 0) {
                throw new SQLException("Failed to insert motm_answer ");
            }
            statement.close();
            connection.close();
            System.out.println("Connection closed");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void updateMsgMotmAns(MOTM_Answer motmAnswer, String newMsg) {

        try {
            connection = DbConfig.getConnection();
            System.out.println("Connected");
            String sql = "UPDATE motm_answer SET message = ? , updated_at = ? WHERE uuid = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            Date date = java.sql.Date.valueOf(java.time.LocalDate.now());
            statement.setString(1, newMsg);
            statement.setDate(2, date);
            statement.setInt(3, motmAnswer.getUuid());
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated == 0) {
                throw new SQLException("Failed to update \"message\" motm_answer with ID: " + motmAnswer.getUuid());
            }
            statement.close();
            connection.close();
            System.out.println("Connection closed");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void updateGradeMotmAns(MOTM_Answer motmAnswer, MOTM_Answer.Grade newGrade) {

        try {
            connection = DbConfig.getConnection();
            System.out.println("Connected");
            String sql = "UPDATE motm_answer SET grade = ? , updated_at = ? WHERE uuid = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            Date date = java.sql.Date.valueOf(java.time.LocalDate.now());
            statement.setInt(1, (int) newGrade.getValue());
            statement.setDate(2, date);
            statement.setInt(3, motmAnswer.getUuid());
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated == 0) {
                throw new SQLException("Failed to update \"grade\" motm_answer with ID: " + motmAnswer.getUuid());
            }
            statement.close();
            connection.close();
            System.out.println("Connection closed");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void DeleteMotmAns(MOTM_Answer motmAnswer) {

        try {
            connection = DbConfig.getConnection();
            System.out.println("Connected");
            String sql = "DELETE FROM motm_answer WHERE uuid = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            Date date = java.sql.Date.valueOf(java.time.LocalDate.now());
            statement.setInt(1, motmAnswer.getUuid());
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated == 0) {
                throw new SQLException("Failed to delete motm_answer with ID: " + motmAnswer.getUuid());
            }
            statement.close();
            connection.close();
            System.out.println("Connection closed");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    public List<MOTM_Answer> getAllMotmAnswer() {

        List<MOTM_Answer> motmAnswerList = new ArrayList<>();
        try {
            connection = DbConfig.getConnection();
            System.out.println("Connected");
            String sqlQuery = "SELECT * FROM motm_answer";
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sqlQuery);
            while (result.next()){
               MOTM_Answer motm = new MOTM_Answer(result.getInt("uuid"), result.getString("message"), MOTM_Answer.Grade.fromValue((double) result.getInt("grade")), result.getInt("Employee_id"),result.getInt("MOTM_id"), result.getDate("created_at").toLocalDate(), result.getDate("updated_at").toLocalDate());
               motmAnswerList.add(motm);

                System.out.println(motmAnswerList);
            }
            connection.close();
            System.out.println("Connection closed");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return motmAnswerList;
    }
}
