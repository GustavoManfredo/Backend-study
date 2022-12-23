package com.api.carshop.controllers;

import com.api.carshop.dtos.ProductsDto;
import com.api.carshop.services.ProductsService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/products")
public class ProductsController {

    final
    ProductsService productsService;

    public ProductsController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @PostMapping
    public ResponseEntity<ProductsDto> saveProducts(@RequestBody @Valid ProductsDto productsDto){
        return ResponseEntity.status(HttpStatus.OK).body(productsService.save(productsDto));
    }

    @GetMapping()
    public ResponseEntity<List<ProductsDto>> getAllProducts(){
        return ResponseEntity.status(HttpStatus.OK).body(productsService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductsDto> getProductById(@PathVariable(value = "id") Long id){
        Optional<ProductsDto> productsDtoOptional = productsService.findByIdDto(id);
        return ResponseEntity.status(HttpStatus.OK).body(productsDtoOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable(value = "id") Long id){
        productsService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Product deleted!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductsDto> updateProduct(@PathVariable(value = "id") Long id, @RequestBody @Valid ProductsDto productsDto){
        return ResponseEntity.status(HttpStatus.OK).body(productsService.update(productsDto, id));
    }
}
