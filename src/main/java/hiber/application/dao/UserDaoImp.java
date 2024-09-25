package hiber.application.dao;

import hiber.application.config.AppConfig;
import hiber.application.model.User;
import hiber.application.service.UserService;
import hiber.web.config.WebConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class UserDaoImp implements UserDao {

    AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(AppConfig.class);




    private EntityManagerFactory emf;

   @PersistenceContext
   private EntityManager em;

   @Autowired
   public EntityManager getEntityManager(EntityManagerFactory emf) {
            return emf.createEntityManager();
   }

    @Override
    public void addUser(User user) {
        em = getEntityManager(emf);
        em.getTransaction().begin();
    em.persist(user);
    em.flush();
        em.getTransaction().commit();
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
    em.merge(user);
    em.flush();
    }

    @Override
    public User getUser(int id) {
        return em.find(User.class, id);
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return em.createQuery("from User", User.class).getResultList();
    }
}
