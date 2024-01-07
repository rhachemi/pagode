package fr.feedelio.pagode.security.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import fr.feedelio.pagode.security.models.Role;
import fr.feedelio.pagode.security.models.User;
import fr.feedelio.pagode.security.services.RoleService;
import fr.feedelio.pagode.security.services.UserService;

import java.util.List;

@Controller
public class RoleController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    @GetMapping("/securite/roles")
    public String parameters(Model model) {
        List<Role> roles = roleService.findAll();
        model.addAttribute("roles", roles);
        return "security/roles";
    }

    @GetMapping("/securite/role/{id}")
    @ResponseBody
    public Role getById(@PathVariable Integer id) {
        return roleService.findById(id);
    }

    @PostMapping("/securite/roles")
    public String save(Role role) {
        roleService.save(role);
        return "redirect:/securite/roles";
    }

    @RequestMapping(value = "/securite/role/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(@PathVariable Integer id) {
        roleService.delete(id);
        return "redirect:/securite/roles";
    }

    @RequestMapping("/securite/role/assign/{userId}/{roleId}")
    public String assignRole(@PathVariable Integer userId,
                             @PathVariable Integer roleId) {
        roleService.assignUserRole(userId, roleId);
        return "redirect:/securite/user/Edit/" + userId;
    }

    @RequestMapping("/securite/role/unassign/{userId}/{roleId}")
    public String unassignRole(@PathVariable Integer userId,
                               @PathVariable Integer roleId) {
        roleService.unassignUserRole(userId, roleId);
        return "redirect:/securite/user/Edit/" + userId;
    }
}
