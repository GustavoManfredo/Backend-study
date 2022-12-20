package com.api.carshop.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EmployeesDto {

    @NotBlank
    private String name;

    @NotBlank
    @Size(max = 16)
    private String phone;

    @NotBlank
    @Size(max = 11)
    private String cpf;

    @NotBlank
    @Size(max = 75)
    private String email;

    @NotBlank
    @Size(max = 75)
    private String jobTitle;

}
