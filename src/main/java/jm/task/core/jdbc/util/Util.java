package jm.task.core.jdbc.util;

import java.sql.* ;

import java.lang.* ;

public class Util {
    private final static String url = ("jdbc:mysql://localhost:3306/mydbtest");
    private final static String username = ("root");
    private final static String password = ("root");
    private static Connection connection;
    private static Statement statement;
    public static boolean jdbc(String sql) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
            statement.executeUpdate(sql);
            return true;
        } catch (SQLException e) {
            e.getStackTrace();
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException i) {
                i.getStackTrace();
                return false;
            }
            return false;
        } catch (ClassNotFoundException e) {
            e.getStackTrace();
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException i) {
                i.getStackTrace();
                return false;
            }
            return false;
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.getStackTrace();
                return false;
            }
            return false;
        }

    }
}
