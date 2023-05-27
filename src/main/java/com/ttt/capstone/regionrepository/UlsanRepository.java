package com.ttt.capstone.regionrepository;

import com.ttt.capstone.regionentity.Jeollabukdo;
import com.ttt.capstone.regionentity.Seoul;
import com.ttt.capstone.regionentity.Ulsan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UlsanRepository extends JpaRepository<Ulsan, Integer> {
    Page<Ulsan> findBySmallCodeAndRoadNameContaining(String smallCode, String roadName, Pageable pageable);
    Page<Ulsan> findBySmallCode(String smallCode, Pageable pageable);
}
