package com.ttt.capstone.regionrepository;

import com.ttt.capstone.regionentity.Jeollabukdo;
import com.ttt.capstone.regionentity.Jeollanamdo;
import com.ttt.capstone.regionentity.Seoul;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JeollanamdoRepository extends JpaRepository<Jeollanamdo, Integer> {
    Page<Jeollanamdo> findBySmallCodeAndRoadNameContaining(String smallCode, String roadName, Pageable pageable);
    Page<Jeollanamdo> findBySmallCode(String smallCode, Pageable pageable);
}
