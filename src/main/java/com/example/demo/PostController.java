package com.example.demo;

import com.example.demo.blog.PostService;
import com.example.demo.blog.presentation.dto.CreateRequestDto;
import com.example.demo.blog.presentation.dto.GetResponseDto;
import com.example.demo.blog.presentation.dto.PostListResponseDto;
import com.example.demo.blog.presentation.dto.UpdateRequestDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService){
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<Long> createPost(
            @Valid @RequestBody CreateRequestDto requestDto
    ) {
        final Long postId = postService.save(requestDto);

        return ResponseEntity
                .created(URI.create("/api/posts/" + postId))
                .body(postId);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<GetResponseDto> getPost(
            @PathVariable Long postId
    ) {
        return ResponseEntity.ok(postService.findById(postId));
    }

    @GetMapping
    public ResponseEntity<List<PostListResponseDto>> getPosts() {
        List<PostListResponseDto> responseDtos = postService.getPosts();
        if (responseDtos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(responseDtos);
    }

    @PutMapping("/{postId}")
    public ResponseEntity<Long> updatePost(
            @PathVariable Long postId,
            @Valid @RequestBody UpdateRequestDto requestDto
    ) {
        return ResponseEntity.ok(postService.update(postId, requestDto));
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<Long> deletePost(
            @PathVariable Long postId
    ) {
        Long deletedId = postService.delete(postId);

        return ResponseEntity.ok(deletedId); // 삭제된 게시글 id 반환
    }
}
