package com.example.JavaSpringLearning.repository;

import com.example.JavaSpringLearning.models.ProductModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<ProductModel,String> {

}
