package com.example.demo.service.impl;

import com.example.demo.model.TierUpgradeRule;
import com.example.demo.repository.TierUpgradeRuleRepository;
import com.example.demo.service.TierUpgradeRuleService;

import java.util.List;
import java.util.NoSuchElementException;

public class TierUpgradeRuleServiceImpl implements TierUpgradeRuleService {

    private final TierUpgradeRuleRepository ruleRepo;

    // REQUIRED constructor order
    public TierUpgradeRuleServiceImpl(TierUpgradeRuleRepository ruleRepo) {
        this.ruleRepo = ruleRepo;
    }

    @Override
    public TierUpgradeRule createRule(TierUpgradeRule rule) {
        if (rule.getMinSpend() < 0 || rule.getMinVisits() < 0) {
            throw new IllegalArgumentException("Minimum spend and visits must be non-negative");
        }
        return ruleRepo.save(rule);
    }

    @Override
    public TierUpgradeRule updateRule(Long id, TierUpgradeRule updatedRule) {
        TierUpgradeRule existing = ruleRepo.findById(id)
                .orElseThrow(NoSuchElementException::new);

        existing.setFromTier(updatedRule.getFromTier());
        existing.setToTier(updatedRule.getToTier());
        existing.setMinSpend(updatedRule.getMinSpend());
        existing.setMinVisits(updatedRule.getMinVisits());
        existing.setActive(updatedRule.getActive());

        return ruleRepo.save(existing);
    }

    @Override
    public TierUpgradeRule getRule(String fromTier, String toTier) {
        return ruleRepo.findByFromTierAndToTier(fromTier, toTier)
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<TierUpgradeRule> getActiveRules() {
        return ruleRepo.findByActiveTrue();
    }

    @Override
    public List<TierUpgradeRule> getAllRules() {
        return ruleRepo.findAll();
    }
}
