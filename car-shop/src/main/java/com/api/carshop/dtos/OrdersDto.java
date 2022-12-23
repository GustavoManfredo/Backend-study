package com.api.carshop.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @JsonInclude(JsonInclude.Include.NON_NULL)
public class OrdersDto {
    @JsonIgnore
    private Long id;
    @NotNull
    private Long customerId;
    @NotNull
    private Long employeeId;
    @NotNull
    private Integer quantityOrdered;
    @NotNull
    private Float totalPrice;
    @NotBlank
    private String date;
    @Null
    private String shipDate;
    @NotBlank
    private String status;
    private String comments;

    private CustomersDto customer;
    private EmployeesDto employee;

}
