package spring.service;

import spring.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

     public void addUser(User user);

     User getUser(long id);

     List<User> getAllUsers();

     void deleteUser(long id);

     void updateUser(User user);

     Optional<User> loginUser(String name, String password);
}
