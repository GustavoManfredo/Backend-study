package com.api.carshop.dtos;

import com.api.carshop.models.CustomersModel;
import com.api.carshop.models.EmployeesModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class OrdersDto {

    private CustomersModel customerId;
    private EmployeesModel employeeId;
    @NotNull
    private Integer quantityOrdered;
    @NotNull
    private Float totalPrice;
    @NotBlank
    private String date;
    private String shipDate;
    @NotBlank
    private String status;
    private String comments;

}
