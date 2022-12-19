package com.api.carshop.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "products")
public class Products implements Serializable {
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
    @JoinColumn(name = "product_type")
    private ProductLines productLines;

    @Column(name = "product_description", nullable = false)
    private String productDescription;

    @Column(name = "product_stock", nullable = false)
    private Integer productStock;

    @Column(name = "product_price", nullable = false)
    private Float productPrice;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getProductManufactureYear() {
        return productManufactureYear;
    }

    public void setProductManufactureYear(Integer productManufactureYear) {
        this.productManufactureYear = productManufactureYear;
    }

    public String getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }

    public ProductLines getProductLines() {
        return productLines;
    }

    public void setProductLines(ProductLines productLines) {
        this.productLines = productLines;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Integer getProductStock() {
        return productStock;
    }

    public void setProductStock(Integer productStock) {
        this.productStock = productStock;
    }

    public Float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Float productPrice) {
        this.productPrice = productPrice;
    }
}
