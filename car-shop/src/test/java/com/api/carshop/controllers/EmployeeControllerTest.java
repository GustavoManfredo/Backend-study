package com.api.carshop.controllers;

import com.api.carshop.client.EmployeeClient;
import com.api.carshop.dto.EmployeeDto;
import com.api.carshop.models.EmployeeModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class EmployeeControllerTest {

    @Autowired
    EmployeeClient employeeClient;

    EmployeeDto employeeDto;
    EmployeeModel employeeModel;
    EmployeeDto employeeDtoPut;

    @BeforeEach
    public void setup(){
        employeeDto = EmployeeDto.builder()
                .name("Dev")
                .cpf("39254728594")
                .email("dev@dev.com")
                .phone("11972317483")
                .role("CTO")
                .build();

        employeeModel = EmployeeModel.builder()
                .name("Dev")
                .cpf("39254728594")
                .email("dev@dev.com")
                .phone("11972317483")
                .role("CTO")
                .build();

        employeeDtoPut = EmployeeDto.builder()
                .name("Ricardo")
                .cpf("40050060070")
                .email("ricardo@dev.com")
                .phone("11940005000")
                .role("CEO")
                .build();
    }

    @Test
    public void shoulDoCRUD(){
        var saveEmployee = employeeClient.saveEmployee(employeeDto);
        employeeModel.setId(saveEmployee.getBody().getId());
        assertEquals(employeeModel.getCpf(), saveEmployee.getBody().getCpf());

        var getEmployee = employeeClient.getEmployeeById(employeeModel.getId());
        assertEquals(employeeModel.getId(), getEmployee.getBody().getId());
        assertEquals(employeeModel.getCpf(), getEmployee.getBody().getCpf());

        var updateEmployee = employeeClient.updateEmployee(employeeModel.getId(), employeeDtoPut);
        assertEquals(employeeModel.getId(), updateEmployee.getBody().getId());
        assertNotEquals(employeeDto.getName(), updateEmployee.getBody().getName());

        var deleteEmployee = employeeClient.deleteEmployee(employeeModel.getId());
        assertEquals("Employee deleted!", deleteEmployee.getBody());
    }

}