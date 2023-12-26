package com.climb.timecounting.controller;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@DisplayName("View Controller - 목표")
@WebMvcTest
class GoalControllerTest {

    private final MockMvc mvc;

    public GoalControllerTest(@Autowired MockMvc mvc)
    {
        this.mvc = mvc;
    }


    @DisplayName("[view][GET] 목표 리스트 페이지 - 정상 호출")
    @Test
    public void givenNothing_whenRequestingView_thenReturnsGoals() throws Exception {
        //Given

        //When & Then
        mvc.perform(get("/goals"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
                .andExpect(view().name("goals/index"))
                .andExpect(model().attributeExists("goals"));

    }


    @DisplayName("[view][GET] 목표 상세 페이지 - 정상 호출")
    @Test
    public void givenNothing_whenRequestingGoalView_thenReturnsGoalView() throws Exception {
        //Given

        //When & Then
        mvc.perform(get("/goals/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
                .andExpect(view().name("goals/detail"))
                .andExpect(model().attributeExists("goals"));

    }


    @Disabled("구현 중")
    @DisplayName("[view][GET] 목표 검색 전용 페이지 - 정상 호출")
    @Test
    public void givenNothing_whenRequestingGoalSearchView_thenReturnsGoalSearchView() throws Exception {
        //Given

        //When & Then
        mvc.perform(get("/goals/search"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML));

    }

}