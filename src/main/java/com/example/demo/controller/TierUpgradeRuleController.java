package com.example.demo.controller;

import com.example.demo.entity.TierUpgradeRule;
import com.example.demo.service.TierUpgradeRuleService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tier-rules")
public class TierUpgradeRuleController {

    private final TierUpgradeRuleService tierUpgradeRuleService;

    public TierUpgradeRuleController(TierUpgradeRuleService tierUpgradeRuleService) {
        this.tierUpgradeRuleService = tierUpgradeRuleService;
    }

    @PostMapping
    public TierUpgradeRule createRule(@RequestBody TierUpgradeRule rule) {
        rule.setId(null);
        return tierUpgradeRuleService.createRule(rule);
    }

    @GetMapping
    public List<TierUpgradeRule> getAllRules() {
        return tierUpgradeRuleService.getAllRules();
    }

    @GetMapping("/active")
    public List<TierUpgradeRule> getActiveRules() {
        return tierUpgradeRuleService.getActiveRules();
    }

  
    @PutMapping("/{id}")
    public TierUpgradeRule updateRule(
            @PathVariable Long id,
            @RequestBody TierUpgradeRule updatedRule) {

        return tierUpgradeRuleService.updateRule(id, updatedRule);
    }
}
