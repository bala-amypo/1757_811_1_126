package com.example.demo.service.impl;

import com.example.demo.model.VisitRecordEntity;
import com.example.demo.repository.VisitRecordRepository;
import com.example.demo.service.VisitRecordService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

@Service
public class VisitRecordServiceImpl implements VisitRecordService {

    private static final Set<String> VALID_CHANNELS =
            Set.of("STORE", "APP", "WEB");

    private final VisitRecordRepository repository;

    public VisitRecordServiceImpl(VisitRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public VisitRecordEntity recordVisit(VisitRecordEntity visit) {
        if (!VALID_CHANNELS.contains(visit.getChannel())) {
            throw new IllegalArgumentException("Invalid visit channel");
        }
        return repository.save(visit);
    }

    @Override
    public List<VisitRecordEntity> getVisitsByCustomer(Long customerId) {
        return repository.findByCustomerId(customerId);
    }

    @Override
    public List<VisitRecordEntity> getAllVisits() {
        return repository.findAll();
    }

    @Override
    public VisitRecordEntity getVisitById(Long id) {
        return repository.findById(id)
                .orElseThrow(NoSuchElementException::new);
    }
}