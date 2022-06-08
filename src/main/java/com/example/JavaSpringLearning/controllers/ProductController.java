package com.example.JavaSpringLearning.controllers;

import java.util.List;

import com.example.JavaSpringLearning.models.ProductModel;
import com.example.JavaSpringLearning.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/v1/product") // localhost:8080/api/product
public class ProductController implements CommandLineRunner {
    int id = 1;
    @Autowired
    private ProductRepository respository;

    List<ProductModel> product_arrayList = List.of(
            new ProductModel(id++, "Iphone", "Smart phone"),
            new ProductModel(id++, "Ipad", "Smart phone"),
            new ProductModel(id++, "BBB", "Smart phone"));

    // GET: localhost:8080/api/v1/product
    // Get all product
    @GetMapping("")
    List<ProductModel> getAllProduct(){
        return product_arrayList;
    }

    // GET: localhost:8080/api/product/:id
    // Show detail product
    @GetMapping("/{id}")
    ProductModel getProductDetail(@PathVariable(required=false) int id) {
        for(int i=0;i<product_arrayList.size();i++) {
            if(product_arrayList.get(i).getId()==id) {
                return product_arrayList.get(i);
            }
        }
        return null;
    }

    //POST: localhost:8080/api/v1/product?name=?&des=?
    //Add single product
    @PostMapping("")
    List<ProductModel> addProduct(@RequestParam(value="name",defaultValue = "Test",required = false) String name, @RequestParam(value="des",defaultValue ="abc",required = false) String des){
        int sizeOfArray = product_arrayList.size();
        product_arrayList.add(3,new ProductModel(4, name, des));
        return product_arrayList;
    }


    @Override
    public void run(String... args) throws Exception {
        respository.deleteAll();
        ProductModel product = new ProductModel(id++, "Iphone", "Smart phone");
        respository.save(product);
    }
}
