package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(
    name = "tier_upgrade_rules",
    uniqueConstraints = @UniqueConstraint(columnNames = {"from_tier", "to_tier"})
)
public class TierUpgradeRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "from_tier")
    private String fromTier;

    @Column(name = "to_tier")
    private String toTier;

    @Column(name = "min_spend")
    private Double minSpend;

    @Column(name = "min_points")
    private Integer minVisits;

    private Boolean active;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFromTier() { return fromTier; }
    public void setFromTier(String fromTier) { this.fromTier = fromTier; }

    public String getToTier() { return toTier; }
    public void setToTier(String toTier) { this.toTier = toTier; }

    public Double getMinSpend() { return minSpend; }
    public void setMinSpend(Double minSpend) { this.minSpend = minSpend; }

    public Integer getMinVisits() { return minVisits; }
    public void setMinVisits(Integer minVisits) { this.minVisits = minVisits; }

    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }
}
