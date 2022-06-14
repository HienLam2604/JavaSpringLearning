package com.example.JavaSpringLearning.repository;

import com.example.JavaSpringLearning.models.BlogModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends MongoRepository<BlogModel,Long> {
}
