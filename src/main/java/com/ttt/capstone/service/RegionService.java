package com.ttt.capstone.service;

import com.google.gson.Gson;
import com.ttt.capstone.config.googleapi.RegionGoogleResponse;
import com.ttt.capstone.controller.PageDto;
import com.ttt.capstone.regionentity.*;
import com.ttt.capstone.regionrepository.*;
import lombok.RequiredArgsConstructor;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.net.URLEncoder;
import java.util.*;

@Service
@RequiredArgsConstructor
public class RegionService {

    private final SeoulRepository seoulRepository;
    private final BusanRepository busanRepository;
    private final ChungcheongbukdoRepository chungcheongbukdoRepository;
    private final ChungcheongnamdoRepository chungcheongnamdoRepository;
    private final DaeguRepository daeguRepository;
    private final DaejeonRepository daejeonRepository;
    private final GandwondoRepository gandwondoRepository;
    private final GwangjuRepository gwangjuRepository;
    private final GyeonggidoRepository gyeonggidoRepository;
    private final GyeongsangbukdoRepository gyeongsangbukdoRepository;
    private final GyeongsangnamdoRepository gyeongsangnamdoRepository;
    private final IncheonRepository incheonRepository;
    private final JejudoRepository jejudoRepository;
    private final JeollabukdoRepository jeollabukdoRepository;
    private final JeollanamdoRepository jeollanamdoRepository;
    private final SejongRepository sejongRepository;
    private final UlsanRepository ulsanRepository;
    @Value("${google.maps.api.key}")
    private String apiKey;

    public PageDto<RegionGoogleResponse> getSeoul(String smallCode, Optional<String> district, Pageable pageable) {
        Page<Seoul> page;
        if (district.isPresent()) {
            page = seoulRepository.findBySmallCodeAndRoadNameContaining(smallCode, district.get(), pageable);
        } else {
            page = seoulRepository.findBySmallCode(smallCode, pageable);
        }

        List<RegionGoogleResponse> extendedDtos = new ArrayList<>();
        for (Seoul seoul : page.getContent()) {

            // Google Maps API를 호출하여 새로운 정보를 가져오기
            String input = seoul.getName() + " " + seoul.getLocalAddress();
            Map<String, Object> additionalInfo = callGoogleMapsApi(input);

            // Builder 패턴을 사용하여 RegionGoogleResponse 객체 생성
            RegionGoogleResponse dto = RegionGoogleResponse.builder()
                    .number(seoul.getNumber())
                    .name(seoul.getName())
                    .branchName(seoul.getBranchName())
                    .largeCode(seoul.getLargeCode())
                    .largeName(seoul.getLargeName())
                    .mediumCode(seoul.getMediumCode())
                    .mediumName(seoul.getMediumName())
                    .smallCode(seoul.getSmallCode())
                    .smallName(seoul.getSmallName())
                    .dongNumber(seoul.getDongNumber())
                    .dongName(seoul.getDongName())
                    .localAddress(seoul.getLocalAddress())
                    .roadName(seoul.getRoadName())
                    .roadAddress(seoul.getRoadAddress())
                    .oldPostalCode(seoul.getOldPostalCode())
                    .newPostalCode(seoul.getNewPostalCode())
                    .longitude(seoul.getLongitude())
                    .latitude(seoul.getLatitude())
                    .rating(additionalInfo != null ? (Double) additionalInfo.get("rating") : null)
                    .openingHours(additionalInfo != null ? (Map<String, Object>) additionalInfo.get("opening_hours") : null)
                    .formattedPhoneNumber(additionalInfo != null ? (String) additionalInfo.get("formatted_phone_number") : null)
                    .reviews(additionalInfo != null ? (List<Map<String, Object>>) additionalInfo.get("reviews") : null)
                    .build();
            extendedDtos.add(dto);
        }
        return new PageDto<>(new PageImpl<>(extendedDtos, pageable, page.getTotalElements()));
    }


    public PageDto<RegionGoogleResponse> getBusan(String smallCode, Optional<String> district, Pageable pageable) {
        Page<Busan> page;
        if (district.isPresent()) {
            page = busanRepository.findBySmallCodeAndRoadNameContaining(smallCode, district.get(), pageable);
        } else {
            page = busanRepository.findBySmallCode(smallCode, pageable);
        }

        List<RegionGoogleResponse> extendedDtos = new ArrayList<>();
        for (Busan busan : page.getContent()) {

            // Google Maps API를 호출하여 새로운 정보를 가져오기
            String input = busan.getName() + " " + busan.getLocalAddress();
            Map<String, Object> additionalInfo = callGoogleMapsApi(input);

            // Builder 패턴을 사용하여 RegionGoogleResponse 객체 생성
            RegionGoogleResponse dto = RegionGoogleResponse.builder()
                    .number(busan.getNumber())
                    .name(busan.getName())
                    .branchName(busan.getBranchName())
                    .largeCode(busan.getLargeCode())
                    .largeName(busan.getLargeName())
                    .mediumCode(busan.getMediumCode())
                    .mediumName(busan.getMediumName())
                    .smallCode(busan.getSmallCode())
                    .smallName(busan.getSmallName())
                    .dongNumber(busan.getDongNumber())
                    .dongName(busan.getDongName())
                    .localAddress(busan.getLocalAddress())
                    .roadName(busan.getRoadName())
                    .roadAddress(busan.getRoadAddress())
                    .oldPostalCode(busan.getOldPostalCode())
                    .newPostalCode(busan.getNewPostalCode())
                    .longitude(busan.getLongitude())
                    .latitude(busan.getLatitude())
                    .rating(additionalInfo != null ? (Double) additionalInfo.get("rating") : null)
                    .openingHours(additionalInfo != null ? (Map<String, Object>) additionalInfo.get("opening_hours") : null)
                    .formattedPhoneNumber(additionalInfo != null ? (String) additionalInfo.get("formatted_phone_number") : null)
                    .reviews(additionalInfo != null ? (List<Map<String, Object>>) additionalInfo.get("reviews") : null)
                    .build();
            extendedDtos.add(dto);
        }
        return new PageDto<>(new PageImpl<>(extendedDtos, pageable, page.getTotalElements()));
    }


