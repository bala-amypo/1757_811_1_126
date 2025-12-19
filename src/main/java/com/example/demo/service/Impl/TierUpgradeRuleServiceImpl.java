package com.example.demo.service.impl;

import com.example.demo.service.*;
import com.example.demo.repository.*;
import com.example.demo.model.*;
import java.util.*;
@Service
public class TierUpgradeRuleServiceImpl implements TierUpgradeRuleService {

    private final TierUpgradeRuleRepository repo;

    public TierUpgradeRuleServiceImpl(TierUpgradeRuleRepository repo) {
        this.repo = repo;
    }

    public TierUpgradeRuleEntity createRule(TierUpgradeRuleEntity r) {
        return repo.save(r);
    }

    public TierUpgradeRuleEntity updateRule(Long id, TierUpgradeRuleEntity r) {
        TierUpgradeRuleEntity e = repo.findById(id).orElseThrow(NoSuchElementException::new);
        e.setMinSpend(r.getMinSpend());
        e.setMinVisits(r.getMinVisits());
        e.setActive(r.getActive());
        return repo.save(e);
    }

    public TierUpgradeRuleEntity getRule(String from, String to) {
        return repo.findByFromTierAndToTier(from, to).orElseThrow(NoSuchElementException::new);
    }

    public List<TierUpgradeRuleEntity> getActiveRules() {
        return repo.findByActiveTrue();
    }

    public List<TierUpgradeRuleEntity> getAllRules() {
        return repo.findAll();
    }
}
