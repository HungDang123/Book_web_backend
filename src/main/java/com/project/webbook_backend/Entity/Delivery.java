package com.project.webbook_backend.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Delivery {
    @Id
    private String DeliveryID;
    @Column(columnDefinition = "nvarchar(50)" ,nullable = false)
    private String DeliveryName;
    @Column(columnDefinition = "text" ,nullable = false)
    private String Description;
    @Column(nullable = false)
    private Double DeliveryFee;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,
    mappedBy = "Delivery")
    private List<Order> Orders;
}
