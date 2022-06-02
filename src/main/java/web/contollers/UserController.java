package web.contollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.dao.UserDao;
import web.dao.UserDaoImpl;
import web.model.User;

import javax.transaction.Transactional;

@Controller
@Transactional
@RequestMapping("/users")
public class UserController {

    private UserDaoImpl userDao = new UserDaoImpl();

    @GetMapping()
    public String allUsers(Model model) {
        model.addAttribute("users", userDao.getAllUsers());
        return "usersview/users";
    }

    @PostMapping
    public String addUser(@RequestParam("name") String name, @RequestParam("surname") String surname, @RequestParam("email") String email) {
        userDao.saveUser(name, surname, email);
        return "redirect:/users";
    }

    @PatchMapping
    public String changeUser(@RequestParam("id") long id, @RequestParam("name") String name, @RequestParam("surname") String surname, @RequestParam("email") String email) {
        userDao.changeUserById(id,name,surname,email);
        return "redirect:/users";
    }

    @DeleteMapping
    public String deleteUser(@RequestParam("id") long id) {
        userDao.removeUserById(id);
        return "redirect:/users";
    }


}
