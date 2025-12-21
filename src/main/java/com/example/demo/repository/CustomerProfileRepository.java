package com.example.demo.repository;

import com.example.demo.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface CustomerProfileRepository extends JpaRepository<CustomerProfile, Long> {
    Optional<CustomerProfile> findByCustomerId(String customerId);
}