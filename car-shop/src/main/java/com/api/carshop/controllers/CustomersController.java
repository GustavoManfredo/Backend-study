package com.api.carshop.controllers;

import com.api.carshop.dtos.CustomersDto;
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
    public ResponseEntity<CustomersDto> saveCustomer(@RequestBody @Valid CustomersDto customersDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(customersService.save(customersDto));
    }

    @GetMapping
    public ResponseEntity<List<CustomersDto>> getAllCustomers() {
        return ResponseEntity.status(HttpStatus.OK).body(customersService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomersDto> getOneCustomer(@PathVariable(value = "id") Long id){
        Optional<CustomersDto> customersDtoOptional = customersService.findByIdDto(id);
        return ResponseEntity.status(HttpStatus.OK).body(customersDtoOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable(value = "id") Long id){
        customersService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Customer deleted successfully!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomersDto> updateCustomer(@PathVariable(value = "id") Long id, @RequestBody @Valid CustomersDto customersDto){
        return ResponseEntity.status(HttpStatus.OK).body(customersService.update(customersDto, id));
    }

}
