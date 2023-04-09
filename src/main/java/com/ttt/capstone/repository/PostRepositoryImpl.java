package com.ttt.capstone.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ttt.capstone.domian.Post;
import com.ttt.capstone.domian.QPost;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class PostRepositoryImpl implements PostRepositoryCustom{

    private final JPAQueryFactory jpaQueryFactory;


    @Override
    public List<Post> getList(int page) {
        return jpaQueryFactory.selectFrom(QPost.post)
                .limit(10)
                .offset((long)(page - 1) * 10)
                .fetch();
    }
}
