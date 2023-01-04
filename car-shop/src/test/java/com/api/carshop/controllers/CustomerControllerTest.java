package com.api.carshop.controllers;

import com.api.carshop.dto.CustomerDto;
import com.api.carshop.services.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.JsonPathResultMatchers;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @MockBean
    private CustomerService customerService;

    @Test
    public void shouldSaveCustomerAndReturnHttpStatusCreated() throws Exception {

        CustomerDto customerDto = CustomerDto.builder()
                .name("Dev")
                .cpf("24350386076")
                .cnpj("90660871000124")
                .phone("11946313126")
                .email("lorenzo.igor.rezende@integrasjc.com.br")
                .address("Rua Acará, 693")
                .city("Bragança Paulista")
                .state("SP")
                .pin("12913066")
                .build();

        String jsonCustomer = mapper.writeValueAsString(customerDto);

        MvcResult mvcResult = mockMvc.perform(post("/customer")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonCustomer))
                .andReturn();

        assertEquals(201, mvcResult.getResponse().getStatus());

        System.out.println(mvcResult.getResponse().getContentAsString());
    }

}