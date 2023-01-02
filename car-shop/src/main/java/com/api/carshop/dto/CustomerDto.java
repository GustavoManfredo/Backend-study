package com.api.carshop.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerDto {
    private Long id;
    private String name;
    private String cnpj;
    private String cpf;
    private String phone;
    private String email;
    private String address;
    private String city;
    private String state;
    private String pin;
}
