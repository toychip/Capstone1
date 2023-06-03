package com.ttt.capstone.controller;


import com.ttt.capstone.request.PostCreateRequest;
import com.ttt.capstone.request.PostEditRequest;
import com.ttt.capstone.request.PostSearchRequest;
import com.ttt.capstone.response.PostResponse;
import com.ttt.capstone.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ReviewController {

    private final PostService postService;


    @PostMapping("/review")
//    public Map<String, String> post(@RequestBody @Valid PostCreateRequest request){
    public void post(@RequestBody @Valid PostCreateRequest request) {
        request.validate();
        postService.write(request);
    }

    @GetMapping("/review")
    public ResponseEntity<List<PostResponse>> search(
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer size,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String content,
            @RequestParam(required = false) String writtenBy
    ) {
        PostSearchRequest postSearchRequest = PostSearchRequest.builder()
                .page(page)
                .size(size)
                .title(title)
                .content(content)
                .writtenBy(writtenBy)
                .build();

        return ResponseEntity.ok(postService.search(postSearchRequest));
    }

    @GetMapping("/review/{postId}")
    public PostResponse get(@PathVariable Long postId) {

        return postService.get(postId);
        // 응답 전용 클래스를 만드는 것이 좋다.
    }

    //조회 API
    // 여러개의 글 조회 API (1개의 글 Post을 가져오는 기능)
//    @GetMapping("/posts")
//    public List<PostResponse> getList(@ModelAttribute PostSearchRequest postSearch) {
//        return postService.getList(postSearch);
//    }

    @PatchMapping("/review/{postId}")
    public void edit(@PathVariable Long postId, @RequestBody @Valid PostEditRequest request){
        postService.edit(postId, request);
    }

    @DeleteMapping("/review/{postId}")
    public void delete(@PathVariable Long postId){
        postService.delete(postId);
    }


}
