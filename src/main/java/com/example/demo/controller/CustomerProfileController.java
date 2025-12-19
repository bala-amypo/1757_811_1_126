package com.example.demo.controller;

import com.example.demo.entity.CustomerProfile;
import com.example.demo.service.CustomerProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerProfileController {

    private final CustomerProfileService customerProfileService;

    @Autowired
    public CustomerProfileController(CustomerProfileService customerProfileService) {
        this.customerProfileService = customerProfileService;
    }

    @GetMapping("/{id}")
    public CustomerProfile getCustomer(@PathVariable Long id) {
        return customerProfileService.getCustomerById(id);
    }

    @GetMapping("/all")
    public List<CustomerProfile> getAllCustomers() {
        return customerProfileService.getAllCustomers();
    }

    @PostMapping("/save")
    public CustomerProfile saveCustomer(@RequestBody CustomerProfile customer) {
        return customerProfileService.saveCustomer(customer);
    }
}
