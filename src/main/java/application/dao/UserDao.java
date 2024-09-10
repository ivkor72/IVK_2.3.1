package application.dao;

import application.model.User;

import java.util.List;

public interface UserDao {

    void addUser(User user);
    void deleteUser(int id);
    void updateUser(User user);
    User getUser(int id);
    List<User> getAllUsers();
}
