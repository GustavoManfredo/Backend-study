package com.api.carshop.mappers;

import com.api.carshop.dto.CustomerDto;
import com.api.carshop.models.CustomerModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class CustomerMapper {

    public abstract CustomerDto mapToDto(CustomerModel customerModel);
    public abstract CustomerModel mapToModel(CustomerDto customerDto);

}
