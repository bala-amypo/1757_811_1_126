package com.example.demo.service;

import java.util.*;
import com.example.demo.model.*;

public interface TierUpgradeEngineService {
    CustomerProfileEntity evaluateAndUpgradeTier(Long customerId);
    List<TierHistoryRecordEntity> getHistoryByCustomer(Long customerId);
    List<TierHistoryRecordEntity> getAllHistory();
}
