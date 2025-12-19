package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tier_history")
public class TierHistoryRecord{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long customerId;

    private String fromTier;  

    private String toTier;    

    private LocalDateTime changedAt;

    // 🔹 Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    // ⭐ THIS WAS MISSING
    public String getFromTier() {
        return fromTier;
    }

    // ⭐ THIS WAS MISSING
    public void setFromTier(String fromTier) {
        this.fromTier = fromTier;
    }

   
    public String getToTier() {
        return toTier;
    }

    // ⭐ THIS WAS MISSING
    public void setToTier(String toTier) {
        this.toTier = toTier;
    }

    public LocalDateTime getChangedAt() {
        return changedAt;
    }

    public void setChangedAt(LocalDateTime changedAt) {
        this.changedAt = changedAt;
    }
}
