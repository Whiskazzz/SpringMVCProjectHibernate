package web.contollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.service.UserService;

import javax.transaction.Transactional;

@Controller
@Transactional
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping()
    public String allUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "usersview/users";
    }

    @PostMapping
    public String addUser(@RequestParam("name") String name, @RequestParam("surname") String surname, @RequestParam("email") String email) {
        userService.addUser(name, surname, email);
        return "redirect:/users";
    }

    @PatchMapping
    public String changeUser(@RequestParam("id") long id, @RequestParam("name") String name, @RequestParam("surname") String surname, @RequestParam("email") String email) {
        userService.updateUser(id,name,surname,email);
        return "redirect:/users";
    }

    @DeleteMapping
    public String deleteUser(@RequestParam("id") long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }


}
