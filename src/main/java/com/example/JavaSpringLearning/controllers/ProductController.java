package com.example.JavaSpringLearning.controllers;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import com.example.JavaSpringLearning.models.ProductModel;
import com.example.JavaSpringLearning.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/api/v1/product") // localhost:8080/api/product
public class ProductController {

    //DI-
    @Autowired
    private ProductService productService;

    //Logger
    Logger logger = Logger.getLogger(ProductController.class.getName());
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // GET: localhost:8080/api/v1/product
    // Get all product
    @GetMapping("")
    List<ProductModel> getAllProduct(){
        if(productService.getAllProduct().isEmpty()){
            for(int i=1;i<10;i++){
                productService.saveProduct(new ProductModel(Long.valueOf(i), "Phone"+i, "Smart phone"));
            }
        }
        productService.getAllProduct().forEach(product ->System.out.println(product));
        logger.info("Fetched data !");
        return productService.getAllProduct();
    }
    //POST: localhost:8080/api/v1/product
    //Add single product
    @PostMapping("")
    void addProduct(@RequestBody ProductModel product){
        productService.saveProduct(product);
        logger.info("Added product:" + product);
    }

    // GET: localhost:8080/api/v1/product/:id
    // Get product deatail
    @GetMapping("/{id}")
    Optional<ProductModel> getProductDetail(@PathVariable("id") Long id){
        logger.info("A detail product: " + productService.getProductById(id));
        return productService.getProductById(id);
    }

    // DETELE: localhost:8080/api/v1/product/:id
    // Detele prouct
    @DeleteMapping("/{id}")
    void deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
        logger.warning("Deleted user with id: " + id);
    }

    //PATCH: localhost:8080/api/v1/product/:id
    //Update product - If not have product -> Add new
    @PatchMapping("/{id}")
    void updateProduct(@PathVariable("id") Long id, @RequestBody ProductModel product){
        productService.upDateProduct(id,product);
        logger.info("Update user with id: " + id);
    }


}
