package com.example.demo.service.impl;

import com.example.demo.entity.TierUpgradeRule;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.TierUpgradeRuleRepository;
import com.example.demo.service.TierUpgradeRuleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TierUpgradeRuleServiceImpl implements TierUpgradeRuleService {

    private final TierUpgradeRuleRepository repository;

    public TierUpgradeRuleServiceImpl(TierUpgradeRuleRepository repository) {
        this.repository = repository;
    }

    @Override
    public TierUpgradeRule createRule(TierUpgradeRule rule) {

        if (rule.getMinSpend() < 0 || rule.getMinVisits() < 0) {
            throw new IllegalArgumentException("Invalid rule values");
        }

        return repository.save(rule);
    }

    @Override
    public TierUpgradeRule updateRule(Long id, TierUpgradeRule updatedRule) {

        TierUpgradeRule existing = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Rule not found"));

        existing.setFromTier(updatedRule.getFromTier());
        existing.setToTier(updatedRule.getToTier());
        existing.setMinSpend(updatedRule.getMinSpend());
        existing.setMinVisits(updatedRule.getMinVisits());
        existing.setActive(updatedRule.getActive());

        return repository.save(existing);
    }

    @Override
    public TierUpgradeRule getRule(String fromTier, String toTier) {
        return repository.findByFromTierAndToTier(fromTier, toTier)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Rule not found"));
    }

    @Override
    public List<TierUpgradeRule> getActiveRules() {
        return repository.findByActiveTrue();
    }

    @Override
    public List<TierUpgradeRule> getAllRules() {
        return repository.findAll();
    }
}
