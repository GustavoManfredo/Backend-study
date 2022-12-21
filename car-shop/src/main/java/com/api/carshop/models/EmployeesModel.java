package com.api.carshop.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "employees")
@Getter @Setter
public class EmployeesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "employeeId")
    private List<OrdersModel> ordersId;

    @Column(name = "employee_name", nullable = false)
    private String name;

    @Column(name = "employee_phone", nullable = false, unique = true, length = 16)
    private String phone;

    @Column(name = "employee_cpf", nullable = false, unique = true, length = 11)
    private String cpf;

    @Column(name = "employee_email", nullable = false, unique = true, length = 75)
    private String email;

    @Column(name = "employee_jobTitle", nullable = false, length = 75)
    private String jobTitle;

}