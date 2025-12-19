package com.example.demo.service.impl;

import com.example.demo.entity.CustomerProfileEntity;
import com.example.demo.entity.TierHistoryRecordEntity;
import com.example.demo.entity.TierUpgradeRuleEntity;
import com.example.demo.repository.CustomerProfileRepository;
import com.example.demo.repository.PurchaseRecordRepository;
import com.example.demo.repository.TierHistoryRecordRepository;
import com.example.demo.repository.TierUpgradeRuleRepository;
import com.example.demo.repository.VisitRecordRepository;
import com.example.demo.service.TierUpgradeEngineService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
    public TierHistoryRecordEntity evaluateAndUpgradeTier(Long customerId) {

        CustomerProfileEntity customer = customerRepo.findById(customerId)
                .orElseThrow(() -> new NoSuchElementException("Customer not found"));

        double totalSpend = purchaseRepo.findByCustomerId(customerId)
                .stream().mapToDouble(p -> p.getAmount()).sum();

        long totalVisits = visitRepo.findByCustomerId(customerId).size();

        for (TierUpgradeRuleEntity rule : ruleRepo.findByActiveTrue()) {
            if (totalSpend >= rule.getMinSpend()
                    && totalVisits >= rule.getMinVisits()
                    && customer.getTier().equals(rule.getFromTier())) {

                customer.setTier(rule.getToTier());
                customerRepo.save(customer);

                TierHistoryRecordEntity history = new TierHistoryRecordEntity();
                history.setCustomerId(customerId);
                history.setFromTier(rule.getFromTier());
                history.setToTier(rule.getToTier());
                history.setChangedAt(LocalDateTime.now());

                return historyRepo.save(history);
            }
        }
        return null;
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
