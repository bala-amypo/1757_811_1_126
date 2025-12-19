package com.example.demo.controller;

import com.example.demo.service.TierUpgradeEngineService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tier")
public class TierUpgradeEngineController {

    private final TierUpgradeEngineService service;

    public TierUpgradeEngineController(TierUpgradeEngineService service) {
        this.service = service;
    }

    @GetMapping("/evaluate/{customerId}")
    public String evaluate(@PathVariable Long customerId) {
        return service.evaluateTier(customerId);
    }
}
