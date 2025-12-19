package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.TierUpgradeEngineService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TierUpgradeEngineServiceImpl implements TierUpgradeEngineService {

    private final CustomerProfileRepository customerRepo;
    private final PurchaseRecordRepository purchaseRepo;
    private final VisitRecordRepository visitRepo;
    private final TierUpgradeRuleRepository ruleRepo;
    private final TierHistoryRecordRepository historyRepo;

    public TierUpgradeEngineServiceImpl(
            CustomerProfileRepository customerRepo,
            PurchaseRecordRepository purchaseRepo,
            VisitRecordRepository visitRepo,
            TierUpgradeRuleRepository ruleRepo,
            TierHistoryRecordRepository historyRepo) {

        this.customerRepo = customerRepo;
        this.purchaseRepo = purchaseRepo;
        this.visitRepo = visitRepo;
        this.ruleRepo = ruleRepo;
        this.historyRepo = historyRepo;
    }

    @Override
    public CustomerProfileEntity evaluateAndUpgradeTier(Long customerId) {

        CustomerProfileEntity customer = customerRepo.findById(customerId)
                .orElseThrow(NoSuchElementException::new);

        double totalSpend = purchaseRepo.findByCustomerId(customerId)
                .stream()
                .mapToDouble(PurchaseRecordEntity::getAmount)
                .sum();

        int visits = visitRepo.findByCustomerId(customerId).size();

        for (TierUpgradeRule rule : ruleRepo.findByActiveTrue()) {
            if (rule.getFromTier().equals(customer.getCurrentTier())
                    && totalSpend >= rule.getMinSpend()
                    && visits >= rule.getMinVisits()) {

                String oldTier = customer.getCurrentTier();
                customer.setCurrentTier(rule.getToTier());
                customerRepo.save(customer);

                TierHistoryRecordEntity history = new TierHistoryRecordEntity();
                history.setCustomerId(customerId);
                history.setOldTier(oldTier);
                history.setNewTier(rule.getToTier());
                history.setReason("Auto upgrade");

                historyRepo.save(history);
            }
        }
        return customer;
    }

    @Override
    public List<TierHistoryRecordEntity> getHistoryByCustomer(Long customerId) {
        return historyRepo.findByCustomerId(customerId);
    }

    @Override
    public List<TierHistoryRecordEntity> getAllHistory() {
        return historyRepo.findAll();
    }
}