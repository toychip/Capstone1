package com.ttt.capstone.regionrepository;

import com.ttt.capstone.regionentity.Busan;
import com.ttt.capstone.regionentity.Chungcheongbukdo;
import com.ttt.capstone.regionentity.Seoul;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChungcheongbukdoRepository extends JpaRepository<Chungcheongbukdo, Integer> {
    Page<Chungcheongbukdo> findBySmallCodeAndRoadNameContaining(String smallCode, String roadName, Pageable pageable);
    Page<Chungcheongbukdo> findBySmallCode(String smallCode, Pageable pageable);
}
