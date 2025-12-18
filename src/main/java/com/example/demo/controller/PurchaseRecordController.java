package com.example.demo.controller;

import com.example.demo.model.PurchaseRecordEntity;
import com.example.demo.service.PurchaseRecordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/purchases")
public class PurchaseRecordController {

    private final PurchaseRecordService service;

    public PurchaseRecordController(PurchaseRecordService service) {
        this.service = service;
    }

    @PostMapping
    public PurchaseRecordEntity recordPurchase(@RequestBody PurchaseRecordEntity purchase) {
        return service.recordPurchase(purchase);
    }

    @GetMapping("/customer/{customerId}")
    public List<PurchaseRecordEntity> getByCustomer(@PathVariable Long customerId) {
        return service.getPurchasesByCustomer(customerId);
    }

    @GetMapping("/{id}")
    public PurchaseRecordEntity getById(@PathVariable Long id) {
        return service.getPurchaseById(id);
    }

    @GetMapping
    public List<PurchaseRecordEntity> getAll() {
        return service.getAllPurchases();
    }
}
