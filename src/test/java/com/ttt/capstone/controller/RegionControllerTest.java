package com.ttt.capstone.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
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

    @Test
    @DisplayName("입력값(소분류)으로 조회 - 서울")
    void testFindBySmallName() throws Exception {
        String smallCode = "D01A03";

        mockMvc.perform(get("/region/seoul/{smallCode}", smallCode)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").isNotEmpty())
                .andDo(print());
    }

    @Test
    @DisplayName("입력값(소분류)으로 조회 - 부산")
    void testFomdBySmallCode_Busan() throws Exception {
        String smallCode = "D01A03";

        mockMvc.perform(get("/region/busan/{smallCode}", smallCode)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").isNotEmpty())
                .andDo(print());
    }

    @Test
    @DisplayName("입력값(소분류)으로 조회 - 충청북도")
    void testFomdBySmallCode_chungcheongbukdo() throws Exception {
        String smallCode = "D01A03";

        mockMvc.perform(get("/region/chungcheongbukdo/{smallCode}", smallCode)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").isNotEmpty())
                .andDo(print());
    }

    @Test
    @DisplayName("입력값(소분류)으로 조회 - 충청남도")
    void testFomdBySmallCode_chungcheongnamdo() throws Exception {
        String smallCode = "D01A03";

        mockMvc.perform(get("/region/chungcheongnamdo/{smallCode}", smallCode)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").isNotEmpty())
                .andDo(print());
    }

    @Test
    @DisplayName("입력값(소분류)으로 조회 - 대구")
    void testFomdBySmallCode_daegu() throws Exception {
        String smallCode = "D01A03";

        mockMvc.perform(get("/region/daegu/{smallCode}", smallCode)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").isNotEmpty())
                .andDo(print());
    }

    @Test
    @DisplayName("입력값(소분류)으로 조회 - 대전")
    void testFomdBySmallCode_daejeon() throws Exception {
        String smallCode = "D01A03";

        mockMvc.perform(get("/region/daejeon/{smallCode}", smallCode)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").isNotEmpty())
                .andDo(print());
    }

    @Test
    @DisplayName("입력값(소분류)으로 조회 - 광주")
    void testFomdBySmallCode_gandwondo() throws Exception {
        String smallCode = "D01A03";

        mockMvc.perform(get("/region/gandwondo/{smallCode}", smallCode)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").isNotEmpty())
                .andDo(print());
    }

    @Test
    @DisplayName("입력값(소분류)으로 조회 - 광주")
    void testFomdBySmallCode_gwangju() throws Exception {
        String smallCode = "D01A03";

        mockMvc.perform(get("/region/gwangju/{smallCode}", smallCode)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").isNotEmpty())
                .andDo(print());
    }

    @Test
    @DisplayName("입력값(소분류)으로 조회 - 경상남도")
    void testFomdBySmallCode_gyeongsangnamdo() throws Exception {
        String smallCode = "D01A03";

        mockMvc.perform(get("/region/gyeongsangnamdo/{smallCode}", smallCode)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").isNotEmpty())
                .andDo(print());
    }

    @Test
    @DisplayName("입력값(소분류)으로 조회 - 경상남도")
    void testFomdBySmallCode_gyeongsangbukdo() throws Exception {
        String smallCode = "D01A03";

        mockMvc.perform(get("/region/gyeongsangbukdo/{smallCode}", smallCode)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").isNotEmpty())
                .andDo(print());
    }

    @Test
    @DisplayName("입력값(소분류)으로 조회 - 인천")
    void testFomdBySmallCode_incheon() throws Exception {
        String smallCode = "D01A03";

        mockMvc.perform(get("/region/incheon/{smallCode}", smallCode)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").isNotEmpty())
                .andDo(print());
    }

    @Test
    @DisplayName("입력값(소분류)으로 조회 - 제주도")
    void testFomdBySmallCode_jejudo() throws Exception {
        String smallCode = "D01A03";

        mockMvc.perform(get("/region/jejudo/{smallCode}", smallCode)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").isNotEmpty())
                .andDo(print());
    }

    @Test
    @DisplayName("입력값(소분류)으로 조회 - 전라북도")
    void testFomdBySmallCode_jeollabukdo() throws Exception {
        String smallCode = "D01A03";

        mockMvc.perform(get("/region/jeollabukdo/{smallCode}", smallCode)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").isNotEmpty())
                .andDo(print());
    }

    @Test
    @DisplayName("입력값(소분류)으로 조회 - 전라남도")
    void testFomdBySmallCode_jeollanamdo() throws Exception {
        String smallCode = "D01A03";

        mockMvc.perform(get("/region/jeollanamdo/{smallCode}", smallCode)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").isNotEmpty())
                .andDo(print());
    }

    @Test
    @DisplayName("입력값(소분류)으로 조회 - 세종")
    void testFomdBySmallCode_sejong() throws Exception {
        String smallCode = "D01A03";

        mockMvc.perform(get("/region/sejong/{smallCode}", smallCode)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").isNotEmpty())
                .andDo(print());
    }

    @Test
    @DisplayName("입력값(소분류)으로 조회 - 울산")
    void testFomdBySmallCode_ulsan() throws Exception {
        String smallCode = "D01A03";

        mockMvc.perform(get("/region/ulsan/{smallCode}", smallCode)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").isNotEmpty())
                .andDo(print());
    }

}
