package com.api.carshop.models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "employees")
@Data
public class EmployeesModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "employee_name", nullable = false)
    private String employeeName;

    @Column(name = "employee_phone", nullable = false, unique = true, length = 16)
    private String employeePhone;

    @Column(name = "employee_cpf", nullable = false, unique = true, length = 11)
    private String employeeCPF;

    @Column(name = "employee_email", nullable = false, unique = true, length = 75)
    private String employeeEmail;

    @Column(name = "employee_jobTitle", nullable = false, length = 75)
    private String employeeJobTitle;

}