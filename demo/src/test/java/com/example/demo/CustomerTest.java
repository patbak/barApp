package com.example.demo;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class CustomerTest {


    @Autowired
    private CustomerRepository customerRepository;

    @Test
    @Transactional
    public void getCustomersTest()throws Exception{
        List<Customer> customerList = customerRepository.findAll();

        assertTrue(customerList.size()>0);
    }

}
