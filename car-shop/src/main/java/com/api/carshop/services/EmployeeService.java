package com.api.carshop.services;

import com.api.carshop.dto.EmployeeDto;
import com.api.carshop.exceptions.ApiRequestException;
import com.api.carshop.mappers.EmployeeMapper;
import com.api.carshop.models.EmployeeModel;
import com.api.carshop.repositories.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EmployeeMapper mapper;

    @Transactional
    public EmployeeDto save(EmployeeDto employeeDto) {
        final EmployeeModel employeeEntity = employeeRepository.save(mapper.mapToModel(validateEmployee(employeeDto)));
        return mapper.mapToDto(employeeEntity);
    }

    @Transactional
    public EmployeeDto update(EmployeeDto employeeDto, Long id){
        final EmployeeModel employeeEntity = mapper.mapToModel(findById(id));
        employeeDto.setId(employeeEntity.getId());
        return mapper.mapToDto(employeeRepository.save(mapper.mapToModel(employeeDto)));
    }

    @Transactional
    public void deleteById(Long id){
        try{
            employeeRepository.deleteById(id);
        } catch (Exception e) {
            throw new ApiRequestException("Employee not found!");
        }
    }

    public EmployeeDto findById(Long id){
        return mapper.mapToDto(checkIfIdExists(id));
    }

    private EmployeeModel checkIfIdExists(Long id){
        final Optional<EmployeeModel> employeeEntity = employeeRepository.findById(id);

        if (!employeeEntity.isPresent()){
            throw new ApiRequestException("Employee not found!");
        }

        return employeeEntity.get();
    }

    private EmployeeDto validateEmployee(EmployeeDto employeeDto){
        employeeDto.setCpf(validateCPF(employeeDto.getCpf()));
        employeeDto.setPhone(validatePhone(employeeDto.getPhone()));
        employeeDto.setEmail(validateEmail(employeeDto.getEmail()));
        return employeeDto;
    }

    private String validateCPF(String cpf){

        final String regex = "(\\d{3}).?(\\d{3}).?(\\d{3})-?(\\d{2})$";
        final String replacement = "$1.$2.$3-$4";

        if (!cpf.matches(regex) || employeeRepository.existsByCpf(cpf.replaceAll(regex, replacement))){
            throw new ApiRequestException("Invalid CPF");
        }

        return cpf.replaceAll(regex, replacement);
    }

    private String validatePhone(String phone){
        final String regex = "^(\\(?[0-9]{2}\\)?)? ?([0-9]{4,5})-?([0-9]{4})$";
        final String replacement = "($1)$2-$3";

        if (!phone.matches(regex) || employeeRepository.existsByPhone(phone.replaceAll(regex, replacement))){
            throw new ApiRequestException("Invalid phone!");
        }

        return phone.replaceAll(regex, replacement);
    }

    private String validateEmail(String email){
        final String regex = "^((?!\\.)[\\w-_.]*[^.])(@\\w+)(\\.\\w+(\\.\\w+)?[^.\\W])$";

        if (!email.matches(regex) || employeeRepository.existsByEmail(email)){
            throw new ApiRequestException("Invalid Email");
        }

        return email;
    }
}
