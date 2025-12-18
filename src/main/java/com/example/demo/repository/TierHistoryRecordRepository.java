package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;
import com.example.demo.model.*;

public interface TierHistoryRecordRepository extends JpaRepository<TierHistoryRecordEntity, Long> {
    List<TierHistoryRecordEntity> findByCustomerId(Long customerId);
}