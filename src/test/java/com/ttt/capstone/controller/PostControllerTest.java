package com.ttt.capstone.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
class PostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("/posts 요청시 빈 오브젝트 반환.")
    void test() throws Exception{
        // 글 제목
        // 글 내용

        // expected
        mockMvc.perform(post("/posts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"title\": \"제목입니다.\",\"content\" :\"내용입니다.\"}")
//                        .param("title", "글 제목")
//                        .param("content", "글 내용입니다 하하")
                )   // application/json
                .andExpect(status().isOk())
                .andExpect(content().string("{}"))
                .andDo(print());
    }

    @Test
    @DisplayName("/posts 요청시 title 값은 필수다.")
    void test2() throws Exception{
        // expected
        mockMvc.perform(post("/posts")
                        .contentType(MediaType.APPLICATION_JSON)
//                {"title:""}
//                {"title:null}도 검증을 해줄지? ? - 해줌
                        .content("{\"title\": null, \"content\": \"내용입니다.\"}")
                )
                .andExpect(status().isBadRequest())
//                .andExpect(MockMvcResultMatchers.content().string("Hello World"))
                .andExpect(jsonPath("$.code").value("400"))
                .andExpect(jsonPath("$.message").value("잘못된 요청입니다."))
                .andExpect(jsonPath("$.validation.title").value("타이틀을 입력해주세요."))
//                                              json의 타이틀이 오른쪽 value 값으로 내려오느냐?
                .andDo(print());
    }
}