package com.example.shopapi.controllers;

import com.example.shopapi.entities.Product;
import com.example.shopapi.entities.User;
import com.example.shopapi.repositories.ProductRepository;
import com.example.shopapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/product")
    public Product addNewProduct(@Validated @RequestBody Product product) {
        return productRepository.save(product);
    }

    @DeleteMapping("/product/{id}")//delete
    public void deleteProduct(@PathVariable Long id) {
        Product product = productRepository.findById(id).orElseThrow();
        productRepository.delete(product);
    }

    @GetMapping("/products") //get list of all products
    public List<Product> getListOfProducts() {
        return productRepository.findAll();
    }

    @PutMapping("/product/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        Product foundProduct = productRepository.findById(id).orElseThrow();
        foundProduct.setName(product.getName());
        foundProduct.setPrice(product.getPrice());
        foundProduct.setQuantity(product.getQuantity());
        return productRepository.save(foundProduct);
    }

}


/* Products, sales, Users = (owner, workers, customer)
 * CRUD for products, users, CRU for Sales
 * Buy product - customers
 * add, remove, modify products - owner
 * sales report - owner
 * */
