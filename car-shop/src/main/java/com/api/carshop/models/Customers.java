package com.api.carshop.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "customers")
public class Customers implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "customer_name",nullable = false, unique = false, length = 50)
    private String customerName;

    @Column(name = "customer_cnpj", unique = true, length = 14)
    private String customerCNPJ;

    @Column(name = "customer_cpf", unique = true, length = 11)
    private String customerCPF;

    @Column(name = "customer_phone", nullable = false, unique = true, length = 14)
    private String customerPhone;

    @Column(name = "customer_email", nullable = false, unique = true, length = 75)
    private String customerEmail;

    @Column(name = "customer_address", nullable = false, length = 75)
    private String customerAddress;

    @Column(name = "customer_city", nullable = false, length = 50)
    private String customerCity;

    @Column(name = "customer_state", nullable = false, length = 50)
    private String customerState;

    @Column(name = "customer_pin", nullable = false, length = 20)
    private String customerPostalCode;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerCNPJ() {
        return customerCNPJ;
    }

    public void setCustomerCNPJ(String customerCNPJ) {
        this.customerCNPJ = customerCNPJ;
    }

    public String getCustomerCPF() {
        return customerCPF;
    }

    public void setCustomerCPF(String customerCPF) {
        this.customerCPF = customerCPF;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerCity() {
        return customerCity;
    }

    public void setCustomerCity(String customerCity) {
        this.customerCity = customerCity;
    }

    public String getCustomerState() {
        return customerState;
    }

    public void setCustomerState(String customerState) {
        this.customerState = customerState;
    }

    public String getCustomerPostalCode() {
        return customerPostalCode;
    }

    public void setCustomerPostalCode(String customerPostalCode) {
        this.customerPostalCode = customerPostalCode;
    }
}