    public PageDto<RegionGoogleResponse> getChungcheongbukdo(String smallCode, Optional<String> district, Pageable pageable) {
        Page<Chungcheongbukdo> page;
        if (district.isPresent()) {
            page = chungcheongbukdoRepository.findBySmallCodeAndRoadNameContaining(smallCode, district.get(), pageable);
        } else {
            page = chungcheongbukdoRepository.findBySmallCode(smallCode, pageable);
        }

        List<RegionGoogleResponse> extendedDtos = new ArrayList<>();
        for (Chungcheongbukdo chungcheongbukdo : page.getContent()) {

            // Google Maps API를 호출하여 새로운 정보를 가져오기
            String input = chungcheongbukdo.getName() + " " + chungcheongbukdo.getLocalAddress();
            Map<String, Object> additionalInfo = callGoogleMapsApi(input);

            // Builder 패턴을 사용하여 RegionGoogleResponse 객체 생성
            RegionGoogleResponse dto = RegionGoogleResponse.builder()
                    .number(chungcheongbukdo.getNumber())
                    .name(chungcheongbukdo.getName())
                    .branchName(chungcheongbukdo.getBranchName())
                    .largeCode(chungcheongbukdo.getLargeCode())
                    .largeName(chungcheongbukdo.getLargeName())
                    .mediumCode(chungcheongbukdo.getMediumCode())
                    .mediumName(chungcheongbukdo.getMediumName())
                    .smallCode(chungcheongbukdo.getSmallCode())
                    .smallName(chungcheongbukdo.getSmallName())
                    .dongNumber(chungcheongbukdo.getDongNumber())
                    .dongName(chungcheongbukdo.getDongName())
                    .localAddress(chungcheongbukdo.getLocalAddress())
                    .roadName(chungcheongbukdo.getRoadName())
                    .roadAddress(chungcheongbukdo.getRoadAddress())
                    .oldPostalCode(chungcheongbukdo.getOldPostalCode())
                    .newPostalCode(chungcheongbukdo.getNewPostalCode())
                    .longitude(chungcheongbukdo.getLongitude())
                    .latitude(chungcheongbukdo.getLatitude())
                    .rating(additionalInfo != null ? (Double) additionalInfo.get("rating") : null)
                    .openingHours(additionalInfo != null ? (Map<String, Object>) additionalInfo.get("opening_hours") : null)
                    .formattedPhoneNumber(additionalInfo != null ? (String) additionalInfo.get("formatted_phone_number") : null)
                    .reviews(additionalInfo != null ? (List<Map<String, Object>>) additionalInfo.get("reviews") : null)
                    .build();
            extendedDtos.add(dto);
        }
        return new PageDto<>(new PageImpl<>(extendedDtos, pageable, page.getTotalElements()));
    }


    public PageDto<RegionGoogleResponse> getChungcheongnamdo(String smallCode, Optional<String> district, Pageable pageable) {
        Page<Chungcheongnamdo> page;
        if (district.isPresent()) {
            page = chungcheongnamdoRepository.findBySmallCodeAndRoadNameContaining(smallCode, district.get(), pageable);
        } else {
            page = chungcheongnamdoRepository.findBySmallCode(smallCode, pageable);
        }

        List<RegionGoogleResponse> extendedDtos = new ArrayList<>();
        for (Chungcheongnamdo chungcheongnamdo : page.getContent()) {

            // Google Maps API를 호출하여 새로운 정보를 가져오기
            String input = chungcheongnamdo.getName() + " " + chungcheongnamdo.getLocalAddress();
            Map<String, Object> additionalInfo = callGoogleMapsApi(input);

            // Builder 패턴을 사용하여 RegionGoogleResponse 객체 생성
            RegionGoogleResponse dto = RegionGoogleResponse.builder()
                    .number(chungcheongnamdo.getNumber())
                    .name(chungcheongnamdo.getName())
                    .branchName(chungcheongnamdo.getBranchName())
                    .largeCode(chungcheongnamdo.getLargeCode())
                    .largeName(chungcheongnamdo.getLargeName())
                    .mediumCode(chungcheongnamdo.getMediumCode())
                    .mediumName(chungcheongnamdo.getMediumName())
                    .smallCode(chungcheongnamdo.getSmallCode())
                    .smallName(chungcheongnamdo.getSmallName())
                    .dongNumber(chungcheongnamdo.getDongNumber())
                    .dongName(chungcheongnamdo.getDongName())
                    .localAddress(chungcheongnamdo.getLocalAddress())
                    .roadName(chungcheongnamdo.getRoadName())
                    .roadAddress(chungcheongnamdo.getRoadAddress())
                    .oldPostalCode(chungcheongnamdo.getOldPostalCode())
                    .newPostalCode(chungcheongnamdo.getNewPostalCode())
                    .longitude(chungcheongnamdo.getLongitude())
                    .latitude(chungcheongnamdo.getLatitude())
                    .rating(additionalInfo != null ? (Double) additionalInfo.get("rating") : null)
                    .openingHours(additionalInfo != null ? (Map<String, Object>) additionalInfo.get("opening_hours") : null)
                    .formattedPhoneNumber(additionalInfo != null ? (String) additionalInfo.get("formatted_phone_number") : null)
                    .reviews(additionalInfo != null ? (List<Map<String, Object>>) additionalInfo.get("reviews") : null)
                    .build();
            extendedDtos.add(dto);
        }
        return new PageDto<>(new PageImpl<>(extendedDtos, pageable, page.getTotalElements()));
    }


