package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.util.Util;
import jm.task.core.jdbc.model.User;

import java.util.List;

import org.hibernate.*;
import org.hibernate.exception.SQLGrammarException;

public class UserDaoHibernateImpl implements UserDao {



    public UserDaoHibernateImpl() {

    }

    @Override
    public void createUsersTable() {
        try {
            String sql = "CREATE TABLE registration " +
                    "(id INTEGER AUTO_INCREMENT, " +
                    " name TINYTEXT, " +
                    " lastName TINYTEXT, " +
                    " age TINYINT, " +
                    " PRIMARY KEY ( id ))";
            Session session = Util.getSessionFactory().openSession();
            Transaction transaction = null;
            transaction = session.beginTransaction();
            session.createSQLQuery(sql).executeUpdate();
            transaction.commit();
            session.close();
        } catch (SQLGrammarException e) {}
    }

    @Override
    public void dropUsersTable() {
        try {
            String sql = "DROP TABLE registration ";
            Session session = Util.getSessionFactory().openSession();
            Transaction transaction = null;
            transaction = session.beginTransaction();
            session.createSQLQuery(sql).executeUpdate();
            transaction.commit();
            session.close();
        } catch (SQLGrammarException e) {}
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        try {
            Session session = Util.getSessionFactory().openSession();
            Transaction transaction = null;
            transaction = session.beginTransaction();
            User user = new User(name, lastName, age);
            user.setId(null);
            session.save(user);
            System.out.println("User с именем - " + name + " добавлен в бвзу данных");
            transaction.commit();
            session.close();
        } catch (SQLGrammarException e) {}
    }

    @Override
    public void removeUserById(long id) {
        try {
            Session session = Util.getSessionFactory().openSession();
            Transaction transaction = null;
            transaction = session.beginTransaction();
            User user = (User) session.get(User.class, id);
            session.delete(user);
            transaction.commit();
            session.close();
        } catch (SQLGrammarException e) {}
    }

    @Override
    public List<User> getAllUsers() {
        try {
            Session session = Util.getSessionFactory().openSession();
            Transaction transaction = null;
            transaction = session.beginTransaction();
            List<User> users = (List<User>) session.createQuery("FROM User").list();
            transaction.commit();
            session.close();
            return users;
        } catch (SQLGrammarException e) {return null;}
    }

    @Override
    public void cleanUsersTable() {
        try {
            Session session = Util.getSessionFactory().openSession();
            Transaction transaction = null;
            transaction = session.beginTransaction();
            List<User> users = (List<User>) session.createQuery("FROM User").list();
            for (User user : users){
                session.delete(user);
            }
            transaction.commit();
            session.close();
        } catch (SQLGrammarException e) {}
    }
}
