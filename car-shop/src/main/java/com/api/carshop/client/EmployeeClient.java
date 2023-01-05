package com.api.carshop.client;

import com.api.carshop.dto.EmployeeDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "employeeClient", url = "${url}")
public interface EmployeeClient {

    @PostMapping("/employee")
    ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto);
    @GetMapping("/employee/{id}")
    ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable(value = "id") Long id);
    @PutMapping("/employee/{id}")
    ResponseEntity<EmployeeDto> updateEmployee(@PathVariable(value = "id") Long id, @RequestBody EmployeeDto employeeDto);
    @DeleteMapping("/employee/{id}")
    ResponseEntity<String> deleteEmployee(@PathVariable(value = "id") Long id);

}
