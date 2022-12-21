package com.api.carshop.controllers;

import com.api.carshop.dtos.ProductsDto;
import com.api.carshop.models.ProductsModel;
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
    public ResponseEntity<Object> saveProducts(@RequestBody @Valid ProductsDto productsDto){
        var productsModel = new ProductsModel();
        return ResponseEntity.status(HttpStatus.OK).body(productsService.save(productsModel, productsDto));
    }

    @GetMapping()
    public ResponseEntity<List<ProductsModel>> getAllProducts(){
        return ResponseEntity.status(HttpStatus.OK).body(productsService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getProductById(@PathVariable(value = "id") Long id){
        Optional<ProductsModel> productsModelOptional = productsService.findById(id);
        return productsModelOptional.<ResponseEntity<Object>>map(productsModel -> ResponseEntity.status(HttpStatus.OK).body(productsModel)).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found!"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable(value = "id") Long id){
        Optional<ProductsModel> productsModelOptional = productsService.findById(id);
        productsService.delete(productsModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Product deleted!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable(value = "id") Long id, @RequestBody @Valid ProductsDto productsDto){
        Optional<ProductsModel> productsModelOptional = productsService.findById(id);
        var productsModel = new ProductsModel();
        return ResponseEntity.status(HttpStatus.OK).body(productsService.update(productsModel, productsDto));
    }
}
