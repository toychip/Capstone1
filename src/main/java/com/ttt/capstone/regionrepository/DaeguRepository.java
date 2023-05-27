package com.ttt.capstone.regionrepository;

import com.ttt.capstone.regionentity.Chungcheongbukdo;
import com.ttt.capstone.regionentity.Daegu;
import com.ttt.capstone.regionentity.Seoul;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DaeguRepository extends JpaRepository<Daegu, Integer> {
    Page<Daegu> findBySmallCodeAndRoadNameContaining(String smallCode, String roadName, Pageable pageable);
    Page<Daegu> findBySmallCode(String smallCode, Pageable pageable);
}
