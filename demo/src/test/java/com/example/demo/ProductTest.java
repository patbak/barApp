package com.example.demo;

import com.example.demo.model.Order;
import com.example.demo.model.Product;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class ProductTest {


    @Autowired
    private ProductRepository productRepository;

    @Test
    @Transactional
    public void getProductsTest()throws Exception{
        List<Product> products = productRepository.findAll();

        assertTrue(products.size()>0);
    }


}
