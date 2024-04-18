package com.project.webbook_backend.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class WishList {
    @Id
    private String WishListID;
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},
            fetch = FetchType.LAZY)
    @JoinColumn(name = "BookID",nullable = false)
    private Book Book;
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},
            fetch = FetchType.LAZY)
    @JoinColumn(name = "UserID",nullable = false)
    private User User;
}
