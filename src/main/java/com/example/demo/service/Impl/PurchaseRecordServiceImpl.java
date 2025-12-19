package com.example.demo.service.impl;

import com.example.demo.model.PurchaseRecordEntity;
import com.example.demo.repository.PurchaseRecordRepository;
import com.example.demo.service.PurchaseRecordService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PurchaseRecordServiceImpl implements PurchaseRecordService {

    private final PurchaseRecordRepository repository;

    public PurchaseRecordServiceImpl(PurchaseRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public PurchaseRecordEntity recordPurchase(PurchaseRecordEntity purchase) {
        if (purchase.getAmount() == null || purchase.getAmount() <= 0) {
            throw new IllegalArgumentException("Purchase amount must be positive");
        }
        return repository.save(purchase);
    }

    @Override
    public List<PurchaseRecordEntity> getPurchasesByCustomer(Long customerId) {
        return repository.findByCustomerId(customerId);
    }

    @Override
    public List<PurchaseRecordEntity> getAllPurchases() {
        return repository.findAll();
    }

    @Override
    public PurchaseRecordEntity getPurchaseById(Long id) {
        return repository.findById(id)
                .orElseThrow(NoSuchElementException::new);
    }
}