    public PageDto<RegionGoogleResponse> getDaegu(String smallCode, Optional<String> district, Pageable pageable) {
        Page<Daegu> page;
        if (district.isPresent()) {
            page = daeguRepository.findBySmallCodeAndRoadNameContaining(smallCode, district.get(), pageable);
        } else {
            page = daeguRepository.findBySmallCode(smallCode, pageable);
        }

        List<RegionGoogleResponse> extendedDtos = new ArrayList<>();
        for (Daegu daegu : page.getContent()) {

            // Google Maps API를 호출하여 새로운 정보를 가져오기
            String input = daegu.getName() + " " + daegu.getLocalAddress();
            Map<String, Object> additionalInfo = callGoogleMapsApi(input);

            // Builder 패턴을 사용하여 RegionGoogleResponse 객체 생성
            RegionGoogleResponse dto = RegionGoogleResponse.builder()
                    .number(daegu.getNumber())
                    .name(daegu.getName())
                    .branchName(daegu.getBranchName())
                    .largeCode(daegu.getLargeCode())
                    .largeName(daegu.getLargeName())
                    .mediumCode(daegu.getMediumCode())
                    .mediumName(daegu.getMediumName())
                    .smallCode(daegu.getSmallCode())
                    .smallName(daegu.getSmallName())
                    .dongNumber(daegu.getDongNumber())
                    .dongName(daegu.getDongName())
                    .localAddress(daegu.getLocalAddress())
                    .roadName(daegu.getRoadName())
                    .roadAddress(daegu.getRoadAddress())
                    .oldPostalCode(daegu.getOldPostalCode())
                    .newPostalCode(daegu.getNewPostalCode())
                    .longitude(daegu.getLongitude())
                    .latitude(daegu.getLatitude())
                    .rating(additionalInfo != null ? (Double) additionalInfo.get("rating") : null)
                    .openingHours(additionalInfo != null ? (Map<String, Object>) additionalInfo.get("opening_hours") : null)
                    .formattedPhoneNumber(additionalInfo != null ? (String) additionalInfo.get("formatted_phone_number") : null)
                    .reviews(additionalInfo != null ? (List<Map<String, Object>>) additionalInfo.get("reviews") : null)
                    .build();
            extendedDtos.add(dto);
        }
        return new PageDto<>(new PageImpl<>(extendedDtos, pageable, page.getTotalElements()));
    }


    public PageDto<RegionGoogleResponse> getDaejeon(String smallCode, Optional<String> district, Pageable pageable) {
        Page<Daejeon> page;
        if (district.isPresent()) {
            page = daejeonRepository.findBySmallCodeAndRoadNameContaining(smallCode, district.get(), pageable);
        } else {
            page = daejeonRepository.findBySmallCode(smallCode, pageable);
        }

        List<RegionGoogleResponse> extendedDtos = new ArrayList<>();
        for (Daejeon daejeon : page.getContent()) {

            // Google Maps API를 호출하여 새로운 정보를 가져오기
            String input = daejeon.getName() + " " + daejeon.getLocalAddress();
            Map<String, Object> additionalInfo = callGoogleMapsApi(input);

            // Builder 패턴을 사용하여 RegionGoogleResponse 객체 생성
            RegionGoogleResponse dto = RegionGoogleResponse.builder()
                    .number(daejeon.getNumber())
                    .name(daejeon.getName())
                    .branchName(daejeon.getBranchName())
                    .largeCode(daejeon.getLargeCode())
                    .largeName(daejeon.getLargeName())
                    .mediumCode(daejeon.getMediumCode())
                    .mediumName(daejeon.getMediumName())
                    .smallCode(daejeon.getSmallCode())
                    .smallName(daejeon.getSmallName())
                    .dongNumber(daejeon.getDongNumber())
                    .dongName(daejeon.getDongName())
                    .localAddress(daejeon.getLocalAddress())
                    .roadName(daejeon.getRoadName())
                    .roadAddress(daejeon.getRoadAddress())
                    .oldPostalCode(daejeon.getOldPostalCode())
                    .newPostalCode(daejeon.getNewPostalCode())
                    .longitude(daejeon.getLongitude())
                    .latitude(daejeon.getLatitude())
                    .rating(additionalInfo != null ? (Double) additionalInfo.get("rating") : null)
                    .openingHours(additionalInfo != null ? (Map<String, Object>) additionalInfo.get("opening_hours") : null)
                    .formattedPhoneNumber(additionalInfo != null ? (String) additionalInfo.get("formatted_phone_number") : null)
                    .reviews(additionalInfo != null ? (List<Map<String, Object>>) additionalInfo.get("reviews") : null)
                    .build();
            extendedDtos.add(dto);
        }
        return new PageDto<>(new PageImpl<>(extendedDtos, pageable, page.getTotalElements()));
    }


    public PageDto<RegionGoogleResponse> getGandwondo(String smallCode, Optional<String> district, Pageable pageable) {
        Page<Gandwondo> page;
        if (district.isPresent()) {
            page = gandwondoRepository.findBySmallCodeAndRoadNameContaining(smallCode, district.get(), pageable);
        } else {
            page = gandwondoRepository.findBySmallCode(smallCode, pageable);
        }

        List<RegionGoogleResponse> extendedDtos = new ArrayList<>();
        for (Gandwondo gandwondo : page.getContent()) {

            // Google Maps API를 호출하여 새로운 정보를 가져오기
            String input = gandwondo.getName() + " " + gandwondo.getLocalAddress();
            Map<String, Object> additionalInfo = callGoogleMapsApi(input);

            // Builder 패턴을 사용하여 RegionGoogleResponse 객체 생성
            RegionGoogleResponse dto = RegionGoogleResponse.builder()
                    .number(gandwondo.getNumber())
                    .name(gandwondo.getName())
                    .branchName(gandwondo.getBranchName())
                    .largeCode(gandwondo.getLargeCode())
                    .largeName(gandwondo.getLargeName())
                    .mediumCode(gandwondo.getMediumCode())
                    .mediumName(gandwondo.getMediumName())
                    .smallCode(gandwondo.getSmallCode())
                    .smallName(gandwondo.getSmallName())
                    .dongNumber(gandwondo.getDongNumber())
                    .dongName(gandwondo.getDongName())
                    .localAddress(gandwondo.getLocalAddress())
                    .roadName(gandwondo.getRoadName())
                    .roadAddress(gandwondo.getRoadAddress())
                    .oldPostalCode(gandwondo.getOldPostalCode())
                    .newPostalCode(gandwondo.getNewPostalCode())
                    .longitude(gandwondo.getLongitude())
                    .latitude(gandwondo.getLatitude())
                    .rating(additionalInfo != null ? (Double) additionalInfo.get("rating") : null)
                    .openingHours(additionalInfo != null ? (Map<String, Object>) additionalInfo.get("opening_hours") : null)
                    .formattedPhoneNumber(additionalInfo != null ? (String) additionalInfo.get("formatted_phone_number") : null)
                    .reviews(additionalInfo != null ? (List<Map<String, Object>>) additionalInfo.get("reviews") : null)
                    .build();
            extendedDtos.add(dto);
        }
        return new PageDto<>(new PageImpl<>(extendedDtos, pageable, page.getTotalElements()));
    }


