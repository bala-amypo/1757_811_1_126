package com.example.demo.repository;

import com.example.demo.entity.TierUpgradeRule; // ✅ Correct package
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TierUpgradeRuleRepository extends JpaRepository<TierUpgradeRule, Long> {

    // Example query methods
    TierUpgradeRule findByRuleName(String ruleName);

}
