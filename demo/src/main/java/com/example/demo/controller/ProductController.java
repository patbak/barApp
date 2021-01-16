package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.model.Product;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;

    @GetMapping("/getProducts")
    public List<Product> getProducts(){
        List<Product> products = productRepository.findAll();
        return products;
    }


    @PostMapping("/addProducts")
    public ResponseEntity<String> addNewProducts(
            @RequestBody
            List<Product> products) {

        productService.addProducts(products);
        return new ResponseEntity<>("Produkty zostały dodane!", HttpStatus.OK);
    }
}
