package com.ttt.capstone.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ttt.capstone.domian.Post;
import com.ttt.capstone.domian.QPost;
import com.ttt.capstone.request.PostSearch;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class PostRepositoryImpl implements PostRepositoryCustom{

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Post> getList(PostSearch postSearch) {
        int size = (postSearch.getSize() == null) ? 10 : postSearch.getSize();
        return jpaQueryFactory.selectFrom(QPost.post)
                .limit(size)

                .offset(postSearch.getOffset())
                .orderBy(QPost.post.id.desc())
                .fetch();
    }
}
