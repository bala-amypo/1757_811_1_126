package com.example.demo.controller;

import com.example.demo.model.CustomerProfileEntity;
import com.example.demo.model.TierHistoryRecordEntity;
import com.example.demo.service.TierUpgradeEngineService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tier-engine")
public class TierUpgradeEngineController {

    private final TierUpgradeEngineService service;

    public TierUpgradeEngineController(TierUpgradeEngineService service) {
        this.service = service;
    }

    @PostMapping("/evaluate/{customerId}")
    public CustomerProfileEntity evaluate(@PathVariable Long customerId) {
        return service.evaluateAndUpgradeTier(customerId);
    }

    @GetMapping("/history/{customerId}")
    public List<TierHistoryRecordEntity> getHistoryByCustomer(
            @PathVariable Long customerId) {
        return service.getHistoryByCustomer(customerId);
    }

    @GetMapping
    public List<TierHistoryRecordEntity> getAllHistory() {
        return service.getAllHistory();
    }
}
