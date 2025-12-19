package com.example.demo.service;

import com.example.demo.entity.TierHistoryRecordEntity;
import java.util.List;

public interface TierUpgradeEngineService {

    TierHistoryRecordEntity evaluateAndUpgradeTier(Long customerId);

    List<TierHistoryRecordEntity> getHistoryByCustomer(Long customerId);

    List<TierHistoryRecordEntity> getAllHistory();
}
