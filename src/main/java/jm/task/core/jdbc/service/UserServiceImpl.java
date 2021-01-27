package jm.task.core.jdbc.service;

import jm.task.core.jdbc.util.Util;
import jm.task.core.jdbc.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {

    public void createUsersTable() {
        String sql = "CREATE TABLE REGISTRATION " +
                "(id INTEGER AUTO_INCREMENT, " +
                " name TINYTEXT, " +
                " last_name TINYTEXT, " +
                " age TINYINT, " +
                " PRIMARY KEY ( id ))";
        Util.execute(sql);
    }

    public void dropUsersTable() {
        String sql = "DROP TABLE REGISTRATION ";
        Util.execute(sql);
    }

    public void saveUser(String name, String lastName, byte age) {
        String sql = "INSERT REGISTRATION(name, last_name, age) " +
                "VALUES ('" + name + "', '" + lastName + "', " + age + ") ";
        if (Util.execute(sql)) System.out.println("User с именем - " + name + " добавлен в бвзу данных");
    }

    public void removeUserById(long id) {
        String sql = "DELETE FROM REGISTRATION " +
                    "WHERE id =" + id + " " ;
        Util.executeUpdate(sql);
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String sql = "select * from REGISTRATION ";
        Util
    }

    public void cleanUsersTable() {
        String sql = "TRUNCATE TABLE  REGISTRATION ";
        Util.execute(sql);
    }
}

