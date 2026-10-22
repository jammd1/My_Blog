package com.example.demo.blog;

import com.example.demo.blog.domain.Post;
import com.example.demo.blog.presentation.dto.CreateRequestDto;
import com.example.demo.blog.presentation.dto.GetResponseDto;
import com.example.demo.blog.presentation.dto.PostListResponseDto;
import com.example.demo.blog.presentation.dto.UpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;

    @Transactional
    public Long save(CreateRequestDto createDto) {
        return postRepository.save(createDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, UpdateRequestDto requestDto) {
        Post post = postRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("UPDATE: There's no post with id:" + id));
        post.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }

    @Transactional
    public Long delete(Long id) {
        Post post = postRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("DELETE: There's no post with id:" + id));
        postRepository.delete(post);
        return id;
    }

    @Transactional(readOnly = true)
    public GetResponseDto findById(Long id) {
        Post post = postRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("GET: There's no post with id:" + id));
        return new GetResponseDto(post);
    }

    @Transactional(readOnly = true)
    public List<PostListResponseDto> getPosts() {
        return postRepository.findAll(Sort.by("createdAt").descending()).stream()
                .map(PostListResponseDto::new)
                .toList();
    }
}
