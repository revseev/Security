package spring.service;

import spring.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

     public void addUser(User user);

     User getUser(int id);

     List<User> getAllUsers();

     void deleteUser(int id);

     void updateUser(User user);

     Optional<User> loginUser(String name, String password);
}
