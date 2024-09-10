package application.service;

import application.dao.UserDao;
import application.dao.UserDaoImp;
import application.model.User;
import org.springframework.context.annotation.Bean;

import java.util.List;


public class UserServiceImp implements UserService {


    private final UserDao userDaoImp = new UserDaoImp();

    @Override
    public void addUser(User user) {
    userDaoImp.addUser(user);
    }

    @Override
    public void deleteUser(int id) {
    userDaoImp.deleteUser(id);
    }

    @Override
    public void updateUser(User user) {
    userDaoImp.updateUser(user);
    }

    @Override
    public User getUser(int id) {
        User user = userDaoImp.getUser(id);
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = userDaoImp.getAllUsers();
        return users;
    }
}
