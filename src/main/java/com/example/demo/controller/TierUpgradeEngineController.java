package com.example.demo.controller;

import com.example.demo.model.TierHistoryRecord;
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
    public String evaluate(@PathVariable Long customerId) {
        service.evaluateAndUpgradeTier(customerId);
        return "Tier evaluation completed";
    }

    @GetMapping("/history/{customerId}")
    public List<TierHistoryRecord> historyByCustomer(@PathVariable Long customerId) {
        return service.getHistoryByCustomer(customerId);
    }

    @GetMapping
    public List<TierHistoryRecord> getAllHistory() {
        return service.getAllHistory();
    }
}
