package com.api.carshop.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Employee")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cpf;
    private String phone;
    private String email;
    private String role;
}
