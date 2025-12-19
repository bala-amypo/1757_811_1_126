package com.example.demo.service.impl;

import com.example.demo.entity.CustomerProfileEntity;
import com.example.demo.repository.CustomerProfileRepository;
import com.example.demo.service.CustomerProfileService;

import java.util.List;
import java.util.NoSuchElementException;

public class CustomerProfileServiceImpl implements CustomerProfileService {

    private final CustomerProfileRepository repository;

    public CustomerProfileServiceImpl(CustomerProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public CustomerProfileEntity createCustomer(CustomerProfileEntity customer) {
        if (repository.findByCustomerId(customer.getCustomerId()).isPresent()) {
            throw new IllegalArgumentException("Customer ID already exists");
        }
        if (customer.getCurrentTier() == null) {
            customer.setCurrentTier("BRONZE");
        }
        return repository.save(customer);
    }

    @Override
    public CustomerProfileEntity getCustomerById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Customer not found"));
    }

    @Override
    public CustomerProfileEntity findByCustomerId(String customerId) {
        return repository.findByCustomerId(customerId)
                .orElseThrow(() -> new NoSuchElementException("Customer not found"));
    }

    @Override
    public List<CustomerProfileEntity> getAllCustomers() {
        return repository.findAll();
    }

    @Override
    public CustomerProfileEntity updateTier(Long id, String newTier) {
        CustomerProfileEntity c = getCustomerById(id);
        c.setCurrentTier(newTier);
        return repository.save(c);
    }

    @Override
    public CustomerProfileEntity updateStatus(Long id, boolean active) {
        CustomerProfileEntity c = getCustomerById(id);
        c.setActive(active);
        return repository.save(c);
    }
}
