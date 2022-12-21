package com.api.carshop.services;

import com.api.carshop.exception.ApiRequestException;
import com.api.carshop.models.CustomersModel;
import com.api.carshop.repositories.CustomersRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomersService {

    final
    CustomersRepository customersRepository;

    public CustomersService(CustomersRepository customersRepository) {
        this.customersRepository = customersRepository;
    }

    @Transactional
    public CustomersModel save(CustomersModel customersModel) {
        if (containsNumberInName(customersModel.getName())){ throw new ApiRequestException("Invalid name!"); }
        if (existsByCpf(customersModel.getCpf())){ throw new ApiRequestException("This CPF is already registered in the database!"); }
        if (existsByCnpj(customersModel.getCnpj())){ throw new ApiRequestException("This CNPJ is already registered in the database!"); }
        if (existsByEmail(customersModel.getEmail())){ throw new ApiRequestException("This Email is already registered in the database!"); }
        if (existsByPhone(customersModel.getPhone())){ throw new ApiRequestException("This Phone is already registered in the database!"); }
        return customersRepository.save(customersModel);
    }

    @Transactional
    public CustomersModel update(CustomersModel customersModel) {
        if (containsNumberInName(customersModel.getName())){ throw new ApiRequestException("Invalid name!"); }
        return customersRepository.save(customersModel);
    }

    private boolean containsNumberInName(String name) {
        return name.matches(".*\\d+.*");
    }

    private boolean existsByCpf(String cpf) {
        if (cpf == null){
            return false;
        }
        return customersRepository.existsByCpf(cpf);
    }

    private boolean existsByCnpj(String cnpj) {
        if (cnpj == null){
            return false;
        }
        return customersRepository.existsByCnpj(cnpj);
    }

    private boolean existsByEmail(String email) {
        return customersRepository.existsByEmail(email);
    }

    private boolean existsByPhone(String phone) {
        return customersRepository.existsByPhone(phone);
    }

    public List<CustomersModel> findAll() {
        return customersRepository.findAll();
    }

    public Optional<CustomersModel> findById(Long id) {
        Optional<CustomersModel> customersModelOptional = customersRepository.findById(id);
        if (!customersModelOptional.isPresent()){ throw new ApiRequestException("Customer not found!"); }
        return customersRepository.findById(id);
    }

    @Transactional
    public void delete(CustomersModel customersModel) {
        customersRepository.delete(customersModel);
    }
}
