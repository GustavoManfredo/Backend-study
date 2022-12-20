package com.api.carshop.repositories;

import com.api.carshop.models.CustomersModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CustomersRepository extends JpaRepository<CustomersModel, UUID> {
    boolean existsByCustomerCPF(String customerCPF);

    boolean existsByCustomerCNPJ(String customerCNPJ);

    boolean existsByCustomerEmail(String customerEmail);

    boolean existsByCustomerPhone(String customerPhone);
}
