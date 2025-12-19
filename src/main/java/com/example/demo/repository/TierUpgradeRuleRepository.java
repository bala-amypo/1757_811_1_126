package com.example.demo.repository;

import com.example.demo.entity.TierUpgradeRuleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TierUpgradeRuleRepository
        extends JpaRepository<TierUpgradeRuleEntity, Long> {

    Optional<TierUpgradeRuleEntity> findByFromTierAndToTier(
            String fromTier, String toTier);

    List<TierUpgradeRuleEntity> findByActiveTrue();
}
