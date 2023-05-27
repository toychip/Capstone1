package com.ttt.capstone.regionrepository;

import com.ttt.capstone.regionentity.Gwangju;
import com.ttt.capstone.regionentity.Gyeongsangbukdo;
import com.ttt.capstone.regionentity.Seoul;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GyeongsangbukdoRepository extends JpaRepository<Gyeongsangbukdo, Integer> {
    Page<Gyeongsangbukdo> findBySmallCodeAndRoadNameContaining(String smallCode, String roadName, Pageable pageable);
    Page<Gyeongsangbukdo> findBySmallCode(String smallCode, Pageable pageable);
}
