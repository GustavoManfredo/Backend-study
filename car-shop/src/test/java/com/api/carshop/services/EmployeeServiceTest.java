package com.api.carshop.services;

import com.api.carshop.dto.EmployeeDto;
import com.api.carshop.mappers.EmployeeMapper;
import com.api.carshop.models.EmployeeModel;
import com.api.carshop.repositories.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

    @Spy
    private EmployeeRepository employeeRepository;
    @Mock
    private EmployeeMapper employeeMapper;
    @InjectMocks
    @Spy
    private EmployeeServiceImpl employeeService;

    EmployeeDto employeeDto = EmployeeDto.builder()
            .name("Dev")
            .cpf("39254728594")
            .email("dev@dev.com")
            .phone("11972317483")
            .role("CTO")
            .build();

    EmployeeModel employeeModel = EmployeeModel.builder()
            .name("Dev")
            .id(1L)
            .cpf("39254728594")
            .email("dev@dev.com")
            .phone("11972317483")
            .role("CTO")
            .build();

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldValidateDataAndSaveEmployee(){
        when(employeeMapper.mapToDto(employeeModel)).thenReturn(employeeDto);
        when(employeeService.save(employeeMapper.mapToDto(employeeModel))).thenReturn(employeeDto);
        var result = employeeService.save(employeeDto);

        assertEquals(employeeDto, result);
        verify(employeeService, times(1)).save(employeeDto);
    }
}
