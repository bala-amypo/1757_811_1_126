package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "customer_profiles")
public class CustomerProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String loyaltyTier; 

    private Double totalPurchaseAmount;


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getLoyaltyTier() { return loyaltyTier; }
    public void setLoyaltyTier(String loyaltyTier) { this.loyaltyTier = loyaltyTier; }

    public Double getTotalPurchaseAmount() { return totalPurchaseAmount; }
    public void setTotalPurchaseAmount(Double totalPurchaseAmount) { this.totalPurchaseAmount = totalPurchaseAmount; }
}
