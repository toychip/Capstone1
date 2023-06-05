package com.ttt.capstone.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ttt.capstone.domian.Post;
import com.ttt.capstone.domian.QPost;
import com.ttt.capstone.domian.QReview;
import com.ttt.capstone.domian.Review;
import com.ttt.capstone.request.SearchRequest;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepositoryCustom{

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Review> getList(SearchRequest searchRequest) {
        int size = (searchRequest.getSize() == null) ? 10 : searchRequest.getSize();
        return jpaQueryFactory.selectFrom(QReview.review)
                .limit(size)
                .offset(searchRequest.getOffset())
                .orderBy(QReview.review.id.desc())
                .fetch();
    }




    @Override
    public List<Review> search(SearchRequest searchRequest) {
        int size = (searchRequest.getSize() == null) ? 10 : searchRequest.getSize();

        BooleanBuilder builder = new BooleanBuilder();

        if (searchRequest.getTitle() != null) {
            builder.and(QReview.review.title.containsIgnoreCase(searchRequest.getTitle()));
        }

        if (searchRequest.getContent() != null) {
            builder.and(QReview.review.content.contains(searchRequest.getContent()));
        }

        if (searchRequest.getWrittenBy() != null) {
            builder.and(QReview.review.writtenBy.containsIgnoreCase(searchRequest.getWrittenBy()));
        }

        return jpaQueryFactory.selectFrom(QReview.review)
                .where(builder)
                .limit(size)
                .offset(searchRequest.getOffset())
                .orderBy(QReview.review.id.desc())
                .fetch();
    }
}
