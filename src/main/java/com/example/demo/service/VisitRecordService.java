package com.example.demo.service;

import com.example.demo.entity.*;
import java.util.List;

public interface VisitRecordService {
    VisitRecord recordVisit(VisitRecord visit);
    List<VisitRecord> getVisitsByCustomer(Long id);
    VisitRecord getVisitById(Long id);
}
