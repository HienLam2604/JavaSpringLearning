package com.example.JavaSpringLearning.service;

import com.example.JavaSpringLearning.models.BlogModel;

import java.util.List;
import java.util.Optional;

public interface BlogService {
    List <BlogModel> getAllBlog();
    Optional<BlogModel> getBlogById(Long id);
    void saveBlog(BlogModel newBlog);

}
