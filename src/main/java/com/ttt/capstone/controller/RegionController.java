package com.ttt.capstone.controller;

import com.ttt.capstone.service.RegionService;
import com.ttt.capstone.service.SmallNameResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/region")
@RequiredArgsConstructor
public class RegionController {

    private final RegionService regionService;

    @GetMapping("/seoul/company")
    public List<SmallNameResponse> getSeoul(@RequestParam String smallCode) {
        return regionService.getSeoul(smallCode);
    }

    @GetMapping("/busan/company")
    public List<SmallNameResponse> getBusan(@RequestParam String smallCode) {
        return regionService.getBusan(smallCode);
    }

    @GetMapping("/chungcheongbukdo/company")
    public List<SmallNameResponse> chungcheongbukdo(@RequestParam String smallCode) {
        return regionService.getChungcheongbukdo(smallCode);
    }

    @GetMapping("/chungcheongnamdo/company")
    public List<SmallNameResponse> chungcheongnamdo(@RequestParam String smallCode) {
        return regionService.getChungcheongnamdo(smallCode);
    }

    @GetMapping("/daegu/company")
    public List<SmallNameResponse> getDaegu(@RequestParam String smallCode) {
        return regionService.getDaegu(smallCode);
    }

    @GetMapping("/daejeon/company")
    public List<SmallNameResponse> getDaejeon(@RequestParam String smallCode) {
        return regionService.getDaejeon(smallCode);
    }

    @GetMapping("/gandwondo/company")
    public List<SmallNameResponse> getGandwondo(@RequestParam String smallCode) {
        return regionService.getGandwondo(smallCode);
    }

    @GetMapping("/gwangju/company")
    public List<SmallNameResponse> getGwangju(@RequestParam String smallCode) {
        return regionService.getGwangju(smallCode);
    }

    @GetMapping("/gyeonggido/company")
    public List<SmallNameResponse> getGyeonggido(@RequestParam String smallCode) {
        return regionService.getGyeonggido(smallCode);
    }

    @GetMapping("/gyeongsangnamdo/company")
    public List<SmallNameResponse> gyeongsangnamdo(@RequestParam String smallCode) {
        return regionService.gyeongsangnamdo(smallCode);
    }

    @GetMapping("/gyeongsangbukdo/company")
    public List<SmallNameResponse> gyeongsangbukdo(@RequestParam String smallCode) {
        return regionService.gyeongsangbukdo(smallCode);
    }
    @GetMapping("/incheon/company")
    public List<SmallNameResponse> incheon(@RequestParam String smallCode) {
        return regionService.incheon(smallCode);
    }
    @GetMapping("/jejudo/company")
    public List<SmallNameResponse> jejudo(@RequestParam String smallCode) {
        return regionService.jejudo(smallCode);
    }
    @GetMapping("/jeollabukdo/company")
    public List<SmallNameResponse> jeollabukdo(@RequestParam String smallCode) {
        return regionService.jeollabukdo(smallCode);
    }
    @GetMapping("/jeollanamdo/company")
    public List<SmallNameResponse> jeollanamdo(@RequestParam String smallCode) {
        return regionService.jeollanamdo(smallCode);
    }

    @GetMapping("/sejong/company")
    public List<SmallNameResponse> sejong(@RequestParam String smallCode) {
        return regionService.sejong(smallCode);
    }

    @GetMapping("/ulsan/company")
    public List<SmallNameResponse> ulsan(@RequestParam String smallCode) {
        return regionService.ulsan(smallCode);
    }
}
