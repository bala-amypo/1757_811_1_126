package com.example.demo.service;

import com.example.demo.entity.TierUpgradeRuleEntity;
import java.util.List;

public interface TierUpgradeRuleService {

    TierUpgradeRuleEntity createRule(TierUpgradeRuleEntity rule);

    TierUpgradeRuleEntity updateRule(Long id, TierUpgradeRuleEntity rule);

    List<TierUpgradeRuleEntity> getActiveRules();

    TierUpgradeRuleEntity getRule(String fromTier, String toTier);

    List<TierUpgradeRuleEntity> getAllRules();
}
