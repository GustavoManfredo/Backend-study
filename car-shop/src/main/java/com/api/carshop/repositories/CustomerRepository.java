package com.api.carshop.repositories;

import com.api.carshop.models.CustomerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerModel, Long> {
    boolean existsByCpf(String cpf);
    boolean existsByCnpj(String cnpj);
    boolean existsByPhone(String phone);
    boolean existsByEmail(String email);
}
