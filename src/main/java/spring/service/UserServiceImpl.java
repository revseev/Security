package spring.service;

import spring.dao.UserDao;
import spring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class UserServiceImpl implements UserService {


    @Autowired
    private UserDao userDao;

//CRUD operations:

    @Override
    public void addUser(User user){
        userDao.addUser(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User getById(long id) {
        return userDao.getById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public User getByName(String username) {
        return userDao.getByName(username);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers(){
        return userDao.getAllUsers();
    }

    @Override
    public void deleteUser(long id){
        userDao.deleteUser(id);
    }

    @Override
    public void updateUser(User user){
        userDao.updateUser(user);
    }
}
