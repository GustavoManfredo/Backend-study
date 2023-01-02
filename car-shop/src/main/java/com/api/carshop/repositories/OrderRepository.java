package com.api.carshop.repositories;

import com.api.carshop.models.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderModel, Long> {
}
