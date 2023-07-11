package com.haruntasci.springbootangularcrud.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "posts")
@Data
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
    private String title;
    @Column(columnDefinition = "TEXT")
    private String content;
    private Long viewCount;
    private LocalDate creationDate = LocalDate.now();
    private Boolean isPublished;

}
