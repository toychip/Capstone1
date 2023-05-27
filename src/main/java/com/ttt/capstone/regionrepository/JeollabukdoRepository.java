package com.ttt.capstone.regionrepository;

import com.ttt.capstone.regionentity.Incheon;
import com.ttt.capstone.regionentity.Jeollabukdo;
import com.ttt.capstone.regionentity.Seoul;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JeollabukdoRepository extends JpaRepository<Jeollabukdo, Integer> {
    Page<Jeollabukdo> findBySmallCodeAndRoadNameContaining(String smallCode, String roadName, Pageable pageable);
    Page<Jeollabukdo> findBySmallCode(String smallCode, Pageable pageable);
}
