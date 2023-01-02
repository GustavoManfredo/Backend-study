package com.api.carshop.repositories;

import com.api.carshop.models.ProductTypeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductTypeRepository extends JpaRepository<ProductTypeModel, Long> {
    boolean existsByType(String type);
}
