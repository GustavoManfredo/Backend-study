package com.api.carshop.client;

import com.api.carshop.dto.CustomerDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "customerClient", url = "${url}")
public interface CustomerClient {

    @PostMapping("/customer")
    ResponseEntity<CustomerDto> saveCustomer(@RequestBody CustomerDto customerDto);
    @GetMapping("/customer/{id}")
    ResponseEntity<CustomerDto> getCustomerById(@PathVariable(value = "id") Long id);
    @PutMapping("/customer/{id}")
    ResponseEntity<CustomerDto> updateCustomer(@PathVariable(value = "id")Long id, @RequestBody CustomerDto customerDto);
    @DeleteMapping("/customer/{id}")
    ResponseEntity<String> deleteCustomer(@PathVariable(value = "id") Long id);
}
