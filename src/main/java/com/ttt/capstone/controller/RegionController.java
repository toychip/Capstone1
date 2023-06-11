package com.ttt.capstone.controller;

import com.ttt.capstone.config.googleapi.RegionGoogleResponse;
import com.ttt.capstone.service.RegionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/region")
@RequiredArgsConstructor
public class RegionController {

    private final RegionService regionService;

    @GetMapping("/seoul/company")
    public PageDto<RegionGoogleResponse> getSeoul(@RequestParam String smallCode,
                                   @RequestParam Optional<String> district,
                                   @RequestParam(defaultValue = "0") int page,
                                   @RequestParam(defaultValue = "6") int size) {
        return regionService.getSeoul(smallCode, district, PageRequest.of(page, size));
    }

    @GetMapping("/busan/company")
    public PageDto<RegionGoogleResponse> getBusan(@RequestParam String smallCode,
                                   @RequestParam Optional<String> district,
                                   @RequestParam(defaultValue = "0") int page,
                                   @RequestParam(defaultValue = "6") int size) {
        return regionService.getBusan(smallCode, district, PageRequest.of(page, size));
    }

    @GetMapping("/chungcheongbukdo/company")
    public PageDto<RegionGoogleResponse> getChungcheongbukdo(@RequestParam String smallCode,
                                                      @RequestParam Optional<String> district,
                                                      @RequestParam(defaultValue = "0") int page,
                                                      @RequestParam(defaultValue = "6") int size) {
        return regionService.getChungcheongbukdo(smallCode, district, PageRequest.of(page, size));
    }

    @GetMapping("/chungcheongnamdo/company")
    public PageDto<RegionGoogleResponse> getChungcheongnamdo(@RequestParam String smallCode,
                                                      @RequestParam Optional<String> district,
                                                      @RequestParam(defaultValue = "0") int page,
                                                      @RequestParam(defaultValue = "6") int size) {
        return regionService.getChungcheongnamdo(smallCode, district, PageRequest.of(page, size));
    }

    @GetMapping("/daegu/company")
    public PageDto<RegionGoogleResponse> getDaegu(@RequestParam String smallCode,
                                   @RequestParam Optional<String> district,
                                   @RequestParam(defaultValue = "0") int page,
                                   @RequestParam(defaultValue = "6") int size) {
        return regionService.getDaegu(smallCode, district, PageRequest.of(page, size));
    }

    @GetMapping("/daejeon/company")
    public PageDto<RegionGoogleResponse> getDaejeon(@RequestParam String smallCode,
                                              @RequestParam Optional<String> district,
                                            @RequestParam(defaultValue = "0") int page,
                                            @RequestParam(defaultValue = "6") int size) {
        return regionService.getDaejeon(smallCode, district, PageRequest.of(page, size));
    }

    @GetMapping("/gandwondo/company")
    public PageDto<RegionGoogleResponse> getGandwondo(@RequestParam String smallCode, @RequestParam Optional<String> district,
                                            @RequestParam(defaultValue = "0") int page,
                                            @RequestParam(defaultValue = "6") int size) {
        return regionService.getGandwondo(smallCode, district, PageRequest.of(page, size));
    }

    @GetMapping("/gwangju/company")
    public PageDto<RegionGoogleResponse> getGwangju(@RequestParam String smallCode, @RequestParam Optional<String> district,
                                            @RequestParam(defaultValue = "0") int page,
                                            @RequestParam(defaultValue = "6") int size) {
        return regionService.getGwangju(smallCode, district, PageRequest.of(page, size));
    }

    @GetMapping("/gyeonggido/company")
    public PageDto<RegionGoogleResponse> getGyeonggido(@RequestParam String smallCode, @RequestParam Optional<String> district,
                                            @RequestParam(defaultValue = "0") int page,
                                            @RequestParam(defaultValue = "6") int size) {
        return regionService.getGyeonggido(smallCode, district, PageRequest.of(page, size));
    }

    @GetMapping("/gyeongsangnamdo/company")
    public PageDto<RegionGoogleResponse> getGyeongsangnamdo(@RequestParam String smallCode, @RequestParam Optional<String> district,
                                            @RequestParam(defaultValue = "0") int page,
                                            @RequestParam(defaultValue = "6") int size) {
        return regionService.getGyeongsangnamdo(smallCode, district, PageRequest.of(page, size));
    }

    @GetMapping("/gyeongsangbukdo/company")
    public PageDto<RegionGoogleResponse> getGyeongsangbukdo(@RequestParam String smallCode, @RequestParam Optional<String> district,
                                            @RequestParam(defaultValue = "0") int page,
                                            @RequestParam(defaultValue = "6") int size) {
        return regionService.getGyeongsangbukdo(smallCode, district, PageRequest.of(page, size));
    }
    @GetMapping("/incheon/company")
    public PageDto<RegionGoogleResponse> getIncheon(@RequestParam String smallCode, @RequestParam Optional<String> district,
                                            @RequestParam(defaultValue = "0") int page,
                                            @RequestParam(defaultValue = "6") int size) {
        return regionService.getIncheon(smallCode, district, PageRequest.of(page, size));
    }
    @GetMapping("/jejudo/company")
    public PageDto<RegionGoogleResponse> getJejudo(@RequestParam String smallCode, @RequestParam Optional<String> district,
                                            @RequestParam(defaultValue = "0") int page,
                                            @RequestParam(defaultValue = "6") int size) {
        return regionService.getJejudo(smallCode, district, PageRequest.of(page, size));
    }
    @GetMapping("/jeollabukdo/company")
    public PageDto<RegionGoogleResponse> getJeollabukdo(@RequestParam String smallCode, @RequestParam Optional<String> district,
                                            @RequestParam(defaultValue = "0") int page,
                                            @RequestParam(defaultValue = "6") int size) {
        return regionService.getJeollabukdo(smallCode, district, PageRequest.of(page, size));
    }
    @GetMapping("/jeollanamdo/company")
    public PageDto<RegionGoogleResponse> getJeollanamdo(@RequestParam String smallCode, @RequestParam Optional<String> district,
                                            @RequestParam(defaultValue = "0") int page,
                                            @RequestParam(defaultValue = "6") int size) {
        return regionService.getJeollanamdo(smallCode, district, PageRequest.of(page, size));
    }

    @GetMapping("/sejong/company")
    public PageDto<RegionGoogleResponse> getSejong(@RequestParam String smallCode, @RequestParam Optional<String> district,
                                                   @RequestParam(defaultValue = "0") int page,
                                                   @RequestParam(defaultValue = "6") int size) {
        return regionService.getSejong(smallCode, district, PageRequest.of(page, size));
    }

    @GetMapping("/ulsan/company")
    public PageDto<RegionGoogleResponse> getUlsan(@RequestParam String smallCode, @RequestParam Optional<String> district,
                                            @RequestParam(defaultValue = "0") int page,
                                            @RequestParam(defaultValue = "6") int size) {
        return regionService.getUlsan(smallCode, district, PageRequest.of(page, size));
    }

}
