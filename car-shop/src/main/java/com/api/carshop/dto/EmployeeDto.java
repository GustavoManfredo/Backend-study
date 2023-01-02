package com.api.carshop.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeDto {
    private Long id;
    private String name;
    private String cpf;
    private String phone;
    private String email;
    private String role;
}
