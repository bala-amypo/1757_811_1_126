package com.example.demo.service;

import com.example.demo.entity.*;
import java.util.List;
public interface TierUpgradeRuleService {
    TierUpgradeRule createRule(TierUpgradeRule rule);
    TierUpgradeRule getRule(String fromTier, String toTier);
}