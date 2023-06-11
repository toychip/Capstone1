package com.ttt.capstone.controller;

import com.ttt.capstone.config.googleapi.RegionGoogleResponse;
import com.ttt.capstone.naverblog.RegionResponse;
import com.ttt.capstone.regionentity.*;
import com.ttt.capstone.service.RegionService;
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
    public PageDto<Seoul> getSeoul(@RequestParam String smallCode,
                                   @RequestParam Optional<String> district,
                                   @RequestParam(defaultValue = "0") int page,
                                   @RequestParam(defaultValue = "9") int size) {
        return regionService.getSeoul(smallCode, district, PageRequest.of(page, size));
    }

    @GetMapping("/busan/company")
    public PageDto<Busan> getBusan(@RequestParam String smallCode,
                                   @RequestParam Optional<String> district,
                                   @RequestParam(defaultValue = "0") int page,
                                   @RequestParam(defaultValue = "9") int size) {
        return regionService.getBusan(smallCode, district, PageRequest.of(page, size));
    }

    @GetMapping("/chungcheongbukdo/company")
    public PageDto<Chungcheongbukdo> getChungcheongbukdo(@RequestParam String smallCode,
                                                      @RequestParam Optional<String> district,
                                                      @RequestParam(defaultValue = "0") int page,
                                                      @RequestParam(defaultValue = "9") int size) {
        return regionService.getChungcheongbukdo(smallCode, district, PageRequest.of(page, size));
    }

    @GetMapping("/chungcheongnamdo/company")
    public PageDto<Chungcheongnamdo> getChungcheongnamdo(@RequestParam String smallCode,
                                                      @RequestParam Optional<String> district,
                                                      @RequestParam(defaultValue = "0") int page,
                                                      @RequestParam(defaultValue = "9") int size) {
        return regionService.getChungcheongnamdo(smallCode, district, PageRequest.of(page, size));
    }

    @GetMapping("/daegu/company")
    public PageDto<Daegu> getDaegu(@RequestParam String smallCode,
                                   @RequestParam Optional<String> district,
                                   @RequestParam(defaultValue = "0") int page,
                                   @RequestParam(defaultValue = "9") int size) {
        return regionService.getDaegu(smallCode, district, PageRequest.of(page, size));
    }

    @GetMapping("/daejeon/company")
    public PageDto<Daejeon> getDaejeon(@RequestParam String smallCode,
                                              @RequestParam Optional<String> district,
                                            @RequestParam(defaultValue = "0") int page,
                                            @RequestParam(defaultValue = "9") int size) {
        return regionService.getDaejeon(smallCode, district, PageRequest.of(page, size));
    }

    @GetMapping("/gandwondo/company")
    public PageDto<Gandwondo> getGandwondo(@RequestParam String smallCode, @RequestParam Optional<String> district,
                                            @RequestParam(defaultValue = "0") int page,
                                            @RequestParam(defaultValue = "9") int size) {
        return regionService.getGandwondo(smallCode, district, PageRequest.of(page, size));
    }

    @GetMapping("/gwangju/company")
    public PageDto<Gwangju> getGwangju(@RequestParam String smallCode, @RequestParam Optional<String> district,
                                            @RequestParam(defaultValue = "0") int page,
                                            @RequestParam(defaultValue = "9") int size) {
        return regionService.getGwangju(smallCode, district, PageRequest.of(page, size));
    }

    @GetMapping("/gyeonggido/company")
    public PageDto<Gyeonggido> getGyeonggido(@RequestParam String smallCode, @RequestParam Optional<String> district,
                                            @RequestParam(defaultValue = "0") int page,
                                            @RequestParam(defaultValue = "9") int size) {
        return regionService.getGyeonggido(smallCode, district, PageRequest.of(page, size));
    }

    @GetMapping("/gyeongsangnamdo/company")
    public PageDto<Gyeongsangnamdo> getGyeongsangnamdo(@RequestParam String smallCode, @RequestParam Optional<String> district,
                                            @RequestParam(defaultValue = "0") int page,
                                            @RequestParam(defaultValue = "9") int size) {
        return regionService.getGyeongsangnamdo(smallCode, district, PageRequest.of(page, size));
    }

    @GetMapping("/gyeongsangbukdo/company")
    public PageDto<Gyeongsangbukdo> getGyeongsangbukdo(@RequestParam String smallCode, @RequestParam Optional<String> district,
                                            @RequestParam(defaultValue = "0") int page,
                                            @RequestParam(defaultValue = "9") int size) {
        return regionService.getGyeongsangbukdo(smallCode, district, PageRequest.of(page, size));
    }
    @GetMapping("/incheon/company")
    public PageDto<Incheon> getIncheon(@RequestParam String smallCode, @RequestParam Optional<String> district,
                                            @RequestParam(defaultValue = "0") int page,
                                            @RequestParam(defaultValue = "9") int size) {
        return regionService.getIncheon(smallCode, district, PageRequest.of(page, size));
    }
    @GetMapping("/jejudo/company")
    public PageDto<Jejudo> getJejudo(@RequestParam String smallCode, @RequestParam Optional<String> district,
                                            @RequestParam(defaultValue = "0") int page,
                                            @RequestParam(defaultValue = "9") int size) {
        return regionService.getJejudo(smallCode, district, PageRequest.of(page, size));
    }
    @GetMapping("/jeollabukdo/company")
    public PageDto<Jeollabukdo> getJeollabukdo(@RequestParam String smallCode, @RequestParam Optional<String> district,
                                            @RequestParam(defaultValue = "0") int page,
                                            @RequestParam(defaultValue = "9") int size) {
        return regionService.getJeollabukdo(smallCode, district, PageRequest.of(page, size));
    }
    @GetMapping("/jeollanamdo/company")
    public PageDto<Jeollanamdo> getJeollanamdo(@RequestParam String smallCode, @RequestParam Optional<String> district,
                                            @RequestParam(defaultValue = "0") int page,
                                            @RequestParam(defaultValue = "9") int size) {
        return regionService.getJeollanamdo(smallCode, district, PageRequest.of(page, size));
    }

    @GetMapping("/sejong/company")
    public PageDto<RegionGoogleResponse> getSejong(@RequestParam String smallCode, @RequestParam Optional<String> district,
                                                   @RequestParam(defaultValue = "0") int page,
                                                   @RequestParam(defaultValue = "9") int size) {
        return regionService.getSejongWithAdditionalInfo(smallCode, district, PageRequest.of(page, size));
    }

//    @GetMapping("/ulsan/company")
//    public PageDto<Ulsan> getUlsan(@RequestParam String smallCode, @RequestParam Optional<String> district,
//                                            @RequestParam(defaultValue = "0") int page,
//                                            @RequestParam(defaultValue = "9") int size) {
//        return regionService.getUlsan(smallCode, district, PageRequest.of(page, size));
//    }

    @GetMapping("/ulsan/company")
    public PageDto<RegionResponse<Ulsan>> getUlsan(@RequestParam String smallCode, @RequestParam Optional<String> district,
                                                   @RequestParam(defaultValue = "0") int page,
                                                   @RequestParam(defaultValue = "9") int size) {
        return regionService.getUlsan(smallCode, district, PageRequest.of(page, size));
    }
}
