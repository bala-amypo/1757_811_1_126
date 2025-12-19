package com.example.demo.controller;

import com.example.demo.entity.VisitRecordEntity;
import com.example.demo.service.VisitRecordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/visits")
public class VisitRecordController {

    private final VisitRecordService service;

    public VisitRecordController(VisitRecordService service) {
        this.service = service;
    }

    @PostMapping
    public VisitRecordEntity create(@RequestBody VisitRecordEntity visit) {
        return service.recordVisit(visit);
    }

    @GetMapping("/{id}")
    public VisitRecordEntity getById(@PathVariable Long id) {
        return service.getVisitById(id);
    }

    @GetMapping("/customer/{customerId}")
    public List<VisitRecordEntity> getByCustomer(@PathVariable Long customerId) {
        return service.getVisitsByCustomer(customerId);
    }

    @GetMapping
    public List<VisitRecordEntity> getAll() {
        return service.getAllVisits();
    }
}
