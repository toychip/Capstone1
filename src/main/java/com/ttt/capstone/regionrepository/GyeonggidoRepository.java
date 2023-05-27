package com.ttt.capstone.regionrepository;

import com.ttt.capstone.regionentity.Gwangju;
import com.ttt.capstone.regionentity.Gyeonggido;
import com.ttt.capstone.regionentity.Seoul;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GyeonggidoRepository extends JpaRepository<Gyeonggido, Integer> {
    Page<Gyeonggido> findBySmallCodeAndRoadNameContaining(String smallCode, String roadName, Pageable pageable);
    Page<Gyeonggido> findBySmallCode(String smallCode, Pageable pageable);
}
