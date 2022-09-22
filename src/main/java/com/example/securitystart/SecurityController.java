package com.example.securitystart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SecurityController {

    /*
    @Autowired
    OldRepository repository;
    */
    @Autowired
    private AdvertRepository repository;

    @Autowired
    private OwnerRepository ownerRepository;

    @GetMapping("/")
    public String start(Model model) {
       // model.addAttribute("repository", repository.getAllAdverts());
        List<Advert> adverts = (List<Advert>) repository.findAll();
        model.addAttribute("repository", adverts);
        return "start";
    }

    @GetMapping("/advert/{id}")
    public String oneAd(@PathVariable Long id, Model model) {

        //Advert advert = repository.getAdvert(id);
        Advert advert = repository.findById(id).orElse(null);
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
      //  repository.addAdvert(advert);
        repository.save(advert);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editBook(@PathVariable Long id, Model model) {

        //Advert advert = repository.getAdvert(id);
        Advert advert = repository.findById(id).orElse(null);
        model.addAttribute("advert", advert);

        return "edit";

    }
    @PostMapping("/saveEdit/{id}")
    public String editPostBook(@ModelAttribute Advert advert, @PathVariable Long id) {

        if (advert.getId() == null) {
            advert.setId(id);
        }
        //repository.editAdvert(advert);
        repository.save(advert);
        return "edit";

    }


    @GetMapping("/shoppingCart/{id}")
    String shoppingCart(HttpSession session, @PathVariable Long id) {

        ArrayList<Advert> cart = (ArrayList<Advert>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
            session.setAttribute("cart", cart);
        }

        // Advert advert = repository.getAdvert(id);
        Advert advert = repository.findById(id).orElse(null);
        if (cart.contains(advert)) {
            int i = cart.indexOf(advert);
            advert = cart.get(i);
            advert.setQuantity(advert.getQuantity()+1);
        } else {
            cart.add(advert);
        }

        return "shoppingCart";

    }
    @GetMapping("/cart")
    String getCart() {
        return "shoppingCart";
    }

    @GetMapping("/test/{id}")
    public String addOwner(@PathVariable Long id, Model model) {
        Advert advert = repository.findById(id).orElse(null);
        //List<Owner> owner = ownerRepository.findByName(name);
       // advert.setOwner(owner.get(0));

        Owner owner = new Owner("Test", "Fest");
        ownerRepository.save(owner);
        advert.setOwner(owner);
        repository.save(advert);

        model.addAttribute("advert", advert);
       // model.addAttribute("owner", owner);


        return "advert";



    }






}
