package com.api.carshop.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductsDto {

    @JsonIgnore
    private Long id;
    @NotBlank
    private String name;
    @NotNull
    private Integer manufactureYear;
    @NotBlank
    private String brand;
    private Long productTypeId;
    @NotBlank
    private String description;
    @NotNull
    private Integer stock;
    @NotNull
    private Float price;
    private ProductTypeDto productType;
}
