package com.api.carshop.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "orders")
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToMany
    @JoinColumn(name = "customer_id")
    private List<Customers> customers;

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

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public List<Customers> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customers> customers) {
        this.customers = customers;
    }

    public Integer getOrderQuantityOrdered() {
        return orderQuantityOrdered;
    }

    public void setOrderQuantityOrdered(Integer orderQuantityOrdered) {
        this.orderQuantityOrdered = orderQuantityOrdered;
    }

    public Float getOrderTotalPrice() {
        return orderTotalPrice;
    }

    public void setOrderTotalPrice(Float orderTotalPrice) {
        this.orderTotalPrice = orderTotalPrice;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderShipDate() {
        return orderShipDate;
    }

    public void setOrderShipDate(String orderShipDate) {
        this.orderShipDate = orderShipDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderComents() {
        return orderComents;
    }

    public void setOrderComents(String orderComents) {
        this.orderComents = orderComents;
    }
}
