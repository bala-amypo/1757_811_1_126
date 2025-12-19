package com.example.demo.service;

import com.example.demo.entity.CustomerProfileEntity;
import java.util.List;

public interface CustomerProfileService {

    CustomerProfileEntity createCustomer(CustomerProfileEntity customer);

    CustomerProfileEntity getCustomerById(Long id);

    CustomerProfileEntity findByCustomerId(String customerId);

    List<CustomerProfileEntity> getAllCustomers();

    CustomerProfileEntity updateTier(Long id, String newTier);

    CustomerProfileEntity updateStatus(Long id, boolean active);
}
