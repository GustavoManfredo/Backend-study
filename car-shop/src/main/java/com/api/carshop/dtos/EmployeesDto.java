package com.api.carshop.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @Builder
public class EmployeesDto {
    @JsonIgnore
    private Long id;

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
