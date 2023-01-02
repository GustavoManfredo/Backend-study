package com.api.carshop.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "product_type")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductTypeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String description;
}
