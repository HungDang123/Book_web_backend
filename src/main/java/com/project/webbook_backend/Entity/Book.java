package com.project.webbook_backend.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Book {
    @Id
    private String BookID;
    @Column(columnDefinition = "nvarchar(50)" ,nullable = false)
    private String BookName;
    @Column(columnDefinition = "nvarchar(50)" ,nullable = false)
    private String Author;
    @Column(columnDefinition = "varchar(50)" ,nullable = false)
    private String ISBN;
    @Column(columnDefinition = "text")
    private String Description;
    @Column(nullable = false)
    private Double ListedPrice;
    @Column(nullable = false)
    private Double Price;
    @Column(nullable = false)
    private int Stock;
    @Column(columnDefinition = "nvarchar(225)")
    private String Rating;
    @ManyToMany(mappedBy = "Books", // Assuming "Books" is the attribute name in the Category entity
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
            fetch = FetchType.LAZY)
    private List<Category> categories;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "Book")
    private List<Image> Images;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "Book")
    private List<DetailCart> DetailCarts;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "Book")
    private List<FeedBack> FeedBacks;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "Book")
    private List<WishList> WishLists ;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "Book")
    private List<Post> Posts ;
}
