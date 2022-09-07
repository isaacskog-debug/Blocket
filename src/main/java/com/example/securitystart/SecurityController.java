package com.example.securitystart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SecurityController {

    @Autowired
    AdvertRepository repository;


    @GetMapping("/")
    public String start(Model model) {
        model.addAttribute("repository", repository.getAllAdverts());
        return "start";
    }

    @GetMapping("/CreateAdvert")
    public String CreateAdvert(Model model) {
        model.addAttribute(new Advert());

        return "CreateAdvert";
    }
    @PostMapping("/CreateAdvert")
    public String CreateAdvertPost(@ModelAttribute Advert advert){

        return "CreateAdvert";
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
