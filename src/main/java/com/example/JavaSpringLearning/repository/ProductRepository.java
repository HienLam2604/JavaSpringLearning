package com.example.JavaSpringLearning.repository;

import com.example.JavaSpringLearning.models.ProductModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductRepository extends MongoRepository<ProductModel,String> {
    ProductModel findbyName(String name);
    List<ProductModel> findAll(String products);
}
