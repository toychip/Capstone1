package com.ttt.capstone.service;

import com.ttt.capstone.repository.RegionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RegionService {
    private final RegionRepository regionRepository;
    public List<SmallNameResponse> getSeoul(String request) {
        return regionRepository.getSeoul(request);
    }

    public List<SmallNameResponse> getBusan(String request) {
        return regionRepository.getBusan(request);
    }

    public List<SmallNameResponse> getChungcheongbukdo(String request) {
        return regionRepository.getChungcheongbukdo(request);
    }

    public List<SmallNameResponse> getChungcheongnamdo(String request) {
        return regionRepository.getChungcheongnamdo(request);
    }

    public List<SmallNameResponse> getDaegu(String request) {
        return regionRepository.getDaegu(request);
    }

    public List<SmallNameResponse> getDaejeon(String request) {
        return regionRepository.getDaejeon(request);
    }

    public List<SmallNameResponse> getGandwondo(String request) {
        return regionRepository.getGandwondo(request);
    }

    public List<SmallNameResponse> getGwangju(String request) {
        return regionRepository.getGwangju(request);
    }

    public List<SmallNameResponse> getGyeonggido(String request) {
        return regionRepository.getGyeonggido(request);
    }
}
