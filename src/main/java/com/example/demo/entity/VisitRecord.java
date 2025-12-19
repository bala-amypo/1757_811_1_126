package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "visit_records")
public class VisitRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long customerId;
    private String visitDate;
    private String remarks;

    // Constructors
    public VisitRecord() {}

    public VisitRecord(Long customerId, String visitDate, String remarks) {
        this.customerId = customerId;
        this.visitDate = visitDate;
        this.remarks = remarks;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getCustomerId() { return customerId; }
    public void setCustomerId(Long customerId) { this.customerId = customerId; }

    public String getVisitDate() { return visitDate; }
    public void setVisitDate(String visitDate) { this.visitDate = visitDate; }

    public String getRemarks() { return remarks; }
    public void setRemarks(String remarks) { this.remarks = remarks; }
}
