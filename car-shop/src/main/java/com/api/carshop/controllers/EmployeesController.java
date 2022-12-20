package com.api.carshop.controllers;

import com.api.carshop.dtos.EmployeesDto;
import com.api.carshop.models.EmployeesModel;
import com.api.carshop.services.EmployeesService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
    public ResponseEntity<Object> saveEmployee(@RequestBody @Valid EmployeesDto employeesDto){

        if (employeesService.existsByCpf(employeesDto.getCpf())){ return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: This CPF is already registered in the database!"); }
        if (employeesService.existsByPhone(employeesDto.getPhone())){ return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: This Phone number is already registered in the database!"); }
        if (employeesService.existsByEmail(employeesDto.getEmail())){ return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: This Email is already registered in the database!"); }

        var employeesModel = new EmployeesModel();
        BeanUtils.copyProperties(employeesDto, employeesModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(employeesService.save(employeesModel));
    }

    @GetMapping()
    public ResponseEntity<List<EmployeesModel>> getAllEmployees(){
        return ResponseEntity.status(HttpStatus.OK).body(employeesService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneEmployee(@PathVariable(value = "id") Long id){
        Optional<EmployeesModel> employeesModelOptional = employeesService.findById(id);
        return employeesModelOptional.<ResponseEntity<Object>>map(employeesModel -> ResponseEntity.status(HttpStatus.OK).body(employeesModel)).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found!"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteEmployee(@PathVariable(value = "id") Long id){
        Optional<EmployeesModel> employeesModelOptional = employeesService.findById(id);
        if (!employeesModelOptional.isPresent()){ return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found!"); }
        employeesService.delete(employeesModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Employee deleted successfully!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateEmployee(@PathVariable(value = "id") Long id, @RequestBody @Valid EmployeesDto employeesDto){
        Optional<EmployeesModel> employeesModelOptional = employeesService.findById(id);
        if(!employeesModelOptional.isPresent()){ return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found!"); }

        var employeesModel = new EmployeesModel();
        BeanUtils.copyProperties(employeesDto, employeesModel);
        employeesModel.setId(employeesModelOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(employeesService.save(employeesModel));
    }
}
