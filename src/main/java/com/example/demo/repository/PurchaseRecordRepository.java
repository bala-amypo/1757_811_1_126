package com.example.demo.repository;

import com.example.demo.entity.PurchaseRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PurchaseRecordRepository extends JpaRepository<PurchaseRecord, Long> {

    @Query("SELECT p FROM PurchaseRecord p WHERE p.customer.id = :customerId")
    List<PurchaseRecord> findByCustomerId(@Param("customerId") Long customerId);

    @Query("SELECT p FROM PurchaseRecord p WHERE p.productName = :productName")
    List<PurchaseRecord> findByProductName(@Param("productName") String productName);

    @Query("SELECT p FROM PurchaseRecord p WHERE p.purchaseDate BETWEEN :startDate AND :endDate")
    List<PurchaseRecord> findPurchasesBetweenDates(@Param("startDate") LocalDate startDate,
                                                   @Param("endDate") LocalDate endDate);
}
