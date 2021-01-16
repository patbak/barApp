package com.example.demo.service;

import com.example.demo.model.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getCustomers();

    void addCustomer(Customer customer);
}
