package com.example.demo.repository;

import com.example.demo.entity.VisitRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface VisitRecordRepository
        extends JpaRepository<VisitRecordEntity, Long> {

    List<VisitRecordEntity> findByCustomerId(Long customerId);

    List<VisitRecordEntity> findByVisitDateBetween(
            LocalDate start, LocalDate end);
}
