package com.example.demo.service.impl;

import com.example.demo.entity.PurchaseRecord;
import com.example.demo.repository.PurchaseRecordRepository;
import com.example.demo.service.PurchaseRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseRecordServiceImpl implements PurchaseRecordService {

    private final PurchaseRecordRepository purchaseRecordRepository;

    @Autowired
    public PurchaseRecordServiceImpl(PurchaseRecordRepository purchaseRecordRepository) {
        this.purchaseRecordRepository = purchaseRecordRepository;
    }

    @Override
    public List<PurchaseRecord> getAllRecords() {
        return purchaseRecordRepository.findAll();
    }

    @Override
    public PurchaseRecord getRecordById(Long id) {
        return purchaseRecordRepository.findById(id).orElse(null);
    }

    @Override
    public PurchaseRecord saveRecord(PurchaseRecord record) {
        return purchaseRecordRepository.save(record);
    }
}
