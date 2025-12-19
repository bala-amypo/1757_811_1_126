package com.example.demo.repository;

import com.example.demo.entity.CustomerProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerProfileRepository extends JpaRepository<CustomerProfile, Long> {

    Optional<CustomerProfile> findByEmail(String email);

    @Query("SELECT c FROM CustomerProfile c WHERE c.loyaltyTier = :tier")
    List<CustomerProfile> findByLoyaltyTier(@Param("tier") String tier);

    @Query("SELECT c FROM CustomerProfile c WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<CustomerProfile> findByNameContaining(@Param("name") String name);
}
