package com.ttt.capstone.service;

import com.ttt.capstone.repository.RegionRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class RegionServiceTest {

    @Autowired
    private RegionRepository regionRepository;
    @Autowired
    private RegionService regionService;
//    @Test
//    @DisplayName("입력값 로기 조회 - 서울")
//    void test1() {
//        String request = "D01A03";
//        List<SmallNameResponse> seoul = regionService.getSeoul(request);
//        for (SmallNameResponse smallNameResponse : seoul) {
//            System.out.println("smallNameResponse.getName() = " + smallNameResponse.getName());
//        }
//    }
//
//    @Test
//    @DisplayName("입력값 로기 조회 - 경기도")
//    void test2() {
//        String request = "D01A03";
//        List<SmallNameResponse> greonggido = regionService.getGyeonggido(request);
//        for (SmallNameResponse smallNameResponse : greonggido) {
//            System.out.println("smallNameResponse.getName() = " + smallNameResponse.getName());
//        }
//    }


}
