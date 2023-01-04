package com.api.carshop.controllers;

import com.api.carshop.client.CustomerClient;
import com.api.carshop.dto.CustomerDto;
import com.api.carshop.services.CustomerService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class CustomerControllerTest {
    @Autowired
    CustomerClient customerClient;


    @BeforeEach
    public CustomerDto customerDto = CustomerDto.builder()
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


    @AfterEach


    @Test
    public void shouldSaveCustomer(){
        var result = customerClient.saveCustomer(customerDto);

        assertNotNull(result);
    }

}