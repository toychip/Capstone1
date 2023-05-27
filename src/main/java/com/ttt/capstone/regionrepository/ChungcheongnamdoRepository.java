package com.ttt.capstone.regionrepository;

import com.ttt.capstone.regionentity.Chungcheongbukdo;
import com.ttt.capstone.regionentity.Chungcheongnamdo;
import com.ttt.capstone.regionentity.Seoul;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChungcheongnamdoRepository extends JpaRepository<Chungcheongnamdo, Integer> {
    Page<Chungcheongnamdo> findBySmallCodeAndRoadNameContaining(String smallCode, String roadName, Pageable pageable);
    Page<Chungcheongnamdo> findBySmallCode(String smallCode, Pageable pageable);
}
