package com.api.carshop.services;

import com.api.carshop.dto.CustomerDto;
import com.api.carshop.dto.OrderDto;
import com.api.carshop.exceptions.ApiRequestException;
import com.api.carshop.mappers.CustomerMapper;
import com.api.carshop.mappers.OrderMapper;
import com.api.carshop.models.CustomerModel;
import com.api.carshop.repositories.CustomerRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper mapper;
    private final OrderMapper orderMapper;
    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper mapper, OrderMapper orderMapper) {
        this.customerRepository = customerRepository;
        this.mapper = mapper;
        this.orderMapper = orderMapper;
    }

    @Override
    @Transactional
    public CustomerDto save(CustomerDto customerDto) {
        final CustomerModel customerEntity = customerRepository.save(mapper.mapToModel(validateCustomer(customerDto)));
        return mapper.mapToDto(customerEntity);
    }

    @Override
    @Transactional
    public CustomerDto update(CustomerDto customerDto, Long id) {
        final CustomerModel customerEntity = mapper.mapToModel(findById(id));
        customerDto.setId(customerEntity.getId());
        return mapper.mapToDto(customerRepository.save(mapper.mapToModel(customerDto)));
    }
    @Override
    @Transactional
    public void deleteById(Long id){
        try{
            customerRepository.deleteById(id);
        }catch (Exception e){
            throw new ApiRequestException("Customer not found!");
        }
    }
    @Override
    public CustomerDto findById(Long id) {
        CustomerModel customerEntity = checkIfIdExists(id);
        CustomerDto customer = mapper.mapToDto(customerEntity);

        if (saveOrders(customerEntity) != null){
            customer.setOrders(saveOrders(customerEntity));
        }

        return customer;
    }

    private CustomerModel checkIfIdExists(Long id){
        final Optional<CustomerModel> customerEntity =  customerRepository.findById(id);

        if (!customerEntity.isPresent()){
            throw new ApiRequestException("Customer not found!");
        }

        return customerEntity.get();
    }

    private List<OrderDto> saveOrders(CustomerModel customerModel){

        if (customerModel.getOrder() == null){
            return null;
        }

        List<OrderDto> orders = new ArrayList<>();
        customerModel.getOrder().forEach(order -> orders.add(orderMapper.mapToDto(order)));
        return orders;
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

        final String regex = "^\\d{3}\\d{3}\\d{3}\\d{2}$";


        if (cpf == null){
            return null;
        }

        if (!cpf.matches(regex) || customerRepository.existsByCpf(cpf)){
            throw new ApiRequestException("CPF Invalid!");
        }

        return cpf;
    }

    private String validateCNPJ(String cnpj){

        final String regex = "^\\d{2}\\d{3}\\d{3}\\d{4}\\d{2}$";

        if (cnpj == null){
            return null;
        }

        if (!cnpj.matches(regex) || customerRepository.existsByCnpj(cnpj)){
            throw new ApiRequestException("Invalid CNPJ");
        }

        return cnpj;
    }

    private String validatePhone(String phone){

        final String regex = "^\\d{2}\\d{1}\\d{4}\\d{4}$";

        if (!phone.matches(regex) || customerRepository.existsByPhone(phone)){
            throw new ApiRequestException("Invalid phone!");
        }

        return phone;
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

        if (!cep.matches(regex)){
            throw new ApiRequestException("Invalid CEP!");
        }

        return cep;
    }
}
