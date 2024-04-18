package com.project.webbook_backend.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "Users")
@Data
public class User {
    @Id
    private String UserID;
    @Column(nullable = false)
    private String Username;
    @Column(nullable = false)
    private String Password;
    @Column(nullable = false)
    private String PhoneNumber;
    private Boolean Gender;
    @Column(nullable = false)
    private String Email;
    @Column(columnDefinition = "nvarchar(225)" ,nullable = false)
    private String Address;
    @Column(columnDefinition = "nvarchar(50)" ,nullable = false)
    private String Firstname;
    @Column(columnDefinition = "nvarchar(50)" ,nullable = false)
    private String Lastname;
    @Column(columnDefinition = "nvarchar(225)" ,nullable = false)
    private String AddressPurchase;
    @Column(columnDefinition = "nvarchar(225)" ,nullable = false)
    private String AddressDelivery;
    @ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(name = "User_Role",
            joinColumns = @JoinColumn(name = "UserID"),
            inverseJoinColumns = @JoinColumn(name = "RoleID")
    )
    private List<Role> Roles;

    @OneToMany(cascade = CascadeType.ALL,
    fetch = FetchType.LAZY,mappedBy = "User")
    private List<Cart> Carts;
    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, mappedBy = "User")
    private List<FeedBack> FeedBacks ;
    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, mappedBy = "User")
    private List<WishList> WishLists ;
    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, mappedBy = "User")
    private List<Post> Posts ;
}