    public PageDto<RegionGoogleResponse> getGwangju(String smallCode, Optional<String> district, Pageable pageable) {
        Page<Gwangju> page;
        if (district.isPresent()) {
            page = gwangjuRepository.findBySmallCodeAndRoadNameContaining(smallCode, district.get(), pageable);
        } else {
            page = gwangjuRepository.findBySmallCode(smallCode, pageable);
        }

        List<RegionGoogleResponse> extendedDtos = new ArrayList<>();
        for (Gwangju gwangju : page.getContent()) {

            // Google Maps API를 호출하여 새로운 정보를 가져오기
            String input = gwangju.getName() + " " + gwangju.getLocalAddress();
            Map<String, Object> additionalInfo = callGoogleMapsApi(input);

            // Builder 패턴을 사용하여 RegionGoogleResponse 객체 생성
            RegionGoogleResponse dto = RegionGoogleResponse.builder()
                    .number(gwangju.getNumber())
                    .name(gwangju.getName())
                    .branchName(gwangju.getBranchName())
                    .largeCode(gwangju.getLargeCode())
                    .largeName(gwangju.getLargeName())
                    .mediumCode(gwangju.getMediumCode())
                    .mediumName(gwangju.getMediumName())
                    .smallCode(gwangju.getSmallCode())
                    .smallName(gwangju.getSmallName())
                    .dongNumber(gwangju.getDongNumber())
                    .dongName(gwangju.getDongName())
                    .localAddress(gwangju.getLocalAddress())
                    .roadName(gwangju.getRoadName())
                    .roadAddress(gwangju.getRoadAddress())
                    .oldPostalCode(gwangju.getOldPostalCode())
                    .newPostalCode(gwangju.getNewPostalCode())
                    .longitude(gwangju.getLongitude())
                    .latitude(gwangju.getLatitude())
                    .rating(additionalInfo != null ? (Double) additionalInfo.get("rating") : null)
                    .openingHours(additionalInfo != null ? (Map<String, Object>) additionalInfo.get("opening_hours") : null)
                    .formattedPhoneNumber(additionalInfo != null ? (String) additionalInfo.get("formatted_phone_number") : null)
                    .reviews(additionalInfo != null ? (List<Map<String, Object>>) additionalInfo.get("reviews") : null)
                    .build();
            extendedDtos.add(dto);
        }
        return new PageDto<>(new PageImpl<>(extendedDtos, pageable, page.getTotalElements()));
    }

    public PageDto<RegionGoogleResponse> getGyeonggido(String smallCode, Optional<String> district, Pageable pageable) {
        Page<Gyeonggido> page;
        if (district.isPresent()) {
            page = gyeonggidoRepository.findBySmallCodeAndRoadNameContaining(smallCode, district.get(), pageable);
        } else {
            page = gyeonggidoRepository.findBySmallCode(smallCode, pageable);
        }

        List<RegionGoogleResponse> extendedDtos = new ArrayList<>();
        for (Gyeonggido gyeonggido : page.getContent()) {

            // Google Maps API를 호출하여 새로운 정보를 가져오기
            String input = gyeonggido.getName() + " " + gyeonggido.getLocalAddress();
            Map<String, Object> additionalInfo = callGoogleMapsApi(input);

            // Builder 패턴을 사용하여 RegionGoogleResponse 객체 생성
            RegionGoogleResponse dto = RegionGoogleResponse.builder()
                    .number(gyeonggido.getNumber())
                    .name(gyeonggido.getName())
                    .branchName(gyeonggido.getBranchName())
                    .largeCode(gyeonggido.getLargeCode())
                    .largeName(gyeonggido.getLargeName())
                    .mediumCode(gyeonggido.getMediumCode())
                    .mediumName(gyeonggido.getMediumName())
                    .smallCode(gyeonggido.getSmallCode())
                    .smallName(gyeonggido.getSmallName())
                    .dongNumber(gyeonggido.getDongNumber())
                    .dongName(gyeonggido.getDongName())
                    .localAddress(gyeonggido.getLocalAddress())
                    .roadName(gyeonggido.getRoadName())
                    .roadAddress(gyeonggido.getRoadAddress())
                    .oldPostalCode(gyeonggido.getOldPostalCode())
                    .newPostalCode(gyeonggido.getNewPostalCode())
                    .longitude(gyeonggido.getLongitude())
                    .latitude(gyeonggido.getLatitude())
                    .rating(additionalInfo != null ? (Double) additionalInfo.get("rating") : null)
                    .openingHours(additionalInfo != null ? (Map<String, Object>) additionalInfo.get("opening_hours") : null)
                    .formattedPhoneNumber(additionalInfo != null ? (String) additionalInfo.get("formatted_phone_number") : null)
                    .reviews(additionalInfo != null ? (List<Map<String, Object>>) additionalInfo.get("reviews") : null)
                    .build();
            extendedDtos.add(dto);
        }
        return new PageDto<>(new PageImpl<>(extendedDtos, pageable, page.getTotalElements()));
    }


