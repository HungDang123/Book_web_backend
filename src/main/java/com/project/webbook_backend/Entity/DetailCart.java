package com.project.webbook_backend.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class DetailCart {
    @Id
    private String DetailCartID;
    @Column(nullable = false)
    private int Quantity;
    @Column(nullable = false)
    private Double Price;
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},
    fetch = FetchType.LAZY)
    private Cart Cart;
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},
            fetch = FetchType.LAZY)
    private Book Book;
}
