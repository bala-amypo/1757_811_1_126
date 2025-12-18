package com.example.demo.service;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import java.util.*;

public class CustomerProfileServiceImpl {
    private final CustomerProfileRepository repo;
    public CustomerProfileService(CustomerProfileRepository repo) { this.repo = repo; }

    public CustomerProfile createCustomer(CustomerProfile c) { return repo.save(c); }
    public CustomerProfile getCustomerById(Long id) {
        return repo.findById(id).orElseThrow(NoSuchElementException::new);
    }
    public CustomerProfile findByCustomerId(String id) {
        return repo.findByCustomerId(id).orElseThrow(NoSuchElementException::new);
    }
    public List<CustomerProfile> getAllCustomers() { return repo.findAll(); }
    public CustomerProfile updateTier(Long id, String tier) {
        CustomerProfile c = getCustomerById(id);
        c.setCurrentTier(tier);
        return repo.save(c);
    }
    public CustomerProfile updateStatus(Long id, boolean active) {
        CustomerProfile c = getCustomerById(id);
        c.setActive(active);
        return repo.save(c);
    }
}