package com.example.demo.service.impl;

import com.example.demo.service.*;
import com.example.demo.repository.*;
import com.example.demo.model.*;
import java.util.*;
@Service
public class PurchaseRecordServiceImpl implements PurchaseRecordService {

    private final PurchaseRecordRepository repo;

    public PurchaseRecordServiceImpl(PurchaseRecordRepository repo) {
        this.repo = repo;
    }

    public PurchaseRecordEntity recordPurchase(PurchaseRecordEntity p) {
        if (p.getAmount() <= 0) throw new IllegalArgumentException();
        return repo.save(p);
    }

    public List<PurchaseRecordEntity> getPurchasesByCustomer(Long id) {
        return repo.findByCustomerId(id);
    }

    public List<PurchaseRecordEntity> getAllPurchases() {
        return repo.findAll();
    }

    public PurchaseRecordEntity getPurchaseById(Long id) {
        return repo.findById(id).orElseThrow(NoSuchElementException::new);
    }
}
