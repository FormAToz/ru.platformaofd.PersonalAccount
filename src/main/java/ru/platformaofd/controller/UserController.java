package ru.platformaofd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;

@Controller
@RequestMapping("users")
public class UserController {

    @PostMapping("/login")
    public ModelAndView login(@RequestParam String login, @RequestParam String password) {
        return new ModelAndView("homePage");
    }

    @PostMapping("/register")
    public ModelAndView register(@RequestParam String login, @RequestParam String password) {
        return new ModelAndView("homePage");
    }

    @GetMapping("/details")
    public ModelAndView getUserDetails() {
        return new ModelAndView("userDetails", "users", Arrays.asList("User1", "User2", "User3"));
    }
}