package com.api.carshop.mappers;

import com.api.carshop.dto.ProductTypeDto;
import com.api.carshop.models.ProductTypeModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class ProductTypeMapper {

    public abstract ProductTypeDto mapToDto(ProductTypeModel productTypeModel);
    public abstract ProductTypeModel mapToModel(ProductTypeDto productTypeDto);

}
