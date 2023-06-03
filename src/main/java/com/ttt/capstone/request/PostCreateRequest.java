package com.ttt.capstone.request;

import com.ttt.capstone.exception.InvalidRequest;
import lombok.*;

import jakarta.validation.constraints.NotBlank;

@ToString
@Setter
@Getter
@NoArgsConstructor
//builder 가 있는 클래스는 생성자를 명시적으로 표현해야한다.
public class PostCreateRequest {

    @NotBlank(message = "타이틀을 입력하세요.")
    private String title;

    @NotBlank(message = "콘텐츠를 입력해주세요.")
    private String content;

    @Builder
    public PostCreateRequest(String title, String content) {
        this.title = title;
        this.content = content;
    }
    public void validate(){
        if (title.contains("바보")) {
            throw new InvalidRequest("title", "제목에 바보를 포함할 수 없습니다.");     // 제목에 바보가 들어가면 오류내버리기
        }
    }
}
