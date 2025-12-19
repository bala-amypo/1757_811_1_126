package com.example.demo.controller;

import com.example.demo.service.TierUpgradeEngineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/tier")
public class TierUpgradeEngineController {

    @Autowired
    private TierUpgradeEngineService tierService;

    @PostMapping("/upgrade/{customerId}")
    public String upgradeTier(@PathVariable Long customerId) {
        return tierService.upgradeTier(customerId);
    }

    @GetMapping("/history/{customerId}")
    public List<String> getHistory(@PathVariable Long customerId) {
        return tierService.getTierHistory(customerId);
    }
}
