package com.api.carshop.controllers;

import com.api.carshop.dtos.ProductTypeDto;
import com.api.carshop.services.ProductTypeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/products/type")
public class ProductTypeController {

    final
    ProductTypeService productTypeService;

    public ProductTypeController(ProductTypeService productTypeService) {
        this.productTypeService = productTypeService;
    }

    @PostMapping()
    public ResponseEntity<ProductTypeDto> saveProductType(@RequestBody @Valid ProductTypeDto productTypeDto){
        return ResponseEntity.status(HttpStatus.OK).body(productTypeService.save(productTypeDto));
    }

    @GetMapping()
    public ResponseEntity<List<ProductTypeDto>> getAllProductsTypes(){
        return ResponseEntity.status(HttpStatus.OK).body(productTypeService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductTypeDto> getOneProductTypeById(@PathVariable(value = "id") Long id){
        Optional<ProductTypeDto> productTypeDtoOptional = productTypeService.findByIdDto(id);
        return ResponseEntity.status(HttpStatus.OK).body(productTypeDtoOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProductType(@PathVariable(value = "id") Long id){
        productTypeService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Product type deleted!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductTypeDto> updateProductType(@PathVariable(value = "id") Long id, @RequestBody @Valid ProductTypeDto productTypeDto){
        return ResponseEntity.status(HttpStatus.OK).body(productTypeService.update(productTypeDto, id));
    }

}
