package spring.dao;

import spring.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoHibernate implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    // !!!! создание сессии как поля крешило проект !!!!
    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addUser(User user) {
        getCurrentSession().save(user);
    }

    @Override
    public User getUser(long id) {
        return (User) getCurrentSession().get(User.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getAllUsers() {
        return getCurrentSession().createQuery("FROM User").list();
    }

    @Override
    public void deleteUser(long id) {
        User user = (User) getCurrentSession().get(User.class, id);
        if (user != null) {
            getCurrentSession().delete(user);
        }
    }

    @Override
    public void updateUser(User user) {
        getCurrentSession().update(user);
    }
}
