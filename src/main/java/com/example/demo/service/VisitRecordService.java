package com.example.demo.service;

import com.example.demo.entity.VisitRecordEntity;
import java.util.List;

public interface VisitRecordService {

    VisitRecordEntity recordVisit(VisitRecordEntity visit);

    VisitRecordEntity getVisitById(Long id);

    List<VisitRecordEntity> getVisitsByCustomer(Long customerId);

    List<VisitRecordEntity> getAllVisits();
}
