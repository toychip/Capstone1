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

    private static String smallCode = "D01A03";

    @Test
    @DisplayName("입력값(소분류)으로 조회 - 서울")
    void testFindBySmallName() throws Exception {
        

        mockMvc.perform(get("/region/seoul/company")
                        .param("smallCode", smallCode)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").isNotEmpty())
                .andDo(print());
    }

    @Test
    @DisplayName("입력값(소분류)으로 조회 - 부산")
    void testFomdBySmallCode_Busan() throws Exception {


        mockMvc.perform(get("/region/busan/company")
                        .param("smallCode", smallCode)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").isNotEmpty())
                .andDo(print());
    }

    @Test
    @DisplayName("입력값(소분류)으로 조회 - 충청북도")
    void testFomdBySmallCode_chungcheongbukdo() throws Exception {
        

        mockMvc.perform(get("/region/chungcheongbukdo/company")
                        .param("smallCode", smallCode)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").isNotEmpty())
                .andDo(print());
    }

    @Test
    @DisplayName("입력값(소분류)으로 조회 - 충청남도")
    void testFomdBySmallCode_chungcheongnamdo() throws Exception {
        

        mockMvc.perform(get("/region/chungcheongnamdo/company")
                        .param("smallCode", smallCode)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").isNotEmpty())
                .andDo(print());
    }

    @Test
    @DisplayName("입력값(소분류)으로 조회 - 대구")
    void testFomdBySmallCode_daegu() throws Exception {
        

        mockMvc.perform(get("/region/daegu/company")
                        .param("smallCode", smallCode)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").isNotEmpty())
                .andDo(print());
    }

    @Test
    @DisplayName("입력값(소분류)으로 조회 - 대전")
    void testFomdBySmallCode_daejeon() throws Exception {
        

        mockMvc.perform(get("/region/daejeon/company")
                        .param("smallCode", smallCode)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").isNotEmpty())
                .andDo(print());
    }

    @Test
    @DisplayName("입력값(소분류)으로 조회 - 광주")
    void testFomdBySmallCode_gandwondo() throws Exception {
        

        mockMvc.perform(get("/region/gandwondo/company")
                        .param("smallCode", smallCode)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").isNotEmpty())
                .andDo(print());
    }

    @Test
    @DisplayName("입력값(소분류)으로 조회 - 광주")
    void testFomdBySmallCode_gwangju() throws Exception {
        

        mockMvc.perform(get("/region/gwangju/company")
                        .param("smallCode", smallCode)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").isNotEmpty())
                .andDo(print());
    }

    @Test
    @DisplayName("입력값(소분류)으로 조회 - 경상남도")
    void testFomdBySmallCode_gyeongsangnamdo() throws Exception {
        

        mockMvc.perform(get("/region/gyeongsangnamdo/company")
                        .param("smallCode", smallCode)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").isNotEmpty())
                .andDo(print());
    }

    @Test
    @DisplayName("입력값(소분류)으로 조회 - 경상남도")
    void testFomdBySmallCode_gyeongsangbukdo() throws Exception {
        

        mockMvc.perform(get("/region/gyeongsangbukdo/company")
                        .param("smallCode", smallCode)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").isNotEmpty())
                .andDo(print());
    }

    @Test
    @DisplayName("입력값(소분류)으로 조회 - 인천")
    void testFomdBySmallCode_incheon() throws Exception {
        

        mockMvc.perform(get("/region/incheon/company")
                        .param("smallCode", smallCode)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").isNotEmpty())
                .andDo(print());
    }

    @Test
    @DisplayName("입력값(소분류)으로 조회 - 제주도")
    void testFomdBySmallCode_jejudo() throws Exception {
        

        mockMvc.perform(get("/region/jejudo/company")
                        .param("smallCode", smallCode)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").isNotEmpty())
                .andDo(print());
    }

    @Test
    @DisplayName("입력값(소분류)으로 조회 - 전라북도")
    void testFomdBySmallCode_jeollabukdo() throws Exception {
        

        mockMvc.perform(get("/region/jeollabukdo/company")
                        .param("smallCode", smallCode)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").isNotEmpty())
                .andDo(print());
    }

    @Test
    @DisplayName("입력값(소분류)으로 조회 - 전라남도")
    void testFomdBySmallCode_jeollanamdo() throws Exception {
        

        mockMvc.perform(get("/region/jeollanamdo/company")
                        .param("smallCode", smallCode)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").isNotEmpty())
                .andDo(print());
    }

    @Test
    @DisplayName("입력값(소분류)으로 조회 - 세종")
    void testFomdBySmallCode_sejong() throws Exception {
        

        mockMvc.perform(get("/region/sejong/company")
                        .param("smallCode", smallCode)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").isNotEmpty())
                .andDo(print());
    }

    @Test
    @DisplayName("입력값(소분류)으로 조회 - 울산")
    void testFomdBySmallCode_ulsan() throws Exception {
        

        mockMvc.perform(get("/region/ulsan/company")
                        .param("smallCode", smallCode)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").isNotEmpty())
                .andDo(print());
    }

}
