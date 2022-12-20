package com.api.carshop.controllers;

import com.api.carshop.dtos.CustomersDto;
import com.api.carshop.models.CustomersModel;
import com.api.carshop.services.CustomersService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        var customersModel = new CustomersModel();
        BeanUtils.copyProperties(customersDto, customersModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(customersService.save(customersModel));
    }

}
