package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;
import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;


@Transactional
@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<User> getAllUsers() {
        String jpql = "from User";
        TypedQuery<User> query = entityManager.createQuery(jpql, User.class);
        return query.getResultList();
    }


    public void saveUser(String name, String lastName, String email) {
        entityManager.persist(new User(name, lastName, email));

    }


    public void removeUserById(long id) {
        entityManager.remove(getUserById(id));
    }

    public User getUserById(long id) {
        return entityManager.find(User.class, id);
    }


    public void changeUserById(long id, String name, String lastName, String email) {
        User user = new User(id, name, lastName, email);
        entityManager.merge(user);

    }


}
