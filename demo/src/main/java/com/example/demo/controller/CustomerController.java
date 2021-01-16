package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.model.OrdersProducts;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(value = "/getCustomers")
    public List<Customer> getOrderProducts(){
    List<Customer> customers = customerService.getCustomers();
    return customers;
    }

    @PostMapping(value = "/addCustomer")
    public ResponseEntity<String> addCustomer(@RequestBody Customer customer){
            customerService.addCustomer(customer);

        return  new ResponseEntity<>("Dodano klienta", HttpStatus.OK);
    }
}
