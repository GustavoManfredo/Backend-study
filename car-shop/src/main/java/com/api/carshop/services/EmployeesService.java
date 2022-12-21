package com.api.carshop.services;

import com.api.carshop.exception.ApiRequestException;
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
        if (containsNumberInName(employeesModel.getName())){ throw new ApiRequestException("Invalid name!"); }
        if (existsByCpf(employeesModel.getCpf())){ throw new ApiRequestException("This CPF is already registered in the database!"); }
        if (existsByEmail(employeesModel.getEmail())){ throw new ApiRequestException("This Email is already registered in the database!"); }
        if (existsByPhone(employeesModel.getPhone())){ throw new ApiRequestException("This Phone is already registered in the database!"); }
        return employeesRepository.save(employeesModel);
    }

    @Transactional
    public EmployeesModel update(EmployeesModel employeesModel) {
        if (containsNumberInName(employeesModel.getName())){ throw new ApiRequestException("Invalid name!"); }
        return employeesRepository.save(employeesModel);
    }

    private boolean containsNumberInName(String name) {
        return name.matches(".*\\d+.*");
    }

    private boolean existsByCpf(String cpf) {
        if(cpf == null){ return false; }
        return employeesRepository.existsByCpf(cpf);
    }

    private boolean existsByPhone(String phone) {
        return employeesRepository.existsByPhone(phone);
    }

    private boolean existsByEmail(String email) {
        return employeesRepository.existsByEmail(email);
    }

    public List<EmployeesModel> findAll(){
        return employeesRepository.findAll();
    }

    public Optional<EmployeesModel> findById(Long id) {
        Optional<EmployeesModel> employeesModelOptional = employeesRepository.findById(id);
        if (!employeesModelOptional.isPresent()){ throw new ApiRequestException("Employee not found!"); }
        return employeesRepository.findById(id);
    }

    @Transactional
    public void delete(EmployeesModel employeesModel) {
        employeesRepository.delete(employeesModel);
    }
}
