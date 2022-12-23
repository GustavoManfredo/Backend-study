package com.api.carshop.services;

import com.api.carshop.dtos.CustomersDto;
import com.api.carshop.exception.ApiRequestException;
import com.api.carshop.models.CustomersModel;
import com.api.carshop.repositories.CustomersRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomersService {

    final
    CustomersRepository customersRepository;

    public CustomersService(CustomersRepository customersRepository) {
        this.customersRepository = customersRepository;
    }

    @Transactional
    public CustomersDto save(CustomersDto customersDto) {
        if (containsNumberInName(customersDto.getName())){ throw new ApiRequestException("Invalid name!"); }
        if (existsByCpf(customersDto.getCpf())){ throw new ApiRequestException("This CPF is already registered in the database!"); }
        if (existsByCnpj(customersDto.getCnpj())){ throw new ApiRequestException("This CNPJ is already registered in the database!"); }
        if (existsByEmail(customersDto.getEmail())){ throw new ApiRequestException("This Email is already registered in the database!"); }
        if (existsByPhone(customersDto.getPhone())){ throw new ApiRequestException("This Phone is already registered in the database!"); }
        return mapModelToDto(customersRepository.save(mapDtoToModel(customersDto)));
    }

    @Transactional
    public CustomersDto update(CustomersDto customersDto, Long id) {
        Optional<CustomersModel> customersModelOptional = customersRepository.findById(id);
        if (containsNumberInName(customersDto.getName())){
            throw new ApiRequestException("Invalid name!");
        }
        customersDto.setId(customersModelOptional.get().getId());
        return mapModelToDto(customersRepository.save(mapDtoToModel(customersDto)));
    }

    private CustomersDto mapModelToDto (CustomersModel customersModel){
        return CustomersDto.builder()
                .id(customersModel.getId())
                .name(customersModel.getName())
                .cpf(customersModel.getCpf())
                .cnpj(customersModel.getCnpj())
                .phone(customersModel.getPhone())
                .email(customersModel.getEmail())
                .city(customersModel.getCity())
                .state(customersModel.getState())
                .postalCode(customersModel.getPostalCode())
                .build();
    }

    private CustomersModel mapDtoToModel (CustomersDto customersDto){
        var customersModel = new CustomersModel();
        customersModel.setId(customersDto.getId());
        customersModel.setName(customersDto.getName());
        customersModel.setCpf(customersDto.getCpf());
        customersModel.setCnpj(customersDto.getCnpj());
        customersModel.setPhone(customersDto.getPhone());
        customersModel.setEmail(customersDto.getEmail());
        customersModel.setAddress(customersDto.getAddress());
        customersModel.setCity(customersDto.getCity());
        customersModel.setState(customersDto.getState());
        customersModel.setPostalCode(customersDto.getPostalCode());
        return customersModel;
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

    public List<CustomersDto> findAll() {
        return customersRepository.findAll().stream().map(this::mapModelToDto).collect(Collectors.toList());
    }

    public Optional<CustomersModel> findById(Long id) {
        Optional<CustomersModel> customersModelOptional = customersRepository.findById(id);
        if (!customersModelOptional.isPresent()){
            throw new ApiRequestException("Customer not found!");
        }
        return customersRepository.findById(id);
    }

    public Optional<CustomersDto> findByIdDto(Long id){
        Optional<CustomersModel> customersModelOptional = customersRepository.findById(id);
        if (!customersModelOptional.isPresent()){
            throw new ApiRequestException("Customer not found!");
        }
        return Optional.of(mapModelToDto(customersModelOptional.get()));
    }

    @Transactional
    public void delete(Long id) {
        Optional<CustomersModel> customersModelOptional = customersRepository.findById(id);
        customersRepository.delete(customersModelOptional.get());
    }
}
