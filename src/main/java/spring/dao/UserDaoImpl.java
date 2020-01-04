package spring.dao;

import org.hibernate.Hibernate;
import spring.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    // !!!! создание сессии как поля крешило проект !!!!
    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addUser(User user) {
        getCurrentSession().persist(user);
    }

    @Override
    public User getById(long id) {
        User user = getCurrentSession().get(User.class, id);
        if(user != null){
            Hibernate.initialize(user.getRoles());
        }
        return user;
    }


    @Override
    @SuppressWarnings("unchecked")
    public List<User> getAllUsers() {
        List<User> users = getCurrentSession().createQuery("FROM User").list();
        // for eagerly fetching user roles:
        //TODO experiment with on/off
        for(User user : users){
            Hibernate.initialize(user.getRoles());
        }
        return users;
    }

    @Override
    public void deleteUser(long id) {
        User user = getCurrentSession().get(User.class, id);
        if (user != null) {
            getCurrentSession().delete(user);
        }
    }

    @Override
    public void updateUser(User user) {
        getCurrentSession().update(user);
    }
}
