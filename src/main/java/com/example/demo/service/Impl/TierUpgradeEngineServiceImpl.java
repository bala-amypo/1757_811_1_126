package com.example.demo.service.impl;

import com.example.demo.entity.CustomerProfile;
import com.example.demo.entity.PurchaseRecord;
import com.example.demo.entity.TierUpgradeRule;
import com.example.demo.entity.VisitRecord;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.PurchaseRecordRepository;
import com.example.demo.repository.TierUpgradeRuleRepository;
import com.example.demo.repository.VisitRecordRepository;
import com.example.demo.service.CustomerProfileService;
import com.example.demo.service.TierUpgradeEngineService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TierUpgradeEngineServiceImpl implements TierUpgradeEngineService {

    private final CustomerProfileService customerProfileService;
    private final PurchaseRecordRepository purchaseRepository;
    private final VisitRecordRepository visitRepository;
    private final TierUpgradeRuleRepository ruleRepository;

    public TierUpgradeEngineServiceImpl(
            CustomerProfileService customerProfileService,
            PurchaseRecordRepository purchaseRepository,
            VisitRecordRepository visitRepository,
            TierUpgradeRuleRepository ruleRepository) {

        this.customerProfileService = customerProfileService;
        this.purchaseRepository = purchaseRepository;
        this.visitRepository = visitRepository;
        this.ruleRepository = ruleRepository;
    }

    @Override
    public CustomerProfile evaluateAndUpgradeTier(Long customerId) {

        CustomerProfile customer = customerProfileService.getCustomerById(customerId);

        if (!customer.isActive()) {
            throw new IllegalArgumentException("Inactive customer");
        }

        List<PurchaseRecord> purchases =
                purchaseRepository.findByCustomerId(customerId);

        List<VisitRecord> visits =
                visitRepository.findByCustomerId(customerId);

        double totalSpend = purchases.stream()
                .mapToDouble(PurchaseRecord::getAmount)
                .sum();

        int totalVisits = visits.size();

        TierUpgradeRule rule = ruleRepository
                .findActiveRuleByFromTier(customer.getCurrentTier())
                .orElseThrow(() ->
                        new ResourceNotFoundException("No active tier upgrade rule"));

        boolean eligible =
                totalSpend >= rule.getMinSpend() &&
                totalVisits >= rule.getMinVisits();

        if (!eligible) {
            throw new IllegalArgumentException("Customer not eligible for tier upgrade");
        }

        customer.setCurrentTier(rule.getToTier());

        return customerProfileService.createCustomer(customer);
    }
}
