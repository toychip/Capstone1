package com.ttt.capstone.repository;

import com.ttt.capstone.domian.Post;
import com.ttt.capstone.domian.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Long>, ReviewRepositoryCustom{
    // Post 엔티티를 받을 것이고 Primary Key는 long타입이다.
    Optional<Review> findById(Long review);
}
