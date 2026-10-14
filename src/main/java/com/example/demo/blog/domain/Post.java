package com.example.demo.blog.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column
    private String title;

    @Column
    private String content;

    @Column
    private LocalDateTime createdAt;

    @Column
    private LocalDateTime updatedAt;

    @Builder
    public Post(String title, String content) {
        this.title = title;
        this.content = content;

        final LocalDateTime now = LocalDateTime.now();
        this.createdAt = now;
        this.updatedAt = now;
    }

    public void update(String newTitle, String newContent) {
        try {
            this.title = newTitle;
            this.content = newContent;
            this.updatedAt = LocalDateTime.now();
        } catch (Exception e) {
            System.out.printf("Post id: %d, Update Failed", this.id);
        }
    }

//    String toFormattedDate(LocalDateTime date) {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");
//        return date.format(formatter);
//    }
}
