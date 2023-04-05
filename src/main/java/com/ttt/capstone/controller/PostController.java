package com.ttt.capstone.controller;


import com.ttt.capstone.request.PostCreate;
import com.ttt.capstone.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
public class PostController {


    /*
    Http Method
    GET, POST, PUT, PATCH, DELETE, OPTIONS, HEAD, TRACE, CONNECT
    글 등록
    POST Method
     */


/*
      SSR -> jsp, thymeleaf, mystache, freemarker 방식
    -> html rendering 서버 렌더링 데이터를 내려줌

     SPA
     vue -> vue + SSR = nuxt
     -> javaascript + <-> API(JSON 응답) 통신 ** 방식 사용

     react -> react + SSR = next.js
 */

    private final PostService postService;

    @PostMapping("/posts")
    public Map<String, String> post(@RequestBody @Valid PostCreate request){

        postService.write(request);
        return Map.of();
    }
}
