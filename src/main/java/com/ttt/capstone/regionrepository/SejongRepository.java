package com.ttt.capstone.regionrepository;

import com.ttt.capstone.regionentity.Jeollanamdo;
import com.ttt.capstone.regionentity.Sejong;
import com.ttt.capstone.regionentity.Seoul;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SejongRepository extends JpaRepository<Sejong, Integer> {
    Page<Sejong> findBySmallCodeAndRoadNameContaining(String smallCode, String roadName, Pageable pageable);
    Page<Sejong> findBySmallCode(String smallCode, Pageable pageable);
}
