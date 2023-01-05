package com.api.carshop.client;

import com.api.carshop.dto.CustomerDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "customerClient", url = "${customer-client.url}")
@RequestMapping("customer")
public interface CustomerClient {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<CustomerDto> getCustomerById(@RequestParam("id") Long id);

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<CustomerDto> saveCustomer(@RequestBody CustomerDto customerDto);

}
