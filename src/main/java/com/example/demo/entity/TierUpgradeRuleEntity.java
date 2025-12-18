package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tier_upgrade_rules",
       uniqueConstraints = @UniqueConstraint(columnNames = {"fromTier","toTier"}))
public class TierUpgradeRuleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fromTier;
    private String toTier;

    private Double minSpend;
    private Integer minVisits;

    private Boolean active = true;

    // getters and setters
}
