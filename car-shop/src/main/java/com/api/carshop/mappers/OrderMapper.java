package com.api.carshop.mappers;

import com.api.carshop.dto.CustomerDto;
import com.api.carshop.dto.EmployeeDto;
import com.api.carshop.dto.OrderDto;
import com.api.carshop.models.OrderModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {CustomerDto.class, EmployeeDto.class})
public abstract class OrderMapper {

    public abstract OrderDto mapToDto(OrderModel orderModel);

    @Mapping(source = "customerId", target = "customer.id")
    @Mapping(source = "employeeId", target = "employee.id")
    public abstract OrderModel mapToModel(OrderDto orderDto);
}
