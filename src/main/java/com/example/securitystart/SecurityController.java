package com.example.securitystart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {

    @Autowired
    AdvertRepository repository;


    @GetMapping("/")
    public String start(Model model) {
        model.addAttribute("repository", repository.getAllAdverts());
        return "start";
    }

    @GetMapping("/secret")
    public String secret() {
        return "secret";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/logout")
    public String logout() {
        return "login";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }
}
