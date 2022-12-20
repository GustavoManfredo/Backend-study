package com.api.carshop.controllers;

import com.api.carshop.dtos.CustomersDto;
import com.api.carshop.models.CustomersModel;
import com.api.carshop.services.CustomersService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/customer")
public class CustomersController {
    final CustomersService customersService;

    public CustomersController(CustomersService customersService) {
        this.customersService = customersService;
    }

    @PostMapping
    public ResponseEntity<Object> saveCustomer(@RequestBody @Valid CustomersDto customersDto){

        if(customersService.containsNumberInName(customersDto.getCustomerName())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Wrong Type of Name!");
        }

        if(customersService.existsByCustomerCPF(customersDto.getCustomerCPF())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: This CPF is already registered in the database!");
        }

        if(customersService.existsByCustomerCNPJ(customersDto.getCustomerCNPJ())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: This CNPJ is already registered in the database!");
        }

        if(customersService.existsByCustomerEmail(customersDto.getCustomerEmail())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: This email is already registered in the database!");
        }

        if(customersService.existsByCustomerPhone(customersDto.getCustomerPhone())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: This phone is already registered in the database!");
        }

        var customersModel = new CustomersModel();
        BeanUtils.copyProperties(customersDto, customersModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(customersService.save(customersModel));
    }

    @GetMapping
    public ResponseEntity<List<CustomersModel>> getAllCustomers() {
        return ResponseEntity.status(HttpStatus.OK).body(customersService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneCustomer(@PathVariable(value = "id") UUID id){
        Optional<CustomersModel> customersModelOptional = customersService.findById(id);
        return customersModelOptional.<ResponseEntity<Object>>map(customersModel -> ResponseEntity.status(HttpStatus.OK).body(customersModel)).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found!"));
    }

}
