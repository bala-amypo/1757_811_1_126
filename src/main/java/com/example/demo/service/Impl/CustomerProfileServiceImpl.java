package com.example.demo.service.impl;

import com.example.demo.service.*;
import com.example.demo.repository.*;
import com.example.demo.model.*;
import java.util.*;
@Service
public class CustomerProfileServiceImpl implements CustomerProfileService {

    private final CustomerProfileRepository repo;

    public CustomerProfileServiceImpl(CustomerProfileRepository repo) {
        this.repo = repo;
    }

    public CustomerProfileEntity createCustomer(CustomerProfileEntity c) {
        return repo.save(c);
    }

    public CustomerProfileEntity getCustomerById(Long id) {
        return repo.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public CustomerProfileEntity findByCustomerId(String customerId) {
        return repo.findByCustomerId(customerId).orElseThrow(NoSuchElementException::new);
    }

    public List<CustomerProfileEntity> getAllCustomers() {
        return repo.findAll();
    }

    public CustomerProfileEntity updateTier(Long id, String tier) {
        CustomerProfileEntity c = getCustomerById(id);
        c.setCurrentTier(tier);
        return repo.save(c);
    }

    public CustomerProfileEntity updateStatus(Long id, boolean active) {
        CustomerProfileEntity c = getCustomerById(id);
        c.setActive(active);
        return repo.save(c);
    }
}
