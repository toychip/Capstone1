package com.ttt.capstone.regionrepository;

import com.ttt.capstone.regionentity.Daejeon;
import com.ttt.capstone.regionentity.Seoul;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DaejeonRepository extends JpaRepository<Daejeon, Integer> {
    Page<Daejeon> findBySmallCodeAndRoadNameContaining(String smallCode, String roadName, Pageable pageable);
    Page<Daejeon> findBySmallCode(String smallCode, Pageable pageable);
}
