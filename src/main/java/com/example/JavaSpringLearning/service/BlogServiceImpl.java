package com.example.JavaSpringLearning.service;

import com.example.JavaSpringLearning.models.BlogModel;
import com.example.JavaSpringLearning.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogServiceImpl implements BlogService{

    @Autowired
    BlogRepository blogRepository;

    @Override
    public List<BlogModel> getAllBlog() {
        return blogRepository.findAll();
    }

    @Override
    public Optional<BlogModel> getBlogById(Long id) {
        return blogRepository.findById(id);
    }

    @Override
    public void saveBlog(BlogModel newBlog) {
        blogRepository.save(newBlog);
    }
}
