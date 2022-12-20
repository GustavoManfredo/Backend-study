package com.api.carshop.services;

import com.api.carshop.models.CustomersModel;
import com.api.carshop.repositories.CustomersRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class CustomersService {

    final
    CustomersRepository customersRepository;

    public CustomersService(CustomersRepository customersRepository) {
        this.customersRepository = customersRepository;
    }

    public CustomersModel save(CustomersModel customersModel) {
        return customersRepository.save(customersModel);
    }
}
