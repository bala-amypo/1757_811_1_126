package com.example.demo.service;

import java.util.*;
import com.example.demo.model.*;
@Service
public interface PurchaseRecordService {
    PurchaseRecordEntity recordPurchase(PurchaseRecordEntity purchase);
    List<PurchaseRecordEntity> getPurchasesByCustomer(Long id);
    List<PurchaseRecordEntity> getAllPurchases();
    PurchaseRecordEntity getPurchaseById(Long id);
}