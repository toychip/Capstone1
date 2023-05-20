package com.ttt.capstone.service;

import com.ttt.capstone.repository.RegionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RegionService {
    private final RegionRepository regionRepository;
    public List<SmallNameResponse> getSeoul(String smallCode, Optional<String> district, Pageable pageable) {
        return regionRepository.getSeoul(smallCode, district, pageable);
    }

    public List<SmallNameResponse> getBusan(String smallCode, Optional<String> district, Pageable pageable) {
        return regionRepository.getBusan(smallCode, district, pageable);
    }

    public List<SmallNameResponse> getChungcheongbukdo(String smallCode, Optional<String> district, Pageable pageable) {
        return regionRepository.getChungcheongbukdo(smallCode, district, pageable);
    }

    public List<SmallNameResponse> getChungcheongnamdo(String smallCode, Optional<String> district, Pageable pageable) {
        return regionRepository.getChungcheongnamdo(smallCode, district, pageable);
    }

    public List<SmallNameResponse> getDaegu(String smallCode, Optional<String> district, Pageable pageable) {
        return regionRepository.getDaegu(smallCode, district, pageable);
    }

    public List<SmallNameResponse> getDaejeon(String smallCode, Optional<String> district, Pageable pageable) {
        return regionRepository.getDaejeon(smallCode, district, pageable);
    }

    public List<SmallNameResponse> getGandwondo(String smallCode, Optional<String> district, Pageable pageable) {
        return regionRepository.getGandwondo(smallCode, district, pageable);
    }

    public List<SmallNameResponse> getGwangju(String smallCode, Optional<String> district, Pageable pageable) {
        return regionRepository.getGwangju(smallCode, district, pageable);
    }

    public List<SmallNameResponse> getGyeonggido(String smallCode, Optional<String> district, Pageable pageable) {
        return regionRepository.getGyeonggido(smallCode, district, pageable);
    }

    public List<SmallNameResponse> gyeongsangnamdo(String smallCode, Optional<String> district, Pageable pageable) {
        return regionRepository.getGyeongsangnamdo(smallCode, district, pageable);
    }

    public List<SmallNameResponse> gyeongsangbukdo(String smallCode, Optional<String> district, Pageable pageable) {
        return regionRepository.getGyeongsangbukdo(smallCode, district, pageable);
    }

    public List<SmallNameResponse> incheon(String smallCode, Optional<String> district, Pageable pageable) {
        return regionRepository.getIncheon(smallCode, district, pageable);
    }

    public List<SmallNameResponse> jejudo(String smallCode, Optional<String> district, Pageable pageable) {
        return regionRepository.getJejudo(smallCode, district, pageable);
    }

    public List<SmallNameResponse> jeollabukdo(String smallCode, Optional<String> district, Pageable pageable) {
        return regionRepository.getJeollabukdo(smallCode, district, pageable);
    }

    public List<SmallNameResponse> jeollanamdo(String smallCode, Optional<String> district, Pageable pageable) {
        return regionRepository.getJeollanamdo(smallCode, district, pageable);
    }

    public List<SmallNameResponse> sejong(String smallCode, Optional<String> district, Pageable pageable) {
        return regionRepository.getSejong(smallCode, district, pageable);
    }

    public List<SmallNameResponse> ulsan(String smallCode, Optional<String> district, Pageable pageable) {
        return regionRepository.getUlsan(smallCode, district, pageable);
    }
}
