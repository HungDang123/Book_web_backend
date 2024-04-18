package com.project.webbook_backend.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Image {
    @Id
    private String ImageID;
    @Column(columnDefinition = "nvarchar(50)" ,nullable = false)
    private String ImageName;
    @Column(columnDefinition = "varchar(225)" ,nullable = false)
    private String Link;
    @Column(columnDefinition = "varchar(225)" ,nullable = false)
    private String Icon;
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},fetch = FetchType.LAZY)
    private Book Book;
}
