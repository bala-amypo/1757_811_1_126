package com.example.demo.controller;

import com.example.demo.entity.CustomerProfile;
import com.example.demo.service.CustomerProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerProfileController {

    private final CustomerProfileService customerProfileService;

    public CustomerProfileController(CustomerProfileService customerProfileService) {
        this.customerProfileService = customerProfileService;
    }

    @PostMapping
    public CustomerProfile createCustomer(@RequestBody CustomerProfile customer) {
        return customerProfileService.createCustomer(customer);
    }

    @GetMapping("/{id}")
    public CustomerProfile getCustomerById(@PathVariable Long id) {
        return customerProfileService.getCustomerById(id);
    }

    @GetMapping
    public List<CustomerProfile> getAllCustomers() {
        return customerProfileService.getAllCustomers();
    }

    @PutMapping("/{id}/tier")
    public CustomerProfile updateTier(
            @PathVariable Long id,
            @RequestParam String newTier) {
        return customerProfileService.updateTier(id, newTier);
    }

    @GetMapping("/lookup/{customerId}")
    public CustomerProfile findByCustomerId(@PathVariable String customerId) {
        return customerProfileService.findByCustomerId(customerId);
    }
}
