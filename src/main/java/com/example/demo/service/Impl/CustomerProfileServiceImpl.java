package com.example.demo.service.impl;

import com.example.demo.entity.CustomerProfileEntity;
import com.example.demo.repository.CustomerProfileRepository;
import com.example.demo.service.CustomerProfileService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service   // ⭐ THIS WAS MISSING
public class CustomerProfileServiceImpl implements CustomerProfileService {

    private final CustomerProfileRepository repository;

    public CustomerProfileServiceImpl(CustomerProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public CustomerProfileEntity createCustomer(CustomerProfileEntity customer) {
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
        CustomerProfileEntity customer = getCustomerById(id);
        customer.setTier(newTier);
        return repository.save(customer);
    }

    @Override
    public CustomerProfileEntity updateStatus(Long id, boolean active) {
        CustomerProfileEntity customer = getCustomerById(id);
        customer.setActive(active);
        return repository.save(customer);
    }
}
