package com.example.JavaSpringLearning.service;

import com.example.JavaSpringLearning.models.ProductModel;
import com.example.JavaSpringLearning.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepository productRepository;
    @Override
    public List<ProductModel> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Optional<ProductModel> getProductById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public void saveProduct(ProductModel product) {
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public void upDateProduct(Long id,ProductModel product) {
        if(product.getId()==id){
            // Update product
            // Don't update id bc it is primary key
            //product.setId(product.getId());
            product.setName(product.getName());
            product.setDescription(product.getDescription());
            this.saveProduct(product);
        }else{
            // New product
            this.saveProduct(product);
        }
    }
}
