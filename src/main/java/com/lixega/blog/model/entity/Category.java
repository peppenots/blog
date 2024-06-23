package com.lixega.blog.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Category {


    @Id
    private String name;
    private String description;
    @Column (name = "created_at")
    private LocalDateTime createdAt;
    private String slug;


    @OneToMany(mappedBy = "category")
    private List<Article> articles;



}
