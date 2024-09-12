package application.dao;

import application.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class UserDaoImp implements UserDao {


    @PersistenceContext
    private EntityManager em;


    @Override
    public void addUser(User user) {
    em.persist(user);
    em.flush();
    }

    @Override
    public void deleteUser(int id) {
    User user = em.find(User.class, id);
    if (user != null) {
        em.remove(user);
        em.flush();
    }
    }

    @Override
    public void updateUser(User user) {
    user = em.merge(user);
    em.flush();
    }

    @Override
    public User getUser(int id) {
        return em.find(User.class, id);
    }


    @Override
    public List<User> getAllUsers() {
        return em.createQuery("from User", User.class).getResultList();
    }
}
