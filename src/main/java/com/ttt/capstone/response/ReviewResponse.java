package com.ttt.capstone.response;

import com.ttt.capstone.domian.Post;
import com.ttt.capstone.domian.Review;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
public class ReviewResponse {

    private final Long id;
    private final String title;
    private final String content;

    private final String writtenBy;

    private final String writtenDateTime; // LocalDateTime에서 String으로 변경

    public ReviewResponse(Review review) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        this.id = review.getId();
        this.title = review.getTitle();
        this.content = review.getContent();
        this.writtenBy = review.getWrittenBy();
        this.writtenDateTime = review.getWrittenDateTime().format(formatter); // LocalDateTime을 String으로 변환
    }

    @Builder
    public ReviewResponse(Long id, String title, String content, String writtenBy, LocalDateTime writtenDateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        this.id = id;
        this.title = title.substring(0, Math.min(title.length(), 10));
        this.content = content;
        this.writtenBy = writtenBy;
        this.writtenDateTime = writtenDateTime.format(formatter); // LocalDateTime을 String으로 변환
    }
}
