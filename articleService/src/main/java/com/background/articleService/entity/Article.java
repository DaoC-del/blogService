package com.background.articleService.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "article")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private Long authorId; // Assuming articles are related to users

    @Column
    private String status="PUBLISHED"; // e.g., "PUBLISHED", "DRAFT", etc.

    // Possible addition of timestamp fields for created and updated timestamps
}