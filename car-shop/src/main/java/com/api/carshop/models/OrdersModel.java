package com.api.carshop.models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "orders")
@Data
public class OrdersModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToMany
    @JoinColumn(name = "customer_id")
    private List<CustomersModel> customers;

    @Column(name = "order_quantityOrdered", nullable = false)
    private Integer orderQuantityOrdered;

    @Column(name = "order_totalPrice", nullable = false)
    private Float orderTotalPrice;

    @Column(name = "order_date", nullable = false)
    private String orderDate;

    @Column(name = "order_shipDate", nullable = false)
    private String orderShipDate;

    @Column(name = "order_status", nullable = false)
    private String orderStatus;

    @Column(name = "order_comments")
    private String orderComents;

}