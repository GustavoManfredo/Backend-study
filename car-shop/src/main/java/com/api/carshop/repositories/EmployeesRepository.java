package com.api.carshop.repositories;

import com.api.carshop.models.EmployeesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeesRepository extends JpaRepository<EmployeesModel, Long> {
    boolean existsByCpf(String cpf);
    boolean existsByEmail(String email);
    boolean existsByPhone(String phone);
}
