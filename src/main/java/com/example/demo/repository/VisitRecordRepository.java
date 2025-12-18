package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;
import com.example.demo.model.*;

public interface VisitRecordRepository extends JpaRepository<VisitRecordEntity, Long> {
    List<VisitRecordEntity> findByCustomerId(Long customerId);
}