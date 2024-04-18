package com.project.webbook_backend.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Payment {
    @Id
    private String PaymentID;
    @Column(columnDefinition = "nvarchar(225)" ,nullable = false)
    private String PaymentName;
    @Column(columnDefinition = "text")
    private String Description;
    @Column(nullable = false)
    private Double Fee;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,
    mappedBy = "Payment")
    private List<Order> Orders;
}
