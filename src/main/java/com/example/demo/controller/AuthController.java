package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    // Simple registration endpoint
    @PostMapping("/register")
    public String register(
            @RequestParam String fullName,
            @RequestParam String email,
            @RequestParam String password
    ) {
        // Normally you would save the user to DB here
        return "User registered successfully: " + email;
    }

    // Simple login endpoint
    @PostMapping("/login")
    public String login(
            @RequestParam String email,
            @RequestParam String password
    ) {
        // Normally you would authenticate user and generate JWT token
        return "Login successful! Dummy token for: " + email;
    }
}
