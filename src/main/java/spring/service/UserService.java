package spring.service;

import spring.model.User;

import java.util.List;

public interface UserService {

     public void addUser(User user);

     User getById(long id);

     User getByName(String username);

     List<User> getAllUsers();

     void deleteUser(long id);

     void updateUser(User user);

//     Optional<User> loginUser(String name, String password);
}
