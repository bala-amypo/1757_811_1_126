package com.example.demo.controller;

import com.example.demo.entity.CustomerProfile;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.service.CustomerProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final CustomerProfileService customerProfileService;

    public AuthController(CustomerProfileService customerProfileService) {
        this.customerProfileService = customerProfileService;
    }

    // ================= REGISTER =================
    @PostMapping("/register")
    public Map<String, Object> register(@RequestBody CustomerProfile customer) {

        CustomerProfile savedCustomer =
                customerProfileService.createCustomer(customer);

        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "User registered successfully");
        response.put("customerId", savedCustomer.getId());
        response.put("tier", savedCustomer.getCurrentTier());

        return response;
    }

    // ================= LOGIN =================
    @PostMapping("/login")
    public Map<String, Object> login(@RequestParam String email) {

        CustomerProfile customer =
                customerProfileService.findByEmail(email)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "User not found with email: " + email));

        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Login successful");
        response.put("customerId", customer.getId());
        response.put("tier", customer.getCurrentTier());

        return response;
    }
}
