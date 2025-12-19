package com.example.demo.controller;

import com.example.demo.entity.TierUpgradeRuleEntity;
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

    @PostMapping
    public TierUpgradeRuleEntity create(@RequestBody TierUpgradeRuleEntity rule) {
        return service.createRule(rule);
    }

    @PutMapping("/{id}")
    public TierUpgradeRuleEntity update(
            @PathVariable Long id,
            @RequestBody TierUpgradeRuleEntity rule) {
        return service.updateRule(id, rule);
    }

    @GetMapping("/active")
    public List<TierUpgradeRuleEntity> getActive() {
        return service.getActiveRules();
    }

    @GetMapping("/lookup")
    public TierUpgradeRuleEntity getRule(
            @RequestParam String fromTier,
            @RequestParam String toTier) {
        return service.getRule(fromTier, toTier);
    }

    @GetMapping
    public List<TierUpgradeRuleEntity> getAll() {
        return service.getAllRules();
    }
}
