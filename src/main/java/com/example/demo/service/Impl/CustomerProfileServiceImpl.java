package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.*;
import java.util.*;
import org.springframework.stereotype.Service;

@Service
public class CustomerProfileServiceImpl implements CustomerProfileService {

    private final CustomerProfileRepository repo;

    public CustomerProfileServiceImpl(CustomerProfileRepository repo) {
        this.repo = repo;
    }

    public CustomerProfile createCustomer(CustomerProfile customer) {
        if (repo.findByCustomerId(customer.getCustomerId()).isPresent()) {
            throw new IllegalArgumentException("Customer ID already exists");
        }
        return repo.save(customer);
    }

    public CustomerProfile getCustomerById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Customer not found"));
    }

    public CustomerProfile findByCustomerId(String customerId) {
        return repo.findByCustomerId(customerId)
                .orElseThrow(() -> new NoSuchElementException("Customer not found"));
    }

    public List<CustomerProfile> getAllCustomers() {
        return repo.findAll();
    }

    public CustomerProfile updateTier(Long id, String newTier) {
        CustomerProfile c = getCustomerById(id);
        c.setCurrentTier(newTier);
        return repo.save(c);
    }
}
