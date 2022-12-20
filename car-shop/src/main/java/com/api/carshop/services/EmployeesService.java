package com.api.carshop.services;

import com.api.carshop.models.EmployeesModel;
import com.api.carshop.repositories.EmployeesRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public boolean existsByCpf(String cpf) {
        if(cpf == null){ return false; }
        return employeesRepository.existsByCpf(cpf);
    }

    public boolean existsByPhone(String phone) {
        return employeesRepository.existsByPhone(phone);
    }

    public boolean existsByEmail(String email) {
        return employeesRepository.existsByEmail(email);
    }

    public List<EmployeesModel> findAll(){
        return employeesRepository.findAll();
    }

    public Optional<EmployeesModel> findById(Long id) {
        return employeesRepository.findById(id);
    }

    @Transactional
    public void delete(EmployeesModel employeesModel) {
        employeesRepository.delete(employeesModel);
    }
}