    public PageDto<RegionGoogleResponse> getGyeongsangnamdo(String smallCode, Optional<String> district, Pageable pageable) {
        Page<Gyeongsangnamdo> page;
        if (district.isPresent()) {
            page = gyeongsangnamdoRepository.findBySmallCodeAndRoadNameContaining(smallCode, district.get(), pageable);
        } else {
            page = gyeongsangnamdoRepository.findBySmallCode(smallCode, pageable);
        }

        List<RegionGoogleResponse> extendedDtos = new ArrayList<>();
        for (Gyeongsangnamdo gyeongsangnamdo : page.getContent()) {

            // Google Maps API를 호출하여 새로운 정보를 가져오기
            String input = gyeongsangnamdo.getName() + " " + gyeongsangnamdo.getLocalAddress();
            Map<String, Object> additionalInfo = callGoogleMapsApi(input);

            // Builder 패턴을 사용하여 RegionGoogleResponse 객체 생성
            RegionGoogleResponse dto = RegionGoogleResponse.builder()
                    .number(gyeongsangnamdo.getNumber())
                    .name(gyeongsangnamdo.getName())
                    .branchName(gyeongsangnamdo.getBranchName())
                    .largeCode(gyeongsangnamdo.getLargeCode())
                    .largeName(gyeongsangnamdo.getLargeName())
                    .mediumCode(gyeongsangnamdo.getMediumCode())
                    .mediumName(gyeongsangnamdo.getMediumName())
                    .smallCode(gyeongsangnamdo.getSmallCode())
                    .smallName(gyeongsangnamdo.getSmallName())
                    .dongNumber(gyeongsangnamdo.getDongNumber())
                    .dongName(gyeongsangnamdo.getDongName())
                    .localAddress(gyeongsangnamdo.getLocalAddress())
                    .roadName(gyeongsangnamdo.getRoadName())
                    .roadAddress(gyeongsangnamdo.getRoadAddress())
                    .oldPostalCode(gyeongsangnamdo.getOldPostalCode())
                    .newPostalCode(gyeongsangnamdo.getNewPostalCode())
                    .longitude(gyeongsangnamdo.getLongitude())
                    .latitude(gyeongsangnamdo.getLatitude())
                    .rating(additionalInfo != null ? (Double) additionalInfo.get("rating") : null)
                    .openingHours(additionalInfo != null ? (Map<String, Object>) additionalInfo.get("opening_hours") : null)
                    .formattedPhoneNumber(additionalInfo != null ? (String) additionalInfo.get("formatted_phone_number") : null)
                    .reviews(additionalInfo != null ? (List<Map<String, Object>>) additionalInfo.get("reviews") : null)
                    .build();
            extendedDtos.add(dto);
        }
        return new PageDto<>(new PageImpl<>(extendedDtos, pageable, page.getTotalElements()));
    }


    public PageDto<RegionGoogleResponse> getGyeongsangbukdo(String smallCode, Optional<String> district, Pageable pageable) {
        Page<Gyeongsangbukdo> page;
        if (district.isPresent()) {
            page = gyeongsangbukdoRepository.findBySmallCodeAndRoadNameContaining(smallCode, district.get(), pageable);
        } else {
            page = gyeongsangbukdoRepository.findBySmallCode(smallCode, pageable);
        }

        List<RegionGoogleResponse> extendedDtos = new ArrayList<>();
        for (Gyeongsangbukdo gyeongsangbukdo : page.getContent()) {

            // Google Maps API를 호출하여 새로운 정보를 가져오기
            String input = gyeongsangbukdo.getName() + " " + gyeongsangbukdo.getLocalAddress();
            Map<String, Object> additionalInfo = callGoogleMapsApi(input);

            // Builder 패턴을 사용하여 RegionGoogleResponse 객체 생성
            RegionGoogleResponse dto = RegionGoogleResponse.builder()
                    .number(gyeongsangbukdo.getNumber())
                    .name(gyeongsangbukdo.getName())
                    .branchName(gyeongsangbukdo.getBranchName())
                    .largeCode(gyeongsangbukdo.getLargeCode())
                    .largeName(gyeongsangbukdo.getLargeName())
                    .mediumCode(gyeongsangbukdo.getMediumCode())
                    .mediumName(gyeongsangbukdo.getMediumName())
                    .smallCode(gyeongsangbukdo.getSmallCode())
                    .smallName(gyeongsangbukdo.getSmallName())
                    .dongNumber(gyeongsangbukdo.getDongNumber())
                    .dongName(gyeongsangbukdo.getDongName())
                    .localAddress(gyeongsangbukdo.getLocalAddress())
                    .roadName(gyeongsangbukdo.getRoadName())
                    .roadAddress(gyeongsangbukdo.getRoadAddress())
                    .oldPostalCode(gyeongsangbukdo.getOldPostalCode())
                    .newPostalCode(gyeongsangbukdo.getNewPostalCode())
                    .longitude(gyeongsangbukdo.getLongitude())
                    .latitude(gyeongsangbukdo.getLatitude())
                    .rating(additionalInfo != null ? (Double) additionalInfo.get("rating") : null)
                    .openingHours(additionalInfo != null ? (Map<String, Object>) additionalInfo.get("opening_hours") : null)
                    .formattedPhoneNumber(additionalInfo != null ? (String) additionalInfo.get("formatted_phone_number") : null)
                    .reviews(additionalInfo != null ? (List<Map<String, Object>>) additionalInfo.get("reviews") : null)
                    .build();
            extendedDtos.add(dto);
        }
        return new PageDto<>(new PageImpl<>(extendedDtos, pageable, page.getTotalElements()));
    }

