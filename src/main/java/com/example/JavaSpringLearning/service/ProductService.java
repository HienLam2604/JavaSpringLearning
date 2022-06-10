package com.example.JavaSpringLearning.service;


import com.example.JavaSpringLearning.models.ProductModel;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Optional;

//CRUD
public interface ProductService {
    List<ProductModel> getAllProduct();
    Optional<ProductModel> getProductById(Long id);
    void saveProduct(ProductModel Product);
    void deleteProduct(Long id);
    void upDateProduct(Long id, ProductModel product);
}
