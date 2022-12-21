package com.api.carshop.repositories;

import com.api.carshop.models.CustomersModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomersRepository extends JpaRepository<CustomersModel, Long> {
    boolean existsByCpf(String cpf);
    boolean existsByCnpj(String cnpj);
    boolean existsByEmail(String email);
    boolean existsByPhone(String phone);
}
