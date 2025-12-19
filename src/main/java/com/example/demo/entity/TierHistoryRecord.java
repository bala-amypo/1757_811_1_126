package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class TierHistoryRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerProfile customer;

    private String fromTier;
    private String toTier;
    private LocalDateTime upgradeDate;

    public Long getId() {
        return id;
    }

    public CustomerProfile getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerProfile customer) {
        this.customer = customer;
    }

    public String getFromTier() {
        return fromTier;
    }

    public void setFromTier(String fromTier) {
        this.fromTier = fromTier;
    }

    public String getToTier() {
        return toTier;
    }

    public void setToTier(String toTier) {
        this.toTier = toTier;
    }

    public LocalDateTime getUpgradeDate() {
        return upgradeDate;
    }

    public void setUpgradeDate(LocalDateTime upgradeDate) {
        this.upgradeDate = upgradeDate;
    }
}
