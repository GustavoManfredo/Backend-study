package com.api.carshop.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "orders")
@Getter @Setter
public class OrdersModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomersModel customersModel;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private EmployeesModel employeesModels;

    @Column(name = "order_quantityOrdered", nullable = false)
    private Integer quantityOrdered;

    @Column(name = "order_totalPrice", nullable = false)
    private Float totalPrice;

    @Column(name = "order_date", nullable = false)
    private String date;

    @Column(name = "order_shipDate", nullable = false)
    private String shipDate;

    @Column(name = "order_status", nullable = false)
    private String status;

    @Column(name = "order_comments")
    private String comments;

}