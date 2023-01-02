package com.api.carshop.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "Customer")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cnpj;
    private String cpf;
    private String phone;
    private String email;
    private String address;
    private String city;
    private String state;
    private String pin;
    @OneToMany(mappedBy = "customer")
    private List<OrderModel> order;
}
