package com.example.demo.service;

import com.example.demo.entity.PurchaseRecord;
import java.util.List;

public interface PurchaseRecordService {
    List<PurchaseRecord> getAllRecords();
    PurchaseRecord getRecordById(Long id);
    PurchaseRecord saveRecord(PurchaseRecord record);
}
