package com.api.carshop.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "customers")
@Getter @Setter
public class CustomersModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    @JoinColumn(name = "orders_id")
    private List<OrdersModel> ordersModel;

    @Column(name = "customer_name",nullable = false, unique = false)
    private String name;

    @Column(name = "customer_cnpj", unique = true, length = 14)
    private String cnpj;

    @Column(name = "customer_cpf", unique = true, length = 11)
    private String cpf;

    @Column(name = "customer_phone", nullable = false, unique = true, length = 16)
    private String phone;

    @Column(name = "customer_email", nullable = false, unique = true)
    private String email;

    @Column(name = "customer_address", nullable = false)
    private String address;

    @Column(name = "customer_city", nullable = false)
    private String city;

    @Column(name = "customer_state", nullable = false)
    private String state;

    @Column(name = "customer_pin", nullable = false)
    private String postalCode;
}