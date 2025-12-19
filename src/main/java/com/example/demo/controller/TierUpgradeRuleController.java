package com.example.demo.controller;

import com.example.demo.entity.TierUpgradeRule;
import com.example.demo.service.TierUpgradeRuleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rules")
public class TierUpgradeRuleController {

    private final TierUpgradeRuleService service;

    public TierUpgradeRuleController(TierUpgradeRuleService service) {
        this.service = service;
    }

    @GetMapping
    public List<TierUpgradeRule> getAllRules() {
        return service.getAllRules();
    }

    @GetMapping("/{id}")
    public TierUpgradeRule getRuleById(@PathVariable Long id) {
        return service.getRuleById(id);
    }

    @PostMapping
    public TierUpgradeRule createRule(@RequestBody TierUpgradeRule rule) {
        return service.createRule(rule);
    }

    @DeleteMapping("/{id}")
    public void deleteRule(@PathVariable Long id) {
        service.deleteRule(id);
    }
}
