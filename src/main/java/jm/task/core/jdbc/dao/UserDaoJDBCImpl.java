package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.util.Util;
import jm.task.core.jdbc.model.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.sql.ResultSet;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        String sql = "CREATE TABLE registration " +
                "(id INTEGER AUTO_INCREMENT, " +
                " name TINYTEXT, " +
                " lastName TINYTEXT, " +
                " age TINYINT, " +
                " PRIMARY KEY ( id ))";
        Util.execute(sql);
    }

    public void dropUsersTable() {
        String sql = "DROP TABLE registration ";
        Util.execute(sql);
    }

    public void saveUser(String name, String lastName, byte age) {
        String sql = "INSERT registration(name, lastName, age) " +
                "VALUES ('" + name + "', '" + lastName + "', " + age + ") ";
        if (Util.execute(sql)) System.out.println("User с именем - " + name + " добавлен в бвзу данных");
    }

    public void removeUserById(long id) {
        String sql = "DELETE FROM registration " +
                "WHERE id =" + id + " " ;
        Util.executeUpdate(sql);
    }

    public List<User> getAllUsers() {
        User user;
        List<User> users = new ArrayList<>();
        String sql = "select * from registration ";
        ResultSet resultSet = Util.executeQuery(sql);
        try {
            while (resultSet.next()) {
                user = new User(resultSet.getString(2), resultSet.getString(3), resultSet.getByte(4)) ;
                user.setId(resultSet.getLong(1));
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void cleanUsersTable() {
        String sql = "TRUNCATE TABLE  registration ";
        Util.execute(sql);
    }
}
