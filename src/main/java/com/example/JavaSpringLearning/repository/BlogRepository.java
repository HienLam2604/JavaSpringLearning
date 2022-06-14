package com.example.JavaSpringLearning.repository;

import com.example.JavaSpringLearning.models.BlogModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends MongoRepository<BlogModel,Long> {
    @Query("{title:/?0/}") //SELECT * FROM Blog WHERE title like ?
    List<BlogModel> getBlogByName(String title);
}
