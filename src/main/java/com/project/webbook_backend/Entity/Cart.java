package com.project.webbook_backend.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Data
public class Cart {
    @Id
    private String CardID;
    @Column(nullable = false)
    private Double TotalPrice;
    @Column(nullable = false)
    private Date DateCreated;
    @Column(columnDefinition = "nvarchar(225)" ,nullable = false)
    private String AddressPurchase;
    @Column(columnDefinition = "nvarchar(225)" ,nullable = false)
    private String AddressDelivery;
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.REMOVE},
    fetch = FetchType.LAZY)
    @JoinColumn(name = "UserID")
    private User User;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "Cart")
    private List<DetailCart> DetailCarts;
}
