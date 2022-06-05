package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.model.User;
import javax.transaction.Transactional;
import java.util.List;


@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserDao userDao;

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    @Transactional
    public void addUser(String name, String lastName, String email) {
        userDao.saveUser(name,lastName,email);

    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        userDao.removeUserById(id);
    }

    @Override
    @Transactional
    public void updateUser(long id, String name, String lastName, String email) {
        userDao.changeUserById(id, name, lastName, email);
    }
}
