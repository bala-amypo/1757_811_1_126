package com.example.demo.controller;

import com.example.demo.entity.VisitRecord;
import com.example.demo.service.VisitRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/visit")
public class VisitRecordController {

    private final VisitRecordService service;

    @Autowired
    public VisitRecordController(VisitRecordService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public VisitRecord addVisit(@RequestBody VisitRecord visit) {
        return service.saveVisit(visit);
    }

    @GetMapping("/{id}")
    public VisitRecord getVisit(@PathVariable Long id) {
        return service.getVisitById(id);
    }

    @GetMapping("/customer/{customerId}")
    public List<VisitRecord> getVisitsByCustomer(@PathVariable Long customerId) {
        return service.getVisitsByCustomer(customerId);
    }

    @GetMapping("/all")
    public List<VisitRecord> getAllVisits() {
        return service.getAllVisits();
    }
}
