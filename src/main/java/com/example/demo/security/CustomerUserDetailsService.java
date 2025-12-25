package com.example.demo.security;

import com.example.demo.entity.CustomerProfile;
import com.example.demo.repository.CustomerProfileRepository;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final CustomerProfileRepository repository;

    public CustomUserDetailsService(CustomerProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String customerId)
            throws UsernameNotFoundException {

        CustomerProfile customer = repository
                .findByCustomerId(customerId)
                .orElseThrow(() -> new UsernameNotFoundException("Customer not found"));

        return User.withUsername(customer.getCustomerId())
                .password("{noop}password")
                .roles("USER")
                .build();
    }
}
