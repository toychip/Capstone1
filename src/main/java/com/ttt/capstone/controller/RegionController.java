package com.ttt.capstone.controller;

import com.ttt.capstone.service.RegionService;
import com.ttt.capstone.service.SmallNameResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
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
                                            @RequestParam Optional<String> district,
                                            @RequestParam(defaultValue = "0") int page,
                                            @RequestParam(defaultValue = "8") int size) {
        return regionService.getSeoul(smallCode, district, PageRequest.of(page, size));
    }

    @GetMapping("/busan/company")
    public List<SmallNameResponse> getBusan(@RequestParam String smallCode,
                                            @RequestParam Optional<String> district,
                                            @RequestParam(defaultValue = "0") int page,
                                            @RequestParam(defaultValue = "8") int size) {
        return regionService.getBusan(smallCode, district, PageRequest.of(page, size));
    }

    @GetMapping("/chungcheongbukdo/company")
    public List<SmallNameResponse> chungcheongbukdo(@RequestParam String smallCode,
                                                    @RequestParam Optional<String> district,
                                            @RequestParam(defaultValue = "0") int page,
                                            @RequestParam(defaultValue = "8") int size) {
        return regionService.getChungcheongbukdo(smallCode, district, PageRequest.of(page, size));
    }

    @GetMapping("/chungcheongnamdo/company")
    public List<SmallNameResponse> chungcheongnamdo(@RequestParam String smallCode,
                                                    @RequestParam Optional<String> district,
                                            @RequestParam(defaultValue = "0") int page,
                                            @RequestParam(defaultValue = "8") int size) {
        return regionService.getChungcheongnamdo(smallCode, district, PageRequest.of(page, size));
    }

    @GetMapping("/daegu/company")
    public List<SmallNameResponse> getDaegu(@RequestParam String smallCode,
                                            @RequestParam Optional<String> district,
                                            @RequestParam(defaultValue = "0") int page,
                                            @RequestParam(defaultValue = "8") int size) {
        return regionService.getDaegu(smallCode, district, PageRequest.of(page, size));
    }

    @GetMapping("/daejeon/company")
    public List<SmallNameResponse> getDaejeon(@RequestParam String smallCode,
                                              @RequestParam Optional<String> district,
                                            @RequestParam(defaultValue = "0") int page,
                                            @RequestParam(defaultValue = "8") int size) {
        return regionService.getDaejeon(smallCode, district, PageRequest.of(page, size));
    }

    @GetMapping("/gandwondo/company")
    public List<SmallNameResponse> getGandwondo(@RequestParam String smallCode, @RequestParam Optional<String> district,
                                            @RequestParam(defaultValue = "0") int page,
                                            @RequestParam(defaultValue = "8") int size) {
        return regionService.getGandwondo(smallCode, district, PageRequest.of(page, size));
    }

    @GetMapping("/gwangju/company")
    public List<SmallNameResponse> getGwangju(@RequestParam String smallCode, @RequestParam Optional<String> district,
                                            @RequestParam(defaultValue = "0") int page,
                                            @RequestParam(defaultValue = "8") int size) {
        return regionService.getGwangju(smallCode, district, PageRequest.of(page, size));
    }

    @GetMapping("/gyeonggido/company")
    public List<SmallNameResponse> getGyeonggido(@RequestParam String smallCode, @RequestParam Optional<String> district,
                                            @RequestParam(defaultValue = "0") int page,
                                            @RequestParam(defaultValue = "8") int size) {
        return regionService.getGyeonggido(smallCode, district, PageRequest.of(page, size));
    }

    @GetMapping("/gyeongsangnamdo/company")
    public List<SmallNameResponse> gyeongsangnamdo(@RequestParam String smallCode, @RequestParam Optional<String> district,
                                            @RequestParam(defaultValue = "0") int page,
                                            @RequestParam(defaultValue = "8") int size) {
        return regionService.gyeongsangnamdo(smallCode, district, PageRequest.of(page, size));
    }

    @GetMapping("/gyeongsangbukdo/company")
    public List<SmallNameResponse> gyeongsangbukdo(@RequestParam String smallCode, @RequestParam Optional<String> district,
                                            @RequestParam(defaultValue = "0") int page,
                                            @RequestParam(defaultValue = "8") int size) {
        return regionService.gyeongsangbukdo(smallCode, district, PageRequest.of(page, size));
    }
    @GetMapping("/incheon/company")
    public List<SmallNameResponse> incheon(@RequestParam String smallCode, @RequestParam Optional<String> district,
                                            @RequestParam(defaultValue = "0") int page,
                                            @RequestParam(defaultValue = "8") int size) {
        return regionService.incheon(smallCode, district, PageRequest.of(page, size));
    }
    @GetMapping("/jejudo/company")
    public List<SmallNameResponse> jejudo(@RequestParam String smallCode, @RequestParam Optional<String> district,
                                            @RequestParam(defaultValue = "0") int page,
                                            @RequestParam(defaultValue = "8") int size) {
        return regionService.jejudo(smallCode, district, PageRequest.of(page, size));
    }
    @GetMapping("/jeollabukdo/company")
    public List<SmallNameResponse> jeollabukdo(@RequestParam String smallCode, @RequestParam Optional<String> district,
                                            @RequestParam(defaultValue = "0") int page,
                                            @RequestParam(defaultValue = "8") int size) {
        return regionService.jeollabukdo(smallCode, district, PageRequest.of(page, size));
    }
    @GetMapping("/jeollanamdo/company")
    public List<SmallNameResponse> jeollanamdo(@RequestParam String smallCode, @RequestParam Optional<String> district,
                                            @RequestParam(defaultValue = "0") int page,
                                            @RequestParam(defaultValue = "8") int size) {
        return regionService.jeollanamdo(smallCode, district, PageRequest.of(page, size));
    }

    @GetMapping("/sejong/company")
    public List<SmallNameResponse> sejong(@RequestParam String smallCode, @RequestParam Optional<String> district,
                                            @RequestParam(defaultValue = "0") int page,
                                            @RequestParam(defaultValue = "8") int size) {
        return regionService.sejong(smallCode, district, PageRequest.of(page, size));
    }

    @GetMapping("/ulsan/company")
    public List<SmallNameResponse> ulsan(@RequestParam String smallCode, @RequestParam Optional<String> district,
                                            @RequestParam(defaultValue = "0") int page,
                                            @RequestParam(defaultValue = "8") int size) {
        return regionService.ulsan(smallCode, district, PageRequest.of(page, size));
    }
}
