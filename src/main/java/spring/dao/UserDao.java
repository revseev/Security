package spring.dao;


import spring.model.User;

import java.util.List;


public interface UserDao  {

    void addUser(User user);

    User getUser(int id);

    List<User> getAllUsers();

    void deleteUser(int id);

    void updateUser(User user);
}
