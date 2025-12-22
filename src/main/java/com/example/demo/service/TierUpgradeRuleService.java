package com.example.demo.service;

import com.example.demo.entity.TierUpgradeRule;

import java.util.List;

public interface TierUpgradeRuleService {

    TierUpgradeRule createRule(TierUpgradeRule rule);

    List<TierUpgradeRule> getAllRules();

    List<TierUpgradeRule> getActiveRules();


    TierUpgradeRule updateRule(Long id, TierUpgradeRule updatedRule);
}
