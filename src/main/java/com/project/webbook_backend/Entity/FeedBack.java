package com.project.webbook_backend.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class FeedBack {
    @Id
    private String FeedBackID;
    @Column(columnDefinition = "text" ,nullable = false)
    private String Comment;
    @Column(columnDefinition = "text" ,nullable = false)
    private String Rating;
    @Column(nullable = false)
    private Date FeedBackDate;
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},
            fetch = FetchType.LAZY)
    @JoinColumn(name = "BookID",nullable = false)
    private Book Book;
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},
            fetch = FetchType.LAZY)
    @JoinColumn(name = "UserID",nullable = false)
    private User User;
}
