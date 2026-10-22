package com.example.demo;

import com.example.demo.blog.PostService;
import com.example.demo.blog.presentation.dto.CreateRequestDto;
import com.example.demo.blog.presentation.dto.GetRequestDto;
import com.example.demo.blog.presentation.dto.PostListResponseDto;
import com.example.demo.blog.presentation.dto.UpdateRequestDto;
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
            @RequestBody CreateRequestDto requestDto
    ) {
        final Long postId = postService.save(requestDto);

        return ResponseEntity
                .created(URI.create("/api/posts/" + postId))
                .body(postId);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<GetRequestDto> getPost(
            @PathVariable Long postId
    ) {
        return ResponseEntity.ok(postService.findById(postId));
    }

    @GetMapping
    public ResponseEntity<List<PostListResponseDto>> getPosts() {
        return ResponseEntity.ok(postService.getPosts());
    }

    @PutMapping("/{postId}")
    public ResponseEntity<Long> updatePost(
            @PathVariable Long postId,
            @RequestBody UpdateRequestDto requestDto
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
