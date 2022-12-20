package com.api.carshop.services;

import com.api.carshop.models.CustomersModel;
import com.api.carshop.repositories.CustomersRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    public boolean containsNumberInName(String customerName) {
        return customerName.matches(".*\\d+.*");
    }

    public boolean existsByCustomerCPF(String customerCPF) {
        if (customerCPF == null){
            return false;
        }
        return customersRepository.existsByCustomerCPF(customerCPF);
    }

    public boolean existsByCustomerCNPJ(String customerCNPJ) {
        if (customerCNPJ == null){
            return false;
        }
        return customersRepository.existsByCustomerCNPJ(customerCNPJ);
    }

    public boolean existsByCustomerEmail(String customerEmail) {
        return customersRepository.existsByCustomerEmail(customerEmail);
    }

    public boolean existsByCustomerPhone(String customerPhone) {
        return customersRepository.existsByCustomerPhone(customerPhone);
    }

    public List<CustomersModel> findAll() {
        return customersRepository.findAll();
    }

    public Optional<CustomersModel> findById(UUID id) {
        return customersRepository.findById(id);
    }

    @Transactional
    public void delete(CustomersModel customersModel) {
        customersRepository.delete(customersModel);
    }
}
