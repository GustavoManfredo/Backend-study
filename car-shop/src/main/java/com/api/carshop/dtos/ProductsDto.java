package com.api.carshop.dtos;

import com.api.carshop.models.ProductTypeModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProductsDto {

    @NotBlank
    private String name;
    @NotNull
    private Integer manufactureYear;
    @NotBlank
    private String brand;
    private ProductTypeModel productTypeId;
    @NotBlank
    private String description;
    @NotNull
    private Integer stock;
    @NotNull
    private Float price;
}
