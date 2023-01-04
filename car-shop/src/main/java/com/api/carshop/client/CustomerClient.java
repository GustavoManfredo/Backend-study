package com.api.carshop.client;

import com.api.carshop.dto.CustomerDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "customerClient", url = "${url}")
public interface CustomerClient {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<CustomerDto> getCustomerById(@RequestParam("id") Long id);

    @PostMapping("/customer")
    ResponseEntity<CustomerDto> saveCustomer(@RequestBody CustomerDto customerDto);

}
