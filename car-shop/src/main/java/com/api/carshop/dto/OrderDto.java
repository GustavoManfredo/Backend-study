package com.api.carshop.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDto {
    private Long id;
    private Long customerId;
    private Long employeeId;
    private Integer quantityOrdered;
    private Float totalPrice;
    private String date;
    private String shipDate;
    private String status;
    private String comments;
}
