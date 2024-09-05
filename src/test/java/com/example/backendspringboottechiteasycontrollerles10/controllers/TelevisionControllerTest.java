package com.example.backendspringboottechiteasycontrollerles10.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
class TelevisionControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void getOneTelevisionTest() throws Exception {
        // arrange
        String requestJson = """
                {
                    "id" : 10000,
                    "type" : "type",
                    "brand" : "brand",
                    "name" : "name",
                    "price" : 100.00,
                    "availableSize" : 100.00,
                    "refreshRate" : 100.00,
                    "screenType" : "screenType",
                    "screenQuality" : "screenQuality",
                    "smartTv" : true,
                    "wifi" : true,
                    "voiceControl" : true,
                    "hdr" : true,
                    "bluetooth" : true,
                    "ambiLight" : true,
                    "originalStock" : 100,
                    "sold" : 100
                }
                """;

        // act
        MvcResult mvcResult = this.mockMvc
                .perform(MockMvcRequestBuilders.post("/televisions")
                .contentType(APPLICATION_JSON_UTF8)
                .content(requestJson))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andReturn();

        String orderId = mvcResult.getResponse().getContentAsString();

        // assert
        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/televisions/" + orderId))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("id").value(10000))
                .andExpect(MockMvcResultMatchers.jsonPath("type").value("type"))
                .andExpect(MockMvcResultMatchers.jsonPath("brand").value("brand"))
                .andExpect(MockMvcResultMatchers.jsonPath("name").value("name"))
                .andExpect(MockMvcResultMatchers.jsonPath("price").value(100.00))
                .andExpect(MockMvcResultMatchers.jsonPath("availableSize").value(100.00))
                .andExpect(MockMvcResultMatchers.jsonPath("refreshRate").value(100.00))
                .andExpect(MockMvcResultMatchers.jsonPath("screenType").value("screenType"))
                .andExpect(MockMvcResultMatchers.jsonPath("screenQuality").value("screenQuality"))
                .andExpect(MockMvcResultMatchers.jsonPath("smartTv").value(true))
                .andExpect(MockMvcResultMatchers.jsonPath("wifi").value(true))
                .andExpect(MockMvcResultMatchers.jsonPath("voiceControl").value(true));

    }
}