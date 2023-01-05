package com.api.carshop.controllers;

import com.api.carshop.client.CustomerClient;
import com.api.carshop.dto.CustomerDto;
import com.api.carshop.models.CustomerModel;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class CustomerControllerTest {
    @Autowired
    CustomerClient customerClient;
    CustomerDto customerDto;
    CustomerModel customerEntity;
    CustomerDto customerDtoPut;

    @BeforeEach
    public void setup(){
        System.out.println("#----Setting up customerDto and CustomerModel----#");
        customerDto = CustomerDto.builder()
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

        customerEntity = CustomerModel.builder()
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

        customerDtoPut = CustomerDto.builder()
                .name("DevTeste2")
                .cpf("35461497187")
                .cnpj("93330871110124")
                .phone("11946317172")
                .email("devPutTeste@integrasjc.com.br")
                .address("Rua Acaraje, 693")
                .city("Osasco")
                .state("SP")
                .pin("12915056")
                .build();
    }
    @Test
    public void shouldDoCRUD(){

        var saveCustomer = customerClient.saveCustomer(customerDto);
        customerEntity.setId(saveCustomer.getBody().getId());
        assertEquals(customerEntity.getCpf(), saveCustomer.getBody().getCpf());

        var getCustomerById = customerClient.getCustomerById(customerEntity.getId());
        assertEquals(customerEntity.getCpf(), getCustomerById.getBody().getCpf());

        var putCustomer = customerClient.updateCustomer(customerEntity.getId(), customerDtoPut);
        assertEquals(customerEntity.getId(), putCustomer.getBody().getId());
        assertNotEquals(customerEntity.getName(), putCustomer.getBody().getName());

        var deleteCustomer = customerClient.deleteCustomer(customerEntity.getId());
        assertEquals(HttpStatus.OK, deleteCustomer.getStatusCode());
        assertEquals("Customer deleted", deleteCustomer.getBody());
    }

}