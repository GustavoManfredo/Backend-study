package com.api.carshop.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "productType")
@Getter @Setter
public class ProductTypeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_type", nullable = false, unique = true)
    private String type;

    @Column(name = "product_description", nullable = false)
    private String description;
}