    public PageDto<RegionGoogleResponse> getIncheon(String smallCode, Optional<String> district, Pageable pageable) {
        Page<Incheon> page;
        if (district.isPresent()) {
            page = incheonRepository.findBySmallCodeAndRoadNameContaining(smallCode, district.get(), pageable);
        } else {
            page = incheonRepository.findBySmallCode(smallCode, pageable);
        }

        List<RegionGoogleResponse> extendedDtos = new ArrayList<>();
        for (Incheon incheon : page.getContent()) {

            // Google Maps API를 호출하여 새로운 정보를 가져오기
            String input = incheon.getName() + " " + incheon.getLocalAddress();
            Map<String, Object> additionalInfo = callGoogleMapsApi(input);

            // Builder 패턴을 사용하여 RegionGoogleResponse 객체 생성
            RegionGoogleResponse dto = RegionGoogleResponse.builder()
                    .number(incheon.getNumber())
                    .name(incheon.getName())
                    .branchName(incheon.getBranchName())
                    .largeCode(incheon.getLargeCode())
                    .largeName(incheon.getLargeName())
                    .mediumCode(incheon.getMediumCode())
                    .mediumName(incheon.getMediumName())
                    .smallCode(incheon.getSmallCode())
                    .smallName(incheon.getSmallName())
                    .dongNumber(incheon.getDongNumber())
                    .dongName(incheon.getDongName())
                    .localAddress(incheon.getLocalAddress())
                    .roadName(incheon.getRoadName())
                    .roadAddress(incheon.getRoadAddress())
                    .oldPostalCode(incheon.getOldPostalCode())
                    .newPostalCode(incheon.getNewPostalCode())
                    .longitude(incheon.getLongitude())
                    .latitude(incheon.getLatitude())
                    .rating(additionalInfo != null ? (Double) additionalInfo.get("rating") : null)
                    .openingHours(additionalInfo != null ? (Map<String, Object>) additionalInfo.get("opening_hours") : null)
                    .formattedPhoneNumber(additionalInfo != null ? (String) additionalInfo.get("formatted_phone_number") : null)
                    .reviews(additionalInfo != null ? (List<Map<String, Object>>) additionalInfo.get("reviews") : null)
                    .build();
            extendedDtos.add(dto);
        }
        return new PageDto<>(new PageImpl<>(extendedDtos, pageable, page.getTotalElements()));
    }

    public PageDto<RegionGoogleResponse> getJejudo(String smallCode, Optional<String> district, Pageable pageable) {
        Page<Jejudo> page;
        if (district.isPresent()) {
            page = jejudoRepository.findBySmallCodeAndRoadNameContaining(smallCode, district.get(), pageable);
        } else {
            page = jejudoRepository.findBySmallCode(smallCode, pageable);
        }

        List<RegionGoogleResponse> extendedDtos = new ArrayList<>();
        for (Jejudo jejudo : page.getContent()) {

            // Google Maps API를 호출하여 새로운 정보를 가져오기
            String input = jejudo.getName() + " " + jejudo.getLocalAddress();
            Map<String, Object> additionalInfo = callGoogleMapsApi(input);

            // Builder 패턴을 사용하여 RegionGoogleResponse 객체 생성
            RegionGoogleResponse dto = RegionGoogleResponse.builder()
                    .number(jejudo.getNumber())
                    .name(jejudo.getName())
                    .branchName(jejudo.getBranchName())
                    .largeCode(jejudo.getLargeCode())
                    .largeName(jejudo.getLargeName())
                    .mediumCode(jejudo.getMediumCode())
                    .mediumName(jejudo.getMediumName())
                    .smallCode(jejudo.getSmallCode())
                    .smallName(jejudo.getSmallName())
                    .dongNumber(jejudo.getDongNumber())
                    .dongName(jejudo.getDongName())
                    .localAddress(jejudo.getLocalAddress())
                    .roadName(jejudo.getRoadName())
                    .roadAddress(jejudo.getRoadAddress())
                    .oldPostalCode(jejudo.getOldPostalCode())
                    .newPostalCode(jejudo.getNewPostalCode())
                    .longitude(jejudo.getLongitude())
                    .latitude(jejudo.getLatitude())
                    .rating(additionalInfo != null ? (Double) additionalInfo.get("rating") : null)
                    .openingHours(additionalInfo != null ? (Map<String, Object>) additionalInfo.get("opening_hours") : null)
                    .formattedPhoneNumber(additionalInfo != null ? (String) additionalInfo.get("formatted_phone_number") : null)
                    .reviews(additionalInfo != null ? (List<Map<String, Object>>) additionalInfo.get("reviews") : null)
                    .build();
            extendedDtos.add(dto);
        }
        return new PageDto<>(new PageImpl<>(extendedDtos, pageable, page.getTotalElements()));
    }

    public PageDto<RegionGoogleResponse> getJeollabukdo(String smallCode, Optional<String> district, Pageable pageable) {
        Page<Jeollabukdo> page;
        if (district.isPresent()) {
            page = jeollabukdoRepository.findBySmallCodeAndRoadNameContaining(smallCode, district.get(), pageable);
        } else {
            page = jeollabukdoRepository.findBySmallCode(smallCode, pageable);
        }

        List<RegionGoogleResponse> extendedDtos = new ArrayList<>();
        for (Jeollabukdo jeollabukdo : page.getContent()) {

            // Google Maps API를 호출하여 새로운 정보를 가져오기
            String input = jeollabukdo.getName() + " " + jeollabukdo.getLocalAddress();
            Map<String, Object> additionalInfo = callGoogleMapsApi(input);

            // Builder 패턴을 사용하여 RegionGoogleResponse 객체 생성
            RegionGoogleResponse dto = RegionGoogleResponse.builder()
                    .number(jeollabukdo.getNumber())
                    .name(jeollabukdo.getName())
                    .branchName(jeollabukdo.getBranchName())
                    .largeCode(jeollabukdo.getLargeCode())
                    .largeName(jeollabukdo.getLargeName())
                    .mediumCode(jeollabukdo.getMediumCode())
                    .mediumName(jeollabukdo.getMediumName())
                    .smallCode(jeollabukdo.getSmallCode())
                    .smallName(jeollabukdo.getSmallName())
                    .dongNumber(jeollabukdo.getDongNumber())
                    .dongName(jeollabukdo.getDongName())
                    .localAddress(jeollabukdo.getLocalAddress())
                    .roadName(jeollabukdo.getRoadName())
                    .roadAddress(jeollabukdo.getRoadAddress())
                    .oldPostalCode(jeollabukdo.getOldPostalCode())
                    .newPostalCode(jeollabukdo.getNewPostalCode())
                    .longitude(jeollabukdo.getLongitude())
                    .latitude(jeollabukdo.getLatitude())
                    .rating(additionalInfo != null ? (Double) additionalInfo.get("rating") : null)
                    .openingHours(additionalInfo != null ? (Map<String, Object>) additionalInfo.get("opening_hours") : null)
                    .formattedPhoneNumber(additionalInfo != null ? (String) additionalInfo.get("formatted_phone_number") : null)
                    .reviews(additionalInfo != null ? (List<Map<String, Object>>) additionalInfo.get("reviews") : null)
                    .build();
            extendedDtos.add(dto);
        }
        return new PageDto<>(new PageImpl<>(extendedDtos, pageable, page.getTotalElements()));
    }

