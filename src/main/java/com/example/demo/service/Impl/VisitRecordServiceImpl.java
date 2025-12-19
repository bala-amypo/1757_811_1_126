package com.example.demo.service.impl;

import com.example.demo.entity.VisitRecord;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.VisitRecordRepository;
import com.example.demo.service.VisitRecordService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitRecordServiceImpl implements VisitRecordService {

    private final VisitRecordRepository repository;

    public VisitRecordServiceImpl(VisitRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public VisitRecord recordVisit(VisitRecord visit) {

        if (!visit.getChannel().equals("STORE") &&
            !visit.getChannel().equals("APP") &&
            !visit.getChannel().equals("WEB")) {

            throw new IllegalArgumentException("Invalid channel");
        }

        return repository.save(visit);
    }

    @Override
    public VisitRecord getVisitById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Visit record not found"));
    }

    @Override
    public List<VisitRecord> getVisitsByCustomer(Long customerId) {
        return repository.findByCustomerId(customerId);
    }

    @Override
    public List<VisitRecord> getAllVisits() {
        return repository.findAll();
    }
}
