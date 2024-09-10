package application.service;

import application.model.User;

import java.util.List;

public interface UserService {

    void addUser(User user);
    void deleteUser(int id);
    void updateUser(User user);
    User getUser(int id);
    List<User> getAllUsers();

}