    public PageDto<RegionGoogleResponse> getJeollanamdo(String smallCode, Optional<String> district, Pageable pageable) {
        Page<Jeollanamdo> page;
        if (district.isPresent()) {
            page = jeollanamdoRepository.findBySmallCodeAndRoadNameContaining(smallCode, district.get(), pageable);
        } else {
            page = jeollanamdoRepository.findBySmallCode(smallCode, pageable);
        }

        List<RegionGoogleResponse> extendedDtos = new ArrayList<>();
        for (Jeollanamdo jeollanamdo : page.getContent()) {

            // Google Maps API를 호출하여 새로운 정보를 가져오기
            String input = jeollanamdo.getName() + " " + jeollanamdo.getLocalAddress();
            Map<String, Object> additionalInfo = callGoogleMapsApi(input);

            // Builder 패턴을 사용하여 RegionGoogleResponse 객체 생성
            RegionGoogleResponse dto = RegionGoogleResponse.builder()
                    .number(jeollanamdo.getNumber())
                    .name(jeollanamdo.getName())
                    .branchName(jeollanamdo.getBranchName())
                    .largeCode(jeollanamdo.getLargeCode())
                    .largeName(jeollanamdo.getLargeName())
                    .mediumCode(jeollanamdo.getMediumCode())
                    .mediumName(jeollanamdo.getMediumName())
                    .smallCode(jeollanamdo.getSmallCode())
                    .smallName(jeollanamdo.getSmallName())
                    .dongNumber(jeollanamdo.getDongNumber())
                    .dongName(jeollanamdo.getDongName())
                    .localAddress(jeollanamdo.getLocalAddress())
                    .roadName(jeollanamdo.getRoadName())
                    .roadAddress(jeollanamdo.getRoadAddress())
                    .oldPostalCode(jeollanamdo.getOldPostalCode())
                    .newPostalCode(jeollanamdo.getNewPostalCode())
                    .longitude(jeollanamdo.getLongitude())
                    .latitude(jeollanamdo.getLatitude())
                    .rating(additionalInfo != null ? (Double) additionalInfo.get("rating") : null)
                    .openingHours(additionalInfo != null ? (Map<String, Object>) additionalInfo.get("opening_hours") : null)
                    .formattedPhoneNumber(additionalInfo != null ? (String) additionalInfo.get("formatted_phone_number") : null)
                    .reviews(additionalInfo != null ? (List<Map<String, Object>>) additionalInfo.get("reviews") : null)
                    .build();
            extendedDtos.add(dto);
        }
        return new PageDto<>(new PageImpl<>(extendedDtos, pageable, page.getTotalElements()));
    }

    public PageDto<RegionGoogleResponse> getSejong(String smallCode, Optional<String> district, Pageable pageable) {
        Page<Sejong> page;
        if (district.isPresent()) {
            page = sejongRepository.findBySmallCodeAndRoadNameContaining(smallCode, district.get(), pageable);
        } else {
            page = sejongRepository.findBySmallCode(smallCode, pageable);
        }

        List<RegionGoogleResponse> extendedDtos = new ArrayList<>();
        for (Sejong sejong : page.getContent()) {

            // Google Maps API를 호출하여 새로운 정보를 가져오기
            String input = sejong.getName() + " " + sejong.getLocalAddress();
            Map<String, Object> additionalInfo = callGoogleMapsApi(input);

            // Builder 패턴을 사용하여 RegionGoogleResponse 객체 생성
            RegionGoogleResponse dto = RegionGoogleResponse.builder()
                    .number(sejong.getNumber())
                    .name(sejong.getName())
                    .branchName(sejong.getBranchName())
                    .largeCode(sejong.getLargeCode())
                    .largeName(sejong.getLargeName())
                    .mediumCode(sejong.getMediumCode())
                    .mediumName(sejong.getMediumName())
                    .smallCode(sejong.getSmallCode())
                    .smallName(sejong.getSmallName())
                    .dongNumber(sejong.getDongNumber())
                    .dongName(sejong.getDongName())
                    .localAddress(sejong.getLocalAddress())
                    .roadName(sejong.getRoadName())
                    .roadAddress(sejong.getRoadAddress())
                    .oldPostalCode(sejong.getOldPostalCode())
                    .newPostalCode(sejong.getNewPostalCode())
                    .longitude(sejong.getLongitude())
                    .latitude(sejong.getLatitude())
                    .rating(additionalInfo != null ? (Double) additionalInfo.get("rating") : null)
                    .openingHours(additionalInfo != null ? (Map<String, Object>) additionalInfo.get("opening_hours") : null)
                    .formattedPhoneNumber(additionalInfo != null ? (String) additionalInfo.get("formatted_phone_number") : null)
                    .reviews(additionalInfo != null ? (List<Map<String, Object>>) additionalInfo.get("reviews") : null)
                    .build();
            extendedDtos.add(dto);
        }
        return new PageDto<>(new PageImpl<>(extendedDtos, pageable, page.getTotalElements()));
    }


