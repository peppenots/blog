package com.lixega.blog.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name= "user")
public class UserAccount {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String name;
    private String surname;
    private String username;
    private String email;
    private String password;

    private Instant birthday;
    @Column(name = "created_at")
    private Instant createAt;


    @JsonIgnore
    @OneToMany(mappedBy = "author")
    private List<Article> articles;

    @JsonIgnore
    @OneToMany(mappedBy = "userAccount", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<RefreshToken> refreshTokens = new ArrayList<>();
}