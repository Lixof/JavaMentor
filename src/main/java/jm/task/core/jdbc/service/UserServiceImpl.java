package jm.task.core.jdbc.service;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UserServiceImpl implements UserService {
    public void createUsersTable() {
        try {
            Statement stmt = Util.statement();
            String sql = "CREATE TABLE REGISTRATION " +
                    "(id INTEGER AUTO_INCREMENT, " +
                    " name TINYTEXT, " +
                    " last_name TINYTEXT, " +
                    " age TINYINT, " +
                    " PRIMARY KEY ( id ))";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
        } finally {
            Util.close();
        }
    }

    public void dropUsersTable() {
        try {
            Statement stmt = Util.statement();
            String sql = "DROP TABLE REGISTRATION ";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
        } finally {
            Util.close();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try {
            Statement stmt = Util.statement();
            String sql = "INSERT REGISTRATION(name, last_name, age) " +
                    "VALUES ('" + name + "', '" + lastName + "', " + age + ") ";
            stmt.executeUpdate(sql);
            System.out.println("User с именем - " + name + " добавлен в базу данных");
        } catch (SQLException e) {
        } finally {
            Util.close();
        }
    }

    public void removeUserById(long id) {
        try {
            Statement stmt = Util.statement();
            String sql = "DELETE FROM REGISTRATION " +
                    "WHERE id =" + id + " " ;
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
        } finally {
            Util.close();
        }
    }

    public List<User> getAllUsers() {
        return null;
    }

    public void cleanUsersTable() {
        try {
            Statement stmt = Util.statement();
            String sql = "TRUNCATE TABLE  REGISTRATION ";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
        } finally {
            Util.close();
        }
    }
}
