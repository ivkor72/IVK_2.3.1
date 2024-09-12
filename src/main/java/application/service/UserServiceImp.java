package application.service;

import application.dao.UserDao;
import application.dao.UserDaoImp;
import application.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.controller.IndexController;

import java.util.List;


@Service
@Transactional
public class UserServiceImp implements UserService {

    private final UserDao userDao;

    public UserServiceImp(UserDao userDao) {
        this.userDao =  userDao;
    }

    @Override
    public void addUser(User user) {
    userDao.addUser(user);
    }

    @Override
    public void deleteUser(int id) {
    userDao.deleteUser(id);
    }

    @Override
    public void updateUser(User user) {
    userDao.updateUser(user);
    }

    @Override
    public User getUser(int id) {
        User user = userDao.getUser(id);
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = userDao.getAllUsers();
        return users;
    }
}
