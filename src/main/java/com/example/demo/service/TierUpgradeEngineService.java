package com.example.demo.service;

import com.example.demo.entity.*;
import java.util.List;
public interface TierUpgradeEngineService {
    TierHistoryRecord evaluateAndUpgradeTier(Long customerId);
    List<TierHistoryRecord> getHistoryByCustomer(Long customerId);
}