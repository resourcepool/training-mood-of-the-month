package io.takima;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DbConfig {

        public static Connection getConnection() throws SQLException {

                String dbURL = "jdbc:postgresql://localhost:5432/welcomepool";
                String username = "postgres";
                String password = "postgres";
                Connection connection = DriverManager.getConnection(dbURL, username, password);
                return connection;
        }

}

