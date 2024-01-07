package fr.feedelio.pagode.security.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecurityController {

    @RequestMapping("/login")
    public String loginPage() {
        return "securite/login";
    }

    @GetMapping("/register")
    public String register() {
        return "securite/register";
    }

    @RequestMapping("/index")
    public String homePage() {
        return "index";
    }

    @GetMapping("/accessDenied")
    public String accessDenied() {
        return "accessDenied";
    }
}
