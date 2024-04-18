package com.project.webbook_backend.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Post {
    @Id
    private String PostID;
    @Column(columnDefinition = "nvarchar(225)" ,nullable = false)
    private String Title;
    @Column(nullable = false)
    private Date DatePost;
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},
            fetch = FetchType.LAZY)
    @JoinColumn(name = "BookID",nullable = false)
    private Book Book;
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},
            fetch = FetchType.LAZY)
    @JoinColumn(name = "UserID",nullable = false)
    private User User;
}
