package com.example.JavaSpringLearning.controllers;

import com.example.JavaSpringLearning.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class IndexController {

    @Autowired
    BlogService blogService;

    @RequestMapping(path ={"","/"})
    @GetMapping("")
    private String getIndexPage(Model model){
        model.addAttribute("blogs", blogService.getAllBlog());
        return "index";
    }
}
