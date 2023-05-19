package com.ttt.capstone.service;

import com.ttt.capstone.repository.RegionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RegionService {
    private final RegionRepository regionRepository;
    public List<SmallNameResponse> getSeoul(String smallCode, Optional<String> district) {
        return regionRepository.getSeoul(smallCode, district);
    }

    public List<SmallNameResponse> getBusan(String smallCode, Optional<String> district) {
        return regionRepository.getBusan(smallCode, district);
    }

    public List<SmallNameResponse> getChungcheongbukdo(String smallCode, Optional<String> district) {
        return regionRepository.getChungcheongbukdo(smallCode, district);
    }

    public List<SmallNameResponse> getChungcheongnamdo(String smallCode, Optional<String> district) {
        return regionRepository.getChungcheongnamdo(smallCode, district);
    }

    public List<SmallNameResponse> getDaegu(String smallCode, Optional<String> district) {
        return regionRepository.getDaegu(smallCode, district);
    }

    public List<SmallNameResponse> getDaejeon(String smallCode, Optional<String> district) {
        return regionRepository.getDaejeon(smallCode, district);
    }

    public List<SmallNameResponse> getGandwondo(String smallCode, Optional<String> district) {
        return regionRepository.getGandwondo(smallCode, district);
    }

    public List<SmallNameResponse> getGwangju(String smallCode, Optional<String> district) {
        return regionRepository.getGwangju(smallCode, district);
    }

    public List<SmallNameResponse> getGyeonggido(String smallCode, Optional<String> district) {
        return regionRepository.getGyeonggido(smallCode, district);
    }

    public List<SmallNameResponse> gyeongsangnamdo(String smallCode, Optional<String> district) {
        return regionRepository.getGyeongsangnamdo(smallCode, district);
    }

    public List<SmallNameResponse> gyeongsangbukdo(String smallCode, Optional<String> district) {
        return regionRepository.getGyeongsangbukdo(smallCode, district);
    }

    public List<SmallNameResponse> incheon(String smallCode, Optional<String> district) {
        return regionRepository.getIncheon(smallCode, district);
    }

    public List<SmallNameResponse> jejudo(String smallCode, Optional<String> district) {
        return regionRepository.getJejudo(smallCode, district);
    }

    public List<SmallNameResponse> jeollabukdo(String smallCode, Optional<String> district) {
        return regionRepository.getJeollabukdo(smallCode, district);
    }

    public List<SmallNameResponse> jeollanamdo(String smallCode, Optional<String> district) {
        return regionRepository.getJeollanamdo(smallCode, district);
    }

    public List<SmallNameResponse> sejong(String smallCode, Optional<String> district) {
        return regionRepository.getSejong(smallCode, district);
    }

    public List<SmallNameResponse> ulsan(String smallCode, Optional<String> district) {
        return regionRepository.getUlsan(smallCode, district);
    }
}
