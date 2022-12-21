package com.api.carshop.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "productType")
@Getter @Setter
public class ProductTypeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "productType")
    private List<ProductsModel> products;

    @Column(name = "product_type", nullable = false, unique = true)
    private String type;

    @Column(name = "product_description")
    private String description;
}