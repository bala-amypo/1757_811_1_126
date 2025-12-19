package com.example.demo.service;

import com.example.demo.entity.VisitRecord;
import java.util.List;

public interface VisitRecordService {
    VisitRecord saveVisit(VisitRecord visitRecord);
    VisitRecord getVisitById(Long id);
    List<VisitRecord> getVisitsByCustomer(Long customerId);
    List<VisitRecord> getAllVisits();
}
