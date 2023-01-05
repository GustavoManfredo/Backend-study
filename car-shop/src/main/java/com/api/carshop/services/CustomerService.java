package com.api.carshop.services;

import com.api.carshop.dto.CustomerDto;

public interface CustomerService {
    CustomerDto save(CustomerDto customerDto);
    CustomerDto update(CustomerDto customerDto, Long id);
    void deleteById(Long id);
    CustomerDto findById(Long id);
}
