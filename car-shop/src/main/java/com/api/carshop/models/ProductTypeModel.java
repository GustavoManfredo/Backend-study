package com.api.carshop.models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "productType")
@Data
public class ProductTypeModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "product_line", nullable = false, unique = true)
    private String productLine;

    @Column(name = "product_description", nullable = false)
    private String productDescription;

}