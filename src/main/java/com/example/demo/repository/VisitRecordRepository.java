package com.example.demo.repository;

import com.example.demo.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface VisitRecordRepository extends JpaRepository<VisitRecord, Long> {
    List<VisitRecord> findByCustomerId(Long customerId);
}
