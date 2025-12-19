package com.example.demo.service.impl;

import com.example.demo.entity.TierUpgradeRule;
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
    public List<TierUpgradeRule> getAllRules() {
        return repository.findAll();
    }

    @Override
    public TierUpgradeRule getRuleById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public TierUpgradeRule createRule(TierUpgradeRule rule) {
        return repository.save(rule);
    }

    @Override
    public void deleteRule(Long id) {
        repository.deleteById(id);
    }
}
