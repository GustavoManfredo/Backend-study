package com.api.carshop.services;

import com.api.carshop.models.EmployeesModel;
import com.api.carshop.repositories.EmployeesRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeesService {

    final
    EmployeesRepository employeesRepository;

    public EmployeesService(EmployeesRepository employeesRepository) {
        this.employeesRepository = employeesRepository;
    }

    @Transactional
    public EmployeesModel save(EmployeesModel employeesModel) {
        return employeesRepository.save(employeesModel);
    }

    public boolean existsByEmployeeCPF(String employeeCPF) {
        if(employeeCPF == null){ return false; }
        return employeesRepository.existsByEmployeeCPF(employeeCPF);
    }

    public boolean existsByEmployeePhone(String employeePhone) {
        return employeesRepository.existsByEmployeePhone(employeePhone);
    }

    public boolean existsByEmployeeEmail(String employeeEmail) {
        return employeesRepository.existsByEmployeeEmail(employeeEmail);
    }

    public List<EmployeesModel> findAll(){
        return employeesRepository.findAll();
    }

    public Optional<EmployeesModel> findById(UUID id) {
        return employeesRepository.findById(id);
    }

    @Transactional
    public void delete(EmployeesModel employeesModel) {
        employeesRepository.delete(employeesModel);
    }
}
