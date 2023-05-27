package com.ttt.capstone.regionrepository;

import com.ttt.capstone.regionentity.Incheon;
import com.ttt.capstone.regionentity.Jejudo;
import com.ttt.capstone.regionentity.Seoul;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JejudoRepository extends JpaRepository<Jejudo, Integer> {
    Page<Jejudo> findBySmallCodeAndRoadNameContaining(String smallCode, String roadName, Pageable pageable);
    Page<Jejudo> findBySmallCode(String smallCode, Pageable pageable);
}
 