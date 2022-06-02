package web.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import web.model.User;

import java.util.List;

public interface UserDao extends JpaRepository<User,Long> {

    void saveUser(String name, String lastName, String email);

    void removeUserById(long id);

    public User getUserById(long id);
    public void changeUserById(long id, String name, String lastName, String email);

    List<User> getAllUsers();


}
