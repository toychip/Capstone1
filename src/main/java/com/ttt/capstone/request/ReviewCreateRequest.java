package com.ttt.capstone.request;

import com.ttt.capstone.exception.InvalidRequest;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@ToString
@Setter
@Getter
@NoArgsConstructor
public class ReviewCreateRequest {

    @NotBlank(message = "타이틀을 입력하세요.")
    private String title;

    @NotBlank(message = "콘텐츠를 입력해주세요.")
    private String content;

    @Builder
    public ReviewCreateRequest(String title, String content) {
        this.title = title;
        this.content = content;
    }
    public void validate(){
        if (title.contains("바보")) {
            throw new InvalidRequest("title", "제목에 바보를 포함할 수 없습니다.");
        }
    }
}
