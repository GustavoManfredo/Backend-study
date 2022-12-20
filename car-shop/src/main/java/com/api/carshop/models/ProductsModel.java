package com.api.carshop.models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "products")
@Data
public class ProductsModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "prodcut_manufactureYear", nullable = false)
    private Integer productManufactureYear;

    @Column(name = "product_brand", nullable = false, length = 50)
    private String productBrand;

    @ManyToOne
    @JoinColumn(name = "product_type", referencedColumnName = "product_type")
    private ProductTypeModel productTypeModel;

    @Column(name = "product_description", nullable = false)
    private String productDescription;

    @Column(name = "product_stock", nullable = false)
    private Integer productStock;

    @Column(name = "product_price", nullable = false)
    private Float productPrice;

}