package com.example.demo.blog.presentation.dto;


import com.example.demo.blog.domain.Post;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostListResponseDto {
    private final Long id;
    private final String title;
    private final LocalDateTime createdAt;

    public PostListResponseDto(Post entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.createdAt = entity.getCreatedAt();
    }
}
