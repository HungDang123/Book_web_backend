package com.project.webbook_backend.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Category {
    @Id
    private String CategoryID;
    @Column(columnDefinition = "nvarchar(50)" ,nullable = false)
    private String CategoryName;
    @ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH}
    ,fetch = FetchType.LAZY)
    @JoinTable(name = "Category_Book",
    joinColumns = @JoinColumn(name = "CategoryID"),
            inverseJoinColumns = @JoinColumn(name = "BookID")
    )
    private List<Book> Books;

}
