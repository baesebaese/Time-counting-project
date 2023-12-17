package com.climb.timecounting.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("Data REST - API 테스트")
@Transactional
@AutoConfigureMockMvc
@SpringBootTest
public class DataRestTest {

    private MockMvc mvc;

    public DataRestTest(@Autowired MockMvc mvc) {
        this.mvc = mvc;
    }

    @DisplayName("[api] 목표 리스트 조회")
    @Test
    void givenNothing_whenRequestingGolas_thenReturnsGolasJsonResponse() throws Exception {
        // Given

        //When & Then
        mvc.perform(get("/api/goals"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.valueOf("application/hal+json")));
    }


    @DisplayName("[api] 목표 단건 조회")
    @Test
    void givenNothing_whenRequestingGola_thenReturnsGolaJsonResponse() throws Exception {
        // Given

        //When & Then
        mvc.perform(get("/api/goals/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.valueOf("application/hal+json")));
    }
    
    @DisplayName("[api] 목표 이력 조회")
    @Test
    void givenNothing_whenRequestingHistories_thenReturnsHistoriesJsonResponse() throws Exception {
        // Given

        //When & Then
        mvc.perform(get("api/histories"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.valueOf("application/hal+json")));
    }

    @DisplayName("[api] 사용자 리스트 조회")
    @Test
    void givenNothing_whenRequestingkUsers_thenReturnsUsersJsonResponse() throws Exception {
        // Given

        //When & Then
        mvc.perform(get("/api/users"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.valueOf("application/hal+json")));
    }
}
