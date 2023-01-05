package com.api.carshop.controllers;

import com.api.carshop.client.CustomerClient;
import com.api.carshop.client.EmployeeClient;
import com.api.carshop.client.OrderClient;
import com.api.carshop.dto.CustomerDto;
import com.api.carshop.dto.EmployeeDto;
import com.api.carshop.dto.OrderDto;
import com.api.carshop.mappers.CustomerMapper;
import com.api.carshop.mappers.EmployeeMapper;
import com.api.carshop.models.OrderModel;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class OrderControllerTest {

    @Autowired
    OrderClient orderClient;

    @Autowired
    CustomerClient customerClient;

    @Autowired
    EmployeeClient employeeClient;

    @Autowired
    CustomerMapper customerMapper;

    @Autowired
    EmployeeMapper employeeMapper;

    OrderDto orderDto;
    OrderModel orderModel;
    OrderDto orderDtoPut;
    CustomerDto customer;
    EmployeeDto employee;

    @BeforeEach
    void setup(){

        customer = CustomerDto.builder()
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

        employee = EmployeeDto.builder()
                .name("Dev")
                .cpf("39254728594")
                .email("dev@dev.com")
                .phone("11972317483")
                .role("CTO")
                .build();

        var createCustomer = customerClient.saveCustomer(customer);
        assertEquals(HttpStatus.CREATED, createCustomer.getStatusCode());

        var createEmployee = employeeClient.saveEmployee(employee);
        assertEquals(HttpStatus.CREATED, createEmployee.getStatusCode());

        orderDto = OrderDto.builder()
                .customerId(createCustomer.getBody().getId())
                .employeeId(createEmployee.getBody().getId())
                .totalPrice(950.99F)
                .comments("Fragile!")
                .status("On Hold")
                .quantityOrdered(30)
                .build();

        orderDtoPut = OrderDto.builder()
                .customerId(createCustomer.getBody().getId())
                .employeeId(createEmployee.getBody().getId())
                .totalPrice(3500.99F)
                .comments("Glass fragile!")
                .status("Shipped")
                .quantityOrdered(90)
                .build();

        orderModel = OrderModel.builder()
                .customer(customerMapper.mapToModel(createCustomer.getBody()))
                .employee(employeeMapper.mapToModel(createEmployee.getBody()))
                .totalPrice(950.99F)
                .comments("Fragile!")
                .status("On Hold")
                .quantityOrdered(30)
                .build();
    }

    @Test
    public void shouldDoCRUD(){
        var saveOrder = orderClient.saveOrder(orderDto);
        orderModel.setId(saveOrder.getBody().getId());
        assertEquals(HttpStatus.CREATED, saveOrder.getStatusCode());
        assertNotNull(saveOrder.getBody());

        var getOrderById = orderClient.getOrder(orderModel.getId());
        assertEquals(HttpStatus.OK, getOrderById.getStatusCode());
        assertNotNull(getOrderById.getBody());

        var updateOrder = orderClient.updateOrder(orderModel.getId(), orderDtoPut);
        assertEquals(HttpStatus.OK, updateOrder.getStatusCode());
        assertNotNull(updateOrder.getBody());
        assertEquals(orderModel.getId(), updateOrder.getBody().getId());

        var deleteOrder = orderClient.deleteOrder(orderModel.getId());
        assertEquals(HttpStatus.OK, deleteOrder.getStatusCode());
        assertEquals("Order deleted", deleteOrder.getBody());

        customerClient.deleteCustomer(orderDto.getCustomerId());
        employeeClient.deleteEmployee(orderDto.getEmployeeId());
    }

}