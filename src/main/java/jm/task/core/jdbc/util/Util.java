package jm.task.core.jdbc.util;

import java.sql.* ;

import java.lang.* ;

public class Util {
    private final static String url = ("jdbc:mysql://localhost:3306/mydbtest");
    private final static String username = ("root");
    private final static String password = ("root");
    private static Connection connection;
    private static Statement statement;
    public static Statement statement() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.getStackTrace();
        } catch (ClassNotFoundException e) {
            e.getStackTrace();
        }
        return statement;
    }
    public static void close() {
        try {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.getStackTrace();
        }
    }
}
