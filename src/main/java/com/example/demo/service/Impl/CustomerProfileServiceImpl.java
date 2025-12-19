package com.example.demo.service;

import com.example.demo.model.CustomerProfileEntity;
import com.example.demo.repository.CustomerProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
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
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public CustomerProfileEntity findByCustomerId(String customerId) {
        return repository.findByCustomerId(customerId)
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<CustomerProfileEntity> getAllCustomers() {
        return repository.findAll();
    }

    @Override
    public CustomerProfileEntity updateTier(Long id, String newTier) {
        CustomerProfileEntity customer = getCustomerById(id);
        customer.setCurrentTier(newTier);
        return repository.save(customer);
    }

    @Override
    public CustomerProfileEntity updateStatus(Long id, boolean active) {
        CustomerProfileEntity customer = getCustomerById(id);
        customer.setActive(active);
        return repository.save(customer);
    }
}