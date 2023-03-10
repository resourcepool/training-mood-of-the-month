package io.takima.dao;

import io.takima.DbConfig;
import io.takima.dao.models.MOTM_Answer;

import javax.annotation.Resource;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MOTM_AnswerDAO {

    @Resource(name = "PostgresDS")
    private Connection connection;
    public MOTM_AnswerDAO() {
    }

    public void insertMotmAnswer(MOTM_Answer mAnswer) {

        try {
            InitialContext ctx = new InitialContext();
            DataSource dataSource = (DataSource) ctx.lookup("java:jboss/datasources/PostgresDS");
            Connection connection = dataSource.getConnection();
            System.out.println("Connected");

            String sql = "INSERT INTO motm_answer (uuid, message, grade, employee_id, motm_id, created_at, updated_at) VALUES(?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(sql);
            Date createdAt = java.sql.Date.valueOf(mAnswer.getCreated_at());
            Date updated_at = java.sql.Date.valueOf(mAnswer.getUpdated_at());


            statement.setString(1, mAnswer.getUuid());
            statement.setString(2, mAnswer.getMessage());
            statement.setInt(3, (int) mAnswer.getGrade().getValue());
            statement.setString(4, mAnswer.getEmployee_id());
            statement.setString(5, mAnswer.getMOTM_id());
            statement.setDate(6, createdAt);
            statement.setDate(7, updated_at);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated == 0) {
                throw new SQLException("Failed to insert motm_answer ");
            }
            statement.close();
            connection.close();
            System.out.println("Connection closed");
        } catch (Exception ex) {
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
            statement.setString(3, motmAnswer.getUuid());
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
            statement.setString(3, motmAnswer.getUuid());
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
            statement.setString(1, motmAnswer.getUuid());
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
               MOTM_Answer motm = new MOTM_Answer(result.getString("uuid"), result.getString("message"), MOTM_Answer.Grade.fromValue((double) result.getInt("grade")), result.getString("Employee_id"), result.getString("MOTM_id"), result.getDate("created_at").toLocalDate(), result.getDate("updated_at").toLocalDate());
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
