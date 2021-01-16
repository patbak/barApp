package com.example.demo;

import com.example.demo.model.Customer;
import com.example.demo.model.Order;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class OrderTest {


    @Autowired
    private OrderRepository orderRepository;

    @Test
    @Transactional
    public void getOrdersTest()throws Exception{
        List<Order> orders = orderRepository.findAll();

        assertTrue(orders.size()>0);
    }

}
