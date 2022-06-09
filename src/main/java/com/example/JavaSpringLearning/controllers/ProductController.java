package com.example.JavaSpringLearning.controllers;

import java.util.List;
import java.util.Optional;

import com.example.JavaSpringLearning.models.ProductModel;
import com.example.JavaSpringLearning.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/v1/product") // localhost:8080/api/product
public class ProductController {
    int id = 1;
    int id1 = 1;

    //DI-
    @Autowired
    private ProductRepository respository;

    public ProductController(ProductRepository respository) {
        this.respository = respository;
    }

    List<ProductModel> product_arrayList = List.of(
            new ProductModel(id++, "Iphone", "Smart phone"),
            new ProductModel(id++, "Ipad", "Smart phone"),
            new ProductModel(id++, "BBB", "Smart phone"));

    // GET: localhost:8080/api/v1/product
    // Get all product
    /*
    @GetMapping("")
    List<ProductModel> getAllProduct(){
        return product_arrayList;
    }
*/
    @GetMapping("")
    List<ProductModel> getAllProduct(){
        if(respository.findAll().isEmpty()){
            respository.save(new ProductModel(id1++, "Iphone", "Smart phone"));
            respository.save(new ProductModel(id1++, "IBiet", "Smart phone"));
            respository.save(new ProductModel(id1++, "IKeu", "Smart phone"));
        }
        respository.findAll().forEach(product ->System.out.println(product));
        return respository.findAll();
    }
    /*
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
    */

    @GetMapping("/{id}")
    ProductModel getProductDetail(@PathVariable("id") int id){
        return respository.findById(String.valueOf(id)).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
    }

    //POST: localhost:8080/api/v1/product?name=?&des=?
    //Add single product
    @PostMapping("")
    List<ProductModel> addProduct(@RequestParam(value="name",defaultValue = "Test",required = false) String name, @RequestParam(value="des",defaultValue ="abc",required = false) String des){
        int sizeOfArray = product_arrayList.size();
        product_arrayList.add(3,new ProductModel(4, name, des));
        return product_arrayList;
    }

}
