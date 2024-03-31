package com.example.FinalProject.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "content")
    private String content;

    @Column(name = "sub_text_1")
    private String subText1;

    @Column(name = "sub_text_2")
    private String subText2;

    @Column(name = "author_name")
    private String authorName;

    @CreationTimestamp()
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updateAt;

    public Post() {
    }

    public Post(Long id, String imageUrl, String content, String subText1, String subText2, String authorName, LocalDateTime createdAt, LocalDateTime updateAt) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.content = content;
        this.subText1 = subText1;
        this.subText2 = subText2;
        this.authorName = authorName;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSubText1() {
        return subText1;
    }

    public void setSubText1(String subText1) {
        this.subText1 = subText1;
    }

    public String getSubText2() {
        return subText2;
    }

    public void setSubText2(String subText2) {
        this.subText2 = subText2;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }
}
