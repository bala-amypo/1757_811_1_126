package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "visit_records")
public class VisitRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long customerId;

    private LocalDate visitDate;

    private String channel;

    @PrePersist
    public void validate() {
        List<String> valid = List.of("STORE", "APP", "WEB");
        if (!valid.contains(channel)) {
            throw new IllegalArgumentException("Invalid visit channel");
        }
    }

    // Getters & Setters
    public Long getId() { return id; }
    public Long getCustomerId() { return customerId; }
    public void setCustomerId(Long customerId) { this.customerId = customerId; }
    public LocalDate getVisitDate() { return visitDate; }
    public void setVisitDate(LocalDate visitDate) { this.visitDate = visitDate; }
    public String getChannel() { return channel; }
    public void setChannel(String channel) { this.channel = channel; }
}
