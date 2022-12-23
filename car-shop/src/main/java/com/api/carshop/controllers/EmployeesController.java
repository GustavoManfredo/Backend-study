package com.api.carshop.controllers;

import com.api.carshop.dtos.EmployeesDto;
import com.api.carshop.services.EmployeesService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/employees")
public class EmployeesController {

    final
    EmployeesService employeesService;

    public EmployeesController(EmployeesService employeesService) {
        this.employeesService = employeesService;
    }

    @PostMapping
    public ResponseEntity<EmployeesDto> saveEmployee(@RequestBody @Valid EmployeesDto employeesDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(employeesService.save(employeesDto));
    }

    @GetMapping()
    public ResponseEntity<List<EmployeesDto>> getAllEmployees(){
        return ResponseEntity.status(HttpStatus.OK).body(employeesService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeesDto> getOneEmployee(@PathVariable(value = "id") Long id){
        Optional<EmployeesDto> employeesDtoOptional = employeesService.findByIdDto(id);
        return ResponseEntity.status(HttpStatus.OK).body(employeesDtoOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable(value = "id") Long id){
        employeesService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Employee deleted successfully!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeesDto> updateEmployee(@PathVariable(value = "id") Long id, @RequestBody @Valid EmployeesDto employeesDto){
        return ResponseEntity.status(HttpStatus.OK).body(employeesService.update(employeesDto, id));
    }
}
