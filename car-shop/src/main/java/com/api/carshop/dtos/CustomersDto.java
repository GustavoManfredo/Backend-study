package com.api.carshop.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CustomersDto {

    @NotBlank
    private String name;
    @Size(max = 14)
    private String cnpj;
    @Size(max = 11)
    private String cpf;
    @NotBlank
    @Size(max = 16)
    private String phone;
    @NotBlank
    private String email;
    @NotBlank
    private String address;
    @NotBlank
    private String city;
    @NotBlank
    private String state;
    @NotBlank
    private String postalCode;

}
