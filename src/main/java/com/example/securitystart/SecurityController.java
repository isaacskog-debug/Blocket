package com.example.securitystart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SecurityController {

    @Autowired
    AdvertRepository repository;


    @GetMapping("/")
    public String start(Model model) {
        model.addAttribute("repository", repository.getAllAdverts());
        return "start";
    }

    @GetMapping("/advert/{id}")
    public String oneAd(@PathVariable int id, Model model) {

        Advert advert = repository.getAdvert(id);
        model.addAttribute("advert", advert);

        return "advert";
    }

    @GetMapping("/CreateAdvert")
    public String CreateAdvert(Model model) {
        model.addAttribute("advert", new Advert());

        return "CreateAdvert";
    }
    @PostMapping("/save")
    public String CreateAdvertPost(@ModelAttribute Advert advert){
        repository.addAdvert(advert);

        return "redirect:/";
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

    @GetMapping("/edit/{id}")
    public String editBook(@PathVariable Long id, Model model) {

        Advert advert = repository.getAdvert(id);
        model.addAttribute("advert", advert);

        return "edit";

    }
    @PostMapping("/saveEdit/{id}")   //@PutMapping("/saveEdit/{ID}")
    public String editPostBook(@ModelAttribute Advert advert, @PathVariable Long id) {
    //public String editPostBook(@ModelAttribute Advert advert, @PathVariable Long id)
        if (advert.getId() == null) {
            advert.setId(id);
        }

        repository.editAdvert(advert);

        //needs to be connected to the repository "put"

        return "edit";

    }

}
