package com.example.demo.service.impl;

import com.example.demo.entity.CustomerProfile;
import com.example.demo.service.CustomerProfileService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service  // <-- This annotation is critical
public class CustomerProfileServiceImpl implements CustomerProfileService {

    private List<CustomerProfile> customers = new ArrayList<>();

    @Override
    public CustomerProfile getCustomerById(Long id) {
        return customers.stream().filter(c -> c.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<CustomerProfile> getAllCustomers() {
        return customers;
    }

    @Override
    public CustomerProfile saveCustomer(CustomerProfile customer) {
        customers.add(customer);
        return customer;
    }
}
