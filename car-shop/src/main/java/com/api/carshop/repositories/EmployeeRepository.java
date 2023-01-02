package com.api.carshop.repositories;

import com.api.carshop.models.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeModel, Long> {
    boolean existsByCpf(String cpf);
    boolean existsByPhone(String phone);
    boolean existsByEmail(String email);
}
