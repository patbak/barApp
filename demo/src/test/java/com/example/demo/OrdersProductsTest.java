package com.example.demo;

import com.example.demo.model.Order;
import com.example.demo.model.OrdersProducts;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.OrdersProductsRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class OrdersProductsTest {


    @Autowired
    private OrdersProductsRepository ordersProductsRepository;

    @Test
    @Transactional
    public void getOrdersProductsTest()throws Exception{
        List<OrdersProducts> ordersproducts = ordersProductsRepository.findAll();

        assertTrue(ordersproducts.size()>0);
    }

}
