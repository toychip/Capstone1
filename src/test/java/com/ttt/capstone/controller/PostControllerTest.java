package com.ttt.capstone.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ttt.capstone.domian.Post;
import com.ttt.capstone.repository.PostRepository;
import com.ttt.capstone.request.PostCreate;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.http.MediaType.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
class PostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void clean(){
        postRepository.deleteAll();
    }

    @Test
    @DisplayName("/posts 요청시 빈 오브젝트 반환.")
    void test() throws Exception{
        // 글 제목
        // 글 내용

        // expected
        mockMvc.perform(post("/posts")
                        .contentType(APPLICATION_JSON)
                        .content("{\"title\": \"제목입니다.\",\"content\" :\"내용입니다.\"}")
//                        .param("title", "글 제목")
//                        .param("content", "글 내용입니다 하하")
                )   // application/json
                .andExpect(status().isOk())
                .andExpect(content().string(""))
                .andDo(print());
    }

    @Test
    @DisplayName("/posts 요청시 title 값은 필수다.")
    void test2() throws Exception{
        // given
        PostCreate request = PostCreate.builder()
//                .title("제목입니다.")
                .content("내용입니다.")
                .build();
        String json = objectMapper.writeValueAsString(request);

        // expected
        mockMvc.perform(post("/posts")
                                .contentType(APPLICATION_JSON)
//                {"title:""}
//                {"title:null}도 검증을 해줄지? ? - 해줌
                        .content(json)
                )
                .andExpect(status().isBadRequest())
//                .andExpect(MockMvcResultMatchers.content().string("Hello World"))
                .andExpect(jsonPath("$.code").value(HttpStatus.BAD_REQUEST.toString()))
                .andExpect(jsonPath("$.message").value("잘못된 요청입니다."))
                .andExpect(jsonPath("$.validation.title").value("타이틀을 입력하세요."))
//                                              json의 타이틀이 오른쪽 value 값으로 내려오느냐?
                .andDo(print());
    }

    @Test
    @DisplayName("/posts 요청시 DB에 값이 저장된다.")
    void test3() throws Exception{
        //given
        PostCreate requestPrev = new PostCreate("제목입니다.", "내용입니다.");
        PostCreate request = PostCreate.builder()
                .title("제목입니다.")
                .content("내용입니다.")
                .build();


//        ObjectMapper objectMapper = new ObjectMapper();  Spring에서 bean에 기본적으로 적용시켜줌
        String json = objectMapper.writeValueAsString(request);
        System.out.println(json);
        // when
        mockMvc.perform(post("/posts")
                                .contentType(APPLICATION_JSON)
//                                .content("{\"title\": \"제목입니다.\", \"content\": \"내용입니다.\"}")
                                .content(json)
                )
                .andExpect(status().isOk())
                .andDo(print());

        //then
        assertEquals(1L, postRepository.count());
        Post post = postRepository.findAll().get(0);
        assertEquals("제목입니다.", post.getTitle());
        assertEquals("내용입니다.", post.getContent());
    }

    @Test
    @DisplayName("글 1개 조회")
    void test4() throws Exception {
        //given

        // 클라이언트 요구 사항
        // json응답에서 title값 길이를 최대 10글자로 해주세요.

        // Post Entity와 PostResponse class 같은 형식이기 때문에 그대로 썼음

        Post post = Post.builder()
                .title("123456789012345")
                .content("bar")
                .build();
        postRepository.save(post);
        //expected(when + then)
        mockMvc.perform(get("/posts/{postId}", post.getId())
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(post.getId()))
                .andExpect(jsonPath("$.title").value("1234567890"))
                .andExpect(jsonPath("$.content").value("bar"))
                .andDo(print());
        //then
    }

    @Test
    @DisplayName("글 여러개 조회")
    void test5() throws Exception {
        //given
        Post post1 = postRepository.save(Post.builder()
                .title("title1")
                .content("content1")
                .build());

        Post post2 = postRepository.save(Post.builder()
                .title("title2")
                .content("content2")
                .build());

        //expected(when + then)
        mockMvc.perform(get("/posts/")
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()", Matchers.is(2)))
                .andExpect(jsonPath("$.[0].id").value(post1.getId()))
                .andExpect(jsonPath("$.[0].title").value("title1"))
                .andExpect(jsonPath("$.[0].content").value("content1"))

                .andExpect(jsonPath("$.[1].id").value(post2.getId()))
                .andExpect(jsonPath("$.[1].title").value("title2"))
                .andExpect(jsonPath("$.[1].content").value("content2"))

                .andDo(print());
        //then
    }

}