package com.api.carshop.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Orders")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class OrderModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "customer")
    private CustomerModel customer;
    @ManyToOne
    @JoinColumn(name = "employee")
    private EmployeeModel employee;
    private Integer quantityOrdered;
    private Float totalPrice;
    private String date;
    private String shipDate;
    private String status;
    private String comments;
}
