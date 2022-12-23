package com.api.carshop.services;

import com.api.carshop.dtos.CustomersDto;
import com.api.carshop.dtos.EmployeesDto;
import com.api.carshop.dtos.OrdersDto;
import com.api.carshop.exception.ApiRequestException;
import com.api.carshop.models.OrdersModel;
import com.api.carshop.repositories.OrdersRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrdersService {

    final
    OrdersRepository ordersRepository;
    final
    CustomersService customersService;

    final
    EmployeesService employeesService;

    public OrdersService(OrdersRepository ordersRepository, CustomersService customersService, EmployeesService employeesService) {
        this.ordersRepository = ordersRepository;
        this.customersService = customersService;
        this.employeesService = employeesService;
    }

    @Transactional
    public OrdersDto save(OrdersDto ordersDto) {
        return mapModelToDto(ordersRepository.save(mapDtoToModel(ordersDto)));
    }

    private OrdersDto mapModelToDto(OrdersModel ordersModel){
        var ordersDto = new OrdersDto();

        ordersDto.setId(ordersModel.getId());
        ordersDto.setQuantityOrdered(ordersModel.getQuantityOrdered());
        ordersDto.setDate(ordersModel.getDate());
        ordersDto.setComments(ordersModel.getComments());
        ordersDto.setCustomer(CustomersDto.builder()
                .id(ordersModel.getCustomerId().getId())
                .name(ordersModel.getCustomerId().getName())
                .cpf(ordersModel.getCustomerId().getCpf())
                .cnpj(ordersModel.getCustomerId().getCnpj())
                .email(ordersModel.getCustomerId().getEmail())
                .address(ordersModel.getCustomerId().getAddress())
                .phone(ordersModel.getCustomerId().getPhone())
                .city(ordersModel.getCustomerId().getCity())
                .state(ordersModel.getCustomerId().getState())
                .build());
        ordersDto.setEmployee(EmployeesDto.builder()
                .id(ordersModel.getEmployeeId().getId())
                .name(ordersModel.getEmployeeId().getName())
                .cpf(ordersModel.getEmployeeId().getCpf())
                .phone(ordersModel.getEmployeeId().getPhone())
                .email(ordersModel.getEmployeeId().getEmail())
                .jobTitle(ordersModel.getEmployeeId().getJobTitle())
                .build());
        ordersDto.setTotalPrice(ordersModel.getTotalPrice());
        ordersDto.setStatus(ordersModel.getStatus());
        ordersDto.setShipDate(ordersModel.getShipDate());

        return ordersDto;
    }

    private OrdersModel mapDtoToModel(OrdersDto ordersDto){
        var ordersModel = new OrdersModel();

        ordersModel.setId(ordersDto.getId());
        ordersModel.setQuantityOrdered(ordersDto.getQuantityOrdered());
        ordersModel.setDate(ordersDto.getDate());
        ordersModel.setComments(ordersDto.getComments());
        ordersModel.setCustomerId(customersService.findById(ordersDto.getCustomerId()).get());
        ordersModel.setEmployeeId(employeesService.findById(ordersDto.getEmployeeId()).get());
        ordersModel.setTotalPrice(ordersDto.getTotalPrice());
        ordersModel.setStatus(ordersDto.getStatus());
        ordersModel.setShipDate(ordersDto.getShipDate());
        return ordersModel;
    }

    public List<OrdersDto> findAll() {
        return ordersRepository.findAll().stream().map(this::mapModelToDto).collect(Collectors.toList());
    }

    public Optional<OrdersModel> findById(Long id) {
        Optional<OrdersModel> ordersModelOptional = ordersRepository.findById(id);
        if (!ordersModelOptional.isPresent()){
            throw new ApiRequestException("Order not found!");
        }
        return ordersRepository.findById(id);
    }

    public Optional<OrdersDto> findByIdDto(Long id) {
        Optional<OrdersModel> ordersModelOptional = ordersRepository.findById(id);
        if (!ordersModelOptional.isPresent()){
            throw new ApiRequestException("Order not found!");
        }
        return Optional.of(mapModelToDto(ordersModelOptional.get()));
    }

    @Transactional
    public void delete(Long id) {
        Optional<OrdersModel> ordersModelOptional = ordersRepository.findById(id);
        ordersRepository.delete(ordersModelOptional.get());
    }

    @Transactional
    public OrdersDto update(OrdersDto ordersDto, Long id) {
        Optional<OrdersModel> ordersModelOptional = ordersRepository.findById(id);
        ordersDto.setId(ordersModelOptional.get().getId());
        return mapModelToDto(ordersRepository.save(mapDtoToModel(ordersDto)));
    }
}
