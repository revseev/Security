package spring.dao;


import spring.model.User;

import java.util.List;


public interface UserDao  {

    User getById(long id);

    User getByName(String username);

    List<User> getAllUsers();

    void addUser(User user);

    void updateUser(User user);

    void deleteUser(long id);
}
