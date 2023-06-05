package com.ttt.capstone.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@ToString
@Setter
@NoArgsConstructor
public class ReviewEditRequest {

    @NotBlank(message = "타이틀을 입력하세요.")
    private String title;

    @NotBlank(message = "콘텐츠를 입력해주세요.")
    private String content;

    @Builder
    public ReviewEditRequest(String title, String content) {
        this.title = title;
        this.content = content;
    }

}
