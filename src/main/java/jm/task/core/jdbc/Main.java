package jm.task.core.jdbc;

import jm.task.core.jdbc.service.*;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserService usi = new UserServiceImpl();

        usi.createUsersTable();
        User first = new User("Аня","Караулан",(byte) 20);
        User second = new User("Гриша","Капустин",(byte) 22);
        User third = new User("Лиза","Лихова",(byte) 14);
        User fourth = new User("Евгений","Лихов",(byte) 47);
        usi.saveUser(first.getName(), first.getLastName(), first.getAge());
        usi.saveUser(second.getName(), second.getLastName(), second.getAge());
        usi.saveUser(third.getName(), third.getLastName(), third.getAge());
        usi.saveUser(fourth.getName(), fourth.getLastName(), fourth.getAge());
        List<User> users = usi.getAllUsers();
        for (User user : users) System.out.println(user.toString());
        usi.cleanUsersTable();
        usi.dropUsersTable();
    }
}

