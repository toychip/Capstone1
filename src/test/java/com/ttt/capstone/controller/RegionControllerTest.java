package com.ttt.capstone.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@WithMockUser(roles = "USER")
public class RegionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private static String smallCode = "D01A03";
    private static Long page = 20L;

    // 서울
    @Test
    @DisplayName("입력값(소분류)으로 조회 - 서울")
    void testFindBySmallName_Seoul() throws Exception {
        performRequest("/region/seoul/company", smallCode, page);
    }

    @Test
    @DisplayName("입력값(소분류와 세부 지역명)으로 조회 - 서울")
    void testFindBySmallNameAndDistrict_Seoul() throws Exception {
        String district = "강동구";
        performRequestWithDistrict("/region/seoul/company", smallCode, district, page);
    }

    // 부산
    @Test
    @DisplayName("입력값(소분류)으로 조회 - 부산")
    void testFindBySmallName_Busan() throws Exception {
        performRequest("/region/busan/company", smallCode, page);
    }

    @Test
    @DisplayName("입력값(소분류와 세부 지역명)으로 조회 - 부산")
    void testFindBySmallNameAndDistrict_Busan() throws Exception {
        String district = "해운대구";
        performRequestWithDistrict("/region/busan/company", smallCode, district, page);
    }

    // 대구
    @Test
    @DisplayName("입력값(소분류)으로 조회 - 대구")
    void testFindBySmallName_Daegu() throws Exception {
        performRequest("/region/daegu/company", smallCode, page);
    }

    @Test
    @DisplayName("입력값(소분류와 세부 지역명)으로 조회 - 대구")
    void testFindBySmallNameAndDistrict_Daegu() throws Exception {
        String district = "수성구";
        performRequestWithDistrict("/region/daegu/company", smallCode, district, page);
    }

    // 인천
    @Test
    @DisplayName("입력값(소분류)으로 조회 - 인천")
    void testFindBySmallName_Incheon() throws Exception {
        performRequest("/region/incheon/company", smallCode, page);
    }

    @Test
    @DisplayName("입력값(소분류와 세부 지역명)으로 조회 - 인천")
    void testFindBySmallNameAndDistrict_Incheon() throws Exception {
        String district = "미추홀구";
        performRequestWithDistrict("/region/incheon/company", smallCode, district, page);
    }

    // 광주
    @Test
    @DisplayName("입력값(소분류)으로 조회 - 광주")
    void testFindBySmallName_Gwangju() throws Exception {
        performRequest("/region/gwangju/company", smallCode, page);
    }

    @Test
    @DisplayName("입력값(소분류와 세부 지역명)으로 조회 - 광주")
    void testFindBySmallNameAndDistrict_Gwangju() throws Exception {
        String district = "서구";
        performRequestWithDistrict("/region/gwangju/company", smallCode, district, page);
    }

    // 대전
    @Test
    @DisplayName("입력값(소분류)으로 조회 - 대전")
    void testFindBySmallName_Daejeon() throws Exception {
        performRequest("/region/daejeon/company", smallCode, page);
    }

    @Test
    @DisplayName("입력값(소분류와 세부 지역명)으로 조회 - 대전")
    void testFindBySmallNameAndDistrict_Daejeon() throws Exception {
        String district = "유성구";
        performRequestWithDistrict("/region/daejeon/company", smallCode, district, page);
    }

    // 울산
    @Test
    @DisplayName("입력값(소분류)으로 조회 - 울산")
    void testFindBySmallName_Ulsan() throws Exception {
        performRequest("/region/ulsan/company", smallCode, page);
    }

    @Test
    @DisplayName("입력값(소분류와 세부 지역명)으로 조회 - 울산")
    void testFindBySmallNameAndDistrict_Ulsan() throws Exception {
        String district = "중구";
        performRequestWithDistrict("/region/ulsan/company", smallCode, district, page);
    }

    // 제주도
    @Test
    @DisplayName("입력값(소분류)으로 조회 - 제주도")
    void testFindBySmallName_Jeju() throws Exception {
        performRequest("/region/jejudo/company", smallCode, page);
    }

    @Test
    @DisplayName("입력값(소분류와 세부 지역명)으로 조회 - 제주도")
    void testFindBySmallNameAndDistrict_Jeju() throws Exception {
        String district = "서귀포시";
        performRequestWithDistrict("/region/jejudo/company", smallCode, district, page);
    }

    // 세종
    @Test
    @DisplayName("입력값(소분류)으로 조회 - 세종")
    void testFindBySmallName_Sejong() throws Exception {
        performRequest("/region/sejong/company", smallCode, page);
    }

    @Test
    @DisplayName("입력값(소분류와 세부 지역명)으로 조회 - 세종")
    void testFindBySmallNameAndDistrict_Sejong() throws Exception {
        String district = "조치원읍";
        performRequestWithDistrict("/region/sejong/company", smallCode, district, page);
    }

    // 경기도
    @Test
    @DisplayName("입력값(소분류)으로 조회 - 경기도")
    void testFindBySmallName_Gyeonggi() throws Exception {
        performRequest("/region/gyeonggido/company", smallCode, page);
    }

    @Test
    @DisplayName("입력값(소분류와 세부 지역명)으로 조회 - 경기도")
    void testFindBySmallNameAndDistrict_Gyeonggi() throws Exception {
        String district = "용인시";
        performRequestWithDistrict("/region/gyeonggido/company", smallCode, district, page);
    }

    // 강원도
    @Test
    @DisplayName("입력값(소분류)으로 조회 - 강원도")
    void testFindBySmallName_Gangwon() throws Exception {
        performRequest("/region/gandwondo/company", smallCode, page);
    }

    @Test
    @DisplayName("입력값(소분류와 세부 지역명)으로 조회 - 강원도")
    void testFindBySmallNameAndDistrict_Gangwon() throws Exception {
        String district = "속초시";
        performRequestWithDistrict("/region/gandwondo/company", smallCode, district, page);
    }
    // 충청북도
    @Test
    @DisplayName("입력값(소분류)으로 조회 - 충청북도")
    void testFindBySmallName_Chungcheongbuk() throws Exception {
        performRequest("/region/chungcheongbukdo/company", smallCode, page);
    }

    @Test
    @DisplayName("입력값(소분류와 세부 지역명)으로 조회 - 충청북도")
    void testFindBySmallNameAndDistrict_Chungcheongbuk() throws Exception {
        String district = "청주시";
        performRequestWithDistrict("/region/chungcheongbukdo/company", smallCode, district, page);
    }

    // 충청남도
    @Test
    @DisplayName("입력값(소분류)으로 조회 - 충청남도")
    void testFindBySmallName_Chungcheongnam() throws Exception {
        performRequest("/region/chungcheongnamdo/company", smallCode, page);
    }

    @Test
    @DisplayName("입력값(소분류와 세부 지역명)으로 조회 - 충청남도")
    void testFindBySmallNameAndDistrict_Chungcheongnam() throws Exception {
        String district = "천안시";
        performRequestWithDistrict("/region/chungcheongnamdo/company", smallCode, district, page);
    }

    // 경상북도
    @Test
    @DisplayName("입력값(소분류)으로 조회 - 경상북도")
    void testFindBySmallName_Gyeongsangbuk() throws Exception {
        performRequest("/region/gyeongsangbukdo/company", smallCode, page);
    }

    @Test
    @DisplayName("입력값(소분류와 세부 지역명)으로 조회 - 경상북도")
    void testFindBySmallNameAndDistrict_Gyeongsangbuk() throws Exception {
        String district = "구미시";
        performRequestWithDistrict("/region/gyeongsangbukdo/company", smallCode, district, page);
    }

    // 경상남도
    @Test
    @DisplayName("입력값(소분류)으로 조회 - 경상남도")
    void testFindBySmallName_Gyeongsangnam() throws Exception {
        performRequest("/region/gyeongsangnamdo/company", smallCode, page);
    }

    @Test
    @DisplayName("입력값(소분류와 세부 지역명)으로 조회 - 경상남도")
    void testFindBySmallNameAndDistrict_Gyeongsangnam() throws Exception {
        String district = "창원시";
        performRequestWithDistrict("/region/gyeongsangnamdo/company", smallCode, district, page);
    }

    // 전라북도
    @Test
    @DisplayName("입력값(소분류)으로 조회 - 전라북도")
    void testFindBySmallName_Jeollabuk() throws Exception {
        performRequest("/region/jeollabukdo/company", smallCode, page);
    }

    @Test
    @DisplayName("입력값(소분류와 세부 지역명)으로 조회 - 전라북도")
    void testFindBySmallNameAndDistrict_Jeollabuk() throws Exception {
        String district = "전주시";
        performRequestWithDistrict("/region/jeollabukdo/company", smallCode, district, page);
    }

    // 전라남도
    @Test
    @DisplayName("입력값(소분류)으로 조회 - 전라남도")
    void testFindBySmallName_Jeollanam() throws Exception {
        performRequest("/region/jeollanamdo/company", smallCode, page);
    }

    @Test
    @DisplayName("입력값(소분류와 세부 지역명)으로 조회 - 전라남도")
    void testFindBySmallNameAndDistrict_Jeollanam() throws Exception {
        String district = "나주시";
        performRequestWithDistrict("/region/jeollanamdo/company", smallCode, district, page);
    }
    
    @Test
    @DisplayName("입력 값")

    private void performRequest(String url, String smallCode, Long page) throws Exception {
        mockMvc.perform(get(url)
                        .param("smallCode", smallCode)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content[0].name").isNotEmpty())
                .andDo(print());
    }

    // district가 있는 요청을 위한 헬퍼 메소드
    private void performRequestWithDistrict(String url, String smallCode, String district, Long page) throws Exception {
        mockMvc.perform(get(url)
                        .param("smallCode", smallCode)
                        .param("district", district)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content[0].name").isNotEmpty())
                .andDo(print());
    }
}
