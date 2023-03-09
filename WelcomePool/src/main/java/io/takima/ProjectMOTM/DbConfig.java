package io.takima.ProjectMOTM;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DbConfig {
        private static Connection connection = null;
        public static Connection getConnection() throws SQLException {
            if (connection != null) {
                return connection;
            } else {
                String dbURL = "jdbc:postgresql://localhost:5432/welcomepool";
                String username = "postgres";
                String password = "postgres";
                connection = DriverManager.getConnection(dbURL, username, password);
                return connection;
            }
        }

        public static void closeConnection() throws SQLException {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

