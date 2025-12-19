package com.example.demo.service;

import java.util.*;
import com.example.demo.model.*;

public interface CustomerProfileService {
    CustomerProfileEntity createCustomer(CustomerProfileEntity customer);
    CustomerProfileEntity getCustomerById(Long id);
    CustomerProfileEntity findByCustomerId(String customerId);
    List<CustomerProfileEntity> getAllCustomers();
    CustomerProfileEntity updateTier(Long id, String newTier);
    CustomerProfileEntity updateStatus(Long id, boolean active);
}