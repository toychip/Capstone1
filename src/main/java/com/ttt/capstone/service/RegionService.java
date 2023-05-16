package com.ttt.capstone.service;

import com.ttt.capstone.repository.RegionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RegionService {
    private final RegionRepository regionRepository;
    public List<SmallNameResponse> getSeoul(String smallCode) {
        return regionRepository.getSeoul(smallCode);
    }

    public List<SmallNameResponse> getBusan(String smallCode) {
        return regionRepository.getBusan(smallCode);
    }

    public List<SmallNameResponse> getChungcheongbukdo(String smallCode) {
        return regionRepository.getChungcheongbukdo(smallCode);
    }

    public List<SmallNameResponse> getChungcheongnamdo(String smallCode) {
        return regionRepository.getChungcheongnamdo(smallCode);
    }

    public List<SmallNameResponse> getDaegu(String smallCode) {
        return regionRepository.getDaegu(smallCode);
    }

    public List<SmallNameResponse> getDaejeon(String smallCode) {
        return regionRepository.getDaejeon(smallCode);
    }

    public List<SmallNameResponse> getGandwondo(String smallCode) {
        return regionRepository.getGandwondo(smallCode);
    }

    public List<SmallNameResponse> getGwangju(String smallCode) {
        return regionRepository.getGwangju(smallCode);
    }

    public List<SmallNameResponse> getGyeonggido(String smallCode) {
        return regionRepository.getGyeonggido(smallCode);
    }

    public List<SmallNameResponse> gyeongsangnamdo(String smallCode) {
        return regionRepository.getGyeongsangnamdo(smallCode);
    }

    public List<SmallNameResponse> gyeongsangbukdo(String smallCode) {
        return regionRepository.getGyeongsangbukdo(smallCode);
    }

    public List<SmallNameResponse> incheon(String smallCode) {
        return regionRepository.getIncheon(smallCode);
    }

    public List<SmallNameResponse> jejudo(String smallCode) {
        return regionRepository.getJejudo(smallCode);
    }

    public List<SmallNameResponse> jeollabukdo(String smallCode) {
        return regionRepository.getJeollabukdo(smallCode);
    }

    public List<SmallNameResponse> jeollanamdo(String smallCode) {
        return regionRepository.getJeollanamdo(smallCode);
    }

    public List<SmallNameResponse> sejong(String smallCode) {
        return regionRepository.getSejong(smallCode);
    }

    public List<SmallNameResponse> ulsan(String smallCode) {
        return regionRepository.getUlsan(smallCode);
    }
}
