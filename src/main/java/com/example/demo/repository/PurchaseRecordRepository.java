package com.example.demo.repository;

import com.example.demo.entity.PurchaseRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface PurchaseRecordRepository
        extends JpaRepository<PurchaseRecordEntity, Long> {

    List<PurchaseRecordEntity> findByCustomerId(Long customerId);

    List<PurchaseRecordEntity> findByPurchaseDateBetween(
            LocalDate start, LocalDate end);
}
