package com.example.demo.controller;

import com.example.demo.model.CustomerProfileEntity;
import com.example.demo.service.CustomerProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerProfileController {

    private final CustomerProfileService service;

    public CustomerProfileController(CustomerProfileService service) {
        this.service = service;
    }

    @PostMapping
    public CustomerProfileEntity createCustomer(@RequestBody CustomerProfileEntity customer) {
        return service.createCustomer(customer);
    }

    @GetMapping("/{id}")
    public CustomerProfileEntity getCustomer(@PathVariable Long id) {
        return service.getCustomerById(id);
    }

    @GetMapping
    public List<CustomerProfileEntity> getAllCustomers() {
        return service.getAllCustomers();
    }

    @PutMapping("/tier")
    public CustomerProfileEntity updateTier(
            @RequestParam Long id,
            @RequestParam String tier) {
        return service.updateTier(id, tier);
    }

    @PutMapping("/status")
    public CustomerProfileEntity updateStatus(
            @RequestParam Long id,
            @RequestParam boolean active) {
        return service.updateStatus(id, active);
    }

    @GetMapping("/lookup/{customerId}")
    public CustomerProfileEntity findByCustomerId(@PathVariable String customerId) {
        return service.findByCustomerId(customerId);
    }
}
