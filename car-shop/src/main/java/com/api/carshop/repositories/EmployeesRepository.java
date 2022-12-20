package com.api.carshop.repositories;

import com.api.carshop.models.EmployeesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EmployeesRepository extends JpaRepository<EmployeesModel, UUID> {
    boolean existsByEmployeeCPF(String employeeCPF);
    boolean existsByEmployeeEmail(String employeeEmail);
    boolean existsByEmployeePhone(String employeePhone);
}
