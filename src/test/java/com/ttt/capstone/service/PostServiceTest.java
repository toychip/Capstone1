package com.ttt.capstone.service;

import com.ttt.capstone.domian.Post;
import com.ttt.capstone.repository.PostRepository;
import com.ttt.capstone.request.PostCreate;
import com.ttt.capstone.request.PostEdit;
import com.ttt.capstone.request.PostSearch;
import com.ttt.capstone.response.PostResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostServiceTest {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private PostService postService;

    @BeforeEach
    void clean(){
        postRepository.deleteAll();
    }

    @Test
    @DisplayName("글 작성")
    void test1() {
        //given
        PostCreate postCreate = PostCreate.builder()
                .title("제목입니다.")
                .content("내용입니다.")
                .build();
        //when
        postService.write(postCreate);
        //then
        assertEquals(1L, postRepository.count());
        Post post = postRepository.findAll().get(0);
        assertEquals("제목입니다.", post.getTitle());
        assertEquals("내용입니다.", post.getContent());
    }

    @Test
    @DisplayName("글 1개 조회")
    void test2(){
        //given
        Post requestPost = Post.builder()
                .title("foo")
                .content("bar")
                .build();
        postRepository.save(requestPost);




        //when
        PostResponse response = postService.get(requestPost.getId());

        //then
        assertNotNull(response);
        assertEquals(1L, postRepository.count());
        assertEquals("foo", response.getTitle());
        assertEquals("bar", response.getContent());
    }

    @Test
    @DisplayName("글 여러개 조회")
    void test3(){
        //given
        List<Post> resultPosts = IntStream.range(0, 20)
                .mapToObj(i -> {
                    return Post.builder()
                            .title("test title " + i + " 번째")
                            .content("test content " + i + " 번째")
                            .build();
                })
                        .collect(Collectors.toList());
        postRepository.saveAll(resultPosts);

        // Pageable pageableRequest = PageRequest.of(0, 10);//, Sort.Direction.DESC, "id");
        PostSearch postSearch = PostSearch.builder()
                .page(1)
//                .size(10) - 한페이지당 여러개 보기
                .build();

        //when
        List<PostResponse> posts = postService.getList(postSearch);
        //then
        assertEquals(10,posts.size());  // 한 페이지당 사이즈
        assertEquals("test title 19 번째",posts.get(0).getTitle());
    }

    @Test
    @DisplayName("글 제목 수정")
    void test4(){
        //give
        Post post = Post.builder()
                            .title("임준형")
                            .content("이것은 내용이지롱")
                            .build();

    postRepository.save(post);

        PostEdit postEdit = PostEdit.builder()
                .title(null)   // 이름을 바꿨으므로 내용은 안 보내서 null로 들어온 경우
                .content("수정된 내용이지롱")
                .build();

        //when
        postService.edit(post.getId(), postEdit);

        //then
        Post changedPost = postRepository.findById(post.getId())
                .orElseThrow(() -> new RuntimeException("글이 존재하지 않습니다. id=" + post.getId()));
        Assertions.assertEquals("임준형", changedPost.getTitle());
        Assertions.assertEquals("수정된 내용이지롱", changedPost.getContent());
    }

    @Test
    @DisplayName("글 내용 수정")
    void test5() {
        //give
        Post post = Post.builder()
                .title("임준형")
                .content("이것은 내용이지롱")
                .build();

        postRepository.save(post);

        PostEdit postEdit = PostEdit.builder()
                .title("임준형")
                .content("저것은 내용이지롱")
                .build();

        //when
        postService.edit(post.getId(), postEdit);

        //then
        Post changedPost = postRepository.findById(post.getId())
                .orElseThrow(() -> new RuntimeException("글이 존재하지 않습니다. id=" + post.getId()));
                Assertions.assertEquals("저것은 내용이지롱", changedPost.getContent());
    }

    @Test
    @DisplayName("게시글 삭제")
    void test6(){
        //give
        Post post = Post.builder()
                .title("임준형")
                .content("이것은 내용이지롱")
                .build();

        postRepository.save(post);

        //when
        postService.delete(post.getId());

        Assertions.assertEquals(0, postRepository.count());
    }
}