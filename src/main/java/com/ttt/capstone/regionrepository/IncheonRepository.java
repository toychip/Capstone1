package com.ttt.capstone.regionrepository;

import com.ttt.capstone.regionentity.Gyeongsangbukdo;
import com.ttt.capstone.regionentity.Incheon;
import com.ttt.capstone.regionentity.Seoul;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncheonRepository extends JpaRepository<Incheon, Integer> {
    Page<Incheon> findBySmallCodeAndRoadNameContaining(String smallCode, String roadName, Pageable pageable);
    Page<Incheon> findBySmallCode(String smallCode, Pageable pageable);
}
