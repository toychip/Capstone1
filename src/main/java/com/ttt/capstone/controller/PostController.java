package com.ttt.capstone.controller;


import com.ttt.capstone.request.PostCreate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
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

    @PostMapping("/posts")
    public String post(@RequestBody PostCreate params){
        log.info("params{} ", params.toString());
        return "Hello World";
    }
}
