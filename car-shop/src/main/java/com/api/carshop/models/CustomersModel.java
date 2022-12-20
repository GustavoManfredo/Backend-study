package com.api.carshop.models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "customers")
@Data
public class CustomersModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "customer_name",nullable = false, unique = false)
    private String customerName;

    @Column(name = "customer_cnpj", unique = true, length = 14)
    private String customerCNPJ;

    @Column(name = "customer_cpf", unique = true, length = 11)
    private String customerCPF;

    @Column(name = "customer_phone", nullable = false, unique = true, length = 16)
    private String customerPhone;

    @Column(name = "customer_email", nullable = false, unique = true)
    private String customerEmail;

    @Column(name = "customer_address", nullable = false)
    private String customerAddress;

    @Column(name = "customer_city", nullable = false)
    private String customerCity;

    @Column(name = "customer_state", nullable = false)
    private String customerState;

    @Column(name = "customer_pin", nullable = false)
    private String customerPostalCode;

}