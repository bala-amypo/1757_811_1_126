package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tier_history")
public class TierHistoryRecordEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long customerId;
    private String oldTier;
    private String newTier;
    private String reason;
    private LocalDateTime changedAt;

    @PrePersist
    void onChange() {
        this.changedAt = LocalDateTime.now();
    }

    // getters and setters
}
