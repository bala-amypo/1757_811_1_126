package com.example.demo.controller;

import com.example.demo.model.TierUpgradeRuleEntity;
import com.example.demo.service.TierUpgradeRuleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tier-rules")
public class TierUpgradeRuleController {

    private final TierUpgradeRuleService service;

    public TierUpgradeRuleController(TierUpgradeRuleService service) {
        this.service = service;
    }

    @GetMapping
    public List<TierUpgradeRuleEntity> getAllRules() {
        return service.getAllRules();
    }

    @PostMapping
    public TierUpgradeRuleEntity createRule(@RequestBody TierUpgradeRuleEntity rule) {
        return service.createRule(rule);
    }

    @PutMapping("/{id}")
    public TierUpgradeRuleEntity updateRule(
            @PathVariable Long id,
            @RequestBody TierUpgradeRuleEntity rule) {
        return service.updateRule(id, rule);
    }

    @GetMapping("/active")
    public List<TierUpgradeRuleEntity> getActiveRules() {
        return service.getActiveRules();
    }

    @GetMapping("/lookup")
    public TierUpgradeRuleEntity getRule(
            @RequestParam String fromTier,
            @RequestParam String toTier) {
        return service.getRule(fromTier, toTier);
    }
}
