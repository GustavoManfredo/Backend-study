package com.api.carshop.controllers;

import com.api.carshop.dtos.CustomersDto;
import com.api.carshop.models.CustomersModel;
import com.api.carshop.services.CustomersService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/customers")
public class CustomersController {
    final CustomersService customersService;

    public CustomersController(CustomersService customersService) {
        this.customersService = customersService;
    }

    @PostMapping
    public ResponseEntity<Object> saveCustomer(@RequestBody @Valid CustomersDto customersDto){
        var customersModel = new CustomersModel();
        return ResponseEntity.status(HttpStatus.CREATED).body(customersService.save(customersModel, customersDto));
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
        customersService.delete(customersModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Customer deleted successfully!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateCustomer(@PathVariable(value = "id") Long id, @RequestBody @Valid CustomersDto customersDto){
        Optional<CustomersModel> customersModelOptional = customersService.findById(id);
        var customerModel = new CustomersModel();
        customerModel.setId((customersModelOptional.get().getId()));
        return ResponseEntity.status(HttpStatus.OK).body(customersService.update(customerModel, customersDto));
    }

}
