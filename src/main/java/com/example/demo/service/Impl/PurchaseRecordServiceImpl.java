package com.example.demo.service.impl;

import com.example.demo.model.PurchaseRecord;
import com.example.demo.repository.PurchaseRecordRepository;
import com.example.demo.service.PurchaseRecordService;

import java.util.List;
import java.util.NoSuchElementException;

public class PurchaseRecordServiceImpl implements PurchaseRecordService {

    private final PurchaseRecordRepository purchaseRepo;

    // REQUIRED constructor order
    public PurchaseRecordServiceImpl(PurchaseRecordRepository purchaseRepo) {
        this.purchaseRepo = purchaseRepo;
    }

    @Override
    public PurchaseRecord recordPurchase(PurchaseRecord purchase) {
        if (purchase.getAmount() == null || purchase.getAmount() <= 0) {
            throw new IllegalArgumentException("Purchase amount must be greater than zero");
        }
        return purchaseRepo.save(purchase);
    }

    @Override
    public List<PurchaseRecord> getPurchasesByCustomer(Long customerId) {
        return purchaseRepo.findByCustomerId(customerId);
    }

    @Override
    public List<PurchaseRecord> getAllPurchases() {
        return purchaseRepo.findAll();
    }

    @Override
    public PurchaseRecord getPurchaseById(Long id) {
        return purchaseRepo.findById(id)
                .orElseThrow(NoSuchElementException::new);
    }
}
