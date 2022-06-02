package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import web.config.HibernateConfig;
import web.model.User;

import javax.persistence.*;
import java.util.List;

@Repository
public class UserDaoImpl{

    @PersistenceContext
    private EntityManager entityManager;

    public List<User> getAllUsers() {

        if (entityManager != null) {
            String jpql = "from User";
            TypedQuery<User> query = entityManager.createQuery(jpql, User.class);

            return query.getResultList();
        } else {
            return null;
        }
    }


    public void saveUser(String name, String lastName, String email) {
        entityManager.persist(new User(name,lastName,email));

    }


    public void removeUserById(long id) {

    }


    public User getUserById(long id) {
        return null;
    }


    public void changeUserById(long id, String name, String lastName, String email) {

    }


}
