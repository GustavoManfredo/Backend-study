package com.api.carshop.services;

import com.api.carshop.dto.CustomerDto;
import com.api.carshop.exceptions.ApiRequestException;
import com.api.carshop.mappers.CustomerMapper;
import com.api.carshop.models.CustomerModel;
import com.api.carshop.repositories.CustomerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomerMapper mapper;

    @Transactional
    public CustomerDto save(CustomerDto customerDto) {
        final CustomerModel customerEntity = customerRepository.save(mapper.mapToModel(validateCustomer(customerDto)));
        return mapper.mapToDto(customerEntity);
    }

    @Transactional
    public CustomerDto update(CustomerDto customerDto, Long id) {
        final CustomerModel customerEntity = mapper.mapToModel(findById(id));
        customerDto.setId(customerEntity.getId());
        return mapper.mapToDto(customerRepository.save(mapper.mapToModel(customerDto)));
    }
    @Transactional
    public void deleteById(Long id){
        try{
            customerRepository.deleteById(id);
        }catch (Exception e){
            throw new ApiRequestException("Customer not found!");
        }
    }

    public CustomerDto findById(Long id) {
        return mapper.mapToDto(checkIfIdExists(id));
    }

    private CustomerModel checkIfIdExists(Long id){
        final Optional<CustomerModel> customerEntity =  customerRepository.findById(id);

        if (!customerEntity.isPresent()){
            throw new ApiRequestException("Customer not found!");
        }

        return customerEntity.get();
    }

    private CustomerDto validateCustomer(CustomerDto customerDto){
        customerDto.setCpf(validateCPF(customerDto.getCpf()));
        customerDto.setCnpj(validateCNPJ(customerDto.getCnpj()));
        customerDto.setPhone(validatePhone(customerDto.getPhone()));
        customerDto.setEmail(validateEmail(customerDto.getEmail()));
        customerDto.setPin(validateCEP(customerDto.getPin()));
        return customerDto;
    }

    private String validateCPF(String cpf){
        if (cpf == null){
            return null;
        }

        final String regex = "(\\d{3}).?(\\d{3}).?(\\d{3})-?(\\d{2})$";
        final String replacement = "$1.$2.$3-$4";

        if (!cpf.matches(regex) || customerRepository.existsByCpf(cpf.replaceAll(regex, replacement))){
            throw new ApiRequestException("Invalid CPF");
        }

        return cpf.replaceAll(regex, replacement);
    }

    private String validateCNPJ(String cnpj){

        if (cnpj == null){
            return null;
        }

        final String regex = "^([0-9]{2}[.]?)([0-9]{3}[.]?)([0-9]{3}/?)([0-9]{4}-?)([0-9]{2})$";
        final String replacement = "$1.$2.$3/$4-$5";

        if (!cnpj.matches(regex) || customerRepository.existsByCnpj(cnpj.replaceAll(regex, replacement)) || customerRepository.existsByCnpj(cnpj)){
            throw new ApiRequestException("Invalid CNPJ");
        }

        return cnpj.replaceAll(regex, replacement);
    }

    private String validatePhone(String phone){
        final String regex = "^(\\(?[0-9]{2}\\)?)? ?([0-9]{4,5})-?([0-9]{4})$";
        final String replacement = "($1)$2-$3";

        if (!phone.matches(regex) || customerRepository.existsByPhone(phone) || customerRepository.existsByPhone(phone.replaceAll(regex, replacement))){
            throw new ApiRequestException("Invalid phone!");
        }

        return phone.replaceAll(regex, replacement);
    }

    private String validateEmail(String email){
        final String regex = "^((?!\\.)[\\w-_.]*[^.])(@\\w+)(\\.\\w+(\\.\\w+)?[^.\\W])$";

        if (!email.matches(regex) || customerRepository.existsByEmail(email)){
            throw new ApiRequestException("Invalid Email");
        }

        return email;
    }

    private String validateCEP(String cep){
        if (cep == null){
            return null;
        }

        final String regex = "^(\\d{0,5}|\\d{5}-\\d{0,3})(\\d{0,3})$";
        final String replacement = "$1-$2";

        if (!cep.matches(regex)){
            throw new ApiRequestException("Invalid CEP!");
        }

        return cep.replaceAll(regex, replacement);
    }
}
