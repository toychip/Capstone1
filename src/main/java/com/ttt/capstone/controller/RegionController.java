package com.ttt.capstone.controller;

import com.ttt.capstone.service.RegionService;
import com.ttt.capstone.service.SmallNameResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/region")
@RequiredArgsConstructor
public class RegionController {

    private final RegionService regionService;

    @GetMapping("/seoul/{smallCode}")
    public List<SmallNameResponse> getSeoul(@PathVariable String smallCode) {
        return regionService.getSeoul(smallCode);
    }

    @GetMapping("/busan/{smallCode}")
    public List<SmallNameResponse> getBusan(@PathVariable String smallCode) {
        return regionService.getBusan(smallCode);
    }

    @GetMapping("/chungcheongbukdo/{smallCode}")
    public List<SmallNameResponse> chungcheongbukdo(@PathVariable String smallCode) {
        return regionService.getChungcheongbukdo(smallCode);
    }

    @GetMapping("/chungcheongnamdo/{smallCode}")
    public List<SmallNameResponse> chungcheongnamdo(@PathVariable String smallCode) {
        return regionService.getChungcheongnamdo(smallCode);
    }

    @GetMapping("/daegu/{smallCode}")
    public List<SmallNameResponse> getDaegu(@PathVariable String smallCode) {
        return regionService.getDaegu(smallCode);
    }

    @GetMapping("/daejeon/{smallCode}")
    public List<SmallNameResponse> getDaejeon(@PathVariable String smallCode) {
        return regionService.getDaejeon(smallCode);
    }

    @GetMapping("/gandwondo/{smallCode}")
    public List<SmallNameResponse> getGandwondo(@PathVariable String smallCode) {
        return regionService.getGandwondo(smallCode);
    }

    @GetMapping("/gwangju/{smallCode}")
    public List<SmallNameResponse> getGwangju(@PathVariable String smallCode) {
        return regionService.getGwangju(smallCode);
    }

    @GetMapping("/gyeonggido/{smallCode}")
    public List<SmallNameResponse> getGyeonggido(@PathVariable String smallCode) {
        return regionService.getGyeonggido(smallCode);
    }

    @GetMapping("/gyeongsangnamdo/{smallCode}")
    public List<SmallNameResponse> gyeongsangnamdo(@PathVariable String smallCode) {
        return regionService.gyeongsangnamdo(smallCode);
    }

    @GetMapping("/gyeongsangbukdo/{smallCode}")
    public List<SmallNameResponse> gyeongsangbukdo(@PathVariable String smallCode) {
        return regionService.gyeongsangbukdo(smallCode);
    }
    @GetMapping("/incheon/{smallCode}")
    public List<SmallNameResponse> incheon(@PathVariable String smallCode) {
        return regionService.incheon(smallCode);
    }
    @GetMapping("/jejudo/{smallCode}")
    public List<SmallNameResponse> jejudo(@PathVariable String smallCode) {
        return regionService.jejudo(smallCode);
    }
    @GetMapping("/jeollabukdo/{smallCode}")
    public List<SmallNameResponse> jeollabukdo(@PathVariable String smallCode) {
        return regionService.jeollabukdo(smallCode);
    }
    @GetMapping("/jeollanamdo/{smallCode}")
    public List<SmallNameResponse> jeollanamdo(@PathVariable String smallCode) {
        return regionService.jeollanamdo(smallCode);
    }

    @GetMapping("/sejong/{smallCode}")
    public List<SmallNameResponse> sejong(@PathVariable String smallCode) {
        return regionService.sejong(smallCode);
    }

    @GetMapping("/ulsan/{smallCode}")
    public List<SmallNameResponse> ulsan(@PathVariable String smallCode) {
        return regionService.ulsan(smallCode);
    }
}
