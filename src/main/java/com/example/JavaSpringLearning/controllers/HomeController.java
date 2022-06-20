package com.example.JavaSpringLearning.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping(path = "/home")
public class HomeController {

    @GetMapping("")
    public String getHomePage(){
        return "home";
    }
}
