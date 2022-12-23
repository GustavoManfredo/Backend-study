package com.api.carshop.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @Builder
public class ProductTypeDto {
    @JsonIgnore
    private Long id;
    @NotBlank
    private String type;
    private String description;
}
