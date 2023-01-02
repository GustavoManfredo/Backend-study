package com.api.carshop.controllers;

import com.api.carshop.services.CustomerService;
import com.api.carshop.dto.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerDto> saveCustomer(@RequestBody CustomerDto customerDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.save(customerDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable(value = "id") Long id){
        return ResponseEntity.ok().body(customerService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDto> updateCustomer(@PathVariable(value = "id") Long id, @RequestBody CustomerDto customerDto){
        return ResponseEntity.ok().body(customerService.update(customerDto, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable(value = "id") Long id){
        customerService.deleteById(id);
        return ResponseEntity.ok().body("Customer deleted");
    }

}
