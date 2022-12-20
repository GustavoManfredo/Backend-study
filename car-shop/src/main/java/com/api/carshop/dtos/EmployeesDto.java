package com.api.carshop.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class EmployeesDto {

    @NotBlank
    private String employeeName;

    @NotBlank
    @Size(max = 16)
    private String employeePhone;

    @NotBlank
    @Size(max = 11)
    private String employeeCPF;

    @NotBlank
    @Size(max = 75)
    private String employeeEmail;

    @NotBlank
    @Size(max = 75)
    private String employeeJobTitle;

}
