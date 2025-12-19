package com.example.demo.service;

import java.util.*;
import com.example.demo.model.*;
@Service
public interface VisitRecordService {
    VisitRecordEntity recordVisit(VisitRecordEntity visit);
    List<VisitRecordEntity> getVisitsByCustomer(Long id);
    List<VisitRecordEntity> getAllVisits();
    VisitRecordEntity getVisitById(Long id);
}
