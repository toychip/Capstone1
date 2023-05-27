package com.ttt.capstone.regionrepository;

import com.ttt.capstone.regionentity.Seoul;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeoulRepository extends JpaRepository<Seoul, Integer> {
    Page<Seoul> findBySmallCodeAndRoadNameContaining(String smallCode, String roadName, Pageable pageable);
    Page<Seoul> findBySmallCode(String smallCode, Pageable pageable);
}
