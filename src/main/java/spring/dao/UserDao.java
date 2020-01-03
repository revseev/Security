package spring.dao;


import spring.model.User;

import java.util.List;


public interface UserDao  {

    void addUser(User user);

    User getUser(long id);

    List<User> getAllUsers();

    void deleteUser(long id);

    void updateUser(User user);
}
