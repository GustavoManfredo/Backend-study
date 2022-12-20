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

/*
* Mudanças
* Tirar os validadores da parte de postmapping e coloca-los
* na camada de service. Tirar response entity da camada de serviço e colocar
* na de
*
*
*
*
* */



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

        if(customersService.containsNumberInName(customersDto.getName())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Wrong Type of Name!");
        }

        if(customersService.existsByCpf(customersDto.getCpf())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: This CPF is already registered in the database!");
        }

        if(customersService.existsByCnpj(customersDto.getCpnj())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: This CNPJ is already registered in the database!");
        }

        if(customersService.existsByEmail(customersDto.getEmail())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: This email is already registered in the database!");
        }

        if(customersService.existsByPhone(customersDto.getPhone())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: This phone is already registered in the database!");
        }

        var customersModel = new CustomersModel();
        BeanUtils.copyProperties(customersDto, customersModel); //throw new / Adicionar o excpetion handler
        return ResponseEntity.status(HttpStatus.CREATED).body(customersService.save(customersModel));//salvar no save
    }

    @GetMapping
    public ResponseEntity<List<CustomersModel>> getAllCustomers() {
        return ResponseEntity.status(HttpStatus.OK).body(customersService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneCustomer(@PathVariable(value = "id") Long id){
        Optional<CustomersModel> customersModelOptional = customersService.findById(id);
        return customersModelOptional.<ResponseEntity<Object>>map(customersModel -> ResponseEntity.status(HttpStatus.OK).body(customersModel)).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found!"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCustomer(@PathVariable(value = "id") Long id){
        Optional<CustomersModel> customersModelOptional = customersService.findById(id);
        if(!customersModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found!");
        }
        customersService.delete(customersModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Customer deleted successfully!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateCustomer(@PathVariable(value = "id") Long id, @RequestBody @Valid CustomersDto customersDto){
        Optional<CustomersModel> customersModelOptional = customersService.findById(id);
        if (!customersModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found!");
        }
        var customerModel = new CustomersModel();
        BeanUtils.copyProperties(customersDto, customerModel);
        customerModel.setId((customersModelOptional.get().getId()));
        return ResponseEntity.status(HttpStatus.OK).body(customersService.save(customerModel));
    }

}
