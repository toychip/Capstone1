package com.ttt.capstone.service;

import com.ttt.capstone.domian.Post;
import com.ttt.capstone.repository.PostRepository;
import com.ttt.capstone.request.PostCreate;
import com.ttt.capstone.response.PostResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostService {


    private final PostRepository postRepository;

    public Post writeNn(PostCreate postCreate){
        // postCreate -> Entity 형태로 바꿔주어야함. postCreate는 RequestDTO이기 때문
        Post post = Post.builder()
                .title(postCreate.getTitle())
                .content(postCreate.getContent())
                .build();

        return postRepository.save(post);
    }
    public void write(PostCreate postCreate){
        // postCreate -> Entity 형태로 바꿔주어야함. postCreate는 RequestDTO이기 때문
        Post post = Post.builder()
                .title(postCreate.getTitle())
                .content(postCreate.getContent())
                .build();
        postRepository.save(post);
    }

    public Long writePk(PostCreate postCreate){
        // postCreate -> Entity 형태로 바꿔주어야함. postCreate는 RequestDTO이기 때문
        Post post = Post.builder()
                .title(postCreate.getTitle())
                .content(postCreate.getContent())
                .build();

        return post.getId();
    }

    public PostResponse get(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 글입니다."));

        return PostResponse.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .build();
    }

    // 여러개의 게시글 조회
    public List<PostResponse> getList(Pageable pageable) {
//        Pageable pageable = PageRequest.of(page,10, Sort.by(Sort.Direction.DESC, "id"));

        return postRepository.getList(1).stream()
                .map(post -> new PostResponse(post))
                .collect(Collectors.toList());
    }


}
