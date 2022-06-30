package com.example.JavaSpringLearning.controllers;


import com.example.JavaSpringLearning.models.BlogModel;
import com.example.JavaSpringLearning.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/blog") //localhost:8080/api/v1/blog
@CrossOrigin(origins ="http://localhost:4200")
public class BlogController {

    @Autowired
    BlogService blogService;

    public BlogController(BlogService blogService) {
    }
    @GetMapping("")
    Page<BlogModel> getAllBlog(Model model, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "4") int size){
        // 4 items/page
        Pageable paging = PageRequest.of(page,size);
        if(blogService.getAllBlog(paging).isEmpty()){
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            String content = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. " +
                    "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer " +
                    "took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, "
                    ;
            for(int i = 1; i<=21;i++){
                blogService.saveBlog(new BlogModel(Long.valueOf(i),"Blog "+i, content+i,i,i,dateFormat.format(date)));
            }
        }
        model.addAttribute("blogs",blogService.getAllBlog(paging));
        return blogService.getAllBlog(paging);
    }
    @GetMapping("/{id}")
    Optional<BlogModel> getBlogById(@PathVariable("id") Long id){
        return blogService.getBlogById(id);
    }
    @PostMapping("/add")
    void addNewBlog(@RequestBody BlogModel newBlog){
        blogService.saveBlog(newBlog);

    }
    @DeleteMapping("/{id}")
    void deleteBlog(@PathVariable("id") Long id){
        blogService.deleteBlog(id);
    }
    @PatchMapping("/{id}")
    void updateBlog(@PathVariable("id") Long id, @RequestBody BlogModel newBlog){
        blogService.updateBlog(id, newBlog);
    }

    @GetMapping("/search") //localhost:8080/api/v1/blog/search?title=?
    List<BlogModel> searchBlog(@RequestParam(required = false) String title){
        //System.out.println(title);
        return blogService.getBlogByName(title);
    }
}
