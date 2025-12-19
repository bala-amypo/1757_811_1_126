package com.example.demo.service.impl;

import com.example.demo.entity.CustomerProfile;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.CustomerProfileRepository;
import com.example.demo.service.CustomerProfileService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerProfileServiceImpl implements CustomerProfileService {

    private final CustomerProfileRepository repository;

    public CustomerProfileServiceImpl(CustomerProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public CustomerProfile createCustomer(CustomerProfile customer) {
        return repository.save(customer);
    }

    @Override
    public CustomerProfile getCustomerById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found"));
    }

    @Override
    public CustomerProfile findByCustomerId(String customerId) {
        return repository.findByCustomerId(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found"));
    }

    @Override
    public List<CustomerProfile> getAllCustomers() {
        return repository.findAll();
    }

    @Override
    public CustomerProfile updateTier(Long id, String newTier) {
        CustomerProfile customer = getCustomerById(id);
        customer.setCurrentTier(newTier);
        return repository.save(customer);
    }

    @Override
    public CustomerProfile updateStatus(Long id, boolean active) {
        CustomerProfile customer = getCustomerById(id);
        customer.setActive(active);
        return repository.save(customer);
    }


    @Override
    public Optional<CustomerProfile> findByEmail(String email) {
        return repository.findByEmail(email);
    }
}
