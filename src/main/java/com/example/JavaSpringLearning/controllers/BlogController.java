package com.example.JavaSpringLearning.controllers;


import com.example.JavaSpringLearning.models.BlogModel;
import com.example.JavaSpringLearning.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/blog") //localhost:8080/api/v1/blog
@CrossOrigin(origins ="localhost:4200")
public class BlogController {

    @Autowired
    BlogService blogService;
    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("")
    List <BlogModel> getAllBlog(){
        if(blogService.getAllBlog().isEmpty()){
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            String content = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. " +
                    "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer " +
                    "took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, " +
                    "but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s" +
                    " with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing " +
                    "software like Aldus PageMaker including versions of Lorem Ipsum";
            for(int i = 1; i<=21;i++){
                blogService.saveBlog(new BlogModel(Long.valueOf(i),"Blog "+i, content+i,i,i,dateFormat.format(date)));
            }
        }
        return blogService.getAllBlog();
    }
    @GetMapping("/{id}")
    Optional<BlogModel> getBlogById(@PathVariable("id") Long id){
        return blogService.getBlogById(id);
    }

}
