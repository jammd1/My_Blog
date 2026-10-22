package com.example.demo.blog.presentation.dto;


import com.example.demo.blog.domain.Post;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class GetResponseDto {
    private final Long id;
    private final String title;
    private final String content;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    public GetResponseDto(Post entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.createdAt = entity.getCreatedAt();
        this.updatedAt = entity.getUpdatedAt();
    }
}
