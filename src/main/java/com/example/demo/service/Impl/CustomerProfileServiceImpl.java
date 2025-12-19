package com.example.demo.service.impl;

import com.example.demo.model.CustomerProfile;
import com.example.demo.repository.CustomerProfileRepository;
import com.example.demo.service.CustomerProfileService;

import java.util.List;
import java.util.NoSuchElementException;

public class CustomerProfileServiceImpl implements CustomerProfileService {

    private final CustomerProfileRepository customerRepo;

    // REQUIRED constructor order
    public CustomerProfileServiceImpl(CustomerProfileRepository customerRepo) {
        this.customerRepo = customerRepo;
    }

    @Override
    public CustomerProfile createCustomer(CustomerProfile customer) {
        return customerRepo.save(customer);
    }

    @Override
    public CustomerProfile getCustomerById(Long id) {
        return customerRepo.findById(id)
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public CustomerProfile findByCustomerId(String customerId) {
        return customerRepo.findByCustomerId(customerId)
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<CustomerProfile> getAllCustomers() {
        return customerRepo.findAll();
    }

    @Override
    public CustomerProfile updateTier(Long id, String newTier) {
        CustomerProfile customer = getCustomerById(id);
        customer.setCurrentTier(newTier);
        return customerRepo.save(customer);
    }

    @Override
    public CustomerProfile updateStatus(Long id, boolean active) {
        CustomerProfile customer = getCustomerById(id);
        customer.setActive(active);
        return customerRepo.save(customer);
    }
}
