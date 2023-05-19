package com.ttt.capstone.controller;

import com.ttt.capstone.service.RegionService;
import com.ttt.capstone.service.SmallNameResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/region")
@RequiredArgsConstructor
public class RegionController {

    private final RegionService regionService;

    @GetMapping("/seoul/company")
    public List<SmallNameResponse> getSeoul(@RequestParam String smallCode,
                                            @RequestParam Optional<String> district) {
        return regionService.getSeoul(smallCode, district);
    }

    @GetMapping("/busan/company")
    public List<SmallNameResponse> getBusan(@RequestParam String smallCode,
                                            @RequestParam Optional<String> district) {
        return regionService.getBusan(smallCode, district);
    }

    @GetMapping("/chungcheongbukdo/company")
    public List<SmallNameResponse> chungcheongbukdo(@RequestParam String smallCode,
                                                    @RequestParam Optional<String> district) {
        return regionService.getChungcheongbukdo(smallCode, district);
    }

    @GetMapping("/chungcheongnamdo/company")
    public List<SmallNameResponse> chungcheongnamdo(@RequestParam String smallCode,
                                                    @RequestParam Optional<String> district) {
        return regionService.getChungcheongnamdo(smallCode, district);
    }

    @GetMapping("/daegu/company")
    public List<SmallNameResponse> getDaegu(@RequestParam String smallCode,
                                            @RequestParam Optional<String> district) {
        return regionService.getDaegu(smallCode, district);
    }

    @GetMapping("/daejeon/company")
    public List<SmallNameResponse> getDaejeon(@RequestParam String smallCode,
                                              @RequestParam Optional<String> district) {
        return regionService.getDaejeon(smallCode, district);
    }

    @GetMapping("/gandwondo/company")
    public List<SmallNameResponse> getGandwondo(@RequestParam String smallCode, @RequestParam Optional<String> district) {
        return regionService.getGandwondo(smallCode, district);
    }

    @GetMapping("/gwangju/company")
    public List<SmallNameResponse> getGwangju(@RequestParam String smallCode, @RequestParam Optional<String> district) {
        return regionService.getGwangju(smallCode, district);
    }

    @GetMapping("/gyeonggido/company")
    public List<SmallNameResponse> getGyeonggido(@RequestParam String smallCode, @RequestParam Optional<String> district) {
        return regionService.getGyeonggido(smallCode, district);
    }

    @GetMapping("/gyeongsangnamdo/company")
    public List<SmallNameResponse> gyeongsangnamdo(@RequestParam String smallCode, @RequestParam Optional<String> district) {
        return regionService.gyeongsangnamdo(smallCode, district);
    }

    @GetMapping("/gyeongsangbukdo/company")
    public List<SmallNameResponse> gyeongsangbukdo(@RequestParam String smallCode, @RequestParam Optional<String> district) {
        return regionService.gyeongsangbukdo(smallCode, district);
    }
    @GetMapping("/incheon/company")
    public List<SmallNameResponse> incheon(@RequestParam String smallCode, @RequestParam Optional<String> district) {
        return regionService.incheon(smallCode, district);
    }
    @GetMapping("/jejudo/company")
    public List<SmallNameResponse> jejudo(@RequestParam String smallCode, @RequestParam Optional<String> district) {
        return regionService.jejudo(smallCode, district);
    }
    @GetMapping("/jeollabukdo/company")
    public List<SmallNameResponse> jeollabukdo(@RequestParam String smallCode, @RequestParam Optional<String> district) {
        return regionService.jeollabukdo(smallCode, district);
    }
    @GetMapping("/jeollanamdo/company")
    public List<SmallNameResponse> jeollanamdo(@RequestParam String smallCode, @RequestParam Optional<String> district) {
        return regionService.jeollanamdo(smallCode, district);
    }

    @GetMapping("/sejong/company")
    public List<SmallNameResponse> sejong(@RequestParam String smallCode, @RequestParam Optional<String> district) {
        return regionService.sejong(smallCode, district);
    }

    @GetMapping("/ulsan/company")
    public List<SmallNameResponse> ulsan(@RequestParam String smallCode, @RequestParam Optional<String> district) {
        return regionService.ulsan(smallCode, district);
    }
}
