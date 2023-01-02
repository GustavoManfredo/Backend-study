package com.api.carshop.mappers;

import com.api.carshop.dto.EmployeeDto;
import com.api.carshop.models.EmployeeModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class EmployeeMapper {
    public abstract EmployeeDto mapToDto(EmployeeModel employeeModel);
    public abstract EmployeeModel mapToModel(EmployeeDto employeeDto);
}
