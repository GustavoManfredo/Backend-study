package com.api.carshop.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDto {
    private Long id;
    private String name;
    private Integer manufactureYear;
    private String brand;
    private String description;
    private Integer stock;
    private Float price;
    private Long typeId;
    private ProductTypeDto productType;
}
