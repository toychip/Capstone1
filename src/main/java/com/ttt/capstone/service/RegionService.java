package com.ttt.capstone.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ttt.capstone.controller.PageDto;
import com.ttt.capstone.naverblog.ApiSearchBlog;
import com.ttt.capstone.naverblog.NaverBlogData;
import com.ttt.capstone.naverblog.RegionResponse;
import com.ttt.capstone.regionentity.*;
import com.ttt.capstone.regionrepository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RegionService {

    private final ApiSearchBlog apiSearchBlog;
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


    public PageDto<Seoul> getSeoul(String smallCode, Optional<String> district, Pageable pageable) {
        Page<Seoul> page;
        if (district.isPresent()) {
            page = seoulRepository.findBySmallCodeAndRoadNameContaining(smallCode, district.get(), pageable);
        } else {
            page = seoulRepository.findBySmallCode(smallCode, pageable);
        }
        return new PageDto<>(page);
    }

    public PageDto<Busan> getBusan(String smallCode, Optional<String> district, Pageable pageable) {
        Page<Busan> page;
        if (district.isPresent()) {
            page = busanRepository.findBySmallCodeAndRoadNameContaining(smallCode, district.get(), pageable);

        } else {
            page = busanRepository.findBySmallCode(smallCode, pageable);
        }
        return new PageDto<>(page);
    }

    public PageDto<Chungcheongbukdo> getChungcheongbukdo(String smallCode, Optional<String> district, Pageable pageable) {
        Page<Chungcheongbukdo> page;
        if (district.isPresent()) {
            page = chungcheongbukdoRepository.findBySmallCodeAndRoadNameContaining(smallCode, district.get(), pageable);

        } else {
            page = chungcheongbukdoRepository.findBySmallCode(smallCode, pageable);
        }
        return new PageDto<>(page);
    }

    public PageDto<Chungcheongnamdo> getChungcheongnamdo(String smallCode, Optional<String> district, Pageable pageable) {
        Page<Chungcheongnamdo> page;
        if (district.isPresent()) {
            page = chungcheongnamdoRepository.findBySmallCodeAndRoadNameContaining(smallCode, district.get(), pageable);

        } else {
            page = chungcheongnamdoRepository.findBySmallCode(smallCode, pageable);
        }
        return new PageDto<>(page);
    }

    public PageDto<Daegu> getDaegu(String smallCode, Optional<String> district, Pageable pageable) {
        Page<Daegu> page;
        if (district.isPresent()) {
            page = daeguRepository.findBySmallCodeAndRoadNameContaining(smallCode, district.get(), pageable);

        } else {
            page = daeguRepository.findBySmallCode(smallCode, pageable);
        }
        return new PageDto<>(page);
    }

    public PageDto<Daejeon> getDaejeon(String smallCode, Optional<String> district, Pageable pageable) {
        Page<Daejeon> page;
        if (district.isPresent()) {
            page = daejeonRepository.findBySmallCodeAndRoadNameContaining(smallCode, district.get(), pageable);

        } else {
            page = daejeonRepository.findBySmallCode(smallCode, pageable);
        }
        return new PageDto<>(page);
    }

    public PageDto<Gandwondo> getGandwondo(String smallCode, Optional<String> district, Pageable pageable) {
        Page<Gandwondo> page;
        if (district.isPresent()) {
            page = gandwondoRepository.findBySmallCodeAndRoadNameContaining(smallCode, district.get(), pageable);

        } else {
            page = gandwondoRepository.findBySmallCode(smallCode, pageable);
        }
        return new PageDto<>(page);
    }

    public PageDto<Gwangju> getGwangju(String smallCode, Optional<String> district, Pageable pageable) {
        Page<Gwangju> page;
        if (district.isPresent()) {
            page = gwangjuRepository.findBySmallCodeAndRoadNameContaining(smallCode, district.get(), pageable);

        } else {
            page = gwangjuRepository.findBySmallCode(smallCode, pageable);
        }
        return new PageDto<>(page);
    }

    public PageDto<Gyeonggido> getGyeonggido(String smallCode, Optional<String> district, Pageable pageable) {
        Page<Gyeonggido> page;
        if (district.isPresent()) {
            page = gyeonggidoRepository.findBySmallCodeAndRoadNameContaining(smallCode, district.get(), pageable);

        } else {
            page = gyeonggidoRepository.findBySmallCode(smallCode, pageable);
        }
        return new PageDto<>(page);
    }

    public PageDto<Gyeongsangbukdo> getGyeongsangbukdo(String smallCode, Optional<String> district, Pageable pageable) {
        Page<Gyeongsangbukdo> page;
        if (district.isPresent()) {
            page = gyeongsangbukdoRepository.findBySmallCodeAndRoadNameContaining(smallCode, district.get(), pageable);

        } else {
            page = gyeongsangbukdoRepository.findBySmallCode(smallCode, pageable);
        }
        return new PageDto<>(page);
    }

    public PageDto<Gyeongsangnamdo> getGyeongsangnamdo(String smallCode, Optional<String> district, Pageable pageable) {
        Page<Gyeongsangnamdo> page;
        if (district.isPresent()) {
            page = gyeongsangnamdoRepository.findBySmallCodeAndRoadNameContaining(smallCode, district.get(), pageable);

        } else {
            page = gyeongsangnamdoRepository.findBySmallCode(smallCode, pageable);
        }
        return new PageDto<>(page);
    }

    public PageDto<Incheon> getIncheon(String smallCode, Optional<String> district, Pageable pageable) {
        Page<Incheon> page;
        if (district.isPresent()) {
            page = incheonRepository.findBySmallCodeAndRoadNameContaining(smallCode, district.get(), pageable);

        } else {
            page = incheonRepository.findBySmallCode(smallCode, pageable);
        }
        return new PageDto<>(page);
    }

    public PageDto<Jejudo> getJejudo(String smallCode, Optional<String> district, Pageable pageable) {
        Page<Jejudo> page;
        if (district.isPresent()) {
            page = jejudoRepository.findBySmallCodeAndRoadNameContaining(smallCode, district.get(), pageable);

        } else {
            page = jejudoRepository.findBySmallCode(smallCode, pageable);
        }
        return new PageDto<>(page);
    }

    public PageDto<Jeollabukdo> getJeollabukdo(String smallCode, Optional<String> district, Pageable pageable) {
        Page<Jeollabukdo> page;
        if (district.isPresent()) {
            page = jeollabukdoRepository.findBySmallCodeAndRoadNameContaining(smallCode, district.get(), pageable);

        } else {
            page = jeollabukdoRepository.findBySmallCode(smallCode, pageable);
        }
        return new PageDto<>(page);
    }

    public PageDto<Jeollanamdo> getJeollanamdo(String smallCode, Optional<String> district, Pageable pageable) {
        Page<Jeollanamdo> page;
        if (district.isPresent()) {
            page = jeollanamdoRepository.findBySmallCodeAndRoadNameContaining(smallCode, district.get(), pageable);

        } else {
            page = jeollanamdoRepository.findBySmallCode(smallCode, pageable);
        }
        return new PageDto<>(page);
    }

    public PageDto<Sejong> getSejong(String smallCode, Optional<String> district, Pageable pageable) {
        Page<Sejong> page;
        if (district.isPresent()) {
            page = sejongRepository.findBySmallCodeAndRoadNameContaining(smallCode, district.get(), pageable);

        } else {
            page = sejongRepository.findBySmallCode(smallCode, pageable);
        }
        return new PageDto<>(page);
    }

    public PageDto<RegionResponse<Ulsan>> getUlsan(String smallCode, Optional<String> district, Pageable pageable) {
        Page<Ulsan> page;
        if (district.isPresent()) {
            page = ulsanRepository.findBySmallCodeAndRoadNameContaining(smallCode, district.get(), pageable);
        } else {
            page = ulsanRepository.findBySmallCode(smallCode, pageable);
        }

        List<RegionResponse<Ulsan>> regionResponses = new ArrayList<>();
        for (Ulsan ulsan : page) {
            // Construct search query using StringBuilder
            StringBuilder searchQuery = new StringBuilder();
            searchQuery.append(ulsan.getName());

            // Append branchName to searchQuery if it's not null or not blank
            if (ulsan.getBranchName() != null && !ulsan.getBranchName().isBlank()) {
                searchQuery.append(" ").append(ulsan.getBranchName());
            }

            // Append roadAddress to searchQuery
            searchQuery.append(" ").append(ulsan.getRoadAddress());

            // Fetch data from Naver Blog API with searchQuery
            List<NaverBlogData> naverBlogData = fetchNaverBlogData(searchQuery.toString()); //, ulsan.getRoadAddress()

            // Create a RegionResponse object
            RegionResponse<Ulsan> regionResponse = new RegionResponse<>(ulsan, naverBlogData); // 순서 변경
            regionResponses.add(regionResponse);
        }

        return new PageDto<>(new PageImpl<>(regionResponses, pageable, page.getTotalElements()));
    }

    private List<NaverBlogData> fetchNaverBlogData(String query) {
//        String display = "display=3&";
        String jsonResult = apiSearchBlog.searchBlog(query);

        System.out.println(jsonResult);
        // JSON 문자열을 NaverBlogData 객체로 변환
        ObjectMapper mapper = new ObjectMapper();
        try {
            NaverBlogData[] naverBlogDataArray = mapper.readValue(jsonResult, NaverBlogData[].class);
            return Arrays.asList(naverBlogDataArray);
        } catch (IOException e) {
            throw new RuntimeException("JSON 파싱에 실패했습니다.", e);
        }
    }
}
