package com.ttt.capstone.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ttt.capstone.domian.Post;
import com.ttt.capstone.domian.QPost;
import com.ttt.capstone.request.SearchRequest;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ReviewRepositoryImpl implements PostRepositoryCustom{

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Post> getList(SearchRequest searchRequest) {
        int size = (searchRequest.getSize() == null) ? 10 : searchRequest.getSize();
        return jpaQueryFactory.selectFrom(QPost.post)
                .limit(size)

                .offset(searchRequest.getOffset())
                .orderBy(QPost.post.id.desc())
                .fetch();
    }

    @Override
    public List<Post> search(SearchRequest searchRequest) {
        int size = (searchRequest.getSize() == null) ? 10 : searchRequest.getSize();

        BooleanBuilder builder = new BooleanBuilder();

        if (searchRequest.getTitle() != null) {
            builder.and(QPost.post.title.containsIgnoreCase(searchRequest.getTitle()));
        }

        if (searchRequest.getContent() != null) {
            builder.and(QPost.post.content.contains(searchRequest.getContent()));
        }

        if (searchRequest.getWrittenBy() != null) {
            builder.and(QPost.post.writtenBy.containsIgnoreCase(searchRequest.getWrittenBy()));
        }

        return jpaQueryFactory.selectFrom(QPost.post)
                .where(builder)
                .limit(size)
                .offset(searchRequest.getOffset())
                .orderBy(QPost.post.id.desc())
                .fetch();
    }
}
