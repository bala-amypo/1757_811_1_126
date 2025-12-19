package com.example.demo.service;

import com.example.demo.entity.PurchaseRecordEntity;
import java.util.List;

public interface PurchaseRecordService {

    PurchaseRecordEntity recordPurchase(PurchaseRecordEntity purchase);

    PurchaseRecordEntity getPurchaseById(Long id);

    List<PurchaseRecordEntity> getPurchasesByCustomer(Long customerId);

    List<PurchaseRecordEntity> getAllPurchases();
}
