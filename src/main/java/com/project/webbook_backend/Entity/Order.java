package com.project.webbook_backend.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "purchase_order") // Specify the table name explicitly to avoid conflicts with reserved keywords
@Data
public class Order {
    @Id
    private String OrderID;
    @Column(columnDefinition = "nvarchar(225)" ,nullable = false)
    private String AddressPurchase;
    @Column(columnDefinition = "nvarchar(225)" ,nullable = false)
    private String AddressDelivery;
    @Column(nullable = false)
    private Date DateCreated;
    @Column(nullable = false)
    private String PaymentStatus;
    @Column(nullable = false)
    private String DeliveryStatus;
    @Column(nullable = false)
    private Double TotalPrice;
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},
            fetch = FetchType.LAZY)
    @JoinColumn(name = "UserID",nullable = false)
    private User User;
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},
            fetch = FetchType.LAZY)
    @JoinColumn(name = "PaymentID",nullable = false)
    private Payment Payment;
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},
            fetch = FetchType.LAZY)
    @JoinColumn(name = "DeliveryID",nullable = false)
    private Delivery Delivery;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "Order")
    private List<DetailOrder> DetailOrders;
}
