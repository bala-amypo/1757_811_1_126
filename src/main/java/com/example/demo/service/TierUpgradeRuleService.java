package com.example.demo.service;

import java.util.*;
import com.example.demo.model.*;
@Service
public interface TierUpgradeRuleService {
    TierUpgradeRuleEntity createRule(TierUpgradeRuleEntity rule);
    TierUpgradeRuleEntity updateRule(Long id, TierUpgradeRuleEntity rule);
    TierUpgradeRuleEntity getRule(String fromTier, String toTier);
    List<TierUpgradeRuleEntity> getActiveRules();
    List<TierUpgradeRuleEntity> getAllRules();
}