package com.example.demo.service.impl;

import com.example.demo.service.*;
import com.example.demo.repository.*;
import com.example.demo.model.*;
import java.util.*;
@Service
public class VisitRecordServiceImpl implements VisitRecordService {

    private final VisitRecordRepository repo;

    public VisitRecordServiceImpl(VisitRecordRepository repo) {
        this.repo = repo;
    }

    public VisitRecordEntity recordVisit(VisitRecordEntity v) {
        if (!List.of("STORE","APP","WEB").contains(v.getChannel()))
            throw new IllegalArgumentException();
        return repo.save(v);
    }

    public List<VisitRecordEntity> getVisitsByCustomer(Long id) {
        return repo.findByCustomerId(id);
    }

    public List<VisitRecordEntity> getAllVisits() {
        return repo.findAll();
    }

    public VisitRecordEntity getVisitById(Long id) {
        return repo.findById(id).orElseThrow(NoSuchElementException::new);
    }
}