    public PageDto<RegionGoogleResponse> getUlsan(String smallCode, Optional<String> district, Pageable pageable) {
        Page<Ulsan> page;
        if (district.isPresent()) {
            page = ulsanRepository.findBySmallCodeAndRoadNameContaining(smallCode, district.get(), pageable);
        } else {
            page = ulsanRepository.findBySmallCode(smallCode, pageable);
        }

        List<RegionGoogleResponse> extendedDtos = new ArrayList<>();
        for (Ulsan ulsan : page.getContent()) {

            // Google Maps API를 호출하여 새로운 정보를 가져오기
            String input = ulsan.getName() + " " + ulsan.getLocalAddress();
            Map<String, Object> additionalInfo = callGoogleMapsApi(input);

            // Builder 패턴을 사용하여 RegionGoogleResponse 객체 생성
            RegionGoogleResponse dto = RegionGoogleResponse.builder()
                    .number(ulsan.getNumber())
                    .name(ulsan.getName())
                    .branchName(ulsan.getBranchName())
                    .largeCode(ulsan.getLargeCode())
                    .largeName(ulsan.getLargeName())
                    .mediumCode(ulsan.getMediumCode())
                    .mediumName(ulsan.getMediumName())
                    .smallCode(ulsan.getSmallCode())
                    .smallName(ulsan.getSmallName())
                    .dongNumber(ulsan.getDongNumber())
                    .dongName(ulsan.getDongName())
                    .localAddress(ulsan.getLocalAddress())
                    .roadName(ulsan.getRoadName())
                    .roadAddress(ulsan.getRoadAddress())
                    .oldPostalCode(ulsan.getOldPostalCode())
                    .newPostalCode(ulsan.getNewPostalCode())
                    .longitude(ulsan.getLongitude())
                    .latitude(ulsan.getLatitude())
                    .rating(additionalInfo != null ? (Double) additionalInfo.get("rating") : null)
                    .openingHours(additionalInfo != null ? (Map<String, Object>) additionalInfo.get("opening_hours") : null)
                    .formattedPhoneNumber(additionalInfo != null ? (String) additionalInfo.get("formatted_phone_number") : null)
                    .reviews(additionalInfo != null ? (List<Map<String, Object>>) additionalInfo.get("reviews") : null)
                    .build();
            extendedDtos.add(dto);
        }
        return new PageDto<>(new PageImpl<>(extendedDtos, pageable, page.getTotalElements()));
    }
    public Map<String, Object> callGoogleMapsApi(String input) {

        OkHttpClient client = new OkHttpClient().newBuilder().build();
        try {
            // 첫 번째 요청: Place ID를 가져오기
            Request requestForPlaceId = new Request.Builder()
                    .url("https://maps.googleapis.com/maps/api/place/findplacefromtext/json?input=" +
                            URLEncoder.encode(input, "UTF-8") +
                            "&inputtype=textquery&fields=place_id&key=" + apiKey)
                    .get()
                    .build();
            Response responseForPlaceId = client.newCall(requestForPlaceId).execute();

            String responseBodyForPlaceId = responseForPlaceId.body().string();

            Gson gson = new Gson();
            Map<String, Object> responseMapForPlaceId = gson.fromJson(responseBodyForPlaceId, Map.class);

            List<Map<String, Object>> candidates = (List<Map<String, Object>>) responseMapForPlaceId.get("candidates");
            if (candidates != null && !candidates.isEmpty()) {
                String placeId = (String) candidates.get(0).get("place_id");

                // 두 번째 요청: Place ID를 사용하여 formatted_phone_number와 reviews 가져오기
                Request requestForDetails = new Request.Builder()
                        .url("https://maps.googleapis.com/maps/api/place/details/json?place_id=" +
                                placeId +
                                "&fields=formatted_phone_number,reviews,rating,opening_hours&reviews_no_translations=true&key=" + apiKey)
                        .get()
                        .build();
                Response responseForDetails = client.newCall(requestForDetails).execute();

                String responseBodyForDetails = responseForDetails.body().string();
                Map<String, Object> responseMapForDetails = gson.fromJson(responseBodyForDetails, Map.class);
                Map<String, Object> placeInfo = (Map<String, Object>) responseMapForDetails.get("result");

                // 필요한 정보 추출
                Map<String, Object> result = new HashMap<>();
                result.put("formatted_phone_number", placeInfo.get("formatted_phone_number"));
                result.put("reviews", placeInfo.get("reviews"));
                result.put("rating", placeInfo.get("rating"));
                result.put("opening_hours", placeInfo.get("opening_hours"));

                return result;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}



//    private List<NaverBlogData> fetchNaverBlogData(String query) {
//        String jsonResult = apiSearchBlog.searchBlog(query);
//
//        System.out.println(jsonResult);
//        ObjectMapper mapper = new ObjectMapper();
//        try {
//            NaverBlogSearchResult searchResult = mapper.readValue(jsonResult, NaverBlogSearchResult.class);
//            return searchResult.getItems();
//        } catch(IOException e){
//            throw new RuntimeException("JSON 파싱에 실패했습니다.", e);
//        }
//    }

//    public PageDto<RegionResponse<Ulsan>> getUlsan(String smallCode, Optional<String> district, Pageable pageable) {
//        Page<Ulsan> page;
//        if (district.isPresent()) {
//            page = ulsanRepository.findBySmallCodeAndRoadNameContaining(smallCode, district.get(), pageable);
//        } else {
//            page = ulsanRepository.findBySmallCode(smallCode, pageable);
//        }
//
//        List<RegionResponse<Ulsan>> regionResponses = new ArrayList<>();
//        for (Ulsan ulsan : page) {
//            // Construct search query using StringBuilder
//            StringBuilder searchQuery = new StringBuilder();
//            searchQuery.append(ulsan.getName());
//
//            if (ulsan.getBranchName() != null && !ulsan.getBranchName().isBlank()) {
//                searchQuery.append(" ").append(ulsan.getBranchName());
//            }
//
//            // Append roadAddress to searchQuery
//            searchQuery.append(" ").append(ulsan.getRoadAddress());
//
//            // Fetch data from Naver Blog API with searchQuery
//            List<NaverBlogData> naverBlogData = fetchNaverBlogData(searchQuery.toString()); //, ulsan.getRoadAddress()
//
//            RegionResponse<Ulsan> regionResponse = new RegionResponse<>(ulsan, naverBlogData); // 순서 변경
//            regionResponses.add(regionResponse);
//        }
//
//        return new PageDto<>(new PageImpl<>(regionResponses, pageable, page.getTotalElements()));
//    }