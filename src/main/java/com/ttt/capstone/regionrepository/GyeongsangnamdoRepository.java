package com.ttt.capstone.regionrepository;

import com.ttt.capstone.regionentity.Gyeongsangbukdo;
import com.ttt.capstone.regionentity.Gyeongsangnamdo;
import com.ttt.capstone.regionentity.Seoul;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GyeongsangnamdoRepository extends JpaRepository<Gyeongsangnamdo, Integer> {
    Page<Gyeongsangnamdo> findBySmallCodeAndRoadNameContaining(String smallCode, String roadName, Pageable pageable);
    Page<Gyeongsangnamdo> findBySmallCode(String smallCode, Pageable pageable);
}
