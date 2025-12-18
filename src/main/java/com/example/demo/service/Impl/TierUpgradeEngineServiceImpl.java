package com.example.demo.service.impl;

import com.example.demo.service.*;
import com.example.demo.repository.*;
import com.example.demo.model.*;
import java.util.*;

public class TierUpgradeEngineServiceImpl implements TierUpgradeEngineService {

    private final CustomerProfileRepository customerRepo;
    private final PurchaseRecordRepository purchaseRepo;
    private final VisitRecordRepository visitRepo;
    private final TierUpgradeRuleRepository ruleRepo;
    private final TierHistoryRecordRepository historyRepo;

    public TierUpgradeEngineServiceImpl(CustomerProfileRepository c,PurchaseRecordRepository p,VisitRecordRepository v,TierUpgradeRuleRepository r,TierHistoryRecordRepository h) {
        this.customerRepo = c;
        this.purchaseRepo = p;
        this.visitRepo = v;
        this.ruleRepo = r;
        this.historyRepo = h;
    }

    public CustomerProfileEntity evaluateAndUpgradeTier(Long customerId) {
        CustomerProfileEntity c = customerRepo.findById(customerId)
                .orElseThrow(NoSuchElementException::new);

        double totalSpend = purchaseRepo.findByCustomerId(customerId)
                .stream().mapToDouble(PurchaseRecordEntity::getAmount).sum();
        int visits = visitRepo.findByCustomerId(customerId).size();

        for (TierUpgradeRuleEntity rule : ruleRepo.findByActiveTrue()) {
            if (rule.getFromTier().equals(c.getCurrentTier())
                    && totalSpend >= rule.getMinSpend()
                    && visits >= rule.getMinVisits()) {

                String old = c.getCurrentTier();
                c.setCurrentTier(rule.getToTier());
                customerRepo.save(c);

                TierHistoryRecordEntity h = new TierHistoryRecordEntity();
                h.setCustomerId(customerId);
                h.setOldTier(old);
                h.setNewTier(rule.getToTier());
                h.setReason("Threshold met");
                historyRepo.save(h);
                break;
            }
        }
        return c;
    }

    public List<TierHistoryRecordEntity> getHistoryByCustomer(Long customerId) {
        return historyRepo.findByCustomerId(customerId);
    }

    public List<TierHistoryRecordEntity> getAllHistory() {
        return historyRepo.findAll();
    }
}
