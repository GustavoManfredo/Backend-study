package com.api.carshop.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "products")
@Getter @Setter
public class ProductsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name", nullable = false)
    private String name;

    @Column(name = "prodcut_manufactureYear", nullable = false)
    private Integer manufactureYear;

    @Column(name = "product_brand", nullable = false, length = 50)
    private String brand;

    @ManyToOne
    @JoinColumn(name = "product_type")
    private ProductTypeModel productType;

    @Column(name = "product_description", nullable = false)
    private String description;

    @Column(name = "product_stock", nullable = false)
    private Integer stock;

    @Column(name = "product_price", nullable = false)
    private Float price;

}