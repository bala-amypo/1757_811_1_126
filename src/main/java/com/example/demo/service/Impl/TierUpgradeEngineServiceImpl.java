package com.example.demo.service.impl;

import com.example.demo.service.TierUpgradeEngineService;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class TierUpgradeEngineServiceImpl implements TierUpgradeEngineService {

    @Override
    public String upgradeTier(Long customerId) {
        return "Tier upgraded for customer: " + customerId;
    }

    @Override
    public List<String> getTierHistory(Long customerId) {
        List<String> history = new ArrayList<>();
        history.add("Tier1 -> Tier2");
        history.add("Tier2 -> Tier3");
        return history;
    }
}
