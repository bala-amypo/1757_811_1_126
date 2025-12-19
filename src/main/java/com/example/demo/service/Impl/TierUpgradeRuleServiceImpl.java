package com.example.demo.service.impl;

import com.example.demo.entity.TierUpgradeRuleEntity;
import com.example.demo.repository.TierUpgradeRuleRepository;
import com.example.demo.service.TierUpgradeRuleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TierUpgradeRuleServiceImpl implements TierUpgradeRuleService {

    private final TierUpgradeRuleRepository repository;

    public TierUpgradeRuleServiceImpl(TierUpgradeRuleRepository repository) {
        this.repository = repository;
    }

    @Override
    public TierUpgradeRuleEntity createRule(TierUpgradeRuleEntity rule) {
        if (rule.getMinSpend() < 0 || rule.getMinVisits() < 0) {
            throw new IllegalArgumentException("Invalid rule values");
        }
        return repository.save(rule);
    }

    @Override
    public TierUpgradeRuleEntity updateRule(Long id, TierUpgradeRuleEntity updatedRule) {
        TierUpgradeRuleEntity rule = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Rule not found"));

        rule.setFromTier(updatedRule.getFromTier());
        rule.setToTier(updatedRule.getToTier());
        rule.setMinSpend(updatedRule.getMinSpend());
        rule.setMinVisits(updatedRule.getMinVisits());
        rule.setActive(updatedRule.getActive());

        return repository.save(rule);
    }

    @Override
    public List<TierUpgradeRuleEntity> getActiveRules() {
        return repository.findByActiveTrue();
    }

    @Override
    public TierUpgradeRuleEntity getRule(String fromTier, String toTier) {
        return repository.findByFromTierAndToTier(fromTier, toTier)
                .orElseThrow(() -> new NoSuchElementException("Rule not found"));
    }

    @Override
    public List<TierUpgradeRuleEntity> getAllRules() {
        return repository.findAll();
    }
}
