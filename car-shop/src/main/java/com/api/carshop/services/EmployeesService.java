package com.api.carshop.services;

import com.api.carshop.dtos.EmployeesDto;
import com.api.carshop.exception.ApiRequestException;
import com.api.carshop.models.EmployeesModel;
import com.api.carshop.repositories.EmployeesRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeesService {

    final
    EmployeesRepository employeesRepository;

    public EmployeesService(EmployeesRepository employeesRepository) {
        this.employeesRepository = employeesRepository;
    }

    @Transactional
    public EmployeesDto save(EmployeesDto employeesDto) {
        if (containsNumberInName(employeesDto.getName())){ throw new ApiRequestException("Invalid name!"); }
        if (existsByCpf(employeesDto.getCpf())){ throw new ApiRequestException("This CPF is already registered in the database!"); }
        if (existsByEmail(employeesDto.getEmail())){ throw new ApiRequestException("This Email is already registered in the database!"); }
        if (existsByPhone(employeesDto.getPhone())){ throw new ApiRequestException("This Phone is already registered in the database!"); }
        return mapModelToDto(employeesRepository.save(mapDtoToModel(employeesDto)));
    }

    @Transactional
    public EmployeesDto update(EmployeesDto employeesDto, Long id) {
        Optional<EmployeesModel> employeesModelOptional = employeesRepository.findById(id);
        if (containsNumberInName(employeesDto.getName())){
            throw new ApiRequestException("Invalid name!");
        }
        employeesDto.setId(employeesModelOptional.get().getId());
        return mapModelToDto(employeesRepository.save(mapDtoToModel(employeesDto)));
    }

    private EmployeesDto mapModelToDto(EmployeesModel employeesModel){
        return EmployeesDto.builder()
                .id(employeesModel.getId())
                .name(employeesModel.getName())
                .cpf(employeesModel.getCpf())
                .email(employeesModel.getEmail())
                .phone(employeesModel.getPhone())
                .jobTitle(employeesModel.getJobTitle())
                .build();
    }

    private EmployeesModel mapDtoToModel(EmployeesDto employeesDto){
        var employeesModel = new EmployeesModel();
        employeesModel.setId(employeesDto.getId());
        employeesModel.setName(employeesDto.getName());
        employeesModel.setCpf(employeesDto.getCpf());
        employeesModel.setEmail(employeesDto.getEmail());
        employeesModel.setPhone(employeesDto.getPhone());
        employeesModel.setJobTitle(employeesDto.getJobTitle());
        return employeesModel;
    }

    private boolean containsNumberInName(String name) {
        return name.matches(".*\\d+.*");
    }

    private boolean existsByCpf(String cpf) {
        if(cpf == null){
            return false;
        }
        return employeesRepository.existsByCpf(cpf);
    }

    private boolean existsByPhone(String phone) {
        return employeesRepository.existsByPhone(phone);
    }

    private boolean existsByEmail(String email) {
        return employeesRepository.existsByEmail(email);
    }

    public List<EmployeesDto> findAll(){
        return employeesRepository.findAll().stream().map(this::mapModelToDto).collect(Collectors.toList());
    }

    public Optional<EmployeesModel> findById(Long id) {
        Optional<EmployeesModel> employeesModelOptional = employeesRepository.findById(id);
        if (!employeesModelOptional.isPresent()){
            throw new ApiRequestException("Employee not found!");
        }
        return employeesRepository.findById(id);
    }

    public Optional<EmployeesDto> findByIdDto(Long id){
        Optional<EmployeesModel> employeesModelOptional = employeesRepository.findById(id);
        if (!employeesModelOptional.isPresent()){
            throw new ApiRequestException("Customer not found!");
        }
        return Optional.of(mapModelToDto(employeesModelOptional.get()));
    }

    @Transactional
    public void delete(Long id) {
        Optional<EmployeesModel> employeesModelOptional = employeesRepository.findById(id);
        employeesRepository.delete(employeesModelOptional.get());
    }
}
