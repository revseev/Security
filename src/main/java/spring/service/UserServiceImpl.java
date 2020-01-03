package spring.service;

import spring.dao.UserDao;
import spring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserDao userDao;

//CRUD operations:

    @Transactional
    @Override
    public void addUser(User user){
        userDao.addUser(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User getUser(long id) {
        return userDao.getUser(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers(){
        return userDao.getAllUsers();
    }

    @Transactional
    @Override
    public void deleteUser(long id){
        userDao.deleteUser(id);
    }

    @Transactional
    @Override
    public void updateUser(User user){
        userDao.updateUser(user);
    }

//Login :

    //TODO not sure if this is needed
/*    @Transactional
    @Override
    public Optional<User> loginUser(String name, String password) {
        User visitor = new User(name, password, 0L);

        return getAllUsers()
                        .stream()
                        .filter(a -> a.equals(visitor))
                        .findAny();
    }*/
}
