package fr.feedelio.pagode.security.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import fr.feedelio.pagode.security.models.User;
import fr.feedelio.pagode.security.services.RoleService;
import fr.feedelio.pagode.security.services.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @GetMapping("/securite/users")
    public String getAll(Model model) {
        model.addAttribute("users", userService.findAll());
        return "/securite/users";
    }

    @GetMapping("/securite/user/{op}/{id}")
    public String editUser(@PathVariable Integer id, @PathVariable String op, Model model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        model.addAttribute("userRoles", roleService.getUserRoles(user));
        model.addAttribute("userNotRoles", roleService.getUserNotRoles(user));
        return "/securite/user" + op; //returns logeEdit or logeDetails
    }

    @PostMapping("/users/addNew")
    public RedirectView addNew(User user, RedirectAttributes redir) {
        userService.save(user);

        RedirectView redirectView = new RedirectView("/login", true);
        redir.addFlashAttribute("message", "Utilisateur enregistré !");
        return redirectView;
    }

}
