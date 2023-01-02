package com.api.carshop.controllers;

import com.api.carshop.services.EmployeeService;
import com.api.carshop.dto.EmployeeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.save(employeeDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable(value = "id") Long id){
        return ResponseEntity.ok().body(employeeService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable(value = "id") Long id, @RequestBody EmployeeDto employeeDto){
        return ResponseEntity.ok().body(employeeService.update(employeeDto, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable(value = "id") Long id){
        employeeService.deleteById(id);
        return ResponseEntity.ok().body("Employee deleted!");
    }

}
