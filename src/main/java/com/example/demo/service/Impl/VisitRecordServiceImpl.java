package com.example.demo.service.impl;

import com.example.demo.entity.VisitRecordEntity;
import com.example.demo.repository.VisitRecordRepository;
import com.example.demo.service.VisitRecordService;

import java.util.List;
import java.util.NoSuchElementException;

public class VisitRecordServiceImpl implements VisitRecordService {

    private final VisitRecordRepository repository;

    public VisitRecordServiceImpl(VisitRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public VisitRecordEntity recordVisit(VisitRecordEntity visit) {
        if (!visit.getChannel().equals("STORE") &&
            !visit.getChannel().equals("APP") &&
            !visit.getChannel().equals("WEB")) {
            throw new IllegalArgumentException("Invalid channel");
        }
        return repository.save(visit);
    }

    @Override
    public VisitRecordEntity getVisitById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Visit record not found"));
    }

    @Override
    public List<VisitRecordEntity> getVisitsByCustomer(Long customerId) {
        return repository.findByCustomerId(customerId);
    }

    @Override
    public List<VisitRecordEntity> getAllVisits() {
        return repository.findAll();
    }
}
