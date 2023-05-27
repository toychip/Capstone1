package com.ttt.capstone.regionrepository;

import com.ttt.capstone.regionentity.Busan;
import com.ttt.capstone.regionentity.Seoul;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusanRepository extends JpaRepository<Busan, Integer> {
    Page<Busan> findBySmallCodeAndRoadNameContaining(String smallCode, String roadName, Pageable pageable);
    Page<Busan> findBySmallCode(String smallCode, Pageable pageable);
}
