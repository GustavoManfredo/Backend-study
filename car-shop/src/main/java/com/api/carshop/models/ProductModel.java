package com.api.carshop.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "product")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer manufactureYear;
    private String brand;
    private String description;
    private Integer stock;
    private Float price;

    @ManyToOne
    @JoinColumn(name = "type")
    private ProductTypeModel productType;
}
