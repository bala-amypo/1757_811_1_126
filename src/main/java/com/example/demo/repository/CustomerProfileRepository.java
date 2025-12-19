package com.example.demo.repository;

import com.example.demo.entity.CustomerProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerProfileRepository
        extends JpaRepository<CustomerProfileEntity, Long> {

    Optional<CustomerProfileEntity> findByCustomerId(String customerId);

    Optional<CustomerProfileEntity> findByEmail(String email);
}
