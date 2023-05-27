package com.ttt.capstone.regionrepository;

import com.ttt.capstone.regionentity.Gandwondo;
import com.ttt.capstone.regionentity.Gwangju;
import com.ttt.capstone.regionentity.Seoul;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GwangjuRepository extends JpaRepository<Gwangju, Integer> {
    Page<Gwangju> findBySmallCodeAndRoadNameContaining(String smallCode, String roadName, Pageable pageable);
    Page<Gwangju> findBySmallCode(String smallCode, Pageable pageable);
}
