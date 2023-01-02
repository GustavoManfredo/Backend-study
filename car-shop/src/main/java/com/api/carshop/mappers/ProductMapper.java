package com.api.carshop.mappers;

import com.api.carshop.dto.ProductDto;
import com.api.carshop.models.ProductModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = ProductTypeMapper.class)
public abstract class ProductMapper {

    public abstract ProductDto mapToDto(ProductModel productModel);

    @Mapping(source = "typeId", target = "productType.id")
    public abstract ProductModel mapToModel(ProductDto productDto);

}
