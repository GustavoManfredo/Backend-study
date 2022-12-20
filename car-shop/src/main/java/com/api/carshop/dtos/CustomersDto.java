package com.api.carshop.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CustomersDto {

    @NotBlank
    private String customerName;
    @Size(max = 14)
    private String customerCNPJ;
    @Size(max = 11)
    private String customerCPF;
    @NotBlank
    @Size(max = 16)
    private String customerPhone;
    @NotBlank
    private String customerEmail;
    @NotBlank
    private String customerAddress;
    @NotBlank
    private String customerCity;
    @NotBlank
    private String customerState;
    @NotBlank
    private String customerPostalCode;

}
