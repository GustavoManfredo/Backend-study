package com.api.carshop.repositories;

import com.api.carshop.models.OrdersModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends JpaRepository<OrdersModel, Long> {

}
