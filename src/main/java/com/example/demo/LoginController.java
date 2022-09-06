package com.example.demo;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Controller
public class LoginController {

    @GetMapping("/")
    public String nivå1() {
        return "login";
    }
    @PostMapping("/")
    public String nivå1(HttpSession session, @RequestParam String username, @RequestParam String password) {
        if (username.equals("admin") && password.equals("123")) {
            session.setAttribute("username", username);
            return "secret";
        }
        return "login";
    }
    @GetMapping("/secret")
    public String nivå1(HttpSession session){
        String username=(String)session.getAttribute("username");
        if (username!=null){
            return "secret";
        }
        return "redirect:/";
    }
    @GetMapping("/logout")
    public String loggaut(HttpSession session, HttpServletResponse res){
        session.removeAttribute("username");
        session.invalidate();
        Cookie cookie=new Cookie("JSESSIONID", "");
        cookie.setMaxAge(0);
        res.addCookie(cookie);
        return "login";
    }
}