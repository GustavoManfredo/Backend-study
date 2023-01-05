package com.api.carshop.services;

import com.api.carshop.dto.CustomerDto;
import com.api.carshop.mappers.CustomerMapper;
import com.api.carshop.models.CustomerModel;
import com.api.carshop.repositories.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {

    @Spy
    private CustomerRepository customerRepository;
    @Mock
    private CustomerMapper customerMapper;
    @InjectMocks @Spy
    private CustomerServiceImpl customerService;
    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    CustomerModel customer = CustomerModel.builder()
            .id(1L)
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

    @Test
    public void shouldValidateDataAndSave() {

        when(customerMapper.mapToDto(customer)).thenReturn(customerDto);
        when(customerService.save(customerMapper.mapToDto(customer))).thenReturn(customerDto);
        var result = customerService.save(customerDto);

        assertEquals(customerDto, result);

        verify(customerService, times(1)).save(customerDto);
    }

    @Test
    public void shouldGetCustomerById(){

        when(customerRepository.findById(1L)).thenReturn(Optional.of(customer));
        when(customerService.findById(1L)).thenReturn(customerDto);

        var result = customerService.findById(customer.getId());

        assertEquals(customerDto, result);
    }
}