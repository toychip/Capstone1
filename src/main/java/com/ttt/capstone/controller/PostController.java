package com.ttt.capstone.controller;


import com.ttt.capstone.request.PostCreate;
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
    public Map<String, String> post(@RequestBody @Valid PostCreate request){
//        log.info("params{} ", params.toString());
//
//        if (result.hasErrors()){
//            List<FieldError> fieldErrors = result.getFieldErrors();
//            FieldError firstFieldError = fieldErrors.get(0);
//            String fieldName = firstFieldError.getField();  //title
//            String defaultMessage = firstFieldError.getDefaultMessage();    //error message
//
//            Map<String, String> error = new HashMap<>();
//            error.put(fieldName, defaultMessage);
//            return error;
//        }
//        db.save(params)

        return Map.of();
    }
}
