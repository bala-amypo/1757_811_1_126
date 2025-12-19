package com.example.demo.service.impl;

import com.example.demo.entity.CustomerProfile;
import com.example.demo.entity.TierHistoryRecord;
import com.example.demo.entity.TierUpgradeRule;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.CustomerProfileRepository;
import com.example.demo.repository.TierHistoryRecordRepository;
import com.example.demo.repository.TierUpgradeRuleRepository;
import com.example.demo.service.TierUpgradeEngineService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TierUpgradeEngineServiceImpl implements TierUpgradeEngineService {

    private final CustomerProfileRepository customerRepository;
    private final TierUpgradeRuleRepository ruleRepository;
    private final TierHistoryRecordRepository historyRepository;

    public TierUpgradeEngineServiceImpl(
            CustomerProfileRepository customerRepository,
            TierUpgradeRuleRepository ruleRepository,
            TierHistoryRecordRepository historyRepository) {

        this.customerRepository = customerRepository;
        this.ruleRepository = ruleRepository;
        this.historyRepository = historyRepository;
    }

    @Override
    public TierHistoryRecord evaluateAndUpgradeTier(Long customerId) {

        CustomerProfile customer = customerRepository.findById(customerId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Customer not found"));

        if (!customer.getActive()) {
            throw new IllegalArgumentException("Customer is inactive");
        }

        TierUpgradeRule rule = ruleRepository
                .findByFromTier(customer.getCurrentTier())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Tier rule not found"));

        // Upgrade tier
        String oldTier = customer.getCurrentTier();
        customer.setCurrentTier(rule.getToTier());
        customerRepository.save(customer);

        // Save history
        TierHistoryRecord history = new TierHistoryRecord();
        history.setCustomer(customer);
        history.setFromTier(oldTier);
        history.setToTier(rule.getToTier());
        history.setUpgradeDate(LocalDateTime.now());

        return historyRepository.save(history);
    }

    @Override
    public List<TierHistoryRecord> getAllHistory() {
        return historyRepository.findAll();
    }
}
