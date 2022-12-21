package com.api.carshop.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProductTypeDto {
    @NotBlank
    private String type;
    private String description;
}
