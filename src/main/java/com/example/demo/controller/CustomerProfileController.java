package com.example.demo.controller;

import com.example.demo.entity.CustomerProfileEntity;
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
    public CustomerProfileEntity create(@RequestBody CustomerProfileEntity customer) {
        return service.createCustomer(customer);
    }

    @GetMapping("/{id}")
    public CustomerProfileEntity getById(@PathVariable Long id) {
        return service.getCustomerById(id);
    }

    @GetMapping
    public List<CustomerProfileEntity> getAll() {
        return service.getAllCustomers();
    }

    @PutMapping("/{id}/tier")
    public CustomerProfileEntity updateTier(
            @PathVariable Long id,
            @RequestParam String newTier) {
        return service.updateTier(id, newTier);
    }

    @GetMapping("/lookup/{customerId}")
    public CustomerProfileEntity findByCustomerId(
            @PathVariable String customerId) {
        return service.findByCustomerId(customerId);
    }
}
