package com.example.JavaSpringLearning.repository;

import com.example.JavaSpringLearning.models.ProductModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<ProductModel,Long> {
   // public ProductModel getProductById(int id);
}
