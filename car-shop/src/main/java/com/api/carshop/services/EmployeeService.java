package com.api.carshop.services;

import com.api.carshop.dto.EmployeeDto;

public interface EmployeeService {
     EmployeeDto save(EmployeeDto employeeDto);
     EmployeeDto update(EmployeeDto employeeDto, Long id);
     void deleteById(Long id);
     EmployeeDto findById(Long id);
}
