package com.ttt.capstone.controller;



import com.ttt.capstone.request.ReviewCreateRequest;
import com.ttt.capstone.request.SearchRequest;

import com.ttt.capstone.response.ReviewResponse;
import com.ttt.capstone.service.ReviewService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;


    @PostMapping(value = "/review", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void post(
            @RequestParam("images") List<MultipartFile> images,
            @RequestParam("title") String title,
            @RequestParam("content") String content
    ) {
        ReviewCreateRequest request = new ReviewCreateRequest();
        request.setTitle(title);
        request.setContent(content);
        request.setImages(images);
        reviewService.write(request);
    }

    @GetMapping("/review")
    public ResponseEntity<List<ReviewResponse>> search(
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer size,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String content,
            @RequestParam(required = false) String writtenBy
    ) {
        SearchRequest searchRequest = SearchRequest.builder()
                .page(page)
                .size(size)
                .title(title)
                .content(content)
                .writtenBy(writtenBy)
                .build();

        return ResponseEntity.ok(reviewService.search(searchRequest));
    }

    @GetMapping("/review/{reviewId}")
    public ReviewResponse get(@PathVariable Long reviewId) {

        return reviewService.get(reviewId);
        // 응답 전용 클래스를 만드는 것이 좋다.
    }

    @DeleteMapping("/review/{reviewId}")
    public void delete(@PathVariable Long reviewId){
        reviewService.delete(reviewId);
    }
}
