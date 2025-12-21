package com.example.demo.controller;

import com.example.demo.entity.CustomerProfile;
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


    @PostMapping("/register")
    public CustomerProfile register(@RequestBody CustomerProfile customerProfile) {
        return customerProfileService.createCustomer(customerProfile);
    }

   
    @PostMapping("/login")
    public Map<String, String> login(@RequestParam String customerId) {
        CustomerProfile customer =
                customerProfileService.findByCustomerId(customerId);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Login successful");
        response.put("customerId", customer.getCustomerId());
        response.put("currentTier", customer.getCurrentTier());

        return response;
    }
}
