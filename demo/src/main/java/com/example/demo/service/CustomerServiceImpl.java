package com.example.demo.service;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getCustomers() {

        List<Customer> customers = customerRepository.findAll();

        return customers;
    }

    @Override
    public void addCustomer(Customer customer) {
        customerRepository.saveAndFlush(customer);
    }
}
