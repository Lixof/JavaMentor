package jm.task.core.jdbc.service;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UserServiceImpl implements UserService {
    public void createUsersTable() {
        String sql = "CREATE TABLE REGISTRATION " +
                "(id INTEGER AUTO_INCREMENT, " +
                " name TINYTEXT, " +
                " last_name TINYTEXT, " +
                " age TINYINT, " +
                " PRIMARY KEY ( id ))";
        Util.jdbc(sql);
    }

    public void dropUsersTable() {
        String sql = "DROP TABLE REGISTRATION ";
        Util.jdbc(sql);
    }

    public void saveUser(String name, String lastName, byte age) {
        String sql = "INSERT REGISTRATION(name, last_name, age) " +
                "VALUES ('" + name + "', '" + lastName + "', " + age + ") ";
        if(Util.jdbc(sql) == true) System.out.println("User с именем - " + name + " добавлен в бвзу данных");
    }

    public void removeUserById(long id) {
        String sql = "DELETE FROM REGISTRATION " +
                    "WHERE id =" + id + " " ;
        Util.jdbc(sql);
    }

    public List<User> getAllUsers() {
        return null;
    }

    public void cleanUsersTable() {
        String sql = "TRUNCATE TABLE  REGISTRATION ";
        Util.jdbc(sql);
    }
}
