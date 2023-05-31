package com.ttt.capstone.controller;

import com.ttt.capstone.response.AuthResponse;
import com.ttt.capstone.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor

public class MyPageController {

    private final PostService postService;

    @GetMapping("/mypage")
    public AuthResponse getMemberInfo() {
        return postService.getCurrentMemberInfo();
    }
}
