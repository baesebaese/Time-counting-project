package com.climb.timecounting.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MainControllerTest.class)
class MainControllerTest {

    public MainControllerTest(@Autowired MockMvc mvc) {
        this.mvc = mvc;
    }

    private final MockMvc mvc;
/*
    @Test
    void givenNothing_whenRequestingRootPage_thenRedirectsToGoalsPage() throws Exception {
        //Given

        //When & Then
        mvc.perform(get("/"))
                .andExpect(status().is3xxRedirection());

    }
*/
}
