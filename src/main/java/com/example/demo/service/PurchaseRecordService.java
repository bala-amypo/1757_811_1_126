package com.example.demo.service;

import com.example.demo.entity.PurchaseRecord;
import java.util.List;

public interface PurchaseRecordService {

    List<PurchaseRecord> getPurchasesByCustomer(Long customerId);

    PurchaseRecord getPurchaseById(Long purchaseId);

    List<PurchaseRecord> getAllPurchases();
}
