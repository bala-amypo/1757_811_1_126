package com.example.demo.service;

import com.example.demo.entity.TierUpgradeRule;
import java.util.List;

public interface TierUpgradeRuleService {

    List<TierUpgradeRule> getAllRules();

    TierUpgradeRule getRuleById(Long id);

    TierUpgradeRule createRule(TierUpgradeRule rule);

    void deleteRule(Long id);
}
