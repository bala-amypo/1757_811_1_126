package com.example.demo.service;

import java.util.List;

public interface TierUpgradeEngineService {

    // Simple methods without DTOs
    String upgradeTier(Long customerId);
    List<String> getTierHistory(Long customerId);
}
