package com.api.carshop.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductTypeDto {
    private Long id;
    private String type;
    private String description;
}
