package com.ttt.capstone.repository;

import com.ttt.capstone.domian.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long>, PostRepositoryCustom{
    // Post 엔티티를 받을 것이고 Primary Key는 long타입이다.
    Optional<Post> findById(Long postId);
}
