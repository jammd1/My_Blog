package com.example.demo.blog.presentation.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Getter
@NoArgsConstructor
public class UpdateRequestDto {
    @NotBlank(message = "수정할 제목을 입력해주세요.")
    @Length(max = 30, message = "제목은 30글자 이하여야 합니다.")
    private String title;

    @NotBlank(message = "본문을 입력해주세요.")
    @Length(min = 1, message = "본문에 내용이 없습니다. 최소 한 글자 이상 입력해주세요.")
    private String content;
}
