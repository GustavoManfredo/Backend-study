package com.api.carshop.services;

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
        return customersRepository.save(customersModel);
    }

    public boolean containsNumberInName(String name) {
        return name.matches(".*\\d+.*");
    }

    public boolean existsByCpf(String cpf) {
        if (cpf == null){
            return false;
        }
        return customersRepository.existsByCpf(cpf);
    }

    public boolean existsByCnpj(String cnpj) {
        if (cnpj == null){
            return false;
        }
        return customersRepository.existsByCnpj(cnpj);
    }

    public boolean existsByEmail(String email) {
        return customersRepository.existsByEmail(email);
    }

    public boolean existsByPhone(String phone) {
        return customersRepository.existsByPhone(phone);
    }

    public List<CustomersModel> findAll() {
        return customersRepository.findAll();
    }

    public Optional<CustomersModel> findById(Long id) {
        return customersRepository.findById(id);
    }

    @Transactional
    public void delete(CustomersModel customersModel) {
        customersRepository.delete(customersModel);
    }
}
