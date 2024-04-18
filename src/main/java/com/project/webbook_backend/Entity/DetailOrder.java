package com.project.webbook_backend.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class DetailOrder {
    @Id
    private String DetailOrderID;
    @Column(nullable = false)
    private int Quantity;
    @Column(nullable = false)
    private Double Price;
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},
    fetch = FetchType.LAZY)
    @JoinColumn(name = "OrderID",nullable = false)
    private Order Order;
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},
            fetch = FetchType.LAZY)
    @JoinColumn(name = "BookID",nullable = false)
    private Book Book;
}
