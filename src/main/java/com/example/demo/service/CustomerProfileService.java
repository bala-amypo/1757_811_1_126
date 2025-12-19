package com.example.demo.service;

import com.example.demo.entity.CustomerProfile;
import java.util.List;

public interface CustomerProfileService {

    CustomerProfile getCustomerById(Long id);

    List<CustomerProfile> getAllCustomers();

    CustomerProfile saveCustomer(CustomerProfile customer);
}
