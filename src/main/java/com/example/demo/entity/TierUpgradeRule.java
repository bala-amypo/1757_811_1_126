package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tier_upgrade_rules")
public class TierUpgradeRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ruleName;
    private int minPoints;
    private String tier;

    public TierUpgradeRule() {}

    public TierUpgradeRule(String ruleName, int minPoints, String tier) {
        this.ruleName = ruleName;
        this.minPoints = minPoints;
        this.tier = tier;
    }

 
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getRuleName() { return ruleName; }
    public void setRuleName(String ruleName) { this.ruleName = ruleName; }

    public int getMinPoints() { return minPoints; }
    public void setMinPoints(int minPoints) { this.minPoints = minPoints; }

    public String getTier() { return tier; }
    public void setTier(String tier) { this.tier = tier; }
}
