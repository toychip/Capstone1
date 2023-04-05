package com.ttt.capstone.service;

import com.ttt.capstone.domian.Post;
import com.ttt.capstone.repository.PostRepository;
import com.ttt.capstone.request.PostCreate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
}
